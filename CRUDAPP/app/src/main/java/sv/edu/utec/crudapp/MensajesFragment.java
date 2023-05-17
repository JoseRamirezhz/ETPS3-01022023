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
import android.widget.TextView;
import android.widget.Toast;

import sv.edu.utec.crudapp.datos.Proveedores;

public class MensajesFragment extends Fragment {

    Context context;
    EditText txtNomProveedor, txtTelProveedor, txtCorrProveedor;
    Button btnguardar,btnactualizar,btnborrar;
    TextView tvMensaje;
    public MensajesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatActivity appCompatActivity = new AppCompatActivity();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflater.inflate(R.layout.fragment_mensajes, container, false);

        View view = inflater.inflate(R.layout.fragment_mensajes,container,false);

        txtNomProveedor = view.findViewById(R.id.edtNomProveedor);
        txtTelProveedor = view.findViewById(R.id.edtTelProveedor);
        txtCorrProveedor = view.findViewById(R.id.edtCorrProveedor);
        tvMensaje = view.findViewById(R.id.tvMensaje);
        btnguardar = view.findViewById(R.id.btnGuardar);
        btnactualizar = view.findViewById(R.id.btnActualizar);
        btnborrar = view.findViewById(R.id.btnBorrar);

        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Proveedores baseProveedores = new Proveedores(context);
                long codigoSave =  baseProveedores.insertarProveedor(txtNomProveedor.getText().toString(),txtTelProveedor.getText().toString(),txtCorrProveedor.getText().toString());
                if(codigoSave > 0){
                    tvMensaje.append("Registro insertado");
                }else{
                    tvMensaje.append("Error al insertar");
                }
            }
        });

        txtNomProveedor.setText("Prueba");
        // Inflate the layout for this fragment
        return view;
    }
}