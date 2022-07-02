package com.example.signum;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.SQLException;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.database.sqlite.SQLiteQueryBuilder;
        import android.util.Log;

        import java.util.ArrayList;
        import java.util.List;

public class db {

    private static final String TAG = "APMOV: db"; // Usado en los mensajes de Log
    // Nombre de la base de datos, tablas y versión
    private static final String DATABASE_NAME = "data";
    private static final String DATABASE_TABLE_SUGERENCIAS = "sugerencias";
    private static final String DATABASE_TABLE_ANIMALS = "animals";
    private static final String DATABASE_TABLE_FOOD = "food";
    private static final String DATABASE_TABLE_CLOTHES = "clothes";
    private static final String DATABASE_TABLE_ABC = "abc";
    private static final String DATABASE_TABLE_ACTIONS = "actions";
    private static final String DATABASE_TABLE_BODY = "body";
    private static final String DATABASE_TABLE_COLORS = "colors";
    private static final String DATABASE_TABLE_COUNTRIES = "countries";
    private static final String DATABASE_TABLE_GREETINGS = "greetings";
    private static final String DATABASE_TABLE_NUMBERS = "numbers";
    private static final String DATABASE_TABLE_A = "a";
    private static final String DATABASE_TABLE_B = "b";
    private static final String DATABASE_TABLE_C = "c";
    private static final String DATABASE_TABLE_D = "d";
    private static final String DATABASE_TABLE_E = "e";
    private static final String DATABASE_TABLE_F = "f";
    private static final String DATABASE_TABLE_G = "g";
    private static final String DATABASE_TABLE_H = "h";
    private static final String DATABASE_TABLE_I = "i";
    private static final String DATABASE_TABLE_J = "j";
    private static final String DATABASE_TABLE_K = "k";
    private static final String DATABASE_TABLE_L = "l";
    private static final String DATABASE_TABLE_M = "m";
    private static final String DATABASE_TABLE_N = "n";
    private static final String DATABASE_TABLE_O = "o";
    private static final String DATABASE_TABLE_P = "p";
    private static final String DATABASE_TABLE_Q = "q";
    private static final String DATABASE_TABLE_R = "r";
    private static final String DATABASE_TABLE_S = "s";
    private static final String DATABASE_TABLE_T = "t";
    private static final String DATABASE_TABLE_U = "u";
    private static final String DATABASE_TABLE_V = "v";
    private static final String DATABASE_TABLE_W = "w";
    private static final String DATABASE_TABLE_X = "x";
    private static final String DATABASE_TABLE_Y = "y";
    private static final String DATABASE_TABLE_Z = "z";


    private static final int DATABASE_VERSION = 2;
    //campos de la tabla de la base de datos
    public static final String KEY_TITLE = "word";
    public static final String KEY_ROWID = "_id";



