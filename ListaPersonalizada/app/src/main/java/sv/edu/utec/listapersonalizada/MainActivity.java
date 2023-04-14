package sv.edu.utec.listapersonalizada;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String [] paises = {"El Salvador","Guatemala","Honduras","Nicaragua"};
    ListView lvstPais;
    Integer [] ImgPais={
            R.drawable.elsalvador,
            R.drawable.guatemala,
            R.drawable.honduras,
            R.drawable.nicaragua
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdaptadorPais adaptador = new AdaptadorPais(this, paises,ImgPais);
        lvstPais = findViewById(R.id.lstPaises);
        lvstPais.setAdapter(adaptador);
    }
}