package sv.edu.utec.controleslayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    //importamos las clases de los componentes que tenemos en la vista
    Spinner spPais;
    EditText edNombre, edApellidos, edinfo;
    RadioButton rbFem, rbMas, rbOtr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hacemos los match con los de la vista
        edNombre = findViewById(R.id.edtNombres);
        edApellidos = findViewById(R.id.edtApellidos);
        edinfo = findViewById(R.id.editTextTextMultiLine);
        spPais = findViewById(R.id.spnPais);

        //Arreglo que permita llenar el spinner
        String[] opciones = {"Guatemala","El Salvador", "Honduras", "Nicaragua","Costa Rica","Panama"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,opciones);

    }


}