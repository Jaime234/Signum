package com.example.signum;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CompoundButton;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.Normalizer;
import java.util.ArrayList;

// Clase vídeo que se utiliza en la función que parsea el fichero .json
class video {
    private String tipo;
    private String idImagen;


    public video() {
        this.tipo = "";
        this.idImagen = "";
    }

    public void setidImagen(String idImagen) {
        this.idImagen = idImagen;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getidImagen() {
        return idImagen;
    }

    public String getTipo() {
        return tipo;
    }

}

public class MainActivity extends AppCompatActivity {

    private db dbAdapter;
    private static final String DATABASE_NAME = "data";
    private static final String PRELOADED_DATABASE_NAME = "data.db";
    private ArrayList<String> sugerencias = new ArrayList<String>();
    private SwitchCompat modoNoche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration config = getResources().getConfiguration();
        onConfigurationChanged(config);
        // Creamos el adaptador de la BD y la abrimos
        dbAdapter = new db(this);
        dbAdapter.open();
        //Se comprueba si es la primera vez que se ejucta la aplicación, en cuyo caso se crea la base de datos en la carpeta databases
        SharedPreferences mPreferences = this.getSharedPreferences("first_time", Context.MODE_PRIVATE);
        Boolean firstTime = mPreferences.getBoolean("firstTime", true);
        if (firstTime) {
            try {
                String destPath = "/data/data/" + getPackageName() + "/databases/" + DATABASE_NAME;

                System.out.println("Traza: no existe el fichero");
                InputStream in = getAssets().open(PRELOADED_DATABASE_NAME);
                OutputStream out = new FileOutputStream(destPath);

                byte[] buffer = new byte[1024];
                int length;
                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }
                in.close();
                out.flush();
                out.close();
                SharedPreferences.Editor editor = mPreferences.edit();
                editor.putBoolean("firstTime", false);
                editor.commit();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        // Botón encargado de forzar el modo noche en la aplicación
        modoNoche = (SwitchCompat) findViewById(R.id.modoNoche);
        modoNoche.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    //setBackgroundResource(null);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

                }
            }
        });
        int nightModeFlags =
                modoNoche.getContext().getResources().getConfiguration().uiMode &
                        Configuration.UI_MODE_NIGHT_MASK;
        switch (nightModeFlags) {
            case Configuration.UI_MODE_NIGHT_YES:
                modoNoche.setChecked(true);
                break;

            case Configuration.UI_MODE_NIGHT_NO:
                modoNoche.setChecked(false);
                break;
        }

        AutoCompleteTextView auto = (AutoCompleteTextView) findViewById(R.id.auto);
        // Creamos un cursor que apunte a todas las palabras de la base de datos
        Cursor cursor = dbAdapter.fetchAllWords("sugerencias");

        // Guardamos todas las palabras de la base de datos en un Array List y se las asignamos a la lista de sugerencias del AutoCompleteTextView.

        for(int i = 1; i <cursor.getCount();i++){
            Cursor c = dbAdapter.fetchWord(i,"sugerencias");
            sugerencias.add(c.getString(c.getColumnIndexOrThrow(db.KEY_TITLE)));
        }
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_dropdown_item_1line, sugerencias);
        auto.setAdapter(adapter);

    }


    // Función encargada de cambiar entre 2 xml dependiendo de si el móvil está en posición vertical u horizontal.
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            setContentView(R.layout.activity_main); // it will use .xml from /res/layout
        }
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            setContentView(R.layout.activity_main_land); // it will use xml from /res/layout-land
        }
    }

    // Infla las opciones del menú en el App Bar
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Se encarga de realizar las acciones correspondientes cuando se pulsan las opciones del App Bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about:
                about_us();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    // Función encargada de iniciar la actividad que traduce a lse (Translation_Screen) cuando se pulsa el botón de búsqueda
    public void sendText(View v){
        AutoCompleteTextView nameText = (AutoCompleteTextView) findViewById(R.id.auto);
        // Guardamos el texto del editText en la variable word
        // Se eliminan tildes y mayúsculas para evitar problemas al buscar la palabra en el fichero .json
        String word = nameText.getText().toString().toLowerCase();
        word = Normalizer.normalize(word, Normalizer.Form.NFD);
        word = word.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        String id = "0";
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
        } else if(id.equals("-1")) {
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
        // Si la palabra fue encontrada se crea un Bundle en el que se guarda el id para que la siguiente
        // actividad despligue el vídeo correspondiente y se inicia dicha actividad
            Intent intent = new Intent(this, Translation_screen.class);
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            bundle.putStringArrayList("sugerencias",sugerencias);
            intent.putExtras(bundle);
            startActivity(intent);
            nameText.getText().clear();
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

    // Cuando se pulsa el botón minijuegos se inicia la actividad correspondiente
    public void minijuegos(View v){
        Intent intent = new Intent(this, minijuegos.class);
        startActivity(intent);

    }

    // Cuando se pulsa el botón opciones se inicia la actividad correspondiente
    public void opciones(View v){
        Intent intent = new Intent(this, opciones.class);
        startActivity(intent);

    }

    // Cuando se pulsa el botón About Us se inicia la actividad correspondiente
    public void about_us(){
        Intent intent = new Intent(this, about_us.class);
        startActivity(intent);
    }
}





