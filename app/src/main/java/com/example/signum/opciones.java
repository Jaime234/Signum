package com.example.signum;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.Normalizer;


public class opciones extends AppCompatActivity {

    private db dbAdapter;
    private Cursor cursor;
    private int contadorAcierto = 0;
    private Boolean firstTimeA = false,firstTimeB = false,firstTimeC= false,firstTimeD= false,firstTimeE= false,firstTimeF= false,firstTimeG= false,
            firstTimeH = false,firstTimeI = false,firstTimeJ = false,firstTimeK = false,firstTimeL = false,
            firstTimeM= false,firstTimeN= false,firstTimeO= false,firstTimeP= false,firstTimeQ= false,firstTimeR= false,
            firstTimeS= false,firstTimeT= false,firstTimeU= false,firstTimeV= false,firstTimeW= false,
            firstTimeX= false,firstTimeY = false,firstTimeZ = false;
    private Boolean answered_A = false,answered_B = false,answered_C= false,answered_D= false,answered_E= false,answered_F= false,answered_G= false,
            answered_H = false,answered_I = false,answered_J = false,answered_K = false,answered_L = false,
            answered_M= false,answered_N= false,answered_O= false,answered_P= false,answered_Q= false,answered_R= false,
            answered_S= false,answered_T= false,answered_U= false,answered_V= false,answered_W= false,
            answered_X= false,answered_Y = false,answered_Z = false;
    private String [] word = {"","","","","","","","","","","",
            "","","","","","","","","","","","","","","",};
    private String [] id = {"-1","-1","-1","-1","-1","-1","-1","-1","-1","-1","-1",
            "-1","-1","-1","-1","-1","-1","-1","-1","-1","-1","-1","-1","-1","-1","-1"};
    private VideoView video;
    private String w;
    private String vu;
    private static final String DATABASE_NAME = "data";
    private static final String PRELOADED_DATABASE_NAME = "data.db";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);
        // Creamos el adaptador de la BD y la abrimos
        dbAdapter = new db(this);
        dbAdapter.open();
        Button button = (Button)findViewById(R.id.buttonResultados);
        button.setVisibility(View.GONE);
        video = (VideoView) findViewById(R.id.video);
        // Se oculta el vídeo hasta que el usuario escoja una palabra
        video.setVisibility(View.GONE);


        //En cada posición del array word se guarda una palabra aleatoria de cada letra
        cursor = dbAdapter.randomWord("a");
        word[0] = cursor.getString(cursor.getColumnIndexOrThrow(db.KEY_TITLE));
        cursor = dbAdapter.randomWord("b");
        word[1] = cursor.getString(cursor.getColumnIndexOrThrow(db.KEY_TITLE));
        cursor = dbAdapter.randomWord("c");
        word[2] = cursor.getString(cursor.getColumnIndexOrThrow(db.KEY_TITLE));
        cursor = dbAdapter.randomWord("d");
        word[3] = cursor.getString(cursor.getColumnIndexOrThrow(db.KEY_TITLE));
        cursor = dbAdapter.randomWord("e");
        word[4] = cursor.getString(cursor.getColumnIndexOrThrow(db.KEY_TITLE));
        cursor = dbAdapter.randomWord("f");
        word[5] = cursor.getString(cursor.getColumnIndexOrThrow(db.KEY_TITLE));
        cursor = dbAdapter.randomWord("g");
        word[6] = cursor.getString(cursor.getColumnIndexOrThrow(db.KEY_TITLE));
        cursor = dbAdapter.randomWord("h");
        word[7] = cursor.getString(cursor.getColumnIndexOrThrow(db.KEY_TITLE));
        cursor = dbAdapter.randomWord("i");
        word[8] = cursor.getString(cursor.getColumnIndexOrThrow(db.KEY_TITLE));
        cursor = dbAdapter.randomWord("j");
        word[9] = cursor.getString(cursor.getColumnIndexOrThrow(db.KEY_TITLE));
        cursor = dbAdapter.randomWord("k");
        word[10] = cursor.getString(cursor.getColumnIndexOrThrow(db.KEY_TITLE));
        cursor = dbAdapter.randomWord("l");
        word[11] = cursor.getString(cursor.getColumnIndexOrThrow(db.KEY_TITLE));
        cursor = dbAdapter.randomWord("m");
        word[12] = cursor.getString(cursor.getColumnIndexOrThrow(db.KEY_TITLE));
        cursor = dbAdapter.randomWord("n");
        word[13] = cursor.getString(cursor.getColumnIndexOrThrow(db.KEY_TITLE));
        cursor = dbAdapter.randomWord("o");
        word[14] = cursor.getString(cursor.getColumnIndexOrThrow(db.KEY_TITLE));
        cursor = dbAdapter.randomWord("p");
        word[15] = cursor.getString(cursor.getColumnIndexOrThrow(db.KEY_TITLE));
        cursor = dbAdapter.randomWord("q");
        word[16] = cursor.getString(cursor.getColumnIndexOrThrow(db.KEY_TITLE));
        cursor = dbAdapter.randomWord("r");
        word[17] = cursor.getString(cursor.getColumnIndexOrThrow(db.KEY_TITLE));
        cursor = dbAdapter.randomWord("s");
        word[18] = cursor.getString(cursor.getColumnIndexOrThrow(db.KEY_TITLE));
        cursor = dbAdapter.randomWord("t");
        word[19] = cursor.getString(cursor.getColumnIndexOrThrow(db.KEY_TITLE));
        cursor = dbAdapter.randomWord("u");
        word[20] = cursor.getString(cursor.getColumnIndexOrThrow(db.KEY_TITLE));
        cursor = dbAdapter.randomWord("v");
        word[21] = cursor.getString(cursor.getColumnIndexOrThrow(db.KEY_TITLE));
        cursor = dbAdapter.randomWord("w");
        word[22] = cursor.getString(cursor.getColumnIndexOrThrow(db.KEY_TITLE));
        cursor = dbAdapter.randomWord("x");
        word[23] = cursor.getString(cursor.getColumnIndexOrThrow(db.KEY_TITLE));
        cursor = dbAdapter.randomWord("y");
        word[24] = cursor.getString(cursor.getColumnIndexOrThrow(db.KEY_TITLE));
        cursor = dbAdapter.randomWord("z");
        word[25] = cursor.getString(cursor.getColumnIndexOrThrow(db.KEY_TITLE));

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

    public void ButtonInfoOnClick(View view) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.activity_pop, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }



    //Función encargada de que, cuando se pulsa un botón de una letra, aparezca el vídeo correspondiente. También se encarga de verificar si la palabra
    //introducida por el usuario es correcta o no. Cuando se ha respondido a todo aparece un botón para ir a la actividad que muestra la solución.
    public void button(View view){
        String url = "";

        final EditText edittext = (EditText) findViewById(R.id.editText);
        Button button;
        switch(view.getId()) {
            case R.id.buttonA:
                if (!firstTimeA) {
                    try {
                        id[0] = readJson(word[0]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    firstTimeA = true;
                }

                url = "https://www.lab.it.uc3m.es/~0345838/LSE_acepciones/" + id[0] + ".mp4";
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
                button = (Button) findViewById(R.id.buttonA);
                AlertDialog.Builder ad = new AlertDialog.Builder(this);
                edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_SEND) {
                            w = edittext.getText().toString().toLowerCase();
                            w = Normalizer.normalize(w, Normalizer.Form.NFD);
                            w = w.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            vu = word[0].toLowerCase();
                            vu = Normalizer.normalize(vu, Normalizer.Form.NFD);
                            vu = vu.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            if (w.equals(vu)) {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.green));
                                edittext.getText().clear();
                                contadorAcierto++;
                            } else if(w.trim().length() == 0){
                                ad.setTitle(R.string.title_dialog);
                                ad.setMessage(R.string.message);
                                ad.setPositiveButton(R.string.button_ok,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int arg1) {
                                                dialog.cancel();
                                            }
                                        });
                                ad.show();

                            }else {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.red));
                                edittext.getText().clear();

                            }
                            answered_A = true;
                            if(answered_A == true && answered_B == true &&answered_C == true &&answered_D == true &&
                                    answered_E == true &&answered_F == true &&answered_G == true &&answered_H == true &&
                                    answered_I == true &&answered_J == true &&answered_K == true &&answered_L == true &&
                                    answered_M == true &&answered_N == true &&answered_O == true &&
                                    answered_P == true &&answered_Q == true &&answered_R == true &&answered_S == true &&
                                    answered_T == true &&answered_U == true &&answered_V == true &&answered_W == true &&
                                    answered_X == true &&answered_Y == true &&answered_Z == true){
                                Button results = (Button)findViewById(R.id.buttonResultados);
                                results.setVisibility(View.VISIBLE);
                            }
                            handled = true;
                        }
                        return handled;
                    }
                });


                break;
            case R.id.buttonB:
                if (!firstTimeB) {
                    try {
                        id[1] = readJson(word[1]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    firstTimeB = true;
                }

                url = "https://www.lab.it.uc3m.es/~0345838/LSE_acepciones/" + id[1] + ".mp4";
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
                button = (Button) findViewById(R.id.buttonB);
                ad = new AlertDialog.Builder(this);
                edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_SEND) {
                            w = edittext.getText().toString().toLowerCase();
                            w = Normalizer.normalize(w, Normalizer.Form.NFD);
                            w = w.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            vu = word[1].toLowerCase();
                            vu = Normalizer.normalize(vu, Normalizer.Form.NFD);
                            vu = vu.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            if (w.equals(vu)) {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.green));
                                edittext.getText().clear();
                                contadorAcierto++;
                            } else if(w.trim().length() == 0){
                                ad.setTitle(R.string.title_dialog);
                                ad.setMessage(R.string.message);
                                ad.setPositiveButton(R.string.button_ok,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int arg1) {
                                                dialog.cancel();
                                            }
                                        });
                                ad.show();

                            }else {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.red));
                                edittext.getText().clear();

                            }
                            answered_B = true;
                            if(answered_A == true && answered_B == true &&answered_C == true &&answered_D == true &&
                                    answered_E == true &&answered_F == true &&answered_G == true &&answered_H == true &&
                                    answered_I == true &&answered_J == true &&answered_K == true &&answered_L == true &&
                                    answered_M == true &&answered_N == true &&answered_O == true &&
                                    answered_P == true &&answered_Q == true &&answered_R == true &&answered_S == true &&
                                    answered_T == true &&answered_U == true &&answered_V == true &&answered_W == true &&
                                    answered_X == true &&answered_Y == true &&answered_Z == true){
                                Button results = (Button)findViewById(R.id.buttonResultados);
                                results.setVisibility(View.VISIBLE);
                            }
                            handled = true;
                        }
                        return handled;
                    }
                });


                break;
            case R.id.buttonC:
                if (!firstTimeC) {
                    try {
                        id[2] = readJson(word[2]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    firstTimeC = true;
                }

                url = "https://www.lab.it.uc3m.es/~0345838/LSE_acepciones/" + id[2] + ".mp4";
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
                button = (Button) findViewById(R.id.buttonC);
                ad = new AlertDialog.Builder(this);
                edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_SEND) {
                            w = edittext.getText().toString().toLowerCase();
                            System.out.println(edittext.getText().toString().toLowerCase());
                            w = Normalizer.normalize(w, Normalizer.Form.NFD);
                            w = w.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            vu = word[2].toLowerCase();
                            vu = Normalizer.normalize(vu, Normalizer.Form.NFD);
                            vu = vu.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            System.out.println(vu);
                            if (w.equals(vu)) {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.green));
                                edittext.getText().clear();
                                contadorAcierto++;
                            } else if(w.trim().length() == 0){
                                ad.setTitle(R.string.title_dialog);
                                ad.setMessage(R.string.message);
                                ad.setPositiveButton(R.string.button_ok,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int arg1) {
                                                dialog.cancel();
                                            }
                                        });
                                ad.show();

                            }else {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.red));
                                edittext.getText().clear();

                            }
                            handled = true;
                        }
                        answered_C = true;
                        if(answered_A == true && answered_B == true &&answered_C == true &&answered_D == true &&
                                answered_E == true &&answered_F == true &&answered_G == true &&answered_H == true &&
                                answered_I == true &&answered_J == true &&answered_K == true &&answered_L == true &&
                                answered_M == true &&answered_N == true &&answered_O == true &&
                                answered_P == true &&answered_Q == true &&answered_R == true &&answered_S == true &&
                                answered_T == true &&answered_U == true &&answered_V == true &&answered_W == true &&
                                answered_X == true &&answered_Y == true &&answered_Z == true){
                            Button results = (Button)findViewById(R.id.buttonResultados);
                            results.setVisibility(View.VISIBLE);
                        }
                        return handled;
                    }
                });


                break;
            case R.id.buttonD:
                if (!firstTimeD) {
                    try {
                        id[3] = readJson(word[3]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    firstTimeD = true;
                }
                url = "https://www.lab.it.uc3m.es/~0345838/LSE_acepciones/" + id[3] + ".mp4";
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
                button = (Button) findViewById(R.id.buttonD);
                ad = new AlertDialog.Builder(this);
                edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_SEND) {
                            w = edittext.getText().toString().toLowerCase();
                            w = Normalizer.normalize(w, Normalizer.Form.NFD);
                            w = w.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            vu = word[3].toLowerCase();
                            vu = Normalizer.normalize(vu, Normalizer.Form.NFD);
                            vu = vu.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            if (w.equals(vu)) {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.green));
                                edittext.getText().clear();
                                contadorAcierto++;
                            } else if(w.trim().length() == 0){
                                ad.setTitle(R.string.title_dialog);
                                ad.setMessage(R.string.message);
                                ad.setPositiveButton(R.string.button_ok,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int arg1) {
                                                dialog.cancel();
                                            }
                                        });
                                ad.show();

                            }else {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.red));
                                edittext.getText().clear();

                            }
                            answered_D = true;
                            if(answered_A == true && answered_B == true &&answered_C == true &&answered_D == true &&
                                    answered_E == true &&answered_F == true &&answered_G == true &&answered_H == true &&
                                    answered_I == true &&answered_J == true &&answered_K == true &&answered_L == true &&
                                    answered_M == true &&answered_N == true &&answered_O == true &&
                                    answered_P == true &&answered_Q == true &&answered_R == true &&answered_S == true &&
                                    answered_T == true &&answered_U == true &&answered_V == true &&answered_W == true &&
                                    answered_X == true &&answered_Y == true &&answered_Z == true){
                                Button results = (Button)findViewById(R.id.buttonResultados);
                                results.setVisibility(View.VISIBLE);
                            }
                            handled = true;
                        }
                        return handled;
                    }
                });


                break;
            case R.id.buttonE:
                if (!firstTimeE) {
                    try {
                        id[4] = readJson(word[4]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    firstTimeE = true;
                }
                url = "https://www.lab.it.uc3m.es/~0345838/LSE_acepciones/" + id[4] + ".mp4";
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
                button = (Button) findViewById(R.id.buttonE);
                ad = new AlertDialog.Builder(this);
                edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_SEND) {
                            w = edittext.getText().toString().toLowerCase();
                            w = Normalizer.normalize(w, Normalizer.Form.NFD);
                            w = w.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            vu = word[4].toLowerCase();
                            vu = Normalizer.normalize(vu, Normalizer.Form.NFD);
                            vu = vu.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            if (w.equals(vu)) {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.green));
                                edittext.getText().clear();
                                contadorAcierto++;
                            } else if(w.trim().length() == 0){
                                ad.setTitle(R.string.title_dialog);
                                ad.setMessage(R.string.message);
                                ad.setPositiveButton(R.string.button_ok,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int arg1) {
                                                dialog.cancel();
                                            }
                                        });
                                ad.show();

                            }else {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.red));
                                edittext.getText().clear();

                            }
                            answered_E = true;
                            if(answered_A == true && answered_B == true &&answered_C == true &&answered_D == true &&
                                    answered_E == true &&answered_F == true &&answered_G == true &&answered_H == true &&
                                    answered_I == true &&answered_J == true &&answered_K == true &&answered_L == true &&
                                    answered_M == true &&answered_N == true &&answered_O == true &&
                                    answered_P == true &&answered_Q == true &&answered_R == true &&answered_S == true &&
                                    answered_T == true &&answered_U == true &&answered_V == true &&answered_W == true &&
                                    answered_X == true &&answered_Y == true &&answered_Z == true){
                                Button results = (Button)findViewById(R.id.buttonResultados);
                                results.setVisibility(View.VISIBLE);
                            }
                            handled = true;
                        }
                        return handled;
                    }
                });


                break;
            case R.id.buttonF:
                if (!firstTimeF) {
                    try {
                        id[5] = readJson(word[5]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    firstTimeF = true;
                }
                url = "https://www.lab.it.uc3m.es/~0345838/LSE_acepciones/" + id[5] + ".mp4";
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
                button = (Button) findViewById(R.id.buttonF);
                ad = new AlertDialog.Builder(this);
                edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_SEND) {
                            w = edittext.getText().toString().toLowerCase();
                            w = Normalizer.normalize(w, Normalizer.Form.NFD);
                            w = w.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            vu = word[5].toLowerCase();
                            vu = Normalizer.normalize(vu, Normalizer.Form.NFD);
                            vu = vu.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            if (w.equals(vu)) {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.green));
                                edittext.getText().clear();
                                contadorAcierto++;
                            } else if(w.trim().length() == 0){
                                ad.setTitle(R.string.title_dialog);
                                ad.setMessage(R.string.message);
                                ad.setPositiveButton(R.string.button_ok,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int arg1) {
                                                dialog.cancel();
                                            }
                                        });
                                ad.show();

                            }else {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.red));
                                edittext.getText().clear();

                            }
                            answered_F = true;
                            if(answered_A == true && answered_B == true &&answered_C == true &&answered_D == true &&
                                    answered_E == true &&answered_F == true &&answered_G == true &&answered_H == true &&
                                    answered_I == true &&answered_J == true &&answered_K == true &&answered_L == true &&
                                    answered_M == true &&answered_N == true &&answered_O == true &&
                                    answered_P == true &&answered_Q == true &&answered_R == true &&answered_S == true &&
                                    answered_T == true &&answered_U == true &&answered_V == true &&answered_W == true &&
                                    answered_X == true &&answered_Y == true &&answered_Z == true){
                                Button results = (Button)findViewById(R.id.buttonResultados);
                                results.setVisibility(View.VISIBLE);
                            }
                            handled = true;
                        }
                        return handled;
                    }
                });


                break;
            case R.id.buttonG:
                if (!firstTimeG) {
                    try {
                        id[6] = readJson(word[6]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    firstTimeG = true;
                }
                url = "https://www.lab.it.uc3m.es/~0345838/LSE_acepciones/" + id[6] + ".mp4";
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
                button = (Button) findViewById(R.id.buttonG);
                ad = new AlertDialog.Builder(this);
                edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_SEND) {
                            w = edittext.getText().toString().toLowerCase();
                            w = Normalizer.normalize(w, Normalizer.Form.NFD);
                            w = w.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            vu = word[6].toLowerCase();
                            vu = Normalizer.normalize(vu, Normalizer.Form.NFD);
                            vu = vu.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            if (w.equals(vu)) {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.green));
                                edittext.getText().clear();
                                contadorAcierto++;
                            } else if(w.trim().length() == 0){
                                ad.setTitle(R.string.title_dialog);
                                ad.setMessage(R.string.message);
                                ad.setPositiveButton(R.string.button_ok,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int arg1) {
                                                dialog.cancel();
                                            }
                                        });
                                ad.show();

                            }else {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.red));
                                edittext.getText().clear();

                            }
                            answered_G = true;
                            if(answered_A == true && answered_B == true &&answered_C == true &&answered_D == true &&
                                    answered_E == true &&answered_F == true &&answered_G == true &&answered_H == true &&
                                    answered_I == true &&answered_J == true &&answered_K == true &&answered_L == true &&
                                    answered_M == true &&answered_N == true &&answered_O == true &&
                                    answered_P == true &&answered_Q == true &&answered_R == true &&answered_S == true &&
                                    answered_T == true &&answered_U == true &&answered_V == true &&answered_W == true &&
                                    answered_X == true &&answered_Y == true &&answered_Z == true){
                                Button results = (Button)findViewById(R.id.buttonResultados);
                                results.setVisibility(View.VISIBLE);
                            }
                            handled = true;
                        }
                        return handled;
                    }
                });


                break;
            case R.id.buttonH:
                if (!firstTimeH) {
                    try {
                        id[7] = readJson(word[7]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    firstTimeH = true;
                }
                url = "https://www.lab.it.uc3m.es/~0345838/LSE_acepciones/" + id[7] + ".mp4";
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
                button = (Button) findViewById(R.id.buttonH);
                ad = new AlertDialog.Builder(this);
                edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_SEND) {
                            w = edittext.getText().toString().toLowerCase();
                            w = Normalizer.normalize(w, Normalizer.Form.NFD);
                            w = w.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            vu = word[7].toLowerCase();
                            vu = Normalizer.normalize(vu, Normalizer.Form.NFD);
                            vu = vu.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            if (w.equals(vu)) {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.green));
                                edittext.getText().clear();
                                contadorAcierto++;
                            } else if(w.trim().length() == 0){
                                ad.setTitle(R.string.title_dialog);
                                ad.setMessage(R.string.message);
                                ad.setPositiveButton(R.string.button_ok,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int arg1) {
                                                dialog.cancel();
                                            }
                                        });
                                ad.show();

                            }else {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.red));
                                edittext.getText().clear();

                            }
                            answered_H = true;
                            if(answered_A == true && answered_B == true &&answered_C == true &&answered_D == true &&
                                    answered_E == true &&answered_F == true &&answered_G == true &&answered_H == true &&
                                    answered_I == true &&answered_J == true &&answered_K == true &&answered_L == true &&
                                    answered_M == true &&answered_N == true &&answered_O == true &&
                                    answered_P == true &&answered_Q == true &&answered_R == true &&answered_S == true &&
                                    answered_T == true &&answered_U == true &&answered_V == true &&answered_W == true &&
                                    answered_X == true &&answered_Y == true &&answered_Z == true){
                                Button results = (Button)findViewById(R.id.buttonResultados);
                                results.setVisibility(View.VISIBLE);
                            }
                            handled = true;
                        }
                        return handled;
                    }
                });


                break;
            case R.id.buttonI:
                if (!firstTimeI) {
                    try {
                        id[8] = readJson(word[8]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    firstTimeI = true;
                }
                url = "https://www.lab.it.uc3m.es/~0345838/LSE_acepciones/" + id[8] + ".mp4";
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
                button = (Button) findViewById(R.id.buttonI);
                ad = new AlertDialog.Builder(this);
                edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_SEND) {
                            w = edittext.getText().toString().toLowerCase();
                            w = Normalizer.normalize(w, Normalizer.Form.NFD);
                            w = w.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            vu = word[8].toLowerCase();
                            vu = Normalizer.normalize(vu, Normalizer.Form.NFD);
                            vu = vu.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            if (w.equals(vu)) {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.green));
                                edittext.getText().clear();
                                contadorAcierto++;
                            } else if(w.trim().length() == 0){
                                ad.setTitle(R.string.title_dialog);
                                ad.setMessage(R.string.message);
                                ad.setPositiveButton(R.string.button_ok,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int arg1) {
                                                dialog.cancel();
                                            }
                                        });
                                ad.show();

                            }else {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.red));
                                edittext.getText().clear();

                            }
                            answered_I = true;
                            if(answered_A == true && answered_B == true &&answered_C == true &&answered_D == true &&
                                    answered_E == true &&answered_F == true &&answered_G == true &&answered_H == true &&
                                    answered_I == true &&answered_J == true &&answered_K == true &&answered_L == true &&
                                    answered_M == true &&answered_N == true &&answered_O == true &&
                                    answered_P == true &&answered_Q == true &&answered_R == true &&answered_S == true &&
                                    answered_T == true &&answered_U == true &&answered_V == true &&answered_W == true &&
                                    answered_X == true &&answered_Y == true &&answered_Z == true){
                                Button results = (Button)findViewById(R.id.buttonResultados);
                                results.setVisibility(View.VISIBLE);
                            }
                            handled = true;
                        }
                        return handled;
                    }
                });


                break;
            case R.id.buttonJ:
                if (!firstTimeJ) {
                    try {
                        id[9] = readJson(word[9]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    firstTimeJ = true;
                }
                url = "https://www.lab.it.uc3m.es/~0345838/LSE_acepciones/" + id[9] + ".mp4";
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
                button = (Button) findViewById(R.id.buttonJ);
                ad = new AlertDialog.Builder(this);
                edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_SEND) {
                            w = edittext.getText().toString().toLowerCase();
                            w = Normalizer.normalize(w, Normalizer.Form.NFD);
                            w = w.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            vu = word[9].toLowerCase();
                            vu = Normalizer.normalize(vu, Normalizer.Form.NFD);
                            vu = vu.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            if (w.equals(vu)) {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.green));
                                edittext.getText().clear();
                                contadorAcierto++;
                            } else if(w.trim().length() == 0){
                                ad.setTitle(R.string.title_dialog);
                                ad.setMessage(R.string.message);
                                ad.setPositiveButton(R.string.button_ok,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int arg1) {
                                                dialog.cancel();
                                            }
                                        });
                                ad.show();

                            }else {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.red));
                                edittext.getText().clear();

                            }
                            answered_J = true;
                            if(answered_A == true && answered_B == true &&answered_C == true &&answered_D == true &&
                                    answered_E == true &&answered_F == true &&answered_G == true &&answered_H == true &&
                                    answered_I == true &&answered_J == true &&answered_K == true &&answered_L == true &&
                                    answered_M == true &&answered_N == true &&answered_O == true &&
                                    answered_P == true &&answered_Q == true &&answered_R == true &&answered_S == true &&
                                    answered_T == true &&answered_U == true &&answered_V == true &&answered_W == true &&
                                    answered_X == true &&answered_Y == true &&answered_Z == true){
                                Button results = (Button)findViewById(R.id.buttonResultados);
                                results.setVisibility(View.VISIBLE);
                            }
                            handled = true;
                        }
                        return handled;
                    }
                });


                break;
            case R.id.buttonK:
                if (!firstTimeK) {
                    try {
                        id[10] = readJson(word[10]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    firstTimeK = true;
                }
                url = "https://www.lab.it.uc3m.es/~0345838/LSE_acepciones/" + id[10] + ".mp4";
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
                button = (Button) findViewById(R.id.buttonK);
                ad = new AlertDialog.Builder(this);
                edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_SEND) {
                            w = edittext.getText().toString().toLowerCase();
                            w = Normalizer.normalize(w, Normalizer.Form.NFD);
                            w = w.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            vu = word[10].toLowerCase();
                            vu = Normalizer.normalize(vu, Normalizer.Form.NFD);
                            vu = vu.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            if (w.equals(vu)) {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.green));
                                edittext.getText().clear();
                                contadorAcierto++;
                            } else if(w.trim().length() == 0){
                                ad.setTitle(R.string.title_dialog);
                                ad.setMessage(R.string.message);
                                ad.setPositiveButton(R.string.button_ok,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int arg1) {
                                                dialog.cancel();
                                            }
                                        });
                                ad.show();

                            }else {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.red));
                                edittext.getText().clear();

                            }
                            handled = true;
                        }
                        answered_K = true;
                        if(answered_A == true && answered_B == true &&answered_C == true &&answered_D == true &&
                                answered_E == true &&answered_F == true &&answered_G == true &&answered_H == true &&
                                answered_I == true &&answered_J == true &&answered_K == true &&answered_L == true &&
                                answered_M == true &&answered_N == true &&answered_O == true &&
                                answered_P == true &&answered_Q == true &&answered_R == true &&answered_S == true &&
                                answered_T == true &&answered_U == true &&answered_V == true &&answered_W == true &&
                                answered_X == true &&answered_Y == true &&answered_Z == true){
                            Button results = (Button)findViewById(R.id.buttonResultados);
                            results.setVisibility(View.VISIBLE);
                        }
                        return handled;
                    }
                });


                break;
            case R.id.buttonL:
                if (!firstTimeL) {
                    try {
                        id[11] = readJson(word[11]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    firstTimeL = true;
                }
                url = "https://www.lab.it.uc3m.es/~0345838/LSE_acepciones/" + id[11] + ".mp4";
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
                button = (Button) findViewById(R.id.buttonL);
                ad = new AlertDialog.Builder(this);
                edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_SEND) {
                            w = edittext.getText().toString().toLowerCase();
                            w = Normalizer.normalize(w, Normalizer.Form.NFD);
                            w = w.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            vu = word[11].toLowerCase();
                            vu = Normalizer.normalize(vu, Normalizer.Form.NFD);
                            vu = vu.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            if (w.equals(vu)) {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.green));
                                edittext.getText().clear();
                                contadorAcierto++;
                            } else if(w.trim().length() == 0){
                                ad.setTitle(R.string.title_dialog);
                                ad.setMessage(R.string.message);
                                ad.setPositiveButton(R.string.button_ok,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int arg1) {
                                                dialog.cancel();
                                            }
                                        });
                                ad.show();

                            }else {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.red));
                                edittext.getText().clear();

                            }
                            answered_L = true;
                            if(answered_A == true && answered_B == true &&answered_C == true &&answered_D == true &&
                                    answered_E == true &&answered_F == true &&answered_G == true &&answered_H == true &&
                                    answered_I == true &&answered_J == true &&answered_K == true &&answered_L == true &&
                                    answered_M == true &&answered_N == true &&answered_O == true &&
                                    answered_P == true &&answered_Q == true &&answered_R == true &&answered_S == true &&
                                    answered_T == true &&answered_U == true &&answered_V == true &&answered_W == true &&
                                    answered_X == true &&answered_Y == true &&answered_Z == true){
                                Button results = (Button)findViewById(R.id.buttonResultados);
                                results.setVisibility(View.VISIBLE);
                            }
                            handled = true;
                        }
                        return handled;
                    }
                });


                break;
            case R.id.buttonM:
                if (!firstTimeM) {
                    try {
                        id[12] = readJson(word[12]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    firstTimeM = true;
                }
                url = "https://www.lab.it.uc3m.es/~0345838/LSE_acepciones/" + id[12] + ".mp4";
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
                button = (Button) findViewById(R.id.buttonM);
                ad = new AlertDialog.Builder(this);
                edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_SEND) {
                            w = edittext.getText().toString().toLowerCase();
                            w = Normalizer.normalize(w, Normalizer.Form.NFD);
                            w = w.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            vu = word[12].toLowerCase();
                            vu = Normalizer.normalize(vu, Normalizer.Form.NFD);
                            vu = vu.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            if (w.equals(vu)) {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.green));
                                edittext.getText().clear();
                                contadorAcierto++;
                            } else if(w.trim().length() == 0){
                                ad.setTitle(R.string.title_dialog);
                                ad.setMessage(R.string.message);
                                ad.setPositiveButton(R.string.button_ok,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int arg1) {
                                                dialog.cancel();
                                            }
                                        });
                                ad.show();

                            }else {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.red));
                                edittext.getText().clear();

                            }
                            answered_M = true;
                            if(answered_A == true && answered_B == true &&answered_C == true &&answered_D == true &&
                                    answered_E == true &&answered_F == true &&answered_G == true &&answered_H == true &&
                                    answered_I == true &&answered_J == true &&answered_K == true &&answered_L == true &&
                                    answered_M == true &&answered_N == true &&answered_O == true &&
                                    answered_P == true &&answered_Q == true &&answered_R == true &&answered_S == true &&
                                    answered_T == true &&answered_U == true &&answered_V == true &&answered_W == true &&
                                    answered_X == true &&answered_Y == true &&answered_Z == true){
                                Button results = (Button)findViewById(R.id.buttonResultados);
                                results.setVisibility(View.VISIBLE);
                            }
                            handled = true;
                        }
                        return handled;
                    }
                });


                break;
            case R.id.buttonN:
                if (!firstTimeN) {
                    try {
                        id[13] = readJson(word[13]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    firstTimeN = true;
                }
                url = "https://www.lab.it.uc3m.es/~0345838/LSE_acepciones/" + id[13] + ".mp4";
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
                button = (Button) findViewById(R.id.buttonN);
                ad = new AlertDialog.Builder(this);
                edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_SEND) {
                            w = edittext.getText().toString().toLowerCase();
                            w = Normalizer.normalize(w, Normalizer.Form.NFD);
                            w = w.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            vu = word[13].toLowerCase();
                            vu = Normalizer.normalize(vu, Normalizer.Form.NFD);
                            vu = vu.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            if (w.equals(vu)) {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.green));
                                edittext.getText().clear();
                                contadorAcierto++;
                            } else if(w.trim().length() == 0){
                                ad.setTitle(R.string.title_dialog);
                                ad.setMessage(R.string.message);
                                ad.setPositiveButton(R.string.button_ok,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int arg1) {
                                                dialog.cancel();
                                            }
                                        });
                                ad.show();

                            }else {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.red));
                                edittext.getText().clear();

                            }
                            handled = true;
                        }
                        answered_N = true;
                        if(answered_A == true && answered_B == true &&answered_C == true &&answered_D == true &&
                                answered_E == true &&answered_F == true &&answered_G == true &&answered_H == true &&
                                answered_I == true &&answered_J == true &&answered_K == true &&answered_L == true &&
                                answered_M == true &&answered_N == true &&answered_O == true &&
                                answered_P == true &&answered_Q == true &&answered_R == true &&answered_S == true &&
                                answered_T == true &&answered_U == true &&answered_V == true &&answered_W == true &&
                                answered_X == true &&answered_Y == true &&answered_Z == true){
                            Button results = (Button)findViewById(R.id.buttonResultados);
                            results.setVisibility(View.VISIBLE);
                        }
                        return handled;
                    }
                });


                break;
            case R.id.buttonO:
                if (!firstTimeO) {
                    try {
                        id[14] = readJson(word[14]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    firstTimeO = true;
                }
                url = "https://www.lab.it.uc3m.es/~0345838/LSE_acepciones/" + id[14] + ".mp4";
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
                button = (Button) findViewById(R.id.buttonO);
                ad = new AlertDialog.Builder(this);
                edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_SEND) {
                            w = edittext.getText().toString().toLowerCase();
                            w = Normalizer.normalize(w, Normalizer.Form.NFD);
                            w = w.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            vu = word[14].toLowerCase();
                            vu = Normalizer.normalize(vu, Normalizer.Form.NFD);
                            vu = vu.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            if (w.equals(vu)) {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.green));
                                edittext.getText().clear();
                                contadorAcierto++;
                            } else if(w.trim().length() == 0){
                                ad.setTitle(R.string.title_dialog);
                                ad.setMessage(R.string.message);
                                ad.setPositiveButton(R.string.button_ok,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int arg1) {
                                                dialog.cancel();
                                            }
                                        });
                                ad.show();

                            }else {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.red));
                                edittext.getText().clear();

                            }
                            handled = true;
                        }
                        answered_O = true;
                        if(answered_A == true && answered_B == true &&answered_C == true &&answered_D == true &&
                                answered_E == true &&answered_F == true &&answered_G == true &&answered_H == true &&
                                answered_I == true &&answered_J == true &&answered_K == true &&answered_L == true &&
                                answered_M == true &&answered_N == true &&answered_O == true &&
                                answered_P == true &&answered_Q == true &&answered_R == true &&answered_S == true &&
                                answered_T == true &&answered_U == true &&answered_V == true &&answered_W == true &&
                                answered_X == true &&answered_Y == true &&answered_Z == true){
                            Button results = (Button)findViewById(R.id.buttonResultados);
                            results.setVisibility(View.VISIBLE);
                        }
                        return handled;
                    }
                });


                break;
            case R.id.buttonP:
                if (!firstTimeP) {
                    try {
                        id[15] = readJson(word[15]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    firstTimeP = true;
                }
                url = "https://www.lab.it.uc3m.es/~0345838/LSE_acepciones/" + id[15] + ".mp4";
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
                button = (Button) findViewById(R.id.buttonP);
                ad = new AlertDialog.Builder(this);
                edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_SEND) {
                            w = edittext.getText().toString().toLowerCase();
                            w = Normalizer.normalize(w, Normalizer.Form.NFD);
                            w = w.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            vu = word[15].toLowerCase();
                            vu = Normalizer.normalize(vu, Normalizer.Form.NFD);
                            vu = vu.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            if (w.equals(vu)) {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.green));
                                edittext.getText().clear();
                                contadorAcierto++;
                            } else if(w.trim().length() == 0){
                                ad.setTitle(R.string.title_dialog);
                                ad.setMessage(R.string.message);
                                ad.setPositiveButton(R.string.button_ok,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int arg1) {
                                                dialog.cancel();
                                            }
                                        });
                                ad.show();

                            }else {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.red));
                                edittext.getText().clear();

                            }
                            answered_P = true;
                            if(answered_A == true && answered_B == true &&answered_C == true &&answered_D == true &&
                                    answered_E == true &&answered_F == true &&answered_G == true &&answered_H == true &&
                                    answered_I == true &&answered_J == true &&answered_K == true &&answered_L == true &&
                                    answered_M == true &&answered_N == true &&answered_O == true &&
                                    answered_P == true &&answered_Q == true &&answered_R == true &&answered_S == true &&
                                    answered_T == true &&answered_U == true &&answered_V == true &&answered_W == true &&
                                    answered_X == true &&answered_Y == true &&answered_Z == true){
                                Button results = (Button)findViewById(R.id.buttonResultados);
                                results.setVisibility(View.VISIBLE);
                            }
                            handled = true;
                        }
                        return handled;
                    }
                });


                break;
            case R.id.buttonQ:
                if (!firstTimeQ) {
                    try {
                        id[16] = readJson(word[16]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    firstTimeQ = true;
                }
                url = "https://www.lab.it.uc3m.es/~0345838/LSE_acepciones/" + id[16] + ".mp4";
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
                button = (Button) findViewById(R.id.buttonQ);
                ad = new AlertDialog.Builder(this);
                edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_SEND) {
                            w = edittext.getText().toString().toLowerCase();
                            w = Normalizer.normalize(w, Normalizer.Form.NFD);
                            w = w.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            vu = word[16].toLowerCase();
                            vu = Normalizer.normalize(vu, Normalizer.Form.NFD);
                            vu = vu.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            if (w.equals(vu)) {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.green));
                                edittext.getText().clear();
                                contadorAcierto++;
                            } else if(w.trim().length() == 0){
                                ad.setTitle(R.string.title_dialog);
                                ad.setMessage(R.string.message);
                                ad.setPositiveButton(R.string.button_ok,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int arg1) {
                                                dialog.cancel();
                                            }
                                        });
                                ad.show();

                            }else {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.red));
                                edittext.getText().clear();

                            }
                            answered_Q = true;
                            if(answered_A == true && answered_B == true &&answered_C == true &&answered_D == true &&
                                    answered_E == true &&answered_F == true &&answered_G == true &&answered_H == true &&
                                    answered_I == true &&answered_J == true &&answered_K == true &&answered_L == true &&
                                    answered_M == true &&answered_N == true &&answered_O == true &&
                                    answered_P == true &&answered_Q == true &&answered_R == true &&answered_S == true &&
                                    answered_T == true &&answered_U == true &&answered_V == true &&answered_W == true &&
                                    answered_X == true &&answered_Y == true &&answered_Z == true){
                                Button results = (Button)findViewById(R.id.buttonResultados);
                                results.setVisibility(View.VISIBLE);
                            }
                            handled = true;
                        }
                        return handled;
                    }
                });


                break;
            case R.id.buttonR:
                if (!firstTimeR) {
                    try {
                        id[17] = readJson(word[17]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    firstTimeR = true;
                }

                url = "https://www.lab.it.uc3m.es/~0345838/LSE_acepciones/" + id[17] + ".mp4";
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
                button = (Button) findViewById(R.id.buttonR);
                ad = new AlertDialog.Builder(this);
                edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_SEND) {
                            w = edittext.getText().toString().toLowerCase();
                            w = Normalizer.normalize(w, Normalizer.Form.NFD);
                            w = w.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            vu = word[17].toLowerCase();
                            vu = Normalizer.normalize(vu, Normalizer.Form.NFD);
                            vu = vu.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            if (w.equals(vu)) {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.green));
                                edittext.getText().clear();
                                contadorAcierto++;
                            } else if(w.trim().length() == 0){
                                ad.setTitle(R.string.title_dialog);
                                ad.setMessage(R.string.message);
                                ad.setPositiveButton(R.string.button_ok,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int arg1) {
                                                dialog.cancel();
                                            }
                                        });
                                ad.show();

                            }else {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.red));
                                edittext.getText().clear();

                            }
                            answered_R = true;
                            if(answered_A == true && answered_B == true &&answered_C == true &&answered_D == true &&
                                    answered_E == true &&answered_F == true &&answered_G == true &&answered_H == true &&
                                    answered_I == true &&answered_J == true &&answered_K == true &&answered_L == true &&
                                    answered_M == true &&answered_N == true &&answered_O == true &&
                                    answered_P == true &&answered_Q == true &&answered_R == true &&answered_S == true &&
                                    answered_T == true &&answered_U == true &&answered_V == true &&answered_W == true &&
                                    answered_X == true &&answered_Y == true &&answered_Z == true){
                                Button results = (Button)findViewById(R.id.buttonResultados);
                                results.setVisibility(View.VISIBLE);
                            }
                            handled = true;
                        }
                        return handled;
                    }
                });


                break;
            case R.id.buttonS:
                if (!firstTimeS) {
                    try {
                        id[18] = readJson(word[18]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    firstTimeS = true;
                }
                url = "https://www.lab.it.uc3m.es/~0345838/LSE_acepciones/" + id[18] + ".mp4";
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
                button = (Button) findViewById(R.id.buttonS);
                ad = new AlertDialog.Builder(this);
                edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_SEND) {
                            w = edittext.getText().toString().toLowerCase();
                            w = Normalizer.normalize(w, Normalizer.Form.NFD);
                            w = w.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            vu = word[18].toLowerCase();
                            vu = Normalizer.normalize(vu, Normalizer.Form.NFD);
                            vu = vu.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            if (w.equals(vu)) {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.green));
                                edittext.getText().clear();
                                contadorAcierto++;
                            } else if(w.trim().length() == 0){
                                ad.setTitle(R.string.title_dialog);
                                ad.setMessage(R.string.message);
                                ad.setPositiveButton(R.string.button_ok,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int arg1) {
                                                dialog.cancel();
                                            }
                                        });
                                ad.show();

                            }else {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.red));
                                edittext.getText().clear();

                            }
                            answered_S = true;
                            if(answered_A == true && answered_B == true &&answered_C == true &&answered_D == true &&
                                    answered_E == true &&answered_F == true &&answered_G == true &&answered_H == true &&
                                    answered_I == true &&answered_J == true &&answered_K == true &&answered_L == true &&
                                    answered_M == true &&answered_N == true &&answered_O == true &&
                                    answered_P == true &&answered_Q == true &&answered_R == true &&answered_S == true &&
                                    answered_T == true &&answered_U == true &&answered_V == true &&answered_W == true &&
                                    answered_X == true &&answered_Y == true &&answered_Z == true){
                                Button results = (Button)findViewById(R.id.buttonResultados);
                                results.setVisibility(View.VISIBLE);
                            }
                            handled = true;
                        }
                        return handled;
                    }
                });


                break;
            case R.id.buttonT:
                if (!firstTimeT) {
                    try {
                        id[19] = readJson(word[19]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    firstTimeT = true;
                }
                url = "https://www.lab.it.uc3m.es/~0345838/LSE_acepciones/" + id[19] + ".mp4";
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
                button = (Button) findViewById(R.id.buttonT);
                ad = new AlertDialog.Builder(this);
                edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_SEND) {
                            w = edittext.getText().toString().toLowerCase();
                            w = Normalizer.normalize(w, Normalizer.Form.NFD);
                            w = w.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            vu = word[19].toLowerCase();
                            vu = Normalizer.normalize(vu, Normalizer.Form.NFD);
                            vu = vu.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            if (w.equals(vu)) {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.green));
                                edittext.getText().clear();
                                contadorAcierto++;
                            } else if(w.trim().length() == 0){
                                ad.setTitle(R.string.title_dialog);
                                ad.setMessage(R.string.message);
                                ad.setPositiveButton(R.string.button_ok,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int arg1) {
                                                dialog.cancel();
                                            }
                                        });
                                ad.show();

                            }else {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.red));
                                edittext.getText().clear();

                            }
                            answered_T = true;
                            if(answered_A == true && answered_B == true &&answered_C == true &&answered_D == true &&
                                    answered_E == true &&answered_F == true &&answered_G == true &&answered_H == true &&
                                    answered_I == true &&answered_J == true &&answered_K == true &&answered_L == true &&
                                    answered_M == true &&answered_N == true &&answered_O == true &&
                                    answered_P == true &&answered_Q == true &&answered_R == true &&answered_S == true &&
                                    answered_T == true &&answered_U == true &&answered_V == true &&answered_W == true &&
                                    answered_X == true &&answered_Y == true &&answered_Z == true){
                                Button results = (Button)findViewById(R.id.buttonResultados);
                                results.setVisibility(View.VISIBLE);
                            }
                            handled = true;
                        }
                        return handled;
                    }
                });


                break;
            case R.id.buttonU:
                if (!firstTimeU) {
                    try {
                        id[20] = readJson(word[20]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    firstTimeU = true;
                }
                url = "https://www.lab.it.uc3m.es/~0345838/LSE_acepciones/" + id[20] + ".mp4";
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
                button = (Button) findViewById(R.id.buttonU);
                ad = new AlertDialog.Builder(this);
                edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_SEND) {
                            w = edittext.getText().toString().toLowerCase();
                            w = Normalizer.normalize(w, Normalizer.Form.NFD);
                            w = w.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            vu = word[20].toLowerCase();
                            vu = Normalizer.normalize(vu, Normalizer.Form.NFD);
                            vu = vu.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            if (w.equals(vu)) {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.green));
                                edittext.getText().clear();
                                contadorAcierto++;
                            } else if(w.trim().length() == 0){
                                ad.setTitle(R.string.title_dialog);
                                ad.setMessage(R.string.message);
                                ad.setPositiveButton(R.string.button_ok,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int arg1) {
                                                dialog.cancel();
                                            }
                                        });
                                ad.show();

                            }else {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.red));
                                edittext.getText().clear();

                            }
                            answered_U = true;
                            if(answered_A == true && answered_B == true &&answered_C == true &&answered_D == true &&
                                    answered_E == true &&answered_F == true &&answered_G == true &&answered_H == true &&
                                    answered_I == true &&answered_J == true &&answered_K == true &&answered_L == true &&
                                    answered_M == true &&answered_N == true &&answered_O == true &&
                                    answered_P == true &&answered_Q == true &&answered_R == true &&answered_S == true &&
                                    answered_T == true &&answered_U == true &&answered_V == true &&answered_W == true &&
                                    answered_X == true &&answered_Y == true &&answered_Z == true){
                                Button results = (Button)findViewById(R.id.buttonResultados);
                                results.setVisibility(View.VISIBLE);
                            }
                            handled = true;
                        }
                        return handled;
                    }
                });


                break;
            case R.id.buttonV:
                if (!firstTimeV) {
                        try {
                            id[21] = readJson(word[21]);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        firstTimeV = true;
                    }

                url = "https://www.lab.it.uc3m.es/~0345838/LSE_acepciones/" + id[21] + ".mp4";
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
                button = (Button) findViewById(R.id.buttonV);
                ad = new AlertDialog.Builder(this);
                edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_SEND) {
                            w = edittext.getText().toString().toLowerCase();
                            w = Normalizer.normalize(w, Normalizer.Form.NFD);
                            w = w.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            vu = word[21].toLowerCase();
                            vu = Normalizer.normalize(vu, Normalizer.Form.NFD);
                            vu = vu.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            if (w.equals(vu)) {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.green));
                                edittext.getText().clear();
                                contadorAcierto++;
                            } else if(w.trim().length() == 0){
                                ad.setTitle(R.string.title_dialog);
                                ad.setMessage(R.string.message);
                                ad.setPositiveButton(R.string.button_ok,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int arg1) {
                                                dialog.cancel();
                                            }
                                        });
                                ad.show();

                            }else {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.red));
                                edittext.getText().clear();

                            }
                            answered_V = true;
                            if(answered_A == true && answered_B == true &&answered_C == true &&answered_D == true &&
                                    answered_E == true &&answered_F == true &&answered_G == true &&answered_H == true &&
                                    answered_I == true &&answered_J == true &&answered_K == true &&answered_L == true &&
                                    answered_M == true &&answered_N == true &&answered_O == true &&
                                    answered_P == true &&answered_Q == true &&answered_R == true &&answered_S == true &&
                                    answered_T == true &&answered_U == true &&answered_V == true &&answered_W == true &&
                                    answered_X == true &&answered_Y == true &&answered_Z == true){
                                Button results = (Button)findViewById(R.id.buttonResultados);
                                results.setVisibility(View.VISIBLE);
                            }
                            handled = true;
                        }
                        return handled;
                    }
                });


                break;
            case R.id.buttonW:
                if (!firstTimeW) {
                        try {
                            id[22] = readJson(word[22]);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        firstTimeW = true;
                    }
                url = "https://www.lab.it.uc3m.es/~0345838/LSE_acepciones/" + id[22] + ".mp4";
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
                button = (Button) findViewById(R.id.buttonW);
                ad = new AlertDialog.Builder(this);
                edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_SEND) {
                            w = edittext.getText().toString().toLowerCase();
                            w = Normalizer.normalize(w, Normalizer.Form.NFD);
                            w = w.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            vu = word[22].toLowerCase();
                            vu = Normalizer.normalize(vu, Normalizer.Form.NFD);
                            vu = vu.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            if (w.equals(vu)) {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.green));
                                edittext.getText().clear();
                                contadorAcierto++;
                            } else if(w.trim().length() == 0){
                                ad.setTitle(R.string.title_dialog);
                                ad.setMessage(R.string.message);
                                ad.setPositiveButton(R.string.button_ok,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int arg1) {
                                                dialog.cancel();
                                            }
                                        });
                                ad.show();

                            }else {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.red));
                                edittext.getText().clear();

                            }
                            answered_W = true;
                            if(answered_A == true && answered_B == true &&answered_C == true &&answered_D == true &&
                                    answered_E == true &&answered_F == true &&answered_G == true &&answered_H == true &&
                                    answered_I == true &&answered_J == true &&answered_K == true &&answered_L == true &&
                                    answered_M == true &&answered_N == true &&answered_O == true &&
                                    answered_P == true &&answered_Q == true &&answered_R == true &&answered_S == true &&
                                    answered_T == true &&answered_U == true &&answered_V == true &&answered_W == true &&
                                    answered_X == true &&answered_Y == true &&answered_Z == true){
                                Button results = (Button)findViewById(R.id.buttonResultados);
                                results.setVisibility(View.VISIBLE);
                            }
                            handled = true;
                        }
                        return handled;
                    }
                });


                break;
            case R.id.buttonX:
                if (!firstTimeX) {
                        try {
                            id[23] = readJson(word[23]);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        firstTimeX = true;
                    }

                url = "https://www.lab.it.uc3m.es/~0345838/LSE_acepciones/" + id[23] + ".mp4";
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
                button = (Button) findViewById(R.id.buttonX);
                ad = new AlertDialog.Builder(this);
                edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_SEND) {
                            w = edittext.getText().toString().toLowerCase();
                            w = Normalizer.normalize(w, Normalizer.Form.NFD);
                            w = w.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            vu = word[23].toLowerCase();
                            vu = Normalizer.normalize(vu, Normalizer.Form.NFD);
                            vu = vu.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            if (w.equals(vu)) {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.green));
                                edittext.getText().clear();
                                contadorAcierto++;
                            } else if(w.trim().length() == 0){
                                ad.setTitle(R.string.title_dialog);
                                ad.setMessage(R.string.message);
                                ad.setPositiveButton(R.string.button_ok,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int arg1) {
                                                dialog.cancel();
                                            }
                                        });
                                ad.show();

                            }else {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.red));
                                edittext.getText().clear();

                            }
                            answered_X = true;
                            if(answered_A == true && answered_B == true &&answered_C == true &&answered_D == true &&
                                    answered_E == true &&answered_F == true &&answered_G == true &&answered_H == true &&
                                    answered_I == true &&answered_J == true &&answered_K == true &&answered_L == true &&
                                    answered_M == true &&answered_N == true &&answered_O == true &&
                                    answered_P == true &&answered_Q == true &&answered_R == true &&answered_S == true &&
                                    answered_T == true &&answered_U == true &&answered_V == true &&answered_W == true &&
                                    answered_X == true &&answered_Y == true &&answered_Z == true){
                                Button results = (Button)findViewById(R.id.buttonResultados);
                                results.setVisibility(View.VISIBLE);
                            }
                            handled = true;
                        }
                        return handled;
                    }
                });


                break;
            case R.id.buttonY:
                if (!firstTimeY) {
                        try {
                            id[24] = readJson(word[24]);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        firstTimeY = true;
                    }
                url = "https://www.lab.it.uc3m.es/~0345838/LSE_acepciones/" + id[24] + ".mp4";
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
                button = (Button) findViewById(R.id.buttonY);
                ad = new AlertDialog.Builder(this);
                edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_SEND) {
                            w = edittext.getText().toString().toLowerCase();
                            w = Normalizer.normalize(w, Normalizer.Form.NFD);
                            w = w.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            vu = word[24].toLowerCase();
                            vu = Normalizer.normalize(vu, Normalizer.Form.NFD);
                            vu = vu.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            if (w.equals(vu)) {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.green));
                                edittext.getText().clear();
                                contadorAcierto++;
                            } else if(w.trim().length() == 0){
                                ad.setTitle(R.string.title_dialog);
                                ad.setMessage(R.string.message);
                                ad.setPositiveButton(R.string.button_ok,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int arg1) {
                                                dialog.cancel();
                                            }
                                        });
                                ad.show();

                            }else {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.red));
                                edittext.getText().clear();

                            }
                            answered_Y = true;
                            if(answered_A == true && answered_B == true &&answered_C == true &&answered_D == true &&
                                    answered_E == true &&answered_F == true &&answered_G == true &&answered_H == true &&
                                    answered_I == true &&answered_J == true &&answered_K == true &&answered_L == true &&
                                    answered_M == true &&answered_N == true &&answered_O == true &&
                                    answered_P == true &&answered_Q == true &&answered_R == true &&answered_S == true &&
                                    answered_T == true &&answered_U == true &&answered_V == true &&answered_W == true &&
                                    answered_X == true &&answered_Y == true &&answered_Z == true){
                                Button results = (Button)findViewById(R.id.buttonResultados);
                                results.setVisibility(View.VISIBLE);
                            }
                            handled = true;
                        }
                        return handled;
                    }
                });


                break;
            case R.id.buttonZ:
                if (!firstTimeZ) {
                        try {
                            id[25] = readJson(word[25]);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    firstTimeZ = true;
                }

                    url = "https://www.lab.it.uc3m.es/~0345838/LSE_acepciones/" + id[25] + ".mp4";
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
                    button = (Button)findViewById(R.id.buttonZ);
                ad = new AlertDialog.Builder(this);
                edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_SEND) {
                            w = edittext.getText().toString().toLowerCase();
                            w = Normalizer.normalize(w, Normalizer.Form.NFD);
                            w = w.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            vu = word[25].toLowerCase();
                            vu = Normalizer.normalize(vu, Normalizer.Form.NFD);
                            vu = vu.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                            if (w.equals(vu)) {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.green));
                                edittext.getText().clear();
                                contadorAcierto++;
                            } else if(w.trim().length() == 0){
                                ad.setTitle(R.string.title_dialog);
                                ad.setMessage(R.string.message);
                                ad.setPositiveButton(R.string.button_ok,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int arg1) {
                                                dialog.cancel();
                                            }
                                        });
                                ad.show();

                            }else {
                                button.setEnabled(false);
                                button.setBackgroundColor(getResources().getColor(R.color.red));
                                edittext.getText().clear();

                            }
                                answered_Z = true;
                                if(answered_A == true && answered_B == true &&answered_C == true &&answered_D == true &&
                                        answered_E == true &&answered_F == true &&answered_G == true &&answered_H == true &&
                                        answered_I == true &&answered_J == true &&answered_K == true &&answered_L == true &&
                                        answered_M == true &&answered_N == true &&answered_O == true &&
                                        answered_P == true &&answered_Q == true &&answered_R == true &&answered_S == true &&
                                        answered_T == true &&answered_U == true &&answered_V == true &&answered_W == true &&
                                        answered_X == true &&answered_Y == true &&answered_Z == true){
                                    Button results = (Button)findViewById(R.id.buttonResultados);
                                    results.setVisibility(View.VISIBLE);
                                }
                                handled = true;
                            }
                            return handled;
                        }
                    });

                    break;


                default:
                    throw new IllegalStateException("Unexpected value: " + view.getId());
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

    // Cuando se termina el PasaSignum se inicia la actividad correspondiente
    public void resultados(View view){
        Intent intent = new Intent(this, resultados.class);
        Bundle bundle = new Bundle();
        bundle.putInt("contadorAcierto", contadorAcierto);
        bundle.putStringArray("word", word);
        intent.putExtras(bundle);
        startActivity(intent);
    }



}