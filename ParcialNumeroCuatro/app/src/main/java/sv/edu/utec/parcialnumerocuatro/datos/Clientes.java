package sv.edu.utec.parcialnumerocuatro.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

import androidx.annotation.Nullable;

import sv.edu.utec.parcialnumerocuatro.entidades.EndClientes;

public class Clientes  extends  BaseHelper{
    Context contex;
    public Clientes(@Nullable Context context) {
        super(context);
    }

    public long insertarClientes(String nombre_cliente1, String apellido_cliente1, String direccion_cliente1, String ciudad_cliente1){
        long codigo = 0;
        try{
            BaseHelper basehelp = new BaseHelper(contex);
            SQLiteDatabase bd = basehelp.getWritableDatabase();

            ContentValues valoresProv = new ContentValues();
            valoresProv.put("nombre_cliente",nombre_cliente1);
            valoresProv.put("apellido_cliente",apellido_cliente1);
            valoresProv.put("direccion_cliente",direccion_cliente1);
            valoresProv.put("ciudad_cliente",ciudad_cliente1);

            codigo =  bd.insert(NOMBRE_TABLA_CL,null,valoresProv);
            return  codigo;
        }
        catch(Exception ex){
            ex.toString();
            return codigo = 0;
        }
    }

    public ArrayList<EndClientes> mostrarClientes(){
        BaseHelper basehelp = new BaseHelper(contex);
        SQLiteDatabase bd = basehelp.getWritableDatabase();

        ArrayList<EndClientes> listaClientes = new ArrayList<>();
        EndClientes entClientes = null;
        Cursor cursorClientes;

        cursorClientes = bd.rawQuery("Select id_cliente,nombre_cliente,apellido_cliente,direccion_cliente,ciudad_cliente from "+NOMBRE_TABLA_CL, null);
        if(cursorClientes.moveToFirst()){
            do{
                entClientes = new EndClientes();
                entClientes.getId_cliente(cursorClientes.getInt(0));
                entClientes.getNombre_cliente(cursorClientes.getString(1));
                entClientes.getApellido_cliente(cursorClientes.getString(2));
                entClientes.getDireccion_cliente(cursorClientes.getString(3));
                entClientes.getCiudad_cliente(cursorClientes.getString(4));
                listaClientes.add(entClientes);
            }
            while (cursorClientes.moveToNext());
        }
        cursorClientes.close();
        return  listaClientes;
    }

}
