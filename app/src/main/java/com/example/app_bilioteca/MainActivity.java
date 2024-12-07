package com.example.app_bilioteca;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.app_bilioteca.fragment.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements onMenuOptionSelectedListener {

    RecyclerView recyclerView;
    ArrayList<Libro> libros;
    FragmentBarraBusqueda fragmentBarraBusqueda;
    FragmentManager fragmentManager;
    FragmentBusquedaLibro fragmentBusquedaLibro;
    RegistroLibroFragment registroLibroFragment;
    FragmentModificar fragmentModificar;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        registroLibroFragment = new RegistroLibroFragment();
        fragmentModificar = new FragmentModificar();
        fragmentBusquedaLibro = new FragmentBusquedaLibro();
        fragmentBarraBusqueda = new FragmentBarraBusqueda();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.LinearLayout, fragmentBarraBusqueda).commit();

    }

    @Override
    public void menuOptionSelected(int position) {
        fragmentManager = getSupportFragmentManager();

        if (position == 1) {
            fragmentManager.beginTransaction()
                    .replace(R.id.LinearLayoutContainer, fragmentBusquedaLibro, "buscar")
                    .commit();
        } else if (position == 2) {
            fragmentManager.beginTransaction()
                    .replace(R.id.LinearLayoutContainer, registroLibroFragment, "RegistroLibroFragment")
                    .commit();
        } else if (position == 3) {
            fragmentManager.beginTransaction()
                    .replace(R.id.LinearLayoutContainer, fragmentModificar, "modificar")
                    .commit();

        }
    }

}