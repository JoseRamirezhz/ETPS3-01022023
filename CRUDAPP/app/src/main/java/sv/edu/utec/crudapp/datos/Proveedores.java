package sv.edu.utec.crudapp.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import sv.edu.utec.crudapp.MensajesFragment;
import sv.edu.utec.crudapp.entidades.EntProveedores;

public class Proveedores extends BaseHelper {
    Context contex;
    public Proveedores(Context context) {
        super(context);
    }

    public long insertarProveedor(String nom_prov, String tel_prov, String corr_prov){
        long codigo = 0;
        try{
            BaseHelper basehelp = new BaseHelper(contex);
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

    public ArrayList<EntProveedores> mostrarProveedores(){
        BaseHelper basehelp = new BaseHelper(contex);
        SQLiteDatabase bd = basehelp.getWritableDatabase();

        ArrayList<EntProveedores> listaProveedores = new ArrayList<>();
        EntProveedores entProveedores = null;
        Cursor cursorProveedores;

        cursorProveedores = bd.rawQuery("Select cod_prov,nom_prov,tel,corr from "+NOMBRE_TABLA_PR, null);
        if(cursorProveedores.moveToFirst()){
            do{
                entProveedores = new EntProveedores();
                entProveedores.getCod_prov(cursorProveedores.getInt(0));
                entProveedores.getNom_prov(cursorProveedores.getString(1));
                entProveedores.getTel(cursorProveedores.getString(2));
                entProveedores.getCorr(cursorProveedores.getString(3));
                listaProveedores.add(entProveedores);
            }
            while (cursorProveedores.moveToNext());
        }
        cursorProveedores.close();
        return  listaProveedores;
    }
}
