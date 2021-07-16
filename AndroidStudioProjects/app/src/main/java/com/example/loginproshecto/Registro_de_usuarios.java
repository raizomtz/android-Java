package com.example.loginproshecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Registro_de_usuarios extends AppCompatActivity {
    Button btn_rsalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_de_usuarios);

        btn_rsalir = findViewById(R.id.btn_rsalir);

        btn_rsalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_rsalir = new Intent(Registro_de_usuarios.this, MainActivity.class);
                Registro_de_usuarios.this.startActivity(intent_rsalir);
            }
        });

    }
}