package com.example.app_bilioteca.fragment;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.app_bilioteca.MyDataBaseHelper;
import com.example.app_bilioteca.R;
import com.example.app_bilioteca.Utilidades;


public class FragmentEliminar extends Fragment {

    private Button buttonEliminar;
    private EditText editTextISBN;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_eliminar, container, false);
        buttonEliminar = view.findViewById(R.id.EliminarButton);
        editTextISBN = view.findViewById(R.id.isbnEdit);
        buttonEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             eliminar();
            }
        });
        return view;
    }

    private void eliminar() {
        MyDataBaseHelper con = new MyDataBaseHelper(getContext(), "bd_biblioteca", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();
        String[] parametros = {editTextISBN.getText().toString()};
        int resultado = db.delete(Utilidades.Tabla_Libro, Utilidades.Campo_ISBN + "=?", parametros);
        db.close();
        if (resultado > 0) {
            Toast.makeText(getContext(), "Eliminado", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getContext(), "Isbn no Encontrado", Toast.LENGTH_SHORT).show();
        }

    }
}