package com.example.signum;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.util.JsonReader;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.util.ArrayList;


public class Translation_screen extends AppCompatActivity {

    private VideoView video;
    private String url;
    public String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle b = getIntent().getExtras();
        id = b.getString("id");
        super.onCreate(savedInstanceState);
        Configuration config = getResources().getConfiguration();
        onConfigurationChanged(config);

        // Se obtiene el Array List con las palabras del bundle creado en la anterior actividad
        // y se las asignamos a la lista de sugerencias del AutoCompleteTextView.
        AutoCompleteTextView auto = (AutoCompleteTextView) findViewById(R.id.auto);
        ArrayList<String> sugerencias = new ArrayList<String>();
        sugerencias = b.getStringArrayList("sugerencias");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, sugerencias);
        auto.setAdapter(adapter);

    }

    // Infla las opciones del menú en el App Bar
    public boolean onCreateOptionsMenu(Menu menu) {
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
            setContentView(R.layout.activity_translation_screen); // it will use .xml from /res/layout
            // Se accede al vídeo mediante una url y empieza a reporducirse en bucle
            url = "https://www.lab.it.uc3m.es/~0345838/LSE_acepciones/" + id + ".mp4";
            video = (VideoView) findViewById(R.id.videoView);
            video.setVideoURI(Uri.parse(url));
            video.start();
            // Método para que el video se ejecute en bucle
            video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.setLooping(true);
                }
            });
        }
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            setContentView(R.layout.activity_translation_screen); // it will use xml from /res/layout-land
            // Se accede al vídeo mediante una url y empieza a reporducirse en bucle
            url = "https://www.lab.it.uc3m.es/~0345838/LSE_acepciones/" + id + ".mp4";
            video = (VideoView) findViewById(R.id.videoView);
            video.setVideoURI(Uri.parse(url));
            video.start();
            // Método para que el video se ejecute en bucle
            video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.setLooping(true);
                }
            });
        }
    }

    // Se encarga de realizar las acciones correspondientes cuando se pulsan las opciones del App Bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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

    // Función encargada de iniciar la actividad que traduce a lse (Translation_Screen) cuando se pulsa el botón de búsqueda
    public void sendText(View v){
        AutoCompleteTextView nameText = (AutoCompleteTextView) findViewById(R.id.auto);
        // Guardamos el texto del editText en la variable word
        // Eliminamos comas y mayúsculas para evitar problemas al buscar la palabra en el fichero .json
        String word = nameText.getText().toString().toLowerCase();
        word = Normalizer.normalize(word, Normalizer.Form.NFD);
        word = word.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        // Llama a la función encargada de parsear el .json y buscar la palabra
        try {
            id = readJson(word);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // En caso de que no se haya escrito nada o solo espacios en blanco se manda un mensaje de alerta
        if (word.trim().length() == 0) {
            AlertDialog.Builder ad = new AlertDialog.Builder(this);
            ad.setTitle(R.string.title_dialog);
            ad.setMessage(R.string.message);
            ad.setPositiveButton(R.string.button_ok,
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int arg1) {
                            dialog.cancel();
                        }
                    });
            ad.show();
        // En caso de que la palabra buscada no se encuentre en el fichero .json salta un mensaje de alerta
        }else if(id.equals("-1")) {
            AlertDialog.Builder ad = new AlertDialog.Builder(this);
            ad.setTitle(R.string.title_dialog);
            ad.setMessage(R.string.message_word);
            ad.setPositiveButton(R.string.button_ok,
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int arg1) {
                            dialog.cancel();
                        }
                    });
            ad.show();
        }else{
            // Si la palabra fue encontrada se cambia la url del vídeo y comienza a ejecutarse en bucle de nuevo
            url = "https://www.lab.it.uc3m.es/~0345838/LSE_acepciones/" + id + ".mp4";
            video = (VideoView) findViewById(R.id.videoView);
            video.setVideoURI(Uri.parse(url));
            video.start();
            nameText.getText().clear();
        }
    }

    // Cuando se pulsa el botón goHome se inicia la actividad correspondiente y se elimina la pila de actividades
    public void goHome(){
        Intent intent = new Intent(this, MainActivity.class);
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    // Cuando se pulsa el botón About Us se inicia la actividad correspondiente
    public void about_us(){
        Intent intent = new Intent(this, about_us.class);
        startActivity(intent);
    }

}