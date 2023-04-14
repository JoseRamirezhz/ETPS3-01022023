package sv.edu.utec.guia_5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnEjercicioUno;
    Button btnEjercicioDos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnEjercicioUno = findViewById(R.id.btnEjercicioUno);
        btnEjercicioDos = findViewById(R.id.btnEjercicioDos);

        btnEjercicioUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EjercicioUno.class);
                startActivity(intent);
            }
        });

        btnEjercicioDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EjercicioDos.class);
                startActivity(intent);
            }
        });
    }
}