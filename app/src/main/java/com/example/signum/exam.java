package com.example.signum;

import android.content.Intent;
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
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.util.ArrayList;


public class exam extends AppCompatActivity {

    public ArrayList<String> list = new ArrayList<>();
    public String word,category;
    private db dbAdapter;
    private static final String DATABASE_NAME = "data";
    private static final String PRELOADED_DATABASE_NAME = "data.db";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration config = getResources().getConfiguration();
        onConfigurationChanged(config);
        Bundle bundle = getIntent().getExtras();
        list = bundle.getStringArrayList("list");
        category = bundle.getString("category");
        dbAdapter = new db(this);
        dbAdapter.open();
        Button atras = (Button) findViewById(R.id.atras);
        atras.setVisibility(View.GONE);
        Button siguiente = (Button) findViewById(R.id.siguiente);
        siguiente.setVisibility(View.GONE);
        String id = "0";
        // Se asigna un valor double aleatorio a cada botón, procurando que no sean iguales
        double b0 = Math.random()* 10;
        double b1 = Math.random()* 10;
        while(b1 == b0){
            b1 = Math.random()* 10;
        }
        double b2 = Math.random()* 10;
        while(b2 == b0 || b2 == b1){
            b2 = Math.random()* 10;
        }
        double b3 = Math.random()* 10;
        while(b3 == b2 || b3 == b1 || b3 == b0){
            b3 = Math.random()* 10;
        }
        Button button = (Button)findViewById(R.id.button);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        Button button4 = (Button)findViewById(R.id.button4);
        Cursor cursor1, cursor2, cursor3, cursor4;
        cursor1 = dbAdapter.randomWord(category);
        word = cursor1.getString(cursor1.getColumnIndexOrThrow(db.KEY_TITLE));
        // Se busca dentro del .json para obtener su id y poder reproducir el vídeo
        try {
            id = readJson(word);
        } catch (IOException e) {
            e.printStackTrace();
        }
        cursor2 = dbAdapter.randomWord(category);
        while(cursor1.getString(cursor1.getColumnIndexOrThrow(db.KEY_TITLE)).equals(cursor2.getString(cursor2.getColumnIndexOrThrow(db.KEY_TITLE)))) {
            cursor2 = dbAdapter.randomWord(category);
        }
        cursor3 = dbAdapter.randomWord(category);
        while(cursor3.getString(cursor3.getColumnIndexOrThrow(db.KEY_TITLE)).equals(cursor2.getString(cursor2.getColumnIndexOrThrow(db.KEY_TITLE))) ||
                cursor3.getString(cursor3.getColumnIndexOrThrow(db.KEY_TITLE)).equals(cursor1.getString(cursor1.getColumnIndexOrThrow(db.KEY_TITLE)))) {
            cursor3 = dbAdapter.randomWord(category);
        }

        cursor4 = dbAdapter.randomWord(category);
        while(cursor4.getString(cursor4.getColumnIndexOrThrow(db.KEY_TITLE)).equals(cursor2.getString(cursor2.getColumnIndexOrThrow(db.KEY_TITLE))) ||
                cursor4.getString(cursor4.getColumnIndexOrThrow(db.KEY_TITLE)).equals(cursor1.getString(cursor1.getColumnIndexOrThrow(db.KEY_TITLE))) ||
                cursor4.getString(cursor4.getColumnIndexOrThrow(db.KEY_TITLE)).equals(cursor3.getString(cursor3.getColumnIndexOrThrow(db.KEY_TITLE)))
        ) {
            cursor4 = dbAdapter.randomWord(category);

        }
        String word2 = cursor2.getString(cursor2.getColumnIndexOrThrow(db.KEY_TITLE));
        String word3 = cursor3.getString(cursor3.getColumnIndexOrThrow(db.KEY_TITLE));
        String word4 = cursor4.getString(cursor4.getColumnIndexOrThrow(db.KEY_TITLE));

