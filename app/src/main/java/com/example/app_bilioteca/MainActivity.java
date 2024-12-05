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
import com.example.app_bilioteca.fragment.FragmentBarraBusqueda;
import com.example.app_bilioteca.fragment.FragmentBusquedaLibro;
import com.example.app_bilioteca.fragment.onMenuOptionSelectedListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements onMenuOptionSelectedListener {

    RecyclerView recyclerView;
    ArrayList<Libro> libros;
    FragmentBusquedaLibro fragmentBusquedaLibro;
    FragmentBarraBusqueda fragmentBarraBusqueda;
    FragmentManager fragmentManager;

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
//        recyclerView = findViewById(R.id.recyclerView);
//
//        libros = new ArrayList<>();
//
//        // Agregar libros a la lista
//        libros.add(new Libro("Cien años de soledad", "Gabriel García Márquez", 1967));
//        libros.add(new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 1605));
//        libros.add(new Libro("Orgullo y prejuicio", "Jane Austen", 1813));
//        libros.add(new Libro("1984", "George Orwell", 1949));
//        libros.add(new Libro("Matar a un ruiseñor", "Harper Lee", 1960));
//        libros.add(new Libro("El Principito", "Antoine de Saint-Exupéry", 1943));
//        libros.add(new Libro("Crimen y castigo", "Fiódor Dostoyevski", 1866));
//        libros.add(new Libro("La metamorfosis", "Franz Kafka", 1915));
//        libros.add(new Libro("El Señor de los Anillos", "J.R.R. Tolkien", 1954));
//        libros.add(new Libro("La Divina Comedia", "Dante Alighieri", 1320));
//        libros.add(new Libro("Las aventuras de Sherlock Holmes", "Arthur Conan Doyle", 1892));
//        libros.add(new Libro("Ulises", "James Joyce", 1922));
//        libros.add(new Libro("En el camino", "Jack Kerouac", 1957));
//        libros.add(new Libro("Cumbres borrascosas", "Emily Brontë", 1847));
//        libros.add(new Libro("El retrato de Dorian Gray", "Oscar Wilde", 1890));
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        CustomAdapter customAdapter = new CustomAdapter(libros);
//
//        recyclerView.setAdapter(customAdapter);

        fragmentBusquedaLibro = new FragmentBusquedaLibro();
        fragmentBarraBusqueda = new FragmentBarraBusqueda();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.LinearLayout, fragmentBarraBusqueda).commit();

    }

    @Override
    public void menuOptionSelected(int position) {
        if (position == 1) {

            if (fragmentManager.findFragmentByTag("BusquedaLibro") == null) {
                fragmentManager.beginTransaction()
                        .add(R.id.LinearLayout, fragmentBusquedaLibro, "BusquedaLibro")
                        .commit();
            }
        } else if (position == 2) {

        }
    }

}