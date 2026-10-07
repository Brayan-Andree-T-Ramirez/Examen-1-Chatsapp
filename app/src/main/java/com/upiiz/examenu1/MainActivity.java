package com.upiiz.examenu1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etUsuario,etContrasenia;
    Button btnIniciarSesion,btnCrearCuenta;
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
        etUsuario = findViewById(R.id.etUsuario);
        etContrasenia = findViewById(R.id.etContrasenia);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        btnCrearCuenta = findViewById(R.id.btnCrearCuenta);
        btnIniciarSesion.setOnClickListener(this);
        btnCrearCuenta.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnCrearCuenta){
            abrirRegistro();
        }

        String usuario = etUsuario.getText().toString().trim();
        String contrasenia = etContrasenia.getText().toString();

        if(!usuario.equals("admin")){
            etUsuario.setError("Usuario incorrecto");
            etUsuario.requestFocus();
            return;
        }

        if(!contrasenia.equals("123456")){
            etContrasenia.setError("Contraseña incorrecta");
            etContrasenia.requestFocus();
            return;

        }

        abrirListado();


    }

    private void abrirListado() {
        Intent intentListado = new Intent(this,UsuariosActivity.class);
        startActivity(intentListado);
    }

    private void abrirRegistro() {
        Intent intentRegistro = new Intent(this,RegistroActivity.class);
        startActivity(intentRegistro);
    }
}