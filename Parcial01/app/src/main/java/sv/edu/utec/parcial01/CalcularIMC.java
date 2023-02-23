package sv.edu.utec.parcial01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CalcularIMC extends AppCompatActivity {

    EditText edPeso, edAltura, edInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_imc);

        edPeso = findViewById(R.id.edtPeso);
        edAltura = findViewById(R.id.edtEstatura);
        edInfo = findViewById(R.id.editTextTextMultiLine);
    }

    public  void Calcular(View v){
        double peso = Double.parseDouble(edPeso.getText().toString());
        double altura = Double.parseDouble(edAltura.getText().toString());
        double resultado = 0.0;
        String mensaje = "";
        String info = "";

        resultado = peso / (altura*altura);

        if (resultado < 10.5){
            mensaje = "Críticamente Bajo de Peso";
        } else if (resultado < 15.9) {
            mensaje = "Severamente Bajo de Peso";
        }else if (resultado < 18.5) {
            mensaje = "Bajo de Peso";
        }else if (resultado < 25) {
            mensaje = "Normal (peso saludable)";
        }else if (resultado < 30) {
            mensaje = "Sobrepeso";
        }else if (resultado < 35) {
            mensaje = "Obesidad Clase 1 - Moderadamente Obeso";
        }else if (resultado < 40) {
            mensaje = "Obesidad Clase 2 - Severamente Obeso";
        }else if (resultado > 50) {
            mensaje = "Obesidad Clase 3 - Críticamente Obeso";
        }

        info = mensaje +"\n" +
                "IMC: "+resultado;

        edInfo.append(info);
    }

}