    // Sentencia SQL para crear las tablas de las bases de datos
    private static final String DATABASE_CREATE_SUGERENCIAS = "create table if not exists " + DATABASE_TABLE_SUGERENCIAS + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_ANIMALS = "create table if not exists " + DATABASE_TABLE_ANIMALS + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_FOOD = "create table if not exists " + DATABASE_TABLE_FOOD + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_CLOTHES = "create table if not exists " + DATABASE_TABLE_CLOTHES + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_ABC = "create table if not exists " + DATABASE_TABLE_ABC + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_ACTIONS = "create table if not exists " + DATABASE_TABLE_ACTIONS + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_BODY = "create table if not exists " + DATABASE_TABLE_BODY + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_COLORS = "create table if not exists " + DATABASE_TABLE_COLORS + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_COUNTRIES = "create table if not exists " + DATABASE_TABLE_COUNTRIES + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_GREETINGS = "create table if not exists " + DATABASE_TABLE_GREETINGS + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_NUMBERS = "create table if not exists " + DATABASE_TABLE_NUMBERS + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_A = "create table if not exists " + DATABASE_TABLE_A + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_B = "create table if not exists " + DATABASE_TABLE_B + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_C = "create table if not exists " + DATABASE_TABLE_C + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_D = "create table if not exists " + DATABASE_TABLE_D + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_E = "create table if not exists " + DATABASE_TABLE_E + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_F = "create table if not exists " + DATABASE_TABLE_F + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_G = "create table if not exists " + DATABASE_TABLE_G + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_H = "create table if not exists " + DATABASE_TABLE_H + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_I = "create table if not exists " + DATABASE_TABLE_I + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_J = "create table if not exists " + DATABASE_TABLE_J + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_K = "create table if not exists " + DATABASE_TABLE_K + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_L = "create table if not exists " + DATABASE_TABLE_L + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_M = "create table if not exists " + DATABASE_TABLE_M + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_N = "create table if not exists " + DATABASE_TABLE_N + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_O = "create table if not exists " + DATABASE_TABLE_O + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_P = "create table if not exists " + DATABASE_TABLE_P + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_Q = "create table if not exists " + DATABASE_TABLE_Q + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_R = "create table if not exists " + DATABASE_TABLE_R + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_S = "create table if not exists " + DATABASE_TABLE_S + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_T = "create table if not exists " + DATABASE_TABLE_T + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_U = "create table if not exists " + DATABASE_TABLE_U + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_V = "create table if not exists " + DATABASE_TABLE_V + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_W = "create table if not exists " + DATABASE_TABLE_W + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_X = "create table if not exists " + DATABASE_TABLE_X + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_Y = "create table if not exists " + DATABASE_TABLE_Y + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private static final String DATABASE_CREATE_Z = "create table if not exists " + DATABASE_TABLE_Z + " (" +
            KEY_ROWID +" integer primary key autoincrement, " +
            KEY_TITLE +" text not null); " ;
    private final Context mCtx;

