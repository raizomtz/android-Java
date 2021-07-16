package com.example.loginproshecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    TextView btn_registrar;
    EditText ed_usuario, ed_pass;
    Button btn_iniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_registrar = findViewById(R.id.btn_registrar);
        ed_usuario = findViewById(R.id.ed_usuario);
        ed_pass = findViewById(R.id.ed_pass);
        btn_iniciar = findViewById(R.id.btn_iniciar);

        btn_iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ejecutarServicio("http://192.168.0.11/android/controlador.php");
            }
        });

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(MainActivity.this, Registro_de_usuarios.class);
                MainActivity.this.startActivity(intentReg);

            }
        });

    }

    private void ejecutarServicio(String URL){
       StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
           @Override
           public void onResponse(String response) {
               if(!response.isEmpty()){
                   Intent intent = new Intent(getApplicationContext(),Principal.class);
                   startActivity(intent);
               }else{
                   Toast.makeText(MainActivity.this, "Fallo en los datos, pruebe otra vez", Toast.LENGTH_SHORT).show();
               }
           }
       }, new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {
               Toast.makeText(getApplicationContext(),"Fallo en la conexion"+ error.toString(),Toast.LENGTH_SHORT).show();
           }
       }){
           @Override
           protected Map<String, String> getParams() throws AuthFailureError {
               Map<String,String> parametros = new HashMap<String , String>();
               parametros.put("usuario", ed_usuario.getText().toString());
               parametros.put("pass", ed_pass.getText().toString());
               return parametros;
           }
       };
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);
    }
}