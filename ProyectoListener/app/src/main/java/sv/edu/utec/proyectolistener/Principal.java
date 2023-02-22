package sv.edu.utec.proyectolistener;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
Button btnMensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnMensaje = findViewById(R.id.btnToast);
        btnMensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = new Toast(getApplicationContext()); // como se usa en el listener no se usa this sino getaplicationcontext
                LayoutInflater inflater = getLayoutInflater(); //trae ka uibfiracuib dek layou
                View layout = inflater.inflate(R.layout.toast_layout,(ViewGroup) findViewById(R.id.lyMensaje));

                TextView txtMensaje = (TextView) layout.findViewById(R.id.textView3);
                txtMensaje.setText("Soy el mensaje");

                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(layout);
                toast.show();
            }
        });
    }
}