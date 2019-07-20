package com.example.personasmaterial;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetallePersona extends AppCompatActivity {

    private TextView nombre;
    private TextView apellido;
    private ImageView foto;
    private Bundle bundle;
    private Intent i;
    private int fot;
    private String nomb, apel, id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_persona);
        nombre = findViewById(R.id.lblNombreD);
        apellido = findViewById(R.id.lblApellidoD);
        foto = findViewById(R.id.fotoD);

        i = getIntent();
        bundle = i.getBundleExtra("datos");
        nomb = bundle.getString("nombre");
        apel = bundle.getString("apellido");
        fot = bundle.getInt("foto");
        id = bundle.getString("id");

        nombre.setText(nomb);
        apellido.setText(apel);
        foto.setImageResource(fot);

    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(DetallePersona.this, MainActivity.class);
        startActivity(i);
    }

    public void eliminar(View v){
        String positivo, negativo;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.titulo_eliminar));
        builder.setMessage(getResources().getString(R.string.mensaje_eliminar));

        positivo = getResources().getString(R.string.positivo);
        negativo = getResources().getString(R.string.negativo);

        builder.setPositiveButton(positivo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Persona p = new Persona();
                p.setId(id);
                p.eliminar();
                onBackPressed();
            }
        });

        builder.setNegativeButton(negativo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }
}
