package com.example.signum;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.SimpleCursorAdapter;
import android.widget.VideoView;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.Array;
import java.text.Normalizer;
import java.util.ArrayList;

import javax.xml.transform.sax.SAXResult;


public class Learning extends AppCompatActivity {

    private ArrayList<String> list = new ArrayList<>();
    private String word,category;
    private Cursor palabra;
    private String idImagen;
    private db dbAdapter;
    private static final String DATABASE_NAME = "data";
    private static final String PRELOADED_DATABASE_NAME = "data.db";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Creamos el adaptador de la BD y la abrimos
        dbAdapter = new db(this);
        dbAdapter.open();
        Bundle b = getIntent().getExtras();
        category = b.getString("category");
        Configuration config = getResources().getConfiguration();
        onConfigurationChanged(config);
        VideoView video = (VideoView) findViewById(R.id.videoView);
        // Se oculta el vídeo hasta que el usuario escoja una palabra
        video.setVisibility(View.GONE);
        ImageView img_arrow = (ImageView) findViewById(R.id.img_arrow);
        ListView selectOpts = (ListView) findViewById(R.id.select_opts);
        img_arrow.setVisibility(View.VISIBLE);

        selectOpts.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if(totalItemCount != selectOpts.getLastVisiblePosition() + 1){
                    img_arrow.setVisibility(View.VISIBLE);
                }else if(totalItemCount == selectOpts.getFirstVisiblePosition() - 1){
                    img_arrow.setVisibility(View.VISIBLE);
                }
                else{
                    img_arrow.setVisibility(View.GONE);
                }
            }
        });


        // Creamos un cursor que apunte a todas las palabras de la base de datos
        Cursor cursor = dbAdapter.fetchAllWords(category);

        // Creamos un array con los campos que queremos mostrar en el listview (sólo el título de la nota)
        String[] from = new String[]{db.KEY_TITLE};

        // Array con los campos que queremos ligar a los campos del array de la línea anterior (en este caso sólo text1)
        int[] to = new int[]{R.id.text1};

        // Creamos un SimpleCursorAdapter y lo asignamos al listview para mostrarlo
        SimpleCursorAdapter words =
                new SimpleCursorAdapter(this, R.layout.words, cursor, from, to, 0);
        selectOpts.setAdapter(words);
        selectOpts.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> arg0, View view, int position, long id)
                    {
                        // Se crea un cursor que apunta a la palabra que el usuario elija y se busca el id dicha palabra en el .json
                        // y se elige el vídeo correspondiente
                        Cursor c = dbAdapter.fetchWord(position + 1,category);
                        word = c.getString(c.getColumnIndexOrThrow(db.KEY_TITLE)).toLowerCase();
                        word = Normalizer.normalize(word, Normalizer.Form.NFD);
                        word = word.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                        try {
                            idImagen = readJson(word);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        setVideo(video,idImagen);

                    }
                }

        );

    }

    // Infla las opciones del menú en el App Bar
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Función encargada de cambiar entre 2 xml dependiendo de si el móvil está en posición vertical u horizontal.
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            setContentView(R.layout.activity_learning); // it will use .xml from /res/layout
        }
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            setContentView(R.layout.activity_learning_land); // it will use xml from /res/layout-land
        }
    }

    // Se encarga de realizar las acciones correspondientes cuando se pulsan las opciones del App Bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_search:
                goHome();
                return true;
            case R.id.action_about:
                about_us();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Función encargada de asignar la url correspondiente, poner el vídeo visible e iniciarlo en bucle
    public void setVideo(VideoView video, String idImagen){
        String url = "https://www.lab.it.uc3m.es/~0345838/LSE_acepciones/" + idImagen + ".mp4";
        video.setVideoURI(Uri.parse(url));
        video.setVisibility(View.VISIBLE);
        video.start();
        // Método para que el video se ejecute en bucle
        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
    }

    // Dada una palabra se parsea el .json y se busca dicha palabra, en caso de no encontrarla se devolverá un -1 que hará saltar el mensaje de alerta
    public String readJson(String word) throws IOException {
        String id = "-1";
        InputStream in;
        try {
            in = getAssets().open("lse.json");
        } catch (IOException e) {
            System.out.println("IOException");
            return id;
        }

        // Se empieza a leer el fichero
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        reader.beginObject();
        while (reader.hasNext()) {
            // Se eliminan tildes y mayúsculas
            String name = reader.nextName().toLowerCase();
            name = Normalizer.normalize(name, Normalizer.Form.NFD);
            name = name.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
            if (name.equals(word)) {
                reader.beginArray();
                while (reader.hasNext()) {
                    video v = new video();
                    reader.beginObject();
                    while (reader.hasNext()) {
                        name = reader.nextName();
                        if (name.equals("items")){
                            reader.beginArray();
                            while(reader.hasNext()) {
                                reader.beginObject();
                                while (reader.hasNext()) {
                                    name = reader.nextName();
                                    // Si el tipo es igual a 11 se devuelve el id
                                    // (Todos los vídeos tienen "tipo" = 11, mientras que en las imágenes es igual a 12)
                                    if (name.equals("idImagen")) {
                                        v.setidImagen(reader.nextString());
                                    } else if (name.equals("tipo")) {
                                        v.setTipo(reader.nextString());
                                    } else {
                                        reader.skipValue();
                                    }
                                    if (v.getTipo().equals("11")) {
                                        id = v.getidImagen();
                                        return id;
                                    }

                                }
                                reader.endObject();
                            }
                            reader.endArray();
                        } else {
                            reader.skipValue();
                        }
                    }
                    reader.endObject();
                }
                reader.endArray();
            }
            reader.skipValue();
        }
        reader.endObject();
        return id;

    }

    // Cuando se pulsa el botón de examen se guardantodas las palabras de la tabla de la base de datos en un Array List y
    // se guarda en un bundle para la siguiente actividad y se inicia dicha actividad
    public void examen(View v){
        Intent intent = new Intent(this, exam.class);
        Bundle bundle = new Bundle();
        Cursor cursor = dbAdapter.fetchAllWords(category);
        bundle.putString("category",category);
        for(int i = 1; i <cursor.getCount();i++){
            Cursor c = dbAdapter.fetchWord(i,category);
            list.add(c.getString(c.getColumnIndexOrThrow(db.KEY_TITLE)));
        }
        bundle.putStringArrayList("list",list);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();

    }

    // Cuando se pulsa el botón goHome se inicia la actividad correspondiente y se elimina la pila de actividades
    public void goHome(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    // Cuando se pulsa el botón About Us se inicia la actividad correspondiente
    public void about_us(){
        Intent intent = new Intent(this, about_us.class);
        startActivity(intent);
    }

}