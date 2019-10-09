package com.example.inmobiliaria;

import android.net.Uri;
import android.os.Bundle;

import com.example.inmobiliaria.modelo.Propietario;
import com.example.inmobiliaria.modelo.PropietarioData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity implements
        PropiedadesFragment.OnFragmentInteractionListener,
        InquilinosFragment.OnFragmentInteractionListener,
        PerfilFragment.OnFragmentInteractionListener,
        PagosFragment.OnFragmentInteractionListener,
        ContratosFragment.OnFragmentInteractionListener,
        PropiedadFragment.OnFragmentInteractionListener,
        CerrarSesionFragment.OnFragmentInteractionListener
{

    private AppBarConfiguration mAppBarConfiguration;
    private TextView tvTituloEncabezado, tvEmailEncabezado;

    public static int idPropietario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Bundle bundle = getIntent().getExtras();
        idPropietario = bundle.getInt("idPropietario");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.perfilFragment, R.id.propiedadesFragment, R.id.inquilinosFragment,
                R.id.pagosFragment, R.id.contratosFragment, R.id.cerrarSesionFragment)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);

        NavigationUI.setupWithNavController(navigationView, navController);

        View headerView = navigationView.getHeaderView(0);
        Propietario p = new PropietarioData().obtenerPropietarioPorId(Home.idPropietario);
        tvTituloEncabezado = headerView.findViewById(R.id.tv1);
        tvTituloEncabezado.setText(p.getNombre());
        tvEmailEncabezado = headerView.findViewById(R.id.tv2);
        tvEmailEncabezado.setText(p.getMail());


        Toast.makeText(this, "Bienvenido "+p.getNombre(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
