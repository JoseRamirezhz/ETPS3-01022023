package sv.edu.utec.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.util.Log;

import sv.edu.utec.sharedpreferences.Helper.AdminSQLiteOpenHelper;

public class MainActivity extends AppCompatActivity {

    EditText txtcodPrd, txtDesc, txtprecio;
    Button btnInsert, btnUpdate, btnDelete,btnbusca,btnBuscaDesc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtcodPrd = findViewById(R.id.edtCodProd);
        txtDesc = findViewById(R.id.edtDescProd);
        txtprecio = findViewById(R.id.edtPrecio);
        txtprecio = findViewById(R.id.edtPrecio);
        btnInsert = findViewById(R.id.btnGuardar);
        btnDelete = findViewById(R.id.btnElimar);
        btnUpdate = findViewById(R.id.btnActualizar);
        btnbusca = findViewById(R.id.btnBuscar);
        btnBuscaDesc = findViewById(R.id.btnBuscarDescripcion);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(), "bodega",null,1);
                SQLiteDatabase bd =  admin.getWritableDatabase();
                String cod = txtcodPrd.getText().toString();
                String desc = txtDesc.getText().toString();
                String precio = txtprecio.getText().toString();

                ContentValues informacion  = new ContentValues();
                informacion.put("cod_producto",cod);
                informacion.put("nom_producto",desc);
                informacion.put("precio_prod",precio);

                try {
                    bd.insert("productos",null,informacion);
                    Toast.makeText(getApplicationContext(),"Se inserto el producto",Toast.LENGTH_LONG).show();
                    bd.close();
                }catch (Exception ex){
                    //Log.println(ex.getStackTrace());
                    Toast.makeText(getApplicationContext(), ex.getCause().toString(),Toast.LENGTH_LONG).show();
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(), "bodega",null,1);
                SQLiteDatabase bd =  admin.getWritableDatabase();
                String cod = txtcodPrd.getText().toString();
                String desc = txtDesc.getText().toString();
                String precio = txtprecio.getText().toString();

                ContentValues informacion  = new ContentValues();
                informacion.put("cod_producto",cod);
                informacion.put("nom_producto",desc);
                informacion.put("precio_prod",precio);

                int cant = bd.update("productos",informacion,"cod_producto="+cod+"",null);
                bd.close();

                if (cant==1){
                    Toast.makeText(getApplicationContext(),"Se modifico el producto",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"No se modifico el producto",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(), "bodega",null,1);
                SQLiteDatabase bd =  admin.getWritableDatabase();
                String cod = txtcodPrd.getText().toString();

                int cant = bd.delete("productos","cod_producto = "+cod,null);
                bd.close();
                txtcodPrd.setText("");
                txtDesc.setText("");
                txtprecio.setText("");

                if (cant == 1){
                    Toast.makeText(getApplicationContext(), "Se borro el producto", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "No se borro el producto", Toast.LENGTH_LONG).show();
                }
            }
        });


        btnbusca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(), "bodega",null,1);
                SQLiteDatabase bd =  admin.getWritableDatabase();
                String cod = txtcodPrd.getText().toString();

                Cursor filas = bd.rawQuery("SELECT nom_producto,precio_prod FROM productos WHERE cod_producto = "+cod,null);

                if (filas.moveToFirst()){
                    txtDesc.setText(filas.getString(0));
                    txtprecio.setText(filas.getString(1));
                }else{
                    Toast.makeText(getApplicationContext(), "No se encontro el producto", Toast.LENGTH_LONG).show();
                }
                bd.close();
            }
        });

        btnBuscaDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(), "bodega",null,1);
                SQLiteDatabase bd =  admin.getWritableDatabase();
                String desc = txtDesc.getText().toString();

                Cursor filas = bd.rawQuery("SELECT cod_producto,nom_producto,precio_prod FROM productos WHERE nom_producto = '"+desc+"'",null);

                if (filas.moveToFirst()){
                    txtcodPrd.setText(filas.getString(0));
                    txtDesc.setText(filas.getString(1));
                    txtprecio.setText(filas.getString(2));
                }else{
                    Toast.makeText(getApplicationContext(), "No se encontro el producto", Toast.LENGTH_LONG).show();
                }
                bd.close();
            }
        });

    }
}