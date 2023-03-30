package sv.edu.utec.menuopciones;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import sv.edu.utec.menuopciones.clases.CamaraFragment;
import sv.edu.utec.menuopciones.clases.FavoritosFragment;
import sv.edu.utec.menuopciones.clases.PrincipalFragment;
import sv.edu.utec.menuopciones.clases.SearchFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView btnNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNav = findViewById(R.id.btnNave);

        btnNav.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) navListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment seleccionFrag = null;
            switch (item.getItemId()){
                case R.id.nav_home:
                    seleccionFrag = new PrincipalFragment();
                    break;
                case R.id.nav_favoritos:
                    seleccionFrag = new FavoritosFragment();
                    break;
                case R.id.nav_camara:
                    seleccionFrag = new CamaraFragment();
                    break;
                case R.id.nav_busqueda:
                    seleccionFrag = new SearchFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.framCount,seleccionFrag).commit();
            return true;

        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_configuraciones, menu);
        return true;
    }

    public  boolean onOptionsItemSelected(MenuItem items){
        Intent intent = new Intent(this, Sumar.class);

        switch (items.getItemId()){
            case R.id.opcion1:
                Toast.makeText(this,"Selecciono la opcion uno", Toast.LENGTH_SHORT).show();
                startActivity(intent);
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