package sv.edu.utec.ramirezhernandez_parcial3.clases;

import android.annotation.SuppressLint;
import android.content.ContentValues;
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
    Button btnInsert, btnUpdate, btnDelete;

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

    }
}