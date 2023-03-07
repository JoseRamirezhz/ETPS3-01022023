package sv.edu.utec.foodapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import sv.edu.utec.foodapp.R;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout btnInicial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInicial = findViewById(R.id.btnInicio);

        //entorno para ejecutar ese boton funcionalidad
        btnInicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Principal.class));
            }
        });
    }
}