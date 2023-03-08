package sv.edu.utec.foodapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import sv.edu.utec.foodapp.R;

public class Principal extends AppCompatActivity {
    TextView tvUserMsj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        tvUserMsj = findViewById(R.id.tvUsuario);
        //bundle es una clase que permite traer las intenciones

        Bundle bundle = getIntent().getExtras();
        String info = "Hola, "+ bundle.getString("usuario");
        tvUserMsj.setText(info);

    }
}