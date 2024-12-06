package com.example.app_bilioteca;

public class Utilidades {


    public static final String Tabla_Libro = "Libro";

    public static final String Campo_ISBN = "ISBN";
    public static final String Campo_Titulo = "Titulo";
    public static final String Campo_Autor = "Autor";
    public static final String Campo_Favorito = "Favorito";
    public static final String Campo_Descripcion = "Descripcion";

    public static final String Crear_tabla_Libro = "CREATE TABLE " + Tabla_Libro + " ("
            + Campo_ISBN + " TEXT PRIMARY KEY, "
            + Campo_Titulo + " TEXT NOT NULL, "
            + Campo_Autor + " TEXT NOT NULL, "
            + Campo_Favorito + " INTEGER DEFAULT 0, "
            + Campo_Descripcion + " TEXT"
            + ");";
}
