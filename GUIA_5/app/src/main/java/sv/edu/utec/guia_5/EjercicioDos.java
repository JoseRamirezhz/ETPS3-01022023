package sv.edu.utec.guia_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class EjercicioDos extends AppCompatActivity {

    private ArrayList<Personas> listapersonas;
    ListView lv1;
    Integer [] Imgpersonas={
                R.drawable.ana,
                R.drawable.carlos,
                R.drawable.fernanda,
                R.drawable.gustavo,
                R.drawable.jose,
                R.drawable.juan,
                R.drawable.karla,
                R.drawable.luis,
                R.drawable.maria,
                R.drawable.marta,
                R.drawable.pedro,
                R.drawable.silvia
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio_dos);

        listapersonas=new ArrayList<Personas>();
        listapersonas.add(new Personas("Ana",'F'));
        listapersonas.add(new Personas("Carlos",'M'));
        listapersonas.add(new Personas("Fernanda",'F'));
        listapersonas.add(new Personas("Gustavo",'M'));
        listapersonas.add(new Personas("Jose",'M'));
        listapersonas.add(new Personas("Juan",'M'));
        listapersonas.add(new Personas("Karla",'F'));
        listapersonas.add(new Personas("Luis",'M'));
        listapersonas.add(new Personas("Maria",'F'));
        listapersonas.add(new Personas("Marta",'F'));
        listapersonas.add(new Personas("Pedro",'M'));
        listapersonas.add(new Personas("Silvia",'F'));

        AdaptadorPersonas adaptador = new AdaptadorPersonas(this);
        lv1 = findViewById(R.id.lstPersonas);
        lv1.setAdapter(adaptador);
    }

    class AdaptadorPersonas extends ArrayAdapter<Personas> {
        AppCompatActivity appCompatActivity;
        AdaptadorPersonas(AppCompatActivity context) {
            super(context, R.layout.persona, listapersonas);
            appCompatActivity = context;
        }
        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.persona, null);
            TextView tvnombre = item.findViewById(R.id.tvNombre);
            tvnombre.setText(listapersonas.get(position).getNombre());
            ImageView imgfoto = item.findViewById(R.id.imvFoto);
            imgfoto.setImageResource(Imgpersonas[position]);
            return(item);
        }
    }

}