package com.example.personasmaterial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Random;

public class AgregarPersona extends AppCompatActivity {

    private ArrayList<Integer> fotos;
    private EditText nombre, apellido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_persona);

        fotos.add(R.drawable.images);
        fotos.add(R.drawable.images2);
        fotos.add(R.drawable.images3);

        nombre = findViewById(R.id.txtNombre);
        apellido = findViewById(R.id.txtApellido);

    }

    public void guardar(View v){
        String nom, apell, id;
        int foto;
        id = Datos.getId();
        nom = nombre.getText().toString();
        apell = apellido.getText().toString();
        foto = this.fotoAleatoria();
        Persona p = new Persona(id, foto, nom, apell);
        p.guardar();
        limpiar();
        Snackbar.make(v,"Persona guardada exitosamente",Snackbar.LENGTH_SHORT).show();
    }

    public void limpiar(View v){
        limpiar();
    }

    public void limpiar(){
        nombre.setText("");
        apellido.setText("");
        nombre.requestFocus();
    }

    public int fotoAleatoria(){
        int fotoSeleccionada ;
        Random r = new Random();
        fotoSeleccionada = r.nextInt(this.fotos.size());
        return fotos.get(fotoSeleccionada);
    }
}
