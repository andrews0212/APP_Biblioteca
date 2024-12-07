package com.example.app_bilioteca.fragment;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
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
import com.example.app_bilioteca.Libro;
import com.example.app_bilioteca.MyDataBaseHelper;
import com.example.app_bilioteca.R;
import com.example.app_bilioteca.Utilidades;

public class FragmentModificar extends Fragment {

    private EditText editTextISBN;
    private EditText editTextTitulo;
    private EditText editTextAutor;
    private EditText editTextDescripcion;
    private RadioButton radioButtonSi;
    private Button buttonModificar;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_modificar, container, false);

        editTextISBN = view.findViewById(R.id.editTextTextISBNMod);
        editTextTitulo = view.findViewById(R.id.editTextTextTituloMod);
        editTextAutor = view.findViewById(R.id.editTextTextAutorMod);
        editTextDescripcion = view.findViewById(R.id.editTextTextMultiLineDescripcionMod);
        radioButtonSi = view.findViewById(R.id.radioButtonSiMod);
        buttonModificar = view.findViewById(R.id.modificarDataButton);

        buttonModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                modificar();
            }
        });

        return view;
    }

    private void modificar() {
        SQLiteDatabase db = obtenerBaseDeDatosEscritura();

        String[] parametros = {obtenerTexto(editTextISBN)};
        String[] camposVisualizados = {Utilidades.Campo_Titulo, Utilidades.Campo_ISBN, Utilidades.Campo_Autor, Utilidades.Campo_Favorito, Utilidades.Campo_Descripcion};

        Cursor cursor = db.query(Utilidades.Tabla_Libro, camposVisualizados, Utilidades.Campo_ISBN + "=?", parametros, null, null, null);

        if (cursor.moveToFirst()) {
            ContentValues contentValues = obtenerValoresParaActualizar(cursor);
            int filasAfectadas = db.update(Utilidades.Tabla_Libro, contentValues, Utilidades.Campo_ISBN + "=?", parametros);
            if (filasAfectadas > 0) {
                mostrarMensaje("Los valores se han modificado correctamente.");
            } else {
                mostrarMensaje("No se realizaron cambios.");
            }
        }
        cursor.close();
        db.close();
    }

    private SQLiteDatabase obtenerBaseDeDatosEscritura() {
        MyDataBaseHelper con = new MyDataBaseHelper(getContext(), "bd_biblioteca", null, 1);
        return con.getWritableDatabase();
    }

    private String obtenerTexto(EditText editText) {
        return editText.getText().toString();
    }

    private ContentValues obtenerValoresParaActualizar(Cursor cursor) {
        String titulo = cursor.getString(1);
        String autor = cursor.getString(2);
        String descripcion = cursor.getString(4);

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.Campo_Titulo, campoNoVacio(obtenerTexto(editTextTitulo), titulo));
        contentValues.put(Utilidades.Campo_Autor, campoNoVacio(obtenerTexto(editTextAutor), autor));
        contentValues.put(Utilidades.Campo_Descripcion, campoNoVacio(obtenerTexto(editTextDescripcion), descripcion));
        contentValues.put(Utilidades.Campo_Favorito, radioButtonSi.isChecked() ? 1 : 0);

        return contentValues;
    }

    private String campoNoVacio(String texto, String valorPorDefecto) {
        return texto.isEmpty() ? valorPorDefecto : texto;
    }

    private void mostrarMensaje(String mensaje) {
        Toast.makeText(getContext(), mensaje, Toast.LENGTH_SHORT).show();
    }
}