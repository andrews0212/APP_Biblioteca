package com.example.app_bilioteca.fragment;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.app_bilioteca.R;
import org.jetbrains.annotations.NotNull;

public class FragmentBarraBusqueda extends Fragment {

    private onMenuOptionSelectedListener listener;
    private Button btnAdd;
    private Button btnSearch;
    private Button btnDelete;
    private Button btnEdit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_barra_busqueda, container, false);

        btnSearch = view.findViewById(R.id.buttonBuscar);
        btnAdd = view.findViewById(R.id.buttonCrear);
        btnEdit =  view.findViewById(R.id.buttonModificar);
        btnSearch.setOnClickListener(v -> {
           if (listener != null){
               listener.menuOptionSelected(1);
            }
        });
        btnAdd.setOnClickListener(v -> {
            if (listener != null){
                listener.menuOptionSelected(2);
            }
        });
        btnEdit.setOnClickListener(v -> {
            listener.menuOptionSelected(3);
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        if (context instanceof onMenuOptionSelectedListener) {
            listener = (onMenuOptionSelectedListener) context;
        }
    }
}