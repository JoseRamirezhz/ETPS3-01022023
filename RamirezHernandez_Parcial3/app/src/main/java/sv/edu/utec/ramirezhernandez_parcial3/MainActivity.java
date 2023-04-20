package sv.edu.utec.ramirezhernandez_parcial3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import sv.edu.utec.ramirezhernandez_parcial3.clases.BuscarFragment;
import sv.edu.utec.ramirezhernandez_parcial3.clases.ConfiguracionFragment;
import sv.edu.utec.ramirezhernandez_parcial3.clases.Contactos;
import sv.edu.utec.ramirezhernandez_parcial3.clases.PrincipalFragment;
import sv.edu.utec.ramirezhernandez_parcial3.clases.Search;

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
                case R.id.nav_busqueda:
                    seleccionFrag = new Search();
                    break;
                case R.id.nav_contactos:
                    seleccionFrag = new Contactos();
                    break;
                case R.id.nav_configuracion:
                    seleccionFrag = new ConfiguracionFragment();
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


}