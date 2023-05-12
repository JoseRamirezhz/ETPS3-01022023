package sv.edu.utec.crudapp.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import sv.edu.utec.crudapp.MensajesFragment;

public class Proveedores extends BaseHelper {
    Context context;


    public Proveedores(@Nullable MensajesFragment context) {
        super(context);
        this.context = context;
    }

    public long insertarProveedor(String nom_prov, String tel_prov, String corr_prov){
        long codigo = 0;
        try{
            BaseHelper basehelp = new BaseHelper(context);
            SQLiteDatabase bd = basehelp.getWritableDatabase();

            ContentValues valoresProv = new ContentValues();
            valoresProv.put("nom_prov",nom_prov);
            valoresProv.put("tel",tel_prov);
            valoresProv.put("corr",corr_prov);

            codigo =  bd.insert(NOMBRE_TABLA_PR,null,valoresProv);
            return  codigo;
        }
        catch(Exception ex){
            ex.toString();
            return codigo = 0;
        }
    }
}
