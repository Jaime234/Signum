package com.example.signum;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class minijuegos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration config = getResources().getConfiguration();
        onConfigurationChanged(config);
    }

    // Función encargada de cambiar entre 2 xml dependiendo de si el móvil está en posición vertical u horizontal.
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            setContentView(R.layout.activity_minijuegos); // it will use .xml from /res/layout
        }
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            setContentView(R.layout.activity_minijuegos_land); // it will use xml from /res/layout-land
        }
    }

    // Infla las opciones del menú en el App Bar
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
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

    // Al pulsar el botón se guarda el String category en un bundle para que la siguiente actividad
    // acceda a la tabla de la base de datos correspondiente y se inicia dicha actividad
    public void acciones(View v){
        Intent intent = new Intent(this, Learning.class);
        Bundle b = new Bundle();
        String category = "acciones";
        b.putString("category", category);
        intent.putExtras(b);
        startActivity(intent);

    }

    // Al pulsar el botón se guarda el String category en un bundle para que la siguiente actividad
    // acceda a la tabla de la base de datos correspondiente y se inicia dicha actividad
    public void cuerpo(View v){
        Intent intent = new Intent(this, Learning.class);
        Bundle b = new Bundle();
        String category = "cuerpo";
        b.putString("category", category);
        intent.putExtras(b);
        startActivity(intent);

    }

    // Al pulsar el botón se guarda el String category en un bundle para que la siguiente actividad
    // acceda a la tabla de la base de datos correspondiente y se inicia dicha actividad
    public void numeros(View v){
        Intent intent = new Intent(this, Learning.class);
        Bundle b = new Bundle();
        String category = "numeros";
        b.putString("category", category);
        intent.putExtras(b);
        startActivity(intent);

    }

    // Al pulsar el botón se guarda el String category en un bundle para que la siguiente actividad
    // acceda a la tabla de la base de datos correspondiente y se inicia dicha actividad
    public void colores(View v){
        Intent intent = new Intent(this, Learning.class);
        Bundle b = new Bundle();
        String category = "colores";
        b.putString("category", category);
        intent.putExtras(b);
        startActivity(intent);

    }

    // Al pulsar el botón se guarda el String category en un bundle para que la siguiente actividad
    // acceda a la tabla de la base de datos correspondiente y se inicia dicha actividad
    public void comida(View v){
        Intent intent = new Intent(this, Learning.class);
        Bundle b = new Bundle();
        String category = "comida";
        b.putString("category", category);
        intent.putExtras(b);
        startActivity(intent);

    }

    // Al pulsar el botón se guarda el String category en un bundle para que la siguiente actividad
    // acceda a la tabla de la base de datos correspondiente y se inicia dicha actividad
    public void paises(View v){
        Intent intent = new Intent(this, Learning.class);
        Bundle b = new Bundle();
        String category = "paises";
        b.putString("category", category);
        intent.putExtras(b);
        startActivity(intent);

    }

    // Al pulsar el botón se guarda el String category en un bundle para que la siguiente actividad
    // acceda a la tabla de la base de datos correspondiente y se inicia dicha actividad
    public void animales(View v){
        Intent intent = new Intent(this, Learning.class);
        Bundle b = new Bundle();
        String category = "animales";
        b.putString("category", category);
        intent.putExtras(b);
        startActivity(intent);
    }

    // Al pulsar el botón se guarda el String category en un bundle para que la siguiente actividad
    // acceda a la tabla de la base de datos correspondiente y se inicia dicha actividad
    public void saludos(View v){
        Intent intent = new Intent(this, Learning.class);
        Bundle b = new Bundle();
        String category = "saludos";
        b.putString("category", category);
        intent.putExtras(b);
        startActivity(intent);

    }

    // Al pulsar el botón se guarda el String category en un bundle para que la siguiente actividad
    // acceda a la tabla de la base de datos correspondiente y se inicia dicha actividad
    public void ropa(View v){
        Intent intent = new Intent(this, Learning.class);
        Bundle b = new Bundle();
        String category = "ropa";
        b.putString("category", category);
        intent.putExtras(b);
        startActivity(intent);

    }

    // Al pulsar el botón se guarda el String category en un bundle para que la siguiente actividad
    // acceda a la tabla de la base de datos correspondiente y se inicia dicha actividad
    public void abc(View v){
        Intent intent = new Intent(this, Learning.class);
        Bundle b = new Bundle();
        String category = "abc";
        b.putString("category", category);
        intent.putExtras(b);
        startActivity(intent);

    }

    // Al pulsar el botón se guarda el String category en un bundle para que la siguiente actividad
    // acceda a la tabla de la base de datos correspondiente y se inicia dicha actividad
    public void sugerencias(View v){
        Intent intent = new Intent(this, Learning.class);
        Bundle b = new Bundle();
        String category = "sugerencias";
        b.putString("category",category);
        intent.putExtras(b);
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