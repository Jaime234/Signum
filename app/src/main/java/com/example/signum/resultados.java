package com.example.signum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class resultados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        Bundle b = getIntent().getExtras();
        TextView text1 = (TextView) findViewById(R.id.textView1);
        TextView text2 = (TextView) findViewById(R.id.textView2);
        TextView text3 = (TextView) findViewById(R.id.textView3);
        String[] word = b.getStringArray("word");
        int aciertos = b.getInt("contadorAcierto");

        // En función del número de aciertos se muestra un mensaje distinto.
        if(aciertos == 26){
            text1.setText(R.string.titulo1);
            text2.setText(R.string.acertado);
            text3.setText(String.valueOf(aciertos));
        }else if(aciertos<26 && aciertos>=16){
            text1.setText(R.string.titulo2);
            text2.setText(R.string.acertado);
            text3.setText(String.valueOf(aciertos));
        }else if(aciertos<16 && aciertos>0){
            text1.setText(R.string.titulo3);
            text2.setText(R.string.acertado);
            text3.setText(String.valueOf(aciertos));
        }else{
            text1.setText(R.string.titulo4);
            text2.setText(R.string.acertado);
            text3.setText(String.valueOf(aciertos));
        }

        ListView list = (ListView) findViewById(R.id.lista);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, word);
        list.setAdapter(aa);
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

    // Cuando se pulsa el botón Jugar Otra se inicia la actividad correspondiente
    public void Otra(View view){
        Intent intent = new Intent(this, opciones.class);
        startActivity(intent);
        finish();
    }

    // Cuando se pulsa el botón Atrás se vuelve a la main activity
    public void atras(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

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