package sv.edu.utec.ramirezparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class DescripcionEmpleado extends AppCompatActivity {

    TextView tvEmpleado;
    TextView tvcargo;
    TextView tvempresa;

    ImageView imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_empleado);
        tvEmpleado = findViewById(R.id.tvNombre);
        tvcargo = findViewById(R.id.tvCargo);
        tvempresa = findViewById(R.id.tvEmpresa);
        imagen = findViewById(R.id.ivFotografia);

        Bundle bundle = getIntent().getExtras();
        String info = bundle.getString("empleado");
        String info2 = bundle.getString("cargo");
        String info3 = bundle.getString("empresa");
        //String imagenFoto = bundle.getString("imagen");

        tvEmpleado.setText(info);
        tvcargo.setText(info2);
        tvempresa.setText(info3);
        //imagen.setImageResource(imagenFoto);
        //


    }
}