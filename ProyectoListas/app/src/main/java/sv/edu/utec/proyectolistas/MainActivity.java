package sv.edu.utec.proyectolistas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lstDias;
    ArrayAdapter<CharSequence> adaptador;
    ArrayList<String>  listaEmpleados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstDias = findViewById(R.id.listaDias);
       /*
        adaptador =  ArrayAdapter.createFromResource(this, R.array.arregloDias, android.R.layout.simple_list_item_1);
        lstDias.setAdapter(adaptador);
       */

        // LLENADO DESDE UN ARRAY LIST
        adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaEmpleados);
         listaEmpleados = new ArrayList<>();
         listaEmpleados.add("Juan");
         listaEmpleados.add("Karla");
         listaEmpleados.add("Roberto");
         listaEmpleados.add("Daniela");


         lstDias.setAdapter(adaptador);


        lstDias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(adapterView.getContext(),"Selecciono "+adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}