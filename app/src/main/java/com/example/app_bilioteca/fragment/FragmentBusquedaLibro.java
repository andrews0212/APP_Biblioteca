package com.example.app_bilioteca.fragment;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.app_bilioteca.*;


import java.util.ArrayList;


public class FragmentBusquedaLibro extends Fragment {


    private CustomAdapter customAdapter;
    private RecyclerView recyclerView;
    private Button btnBuscarTodo;
    private Button btnBusquedaLibro;
    private MyDataBaseHelper con;
    private EditText txtBusqueda;
    ArrayList<Libro> libros;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_busqueda_libro, container, false);
        btnBusquedaLibro = view.findViewById(R.id.buttonBuscar);
        btnBuscarTodo = view.findViewById(R.id.buttonBuscarTodos);
        txtBusqueda = view.findViewById(R.id.editTextTextBuscar);
        recyclerView = view.findViewById(R.id.recyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        con = new MyDataBaseHelper(getContext(), "bd_biblioteca", null,1);
        libros = new ArrayList<>();
        customAdapter = new CustomAdapter(libros);
        recyclerView.setAdapter(customAdapter);
        // Agregar libros a la lista


        // no hay libros a la lista


        btnBusquedaLibro = view.findViewById(R.id.buttonBuscar);

        btnBusquedaLibro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Consultar();
            }
        });

        btnBuscarTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Deberías hacer una consulta para cargar todos los libros
                ConsultaALL();
            }
        });




        return view;
    }
    public void Consultar(){
        libros.clear(); // Limpia la lista antes de agregar nuevos elementos

        SQLiteDatabase db = con.getReadableDatabase();

        String[] parametros = {txtBusqueda.getText().toString()};

        String[] camposVisualizados =  {Utilidades.Campo_Titulo, Utilidades.Campo_ISBN, Utilidades.Campo_Autor, Utilidades.Campo_Favorito, Utilidades.Campo_Descripcion};

        Cursor cursor = db.query(Utilidades.Tabla_Libro, camposVisualizados, Utilidades.Campo_ISBN +"=?",parametros,null,null,null);

        if (cursor.moveToFirst()){
            String isbn = cursor.getString(0);
            String titulo = cursor.getString(1);
            String autor = cursor.getString(2);
            boolean favorito = cursor.getInt(3) == 1;
            String descripcion = cursor.getString(4);
            libros.add(new Libro(isbn, titulo, autor, favorito, descripcion));
        }

        cursor.close();
        customAdapter.notifyDataSetChanged(); // Notifica al adaptador que los datos han cambiado
    }

    public void ConsultaALL(){
        libros.clear(); // Limpia la lista antes de agregar nuevos elementos
        SQLiteDatabase db = con.getReadableDatabase();
        String[] camposVisualizados =  {Utilidades.Campo_Titulo, Utilidades.Campo_ISBN, Utilidades.Campo_Autor, Utilidades.Campo_Favorito, Utilidades.Campo_Descripcion};
        Cursor cursor = db.query(Utilidades.Tabla_Libro,null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                String isbn = cursor.getString(0);
                String titulo = cursor.getString(1);
                String autor = cursor.getString(2);
                boolean favorito = cursor.getInt(3) == 1;
                String descripcion = cursor.getString(4);
                libros.add(new Libro(isbn, titulo, autor, favorito, descripcion));
            } while (cursor.moveToNext());
        }
        cursor.close();

        customAdapter.notifyDataSetChanged();
    }
}




