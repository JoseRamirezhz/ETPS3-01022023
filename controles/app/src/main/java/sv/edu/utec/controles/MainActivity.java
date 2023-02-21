package sv.edu.utec.controles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText edtValor, edtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //union parte grafica con parte de codigo
        edtValor = findViewById(R.id.edtTabla);
        edtResultado = findViewById(R.id.edtMtabla);
    }
}