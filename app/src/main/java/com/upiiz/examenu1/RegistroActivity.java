package com.upiiz.examenu1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etNombre, etCorreo, etContraseniaRegistro, getEtContraseniaRegistroConfirmar,etUsuario;
    TextView tvIniciarSesion;

    Button btnRegistrarse;

    ImageButton btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNombre = findViewById(R.id.etNombre);
        etCorreo = findViewById(R.id.etCorreo);
        etUsuario = findViewById(R.id.etUsuario);
        etContraseniaRegistro = findViewById(R.id.etContraseniaRegistro);
        getEtContraseniaRegistroConfirmar = findViewById(R.id.etConfirmarContraseniaRegistro);

        tvIniciarSesion = findViewById(R.id.tvIniciarSesion);

        btnRegistrarse = findViewById(R.id.btnRegistrarse);

        btnRegresar = findViewById(R.id.btnRegresar);

        btnRegistrarse.setOnClickListener(this);
        btnRegresar.setOnClickListener(this);
        tvIniciarSesion.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnRegistrarse){
            String nombre = etNombre.getText().toString().trim();
            String correo = etCorreo.getText().toString().trim();
            String usuario = etUsuario.getText().toString().trim();
            String contrasenia = etContraseniaRegistro.getText().toString();
            String confirmarContrasenia =
                    getEtContraseniaRegistroConfirmar.getText().toString();

            // Validar nombre
            if (nombre.isEmpty()) {
                etNombre.setError("Ingrese su nombre");
                etNombre.requestFocus();
                return;
            }

            if (nombre.length() < 3) {
                etNombre.setError("El nombre debe tener mínimo 3 caracteres");
                etNombre.requestFocus();
                return;
            }

            // Validar correo
            if (correo.isEmpty()) {
                etCorreo.setError("Ingrese su correo");
                etCorreo.requestFocus();
                return;
            }

            // Validar usuario
            if (usuario.isEmpty()) {
                etUsuario.setError("Ingrese un usuario");
                etUsuario.requestFocus();
                return;
            }

            // Validar contraseña
            if (contrasenia.isEmpty()) {
                etContraseniaRegistro.setError("Ingrese una contraseña");
                etContraseniaRegistro.requestFocus();
                return;
            }

            if (contrasenia.length() < 8) {
                etContraseniaRegistro.setError("Mínimo 8 caracteres");
                etContraseniaRegistro.requestFocus();
                return;
            }

            // Validar confirmación
            if (confirmarContrasenia.isEmpty()) {
                getEtContraseniaRegistroConfirmar.setError("Confirme su contraseña");
                getEtContraseniaRegistroConfirmar.requestFocus();
                return;
            }

            // Comparar contraseñas
            if (!contrasenia.equals(confirmarContrasenia)) {
                getEtContraseniaRegistroConfirmar.setError("Las contraseñas no coinciden");
                getEtContraseniaRegistroConfirmar.requestFocus();
                return;
            }

            abrirLogin();


        }else{
            abrirLogin();
        }

    }

    private void abrirLogin() {
        Intent intentLogin = new Intent(this, MainActivity.class);
        startActivity(intentLogin);
    }
}