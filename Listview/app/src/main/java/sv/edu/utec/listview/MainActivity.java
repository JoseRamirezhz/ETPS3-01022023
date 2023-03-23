package sv.edu.utec.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    int[] img;
    List<String> peliculas;
    List<String> descr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = findViewById(R.id.lsvPeliculas);

        peliculas = new ArrayList<String>();
        peliculas.add("Ex-Mquina");
        peliculas.add("Extraordinario");
        peliculas.add("Forma de Agua");
        peliculas.add("Interestelar");
        peliculas.add("Jumanji");
        peliculas.add("La llegada");

        descr = new ArrayList<String>();
        descr.add("Es una pelicula de accion");
        descr.add("Es una pelicula de ficcion");
        descr.add("Es una pelicula de entreteniminto");
        descr.add("Es una pelicula de espacio");
        descr.add("Es una pelicula de infantil");
        descr.add("Es una pelicula de accion");

        int [] pictures = {
                R.drawable.imagen1,
                R.drawable.imagen2,
                R.drawable.imagen3,
                R.drawable.imagen4,
                R.drawable.imagen5,
                R.drawable.imagen6
        };

        // OPCION DOS


        //ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        Adaptador adaptador = new Adaptador(this, R.layout.elemento,peliculas,descr,pictures);


        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Selecciono "+ peliculas.get(i),Toast.LENGTH_SHORT).show();
            }
        });
    }
}