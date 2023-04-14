package sv.edu.utec.guia_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class EjercicioUno extends AppCompatActivity {
    String [] paises = {"El Salvador","Guatemala","Honduras","Nicaragua","Costa Rica","Panama","Colombia","Chile","Peru","Uruguay","Brazil","Bolivia","Argentina"};
    ListView lvstPais;
    Integer [] ImgPais={
            R.drawable.elsalvador,
            R.drawable.guatemala,
            R.drawable.honduras,
            R.drawable.nicaragua,
            R.drawable.costarica,
            R.drawable.panama,
            R.drawable.colombia,
            R.drawable.chile,
            R.drawable.peru,
            R.drawable.uruguay,
            R.drawable.brazil,
            R.drawable.bolivia,
            R.drawable.argentina
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio_uno);
        AdaptadorPais adaptador = new AdaptadorPais(this, paises,ImgPais);
        lvstPais = findViewById(R.id.lstPaises);
        lvstPais.setAdapter(adaptador);
    }
}