    private static class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE_SUGERENCIAS);
            db.execSQL(DATABASE_CREATE_ANIMALS);
            db.execSQL(DATABASE_CREATE_FOOD);
            db.execSQL(DATABASE_CREATE_CLOTHES);
            db.execSQL(DATABASE_CREATE_ABC);
            db.execSQL(DATABASE_CREATE_ACTIONS);
            db.execSQL(DATABASE_CREATE_BODY);
            db.execSQL(DATABASE_CREATE_COLORS);
            db.execSQL(DATABASE_CREATE_COUNTRIES);
            db.execSQL(DATABASE_CREATE_GREETINGS);
            db.execSQL(DATABASE_CREATE_NUMBERS);
            db.execSQL(DATABASE_CREATE_A);
            db.execSQL(DATABASE_CREATE_B);
            db.execSQL(DATABASE_CREATE_C);
            db.execSQL(DATABASE_CREATE_D);
            db.execSQL(DATABASE_CREATE_E);
            db.execSQL(DATABASE_CREATE_F);
            db.execSQL(DATABASE_CREATE_G);
            db.execSQL(DATABASE_CREATE_H);
            db.execSQL(DATABASE_CREATE_I);
            db.execSQL(DATABASE_CREATE_J);
            db.execSQL(DATABASE_CREATE_K);
            db.execSQL(DATABASE_CREATE_L);
            db.execSQL(DATABASE_CREATE_M);
            db.execSQL(DATABASE_CREATE_N);
            db.execSQL(DATABASE_CREATE_O);
            db.execSQL(DATABASE_CREATE_P);
            db.execSQL(DATABASE_CREATE_Q);
            db.execSQL(DATABASE_CREATE_R);
            db.execSQL(DATABASE_CREATE_S);
            db.execSQL(DATABASE_CREATE_T);
            db.execSQL(DATABASE_CREATE_U);
            db.execSQL(DATABASE_CREATE_V);
            db.execSQL(DATABASE_CREATE_W);
            db.execSQL(DATABASE_CREATE_X);
            db.execSQL(DATABASE_CREATE_Y);
            db.execSQL(DATABASE_CREATE_Z);

        }

        @Override
        public void onOpen(SQLiteDatabase db) {
            super.onOpen(db);
            db.disableWriteAheadLogging();
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_SUGERENCIAS);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_ANIMALS);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_FOOD);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_CLOTHES);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_ABC);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_ACTIONS);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_BODY);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_COLORS);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_COUNTRIES);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_GREETINGS);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_NUMBERS);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_A);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_B);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_C);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_D);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_E);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_F);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_G);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_H);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_I);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_J);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_K);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_L);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_M);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_N);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_O);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_P);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_Q);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_R);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_S);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_T);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_U);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_V);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_W);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_X);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_Y);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_Z);
            onCreate(db);
        }
    }


    /**
     * Constructor - Coje el contexto necesario para
     * abrir/crear la base de datos
     *
     * @param ctx
     */

    public db(Context ctx) {
        this.mCtx = ctx;
    }

    /**
     * Abre la base de datos. En caso de no poder, intenta crear una instancia.
     * Si no puede crear la instancia lanza una excepción
     *
     * @return this
     * @throws SQLException
     */

    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;

    public db open() throws SQLException {
        mDbHelper = new DatabaseHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    // Devuelve un cursor que apunta a todas las palabras de una base de datos
    public Cursor fetchAllWords(String category) {

        if (category.equals("sugerencias")) {
            return mDb.query(DATABASE_TABLE_SUGERENCIAS, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("animales")) {
            return mDb.query(DATABASE_TABLE_ANIMALS, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("comida")) {
            return mDb.query(DATABASE_TABLE_FOOD, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("ropa")) {
            return mDb.query(DATABASE_TABLE_CLOTHES, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("abc")) {
            return mDb.query(DATABASE_TABLE_ABC, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("acciones")) {
            return mDb.query(DATABASE_TABLE_ACTIONS, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("cuerpo")) {
            return mDb.query(DATABASE_TABLE_BODY, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("colores")) {
            return mDb.query(DATABASE_TABLE_COLORS, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("paises")) {
            return mDb.query(DATABASE_TABLE_COUNTRIES, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("saludos")) {
            return mDb.query(DATABASE_TABLE_GREETINGS, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("numeros")) {
            return mDb.query(DATABASE_TABLE_NUMBERS, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("a")) {
            return mDb.query(DATABASE_TABLE_A, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("b")) {
            return mDb.query(DATABASE_TABLE_B, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("c")) {
            return mDb.query(DATABASE_TABLE_C, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("d")) {
            return mDb.query(DATABASE_TABLE_D, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("e")) {
            return mDb.query(DATABASE_TABLE_E, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("f")) {
            return mDb.query(DATABASE_TABLE_F, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("g")) {
            return mDb.query(DATABASE_TABLE_G, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("h")) {
            return mDb.query(DATABASE_TABLE_H, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("i")) {
            return mDb.query(DATABASE_TABLE_I, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("j")) {
            return mDb.query(DATABASE_TABLE_J, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("k")) {
            return mDb.query(DATABASE_TABLE_K, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("l")) {
            return mDb.query(DATABASE_TABLE_L, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("m")) {
            return mDb.query(DATABASE_TABLE_M, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("n")) {
            return mDb.query(DATABASE_TABLE_N, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("o")) {
            return mDb.query(DATABASE_TABLE_O, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("p")) {
            return mDb.query(DATABASE_TABLE_P, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("q")) {
            return mDb.query(DATABASE_TABLE_Q, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("r")) {
            return mDb.query(DATABASE_TABLE_R, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("s")) {
            return mDb.query(DATABASE_TABLE_S, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("t")) {
            return mDb.query(DATABASE_TABLE_T, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("u")) {
            return mDb.query(DATABASE_TABLE_U, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("v")) {
            return mDb.query(DATABASE_TABLE_V, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("w")) {
            return mDb.query(DATABASE_TABLE_W, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("x")) {
            return mDb.query(DATABASE_TABLE_X, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("y")) {
            return mDb.query(DATABASE_TABLE_Y, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }
        if (category.equals("z")) {
            return mDb.query(DATABASE_TABLE_Z, new String[]{KEY_ROWID, KEY_TITLE}, null, null, null, null, null);
        }

        return null;
    }

    /**
     * Devuelve un Cursor que apunta a la palabra que coincide con el rowId dado
     *
     * @param rowId id de la palabra
     * @return Cursor
     * @throws SQLException Excepción
     */
    public Cursor fetchWord(long rowId, String category) throws SQLException {

        if(category.equals("animales")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_ANIMALS, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }

        if(category.equals("sugerencias")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_SUGERENCIAS, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }

        if(category.equals("ropa")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_CLOTHES, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        if(category.equals("abc")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_ABC, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        if(category.equals("acciones")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_ACTIONS, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        if(category.equals("comida")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_FOOD, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        if(category.equals("cuerpo")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_BODY, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        if(category.equals("colores")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_COLORS, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        if(category.equals("paises")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_COUNTRIES, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        if(category.equals("saludos")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_GREETINGS, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        if(category.equals("numeros")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_NUMBERS, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        if(category.equals("a")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_A, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        if(category.equals("b")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_B, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        if(category.equals("c")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_C, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        if(category.equals("d")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_D, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        if(category.equals("e")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_E, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        if(category.equals("f")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_F, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        if(category.equals("g")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_G, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        if(category.equals("h")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_H, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        if(category.equals("i")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_I, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        if(category.equals("j")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_J, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        if(category.equals("k")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_K, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        if(category.equals("l")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_L, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        if(category.equals("m")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_M, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        if(category.equals("n")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_N, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        if(category.equals("o")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_O, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        if(category.equals("p")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_P, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        if(category.equals("q")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_Q, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        if(category.equals("r")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_R, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        if(category.equals("s")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_S, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        if(category.equals("t")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_T, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        if(category.equals("u")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_U, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        if(category.equals("v")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_V, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        if(category.equals("w")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_W, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        if(category.equals("x")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_X, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        if(category.equals("y")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_Y, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        if(category.equals("z")) {
            Cursor mCursor =

                    mDb.query(true, DATABASE_TABLE_Z, new String[]{KEY_ROWID,
                                    KEY_TITLE}, KEY_ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        return null;
    }

    // Función encargada de devolver un cursor que apunta a una palabra aleatoria de una tabla
    public Cursor randomWord(String category){
        if(category.equals("a")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_A + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("b")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_B + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("c")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_C + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("d")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_D + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("e")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_E + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("f")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_F + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("g")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_G + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("h")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_H + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("i")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_I + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("j")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_J + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("k")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_K + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("l")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_L + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("m")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_M + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("n")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_N + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("o")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_O + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("p")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_P + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("q")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_Q + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("r")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_R + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("s")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_S + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("t")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_T + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("u")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_U + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("v")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_V + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("w")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_W + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("x")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_X + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("y")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_Y + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("z")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_Z + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("animales")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_ANIMALS + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("sugerencias")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_SUGERENCIAS + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("ropa")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_CLOTHES + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("abc")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_ABC + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("acciones")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_ACTIONS + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("comida")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_FOOD + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("cuerpo")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_BODY + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("colores")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_COLORS + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("paises")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_COUNTRIES + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("saludos")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_GREETINGS + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        if(category.equals("numeros")) {
            Cursor cursor = mDb.rawQuery("SELECT " + KEY_TITLE + " FROM " + DATABASE_TABLE_NUMBERS + " ORDER BY RANDOM() LIMIT 1", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }

        return null;

    }


}


