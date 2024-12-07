package com.example.app_bilioteca.fragment;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.app_bilioteca.MyDataBaseHelper;
import com.example.app_bilioteca.R;
import com.example.app_bilioteca.Utilidades;

public class RegistroLibroFragment extends Fragment {
    
    private Button btnRegistrar;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_registro_libro, container, false);
        btnRegistrar = view.findViewById(R.id.modificarDataButton);
        btnRegistrar.setOnClickListener(v -> {
           registrar(); 
        });
        return view;
        
    }

    private void registrar() {

        EditText editTextISBN = getView().findViewById(R.id.editTextTextISBNMod);
        EditText editTextTitulo = getView().findViewById(R.id.editTextTextTituloMod);
        EditText editTextAutor = getView().findViewById(R.id.editTextTextAutorMod);
        RadioButton radioButtonSi = getView().findViewById(R.id.radioButtonSiMod);
        EditText editTextDescripcion = getView().findViewById(R.id.editTextTextMultiLineDescripcionMod);

        String isbn = editTextISBN.getText().toString();
        String titulo = editTextTitulo.getText().toString();
        String autor = editTextAutor.getText().toString();
        boolean favorito = radioButtonSi.isChecked() ? true : false;
        String descripcion = editTextDescripcion.getText().toString();

        MyDataBaseHelper con = new MyDataBaseHelper(getContext(), "bd_biblioteca", null,1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilidades.Campo_ISBN, isbn);
        values.put(Utilidades.Campo_Titulo, titulo);
        values.put(Utilidades.Campo_Autor, autor);
        values.put(Utilidades.Campo_Favorito, favorito);
        values.put(Utilidades.Campo_Descripcion, descripcion);

        long idResultante = db.insert(Utilidades.Tabla_Libro, Utilidades.Campo_ISBN, values);

        Toast.makeText(getContext(), "ID Resultante: " + idResultante, Toast.LENGTH_SHORT).show();
        db.close();

    }


}