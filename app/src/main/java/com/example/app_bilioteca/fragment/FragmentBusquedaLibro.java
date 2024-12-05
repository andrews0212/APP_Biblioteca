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


        // no hay libros a la lista

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




