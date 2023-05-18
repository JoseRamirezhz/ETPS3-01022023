package sv.edu.utec.parcialnumerocuatro;

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

import sv.edu.utec.parcialnumerocuatro.datos.Clientes;

public class AgregarFragment extends Fragment {
    Context context;
    EditText txtNomCliente, txtApellCliente, txtDirCliente, txtCiudadCliente;
    Button btnguardar,btnactualizar,btnborrar;
    TextView tvMensaje;
    public AgregarFragment() {
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
        inflater.inflate(R.layout.fragment_agregar, container, false);

        View view = inflater.inflate(R.layout.fragment_agregar,container,false);

        txtNomCliente = view.findViewById(R.id.edtNomCliente);
        txtApellCliente = view.findViewById(R.id.edtApellCliente);
        txtDirCliente = view.findViewById(R.id.edtDirCliente);
        txtCiudadCliente = view.findViewById(R.id.edtCiudadCliente);
        tvMensaje = view.findViewById(R.id.tvMensaje);
        btnguardar = view.findViewById(R.id.btnGuardar);
        btnactualizar = view.findViewById(R.id.btnActualizar);
        btnborrar = view.findViewById(R.id.btnBorrar);

        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Clientes baseClientes = new Clientes(context);
                long codigoSave =  baseClientes.insertarClientes(txtNomCliente.getText().toString(),txtApellCliente.getText().toString(),txtDirCliente.getText().toString(),txtCiudadCliente.getText().toString());
                if(codigoSave > 0){
                    tvMensaje.append("Registro insertado");
                }else{
                    tvMensaje.append("Error al insertar");
                }
            }
        });

        return view;
    }
}