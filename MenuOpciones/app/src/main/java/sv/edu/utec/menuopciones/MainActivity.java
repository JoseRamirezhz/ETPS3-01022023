package sv.edu.utec.menuopciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_configuraciones, menu);
        return true;
    }

    public  boolean onOptionsItemSelected(MenuItem items){
        switch (items.getItemId()){
            case R.id.opcion1:
                Toast.makeText(this,"Selecciono la opcion uno", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.opcion2:
                Toast.makeText(this,"Selecciono la opcion dos", Toast.LENGTH_SHORT).show();
                return  true;
            case R.id.opcion3:
                Toast.makeText(this,"Selecciono la opcion tres", Toast.LENGTH_SHORT).show();
                return  true;
            case R.id.opcion4:
                Toast.makeText(this,"Selecciono la opcion cuatro", Toast.LENGTH_SHORT).show();
                return  true;
        }
        return super.onOptionsItemSelected(items);
    }
}