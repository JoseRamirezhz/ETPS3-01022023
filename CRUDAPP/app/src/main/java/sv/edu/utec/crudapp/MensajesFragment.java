package sv.edu.utec.crudapp;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.utec.crudapp.datos.Proveedores;

public class MensajesFragment extends Fragment {

    Context context;
    EditText txtNomProveedor, txtTelProveedor, txtCorrProveedor;
    Button btnguardar,btnactualizar,btnborrar;
    public MensajesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatActivity appCompatActivity = new AppCompatActivity();

        txtNomProveedor = appCompatActivity.findViewById(R.id.edtNomProveedor);
        txtTelProveedor = appCompatActivity.findViewById(R.id.edtTelProveedor);
        txtCorrProveedor = appCompatActivity.findViewById(R.id.edtCorrProveedor);
        btnguardar = appCompatActivity.findViewById(R.id.btnGuardar);
        btnactualizar = appCompatActivity.findViewById(R.id.btnActualizar);
        btnborrar = appCompatActivity.findViewById(R.id.btnBorrar);

        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Proveedores baseProveedores = new Proveedores(MensajesFragment.this);
                long codigoSave =  baseProveedores.insertarProveedor(txtNomProveedor.getText().toString(),txtTelProveedor.getText().toString(),txtCorrProveedor.getText().toString());
                if(codigoSave > 0){
                    Toast.makeText(context, "Se inserto correctamente", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "Error al insertar", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_mensajes, container, false);
    }
}