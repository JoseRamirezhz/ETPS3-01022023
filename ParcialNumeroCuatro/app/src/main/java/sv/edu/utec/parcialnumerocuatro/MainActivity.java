package sv.edu.utec.parcialnumerocuatro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

import sv.edu.utec.parcialnumerocuatro.datos.BaseHelper;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drwLayout;
    Toolbar tlBarra;
    FrameLayout frmLayout;
    NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tlBarra = findViewById(R.id.toolbar);
        drwLayout = findViewById(R.id.drawrLat);
        navView = findViewById(R.id.navigator);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drwLayout,tlBarra,R.string.open,R.string.close);

        drwLayout.addDrawerListener(toggle);
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white,null));//muetra una flechita para ver y ocultar

        BaseHelper basehelper = new BaseHelper(this);
        SQLiteDatabase db = basehelper.getWritableDatabase();
        if (db != null){
            Toast.makeText(this, "Base de datos creada", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Error al crear la base de datos", Toast.LENGTH_LONG).show();
        }

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.agregar:
                        fragmentosR(new AgregarFragment());
                        drwLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(getApplicationContext(), "Agregar Nuevo", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
    }

    private void fragmentosR(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frmLayoutContenedor, fragment);
        fragmentTransaction.commit();
    }
}