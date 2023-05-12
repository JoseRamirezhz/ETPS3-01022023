package sv.edu.utec.crudapp.datos;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import sv.edu.utec.crudapp.MainActivity;

public class BaseHelper extends SQLiteOpenHelper {

    private static final int VERSION_BD = 1;
    private static final String NOMBRE_BD= "bd_tienda.db";
    public static final String NOMBRE_TABLA_PR = "t_provedores";
    private static final String NOMBRE_TABLA_CL = "t_clientes";
    private static final String NOMBRE_TABLA_PRO = "t_productos";

    public BaseHelper(@Nullable MainActivity context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sql_db) {
        sql_db.execSQL("CREATE TABLE "+NOMBRE_TABLA_PR+" ("+
                "cod_prov INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nom_prov TEXT NOT NULL," +
                "tel TEXT NOT NULL," +
                "corr TEXT NOT NULL"
                +")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sql_db, int i, int i1) {
        sql_db.execSQL("DROP TABLE "+NOMBRE_TABLA_PR);
        onCreate(sql_db);
    }
}
