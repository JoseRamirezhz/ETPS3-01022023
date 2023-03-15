package sv.edu.utec.recicleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mrecyclerView;
    Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mrecyclerView = findViewById(R.id.rvPeliculas);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(this)); // controlador del layout y lo tomaresmos dle contexto actual
        adaptador = new Adaptador(this, getListado());
        mrecyclerView.setAdapter(adaptador);


    }

    private ArrayList<Modelo> getListado(){
        ArrayList<Modelo> modelos = new ArrayList<>();
        Modelo modeLista = new Modelo();
        modeLista.setNomPeli("Ex-Maquina");
        modeLista.setDirecPeli("Carlos Jort");
        modeLista.setGenPeli("Ciencia Ficción");
        modeLista.setImgPeli(R.drawable.ex_maquina); // error sin el valueof
        modeLista.setClasificar(3.45);
        modeLista.setDurapeli("108 min");
        modeLista.setAniopeli("2020");
        modelos.add(modeLista);

        modeLista = new Modelo();
        modeLista.setNomPeli("Extraordinario");
        modeLista.setDirecPeli("Carlos Jort");
        modeLista.setGenPeli("Ciencia Ficción");
        modeLista.setImgPeli(R.drawable.extraordinario); // error sin el valueof
        modeLista.setClasificar(3.45);
        modeLista.setDurapeli("220 min");
        modeLista.setAniopeli("2021");
        modelos.add(modeLista);

        modeLista = new Modelo();
        modeLista.setNomPeli("Forma de agua");
        modeLista.setDirecPeli("Carlos Jort");
        modeLista.setGenPeli("Ciencia Ficción");
        modeLista.setImgPeli(R.drawable.forma_agua); // error sin el valueof
        modeLista.setClasificar(3.45);
        modeLista.setDurapeli("130 min");
        modeLista.setAniopeli("2017");
        modelos.add(modeLista);

        modeLista = new Modelo();
        modeLista.setNomPeli("Interestelar");
        modeLista.setDirecPeli("Carlos Jort");
        modeLista.setGenPeli("Ciencia Ficción");
        modeLista.setImgPeli(R.drawable.interestelar); // error sin el valueof
        modeLista.setClasificar(3.45);
        modeLista.setDurapeli("108 min");
        modeLista.setAniopeli("2013");
        modelos.add(modeLista);

        modeLista = new Modelo();
        modeLista.setNomPeli("Jumanji");
        modeLista.setDirecPeli("Carlos Jort");
        modeLista.setGenPeli("Ciencia Ficción");
        modeLista.setImgPeli(R.drawable.jumanji); // error sin el valueof
        modeLista.setClasificar(3.45);
        modeLista.setDurapeli("89 min");
        modeLista.setAniopeli("2015");
        modelos.add(modeLista);

        modeLista = new Modelo();
        modeLista.setNomPeli("La Llegada");
        modeLista.setDirecPeli("Carlos Jort");
        modeLista.setGenPeli("Ciencia Ficción");
        modeLista.setImgPeli(R.drawable.la_llegada); // error sin el valueof
        modeLista.setClasificar(3.45);
        modeLista.setDurapeli("120 min");
        modeLista.setAniopeli("2009");
        //llenando el modelo
        modelos.add(modeLista);

        return modelos;
    }
}