        // El botón con mayor puntuación es asignado la palabra correcta,
        // a los demás se asignan palabras aleatorias procurando que no coincidan entre ellas
        if(b0 > b1 && b0 > b2 && b0 > b3){
            button.setText(word);
            button2.setText(word2);
            button3.setText(word3);
            button4.setText(word4);
        }else if(b1 > b0 && b1 > b2 && b1 > b3){
            button.setText(word2);
            button2.setText(word);
            button3.setText(word3);
            button4.setText(word4);
        }else if(b2 > b0 && b2 > b1 && b2 > b3){
            button.setText(word2);
            button2.setText(word3);
            button3.setText(word);
            button4.setText(word4);

        }else{
            button.setText(word2);
            button2.setText(word3);
            button3.setText(word4);
            button4.setText(word);
        }
        // Se accede al vídeo mediante una url y empieza a reporducirse en bucle
        String url = "https://www.lab.it.uc3m.es/~0345838/LSE_acepciones/" + id + ".mp4";
        VideoView video = (VideoView) findViewById(R.id.videoView);
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
            setContentView(R.layout.exam_layout); // it will use .xml from /res/layout
        }
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            setContentView(R.layout.exam_layout_land); // it will use xml from /res/layout-land
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

    // Dada una palabra se parsea el .json y se busca dicha palabra, en caso de no encontrarla se devolverá un -1 que hará saltar el mensaje de alerta
    public String readJson(String word) throws IOException {
        word = word.toLowerCase();
        word = Normalizer.normalize(word, Normalizer.Form.NFD);
        word = word.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
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

    // Una vez pulsado el botón 1 se cambian los colores de estos a verde o rojo dependiendo de si son el correcto o no
    // para saber si se ha acertado o se despliega un TextView indicándolo. Se hacen visibles los botonoes "atrás" y "siguiente"
    public void b1pulsado(View v){
        Button button = (Button)findViewById(R.id.button);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        Button button4 = (Button)findViewById(R.id.button4);
        TextView text = (TextView)findViewById(R.id.textView2);

        if(button.getText().equals(word)){
            button.setEnabled(false);
            button.setBackgroundColor(getResources().getColor(R.color.green));
            button2.setEnabled(false);
            button2.setBackgroundColor(getResources().getColor(R.color.red));
            button3.setEnabled(false);
            button3.setBackgroundColor(getResources().getColor(R.color.red));
            button4.setEnabled(false);
            button4.setBackgroundColor(getResources().getColor(R.color.red));
            text.setText("RESPUESTA CORRECTA");

        }
        if(button2.getText().equals(word)){
            button2.setEnabled(false);
            button2.setBackgroundColor(getResources().getColor(R.color.green));
            button.setEnabled(false);
            button.setBackgroundColor(getResources().getColor(R.color.red));
            button3.setEnabled(false);
            button3.setBackgroundColor(getResources().getColor(R.color.red));
            button4.setEnabled(false);
            button4.setBackgroundColor(getResources().getColor(R.color.red));
            text.setText("RESPUESTA INCORRECTA");

        }
        if(button3.getText().equals(word)){
            button3.setEnabled(false);
            button3.setBackgroundColor(getResources().getColor(R.color.green));
            button2.setEnabled(false);
            button2.setBackgroundColor(getResources().getColor(R.color.red));
            button.setEnabled(false);
            button.setBackgroundColor(getResources().getColor(R.color.red));
            button4.setEnabled(false);
            button4.setBackgroundColor(getResources().getColor(R.color.red));
            text.setText("RESPUESTA INCORRECTA");

        }
        if(button4.getText().equals(word)){
            button4.setEnabled(false);
            button4.setBackgroundColor(getResources().getColor(R.color.green));
            button2.setEnabled(false);
            button2.setBackgroundColor(getResources().getColor(R.color.red));
            button3.setEnabled(false);
            button3.setBackgroundColor(getResources().getColor(R.color.red));
            button.setEnabled(false);
            button.setBackgroundColor(getResources().getColor(R.color.red));
            text.setText("RESPUESTA INCORRECTA");

        }
        Button atras = (Button) findViewById(R.id.atras);
        Button siguiente = (Button) findViewById(R.id.siguiente);
        atras.setVisibility(View.VISIBLE);
        siguiente.setVisibility(View.VISIBLE);
    }

    // Una vez pulsado el botón 2 se cambian los colores de estos a verde o rojo dependiendo de si son el correcto o no
    // para saber si se ha acertado o se despliega un TextView indicándolo. Se hacen visibles los botonoes "atrás" y "siguiente"
    public void b2pulsado(View v){
        Button button = (Button)findViewById(R.id.button);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        Button button4 = (Button)findViewById(R.id.button4);
        TextView text = (TextView)findViewById(R.id.textView2);

        if(button.getText().equals(word)){
            button.setEnabled(false);
            button.setBackgroundColor(getResources().getColor(R.color.green));
            button2.setEnabled(false);
            button2.setBackgroundColor(getResources().getColor(R.color.red));
            button3.setEnabled(false);
            button3.setBackgroundColor(getResources().getColor(R.color.red));
            button4.setEnabled(false);
            button4.setBackgroundColor(getResources().getColor(R.color.red));
            text.setText("RESPUESTA INCORRECTA");

        }
        if(button2.getText().equals(word)){
            button2.setEnabled(false);
            button2.setBackgroundColor(getResources().getColor(R.color.green));
            button.setEnabled(false);
            button.setBackgroundColor(getResources().getColor(R.color.red));
            button3.setEnabled(false);
            button3.setBackgroundColor(getResources().getColor(R.color.red));
            button4.setEnabled(false);
            button4.setBackgroundColor(getResources().getColor(R.color.red));
            text.setText("RESPUESTA CORRECTA");

        }
        if(button3.getText().equals(word)){
            button3.setEnabled(false);
            button3.setBackgroundColor(getResources().getColor(R.color.green));
            button2.setEnabled(false);
            button2.setBackgroundColor(getResources().getColor(R.color.red));
            button.setEnabled(false);
            button.setBackgroundColor(getResources().getColor(R.color.red));
            button4.setEnabled(false);
            button4.setBackgroundColor(getResources().getColor(R.color.red));
            text.setText("RESPUESTA INCORRECTA");

        }
        if(button4.getText().equals(word)){
            button4.setEnabled(false);
            button4.setBackgroundColor(getResources().getColor(R.color.green));
            button2.setEnabled(false);
            button2.setBackgroundColor(getResources().getColor(R.color.red));
            button3.setEnabled(false);
            button3.setBackgroundColor(getResources().getColor(R.color.red));
            button.setEnabled(false);
            button.setBackgroundColor(getResources().getColor(R.color.red));
            text.setText("RESPUESTA INCORRECTA");

        }
        Button atras = (Button) findViewById(R.id.atras);
        Button siguiente = (Button) findViewById(R.id.siguiente);
        atras.setVisibility(View.VISIBLE);
        siguiente.setVisibility(View.VISIBLE);
    }

    // Una vez pulsado el botón 3 se cambian los colores de estos a verde o rojo dependiendo de si son el correcto o no
    // para saber si se ha acertado o se despliega un TextView indicándolo. Se hacen visibles los botonoes "atrás" y "siguiente"
    public void b3pulsado(View v){
        Button button = (Button)findViewById(R.id.button);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        Button button4 = (Button)findViewById(R.id.button4);
        TextView text = (TextView)findViewById(R.id.textView2);

        if(button.getText().equals(word)){
            button.setEnabled(false);
            button.setBackgroundColor(getResources().getColor(R.color.green));
            button2.setEnabled(false);
            button2.setBackgroundColor(getResources().getColor(R.color.red));
            button3.setEnabled(false);
            button3.setBackgroundColor(getResources().getColor(R.color.red));
            button4.setEnabled(false);
            button4.setBackgroundColor(getResources().getColor(R.color.red));
            text.setText("RESPUESTA INCORRECTA");

        }
        if(button2.getText().equals(word)){
            button2.setEnabled(false);
            button2.setBackgroundColor(getResources().getColor(R.color.green));
            button.setEnabled(false);
            button.setBackgroundColor(getResources().getColor(R.color.red));
            button3.setEnabled(false);
            button3.setBackgroundColor(getResources().getColor(R.color.red));
            button4.setEnabled(false);
            button4.setBackgroundColor(getResources().getColor(R.color.red));
            text.setText("RESPUESTA INCORRECTA");

        }
        if(button3.getText().equals(word)){
            button3.setEnabled(false);
            button3.setBackgroundColor(getResources().getColor(R.color.green));
            button2.setEnabled(false);
            button2.setBackgroundColor(getResources().getColor(R.color.red));
            button.setEnabled(false);
            button.setBackgroundColor(getResources().getColor(R.color.red));
            button4.setEnabled(false);
            button4.setBackgroundColor(getResources().getColor(R.color.red));
            text.setText("RESPUESTA CORRECTA");

        }
        if(button4.getText().equals(word)){
            button4.setEnabled(false);
            button4.setBackgroundColor(getResources().getColor(R.color.green));
            button2.setEnabled(false);
            button2.setBackgroundColor(getResources().getColor(R.color.red));
            button3.setEnabled(false);
            button3.setBackgroundColor(getResources().getColor(R.color.red));
            button.setEnabled(false);
            button.setBackgroundColor(getResources().getColor(R.color.red));
            text.setText("RESPUESTA INCORRECTA");

        }
        Button atras = (Button) findViewById(R.id.atras);
        Button siguiente = (Button) findViewById(R.id.siguiente);
        atras.setVisibility(View.VISIBLE);
        siguiente.setVisibility(View.VISIBLE);
    }

    // Una vez pulsado el botón 4 se cambian los colores de estos a verde o rojo dependiendo de si son el correcto o no
    // para saber si se ha acertado o se despliega un TextView indicándolo. Se hacen visibles los botonoes "atrás" y "siguiente"
    public void b4pulsado(View v){
        Button button = (Button)findViewById(R.id.button);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        Button button4 = (Button)findViewById(R.id.button4);
        TextView text = (TextView)findViewById(R.id.textView2);

        if(button.getText().equals(word)){
            button.setEnabled(false);
            button.setBackgroundColor(getResources().getColor(R.color.green));
            button2.setEnabled(false);
            button2.setBackgroundColor(getResources().getColor(R.color.red));
            button3.setEnabled(false);
            button3.setBackgroundColor(getResources().getColor(R.color.red));
            button4.setEnabled(false);
            button4.setBackgroundColor(getResources().getColor(R.color.red));
            text.setText("RESPUESTA INCORRECTA");

        }
        if(button2.getText().equals(word)){
            button2.setEnabled(false);
            button2.setBackgroundColor(getResources().getColor(R.color.green));
            button.setEnabled(false);
            button.setBackgroundColor(getResources().getColor(R.color.red));
            button3.setEnabled(false);
            button3.setBackgroundColor(getResources().getColor(R.color.red));
            button4.setEnabled(false);
            button4.setBackgroundColor(getResources().getColor(R.color.red));
            text.setText("RESPUESTA INCORRECTA");

        }
        if(button3.getText().equals(word)){
            button3.setEnabled(false);
            button3.setBackgroundColor(getResources().getColor(R.color.green));
            button2.setEnabled(false);
            button2.setBackgroundColor(getResources().getColor(R.color.red));
            button.setEnabled(false);
            button.setBackgroundColor(getResources().getColor(R.color.red));
            button4.setEnabled(false);
            button4.setBackgroundColor(getResources().getColor(R.color.red));
            text.setText("RESPUESTA INCORRECTA");

        }
        if(button4.getText().equals(word)){
            button4.setEnabled(false);
            button4.setBackgroundColor(getResources().getColor(R.color.green));
            button2.setEnabled(false);
            button2.setBackgroundColor(getResources().getColor(R.color.red));
            button3.setEnabled(false);
            button3.setBackgroundColor(getResources().getColor(R.color.red));
            button.setEnabled(false);
            button.setBackgroundColor(getResources().getColor(R.color.red));
            text.setText("RESPUESTA CORRECTA");

        }
        Button atras = (Button) findViewById(R.id.atras);
        Button siguiente = (Button) findViewById(R.id.siguiente);
        atras.setVisibility(View.VISIBLE);
        siguiente.setVisibility(View.VISIBLE);
    }




    // Cuando se pulsa el botón atrás se inicia la actividad anterior y se elimina la actual de la pila de actividades
    public void atras(View v){
        Intent intent = new Intent(this, Learning.class);
        Bundle bundle = new Bundle();
        bundle.putString("category", category);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    // Cuando se pulsa el botón siguiente se inicia otra actividad examen, guardando el un bundle lo necesario y se
    // elimina la actividad actual de la pila de actividades
    public void siguiente(View v){
        Intent intent = new Intent(this, exam.class);
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("list", list);
        bundle.putString("category", category);
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
        finish();
    }

}