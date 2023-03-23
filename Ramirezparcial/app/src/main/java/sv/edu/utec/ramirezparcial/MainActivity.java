package sv.edu.utec.ramirezparcial;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lista;

    int[] img;
    List<String> empleados;
    List<String> cargo;
    List<String> compania;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = findViewById(R.id.lvEmpleados);

        empleados = new ArrayList<String>();
        empleados.add("Alexander Pierrot");
        empleados.add("Carlos Lopez");
        empleados.add("Sara bonz");
        empleados.add("Liliana Clarence");
        empleados.add("Benito Peralta");
        empleados.add("Juan Jaramillo");
        empleados.add("Crhistian Steps");
        empleados.add("Alexa Giraldo");
        empleados.add("Linda Murillo");
        empleados.add("Lizeth Astrada");

        cargo = new ArrayList<String>();
        cargo.add("CEO");
        cargo.add("Asistente");
        cargo.add("Directora de Marketing");
        cargo.add("Diseñadora de Productos");
        cargo.add("Supervisor de Ventas");
        cargo.add("CEO");
        cargo.add("CTO");
        cargo.add("Lead Programmer");
        cargo.add("Directora de Marketing");
        cargo.add("CEO");

        compania = new ArrayList<String>();
        compania.add("Insures S.O.");
        compania.add("Hospital Blue");
        compania.add("Electrical Parts Itd");
        compania.add("Creativa App");
        compania.add("Neumáticos Pres");
        compania.add("Banco Nacional");
        compania.add("Cooperativa Verde");
        compania.add("Frutisofy");
        compania.add("Seguros Boliver");
        compania.add("Convesionario Motolox");

        int [] pictures = {
                R.drawable.lead_photo_1,
                R.drawable.lead_photo_2,
                R.drawable.lead_photo_3,
                R.drawable.lead_photo_4,
                R.drawable.lead_photo_5,
                R.drawable.lead_photo_6,
                R.drawable.lead_photo_7,
                R.drawable.lead_photo_8,
                R.drawable.lead_photo_9,
                R.drawable.lead_photo_10
        };

        Adaptador adaptador = new Adaptador(this, R.layout.elemento,empleados,cargo,compania,pictures);


        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getApplicationContext(), "Selecciono "+ empleados.get(i),Toast.LENGTH_SHORT).show();

                Intent intt = new Intent(getApplicationContext(), DescripcionEmpleado.class);
                intt.putExtra("empleado", empleados.get(i).toString());
                intt.putExtra("cargo", cargo.get(i).toString());
                intt.putExtra("empresa", compania.get(i).toString());
                intt.putExtra("imagen", pictures);

                startActivity(intt);
            }
        });
    }
}