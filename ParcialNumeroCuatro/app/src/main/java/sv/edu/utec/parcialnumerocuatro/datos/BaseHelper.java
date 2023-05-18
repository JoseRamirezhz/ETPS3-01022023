package sv.edu.utec.parcialnumerocuatro.datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseHelper extends SQLiteOpenHelper {

    private static  final int VERSION_BD = 1;
    private static final String NOMBRE_BD= "bd_parcial.db";
    public static final String NOMBRE_TABLA_CL = "clientes";
    private static final String NOMBRE_TABLA_CV = "cliente_vehiculo";
    private static final String NOMBRE_TABLA_V = "vehiculos";

    public BaseHelper(@Nullable Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sql_db) {
        sql_db.execSQL("CREATE TABLE "+NOMBRE_TABLA_CL+" ("+
                "id_cliente INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre_cliente TEXT NOT NULL," +
                "apellido_cliente TEXT NOT NULL," +
                "direccion_cliente TEXT NOT NULL,"+
                "ciudad_cliente TEXT NOT NULL"
                +")");

        sql_db.execSQL(" CREATE TABLE "+NOMBRE_TABLA_CV+" ("+
                "id_vehiculo INTEGER PRIMARY KEY AUTOINCREMENT," +
                "id_cliente INTEGER," +
                "matricula TEXT NOT NULL," +
                "kilometros TEXT NOT NULL"
                +")");

        sql_db.execSQL(" CREATE TABLE "+NOMBRE_TABLA_V+" ("+
                "id_vehiculo INTEGER PRIMARY KEY AUTOINCREMENT," +
                "marca TEXT NOT NULL," +
                "modelo TEXT NOT NULL"
                +")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sql_db, int oldVersion, int newVersion) {
        sql_db.execSQL("DROP TABLE IF EXISTS "+NOMBRE_TABLA_CL);
        sql_db.execSQL(" DROP TABLE IF EXISTS "+NOMBRE_TABLA_CV);
        sql_db.execSQL(" DROP TABLE IF EXISTS "+NOMBRE_TABLA_V);
        onCreate(sql_db);
    }
}
