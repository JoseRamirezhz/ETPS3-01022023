package sv.edu.utec.controles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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

    public void Tabla(View v){
        int valtabla = Integer.parseInt(edtValor.getText().toString());
        int resultados;
        String Resultado = "";
        String titulo = "";
        edtResultado.setText(Resultado);
        titulo = "Tabla:";
        edtResultado.setText(titulo+""+valtabla+"\n");
        for(int i=0; i<=10;i++){
            resultados = valtabla*i;
            Resultado = String.valueOf(resultados);
            //edtResultado.setText(Resultado);
            edtResultado.append(valtabla+"*"+i+"="+Resultado+"\n"); // appen va agregando

        }
    }
}