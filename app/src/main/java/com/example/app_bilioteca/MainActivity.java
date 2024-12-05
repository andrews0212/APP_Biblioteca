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
import com.example.app_bilioteca.fragment.RegistroLibroFragment;
import com.example.app_bilioteca.fragment.onMenuOptionSelectedListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements onMenuOptionSelectedListener {


    ArrayList<Libro> libros;
    FragmentBusquedaLibro fragmentBusquedaLibro;
    FragmentBarraBusqueda fragmentBarraBusqueda;
    FragmentManager fragmentManager;
    RegistroLibroFragment registroLibroFragment;

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


        MyDataBaseHelper con = new MyDataBaseHelper(this, "bd_biblioteca", null,1);

        registroLibroFragment = new RegistroLibroFragment();
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
            if (fragmentManager.findFragmentByTag("addLibro") == null) {
                fragmentManager.beginTransaction()
                        .add(R.id.LinearLayout, registroLibroFragment, "addLibro")
                        .commit();
            }
        }
    }

}