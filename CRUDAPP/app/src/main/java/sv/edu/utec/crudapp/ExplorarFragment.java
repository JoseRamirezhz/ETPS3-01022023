package sv.edu.utec.crudapp;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import sv.edu.utec.crudapp.adaptadores.LstProveedoresAdapter;
import sv.edu.utec.crudapp.datos.Proveedores;
import sv.edu.utec.crudapp.entidades.EntProveedores;


public class ExplorarFragment extends Fragment {

    RecyclerView listaProveedores;
    ArrayList<EntProveedores> alistProvee;
    Context context;
    public ExplorarFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_explorar, container, false);
        listaProveedores = view.findViewById(R.id.lvProveedores);
        listaProveedores.setLayoutManager(new LinearLayoutManager(context));
        Proveedores bdProvee = new Proveedores(context);

        alistProvee = new ArrayList<>();
        LstProveedoresAdapter adapter = new LstProveedoresAdapter(bdProvee.mostrarProveedores());
        listaProveedores.setAdapter(adapter);
        return view;
    }
}