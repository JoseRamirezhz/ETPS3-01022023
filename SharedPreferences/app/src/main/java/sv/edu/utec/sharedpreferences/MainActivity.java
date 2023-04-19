package sv.edu.utec.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import sv.edu.utec.sharedpreferences.Helper.AdminSQLiteOpenHelper;

public class MainActivity extends AppCompatActivity {

    EditText txtcodPrd, txtDesc, txtprecio;
    Button btnInsert, btnUpdate, btnDelete;


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

                bd.insert("productos",null,informacion);
            }
        });


    }
}