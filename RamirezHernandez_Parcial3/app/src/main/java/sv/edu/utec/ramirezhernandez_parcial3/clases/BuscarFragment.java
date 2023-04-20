package sv.edu.utec.ramirezhernandez_parcial3.clases;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.utec.ramirezhernandez_parcial3.Helper.AdminSQLiteOpenHelper;
import sv.edu.utec.ramirezhernandez_parcial3.R;


public class BuscarFragment extends AppCompatActivity {
    EditText txtNom, txtApell, txtTele, txtCorr;
    Button btnInsert, btnUpdate, btnDelete, btnbusca;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNom = findViewById(R.id.edtNombre);
        txtApell = findViewById(R.id.edtApellidos);
        txtTele = findViewById(R.id.edtTelefono);
        txtCorr = findViewById(R.id.edtCorreo);
        btnInsert = findViewById(R.id.btnInsert);
        btnDelete = findViewById(R.id.btnBorrar);
        btnUpdate = findViewById(R.id.btnActualiza);
        btnbusca = findViewById(R.id.btnBuscar);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(), "parcial", null, 1);
                SQLiteDatabase bd = admin.getWritableDatabase();
                String nombre = txtNom.getText().toString();
                String apellido = txtApell.getText().toString();
                String telefono = txtTele.getText().toString();
                String correo = txtCorr.getText().toString();

                ContentValues informacion = new ContentValues();
                informacion.put("nombre", nombre);
                informacion.put("apellido", apellido);
                informacion.put("telefono", telefono);
                informacion.put("correo", correo);

                try {
                    bd.insert("productos", null, informacion);
                    Toast.makeText(getApplicationContext(), "Se inserto el contacto", Toast.LENGTH_LONG).show();
                    bd.close();
                } catch (Exception ex) {
                    //Log.println(ex.getStackTrace());
                    Toast.makeText(getApplicationContext(), ex.getCause().toString(), Toast.LENGTH_LONG).show();
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(), "parcial",null,1);
                SQLiteDatabase bd =  admin.getWritableDatabase();
                String nombre = txtNom.getText().toString();
                String apellido = txtApell.getText().toString();
                String telefono = txtTele.getText().toString();
                String correo = txtCorr.getText().toString();

                ContentValues informacion = new ContentValues();
                informacion.put("nombre", nombre);
                informacion.put("apellido", apellido);
                informacion.put("telefono", telefono);
                informacion.put("correo", correo);

                int cant = bd.update("contactos",informacion,"nombre="+nombre+"",null);
                bd.close();

                if (cant==1){
                    Toast.makeText(getApplicationContext(),"Se modifico con exito el contacto",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"No se modifico el contacto",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(), "parcial",null,1);
                SQLiteDatabase bd =  admin.getWritableDatabase();
                String nombre = txtNom.getText().toString();

                int cant = bd.delete("contacto","nombre = "+nombre,null);
                bd.close();
                txtNom.setText("");
                txtApell.setText("");
                txtTele.setText("");
                txtCorr.setText("");

                if (cant == 1){
                    Toast.makeText(getApplicationContext(), "Se borro el cotacto", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "No se borro el contacto", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnbusca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(),"parcial",null,1);
                SQLiteDatabase bd = admin.getWritableDatabase();
                String nombre = txtNom.getText().toString();

                Cursor filas = bd.rawQuery("SELECT nombre,apellido,telefono,correo FROM contactos WHERE nombre = "+nombre   ,null);

                if (filas.moveToFirst()){
                    txtNom.setText(filas.getString(0));
                    txtApell.setText(filas.getString(1));
                    txtTele.setText(filas.getString(2));
                    txtCorr.setText(filas.getString(3));
                }else{
                    Toast.makeText(getApplicationContext(), "No se encontro el contacto", Toast.LENGTH_LONG).show();
                }
                bd.close();

            }
        });

    }
}