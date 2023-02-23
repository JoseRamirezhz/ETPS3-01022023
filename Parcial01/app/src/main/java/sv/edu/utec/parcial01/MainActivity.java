package sv.edu.utec.parcial01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edUsuario,edPassword;
    Button btnMensaje,btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edUsuario = findViewById(R.id.edtUsuario);
        edPassword = findViewById(R.id.edtPassword);
    }

    public  void Ingresar(View v){
        String usuario = edUsuario.getText().toString();
        String password = edPassword.getText().toString();
        String usu = "parcialETps1";
        String pass = "p4rC14l#tp$";

        btnMensaje = findViewById(R.id.btnIngresar);
        btnCalcular = findViewById(R.id.btnIngresar);
        if (usuario == usu && password == pass){
            btnMensaje.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast toast = new Toast(getApplicationContext());
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.toast_layout,(ViewGroup) findViewById(R.id.lyMensaje));

                    TextView txtMensaje = (TextView) layout.findViewById(R.id.textView3);
                    txtMensaje.setText("Bienvenido");

                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setView(layout);
                    toast.show();
                }
            });
            Intent intento = new Intent(this,CalcularIMC.class);
            startActivity(intento);
        }else {
            btnMensaje.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast toast = new Toast(getApplicationContext());
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.toast_layout,(ViewGroup) findViewById(R.id.lyMensaje));

                    TextView txtMensaje = (TextView) layout.findViewById(R.id.textView3);
                    txtMensaje.setText("contraseña y usuario no son correctos");

                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setView(layout);
                    toast.show();

                }

            });
            Intent intento = new Intent(this,CalcularIMC.class);
            startActivity(intento);
        }
    }

}