package com.example.app_bilioteca.fragment;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.app_bilioteca.CustomAdapter;
import com.example.app_bilioteca.Libro;
import com.example.app_bilioteca.R;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class FragmentBusquedaLibro extends Fragment {


    private CustomAdapter customAdapter;
    private RecyclerView recyclerView;
    private Button btnBuscarTodo;
    private Button btnBusquedaLibro;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_busqueda_libro, container, false);
        btnBusquedaLibro = view.findViewById(R.id.buttonBuscar);
        btnBuscarTodo = view.findViewById(R.id.buttonBuscarTodos);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ArrayList<Libro> libros = new ArrayList<>();

        // Agregar libros a la lista
        libros.add(new Libro("Cien años de soledad", "Gabriel García Márquez", 1967));
        libros.add(new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 1605));
        libros.add(new Libro("Orgullo y prejuicio", "Jane Austen", 1813));
        libros.add(new Libro("1984", "George Orwell", 1949));
        libros.add(new Libro("Matar a un ruiseñor", "Harper Lee", 1960));
        libros.add(new Libro("El Principito", "Antoine de Saint-Exupéry", 1943));
        libros.add(new Libro("Crimen y castigo", "Fiódor Dostoyevski", 1866));
        libros.add(new Libro("La metamorfosis", "Franz Kafka", 1915));
        libros.add(new Libro("El Señor de los Anillos", "J.R.R. Tolkien", 1954));
        libros.add(new Libro("La Divina Comedia", "Dante Alighieri", 1320));
        libros.add(new Libro("Las aventuras de Sherlock Holmes", "Arthur Conan Doyle", 1892));
        libros.add(new Libro("Ulises", "James Joyce", 1922));
        libros.add(new Libro("En el camino", "Jack Kerouac", 1957));
        libros.add(new Libro("Cumbres borrascosas", "Emily Brontë", 1847));
        libros.add(new Libro("El retrato de Dorian Gray", "Oscar Wilde", 1890));
        customAdapter = new CustomAdapter(libros);



        btnBuscarTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setAdapter(customAdapter);
            }
        });




        return view;
    }
}




