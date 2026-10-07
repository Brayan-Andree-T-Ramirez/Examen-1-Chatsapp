package com.upiiz.examenu1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.upiiz.examenu1.Model.Mensaje;
import com.upiiz.examenu1.Adapters.MensajeAdapter;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatsActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView lvMensajes;
    private MensajeAdapter adapter;

    private ImageButton btnRegresarChats;
    private List<Mensaje> mensajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chats);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });





        // Recibir datos del usuario seleccionado
        String nombre = getIntent().getStringExtra("nombre");
        String alias = getIntent().getStringExtra("alias");
        int foto = getIntent().getIntExtra("foto", 0);

        TextView tvNombre = findViewById(R.id.tvNombre);
        CircleImageView imgPerfilChat = findViewById(R.id.imgPerfilChat);
        btnRegresarChats = findViewById(R.id.btnRegresarChat);

        btnRegresarChats.setOnClickListener(this);


        if (nombre != null) {
            tvNombre.setText(nombre);
        }

        if (foto != 0) {
            imgPerfilChat.setImageResource(foto);
        }

        lvMensajes = findViewById(R.id.lvMensajes);

        mensajes = new ArrayList<>();
        cargarMensajes();

        adapter = new MensajeAdapter(this,mensajes);

        lvMensajes.setAdapter(adapter);
    }

    private void cargarMensajes() {
        mensajes.add(new Mensaje(
                "Hola, ¿cómo estás?",
                "16:20",
                false
        ));

        mensajes.add(new Mensaje(
                "Muy bien, ¿y tú?",
                "16:21",
                true
        ));

        mensajes.add(new Mensaje(
                "También estoy bien.",
                "16:21",
                false
        ));

        mensajes.add(new Mensaje(
                "¿Qué haces?",
                "16:22",
                true
        ));

        mensajes.add(new Mensaje(
                "Estoy haciendo la tarea.",
                "16:22",
                false
        ));

        mensajes.add(new Mensaje(
                "¿La de Android?",
                "16:23",
                true
        ));

        mensajes.add(new Mensaje(
                "Sí, esa misma.",
                "16:23",
                false
        ));

        mensajes.add(new Mensaje(
                "Está medio complicada jajaja.",
                "16:24",
                true
        ));

        mensajes.add(new Mensaje(
                "Un poco, pero ya casi termino.",
                "16:25",
                false
        ));

        mensajes.add(new Mensaje(
                "Qué bueno.",
                "16:25",
                true
        ));

        mensajes.add(new Mensaje(
                "¿Ya terminaste tu proyecto?",
                "16:26",
                false
        ));

        mensajes.add(new Mensaje(
                "Todavía me falta una parte.",
                "16:27",
                true
        ));

        mensajes.add(new Mensaje(
                "¿Cuál?",
                "16:27",
                false
        ));

        mensajes.add(new Mensaje(
                "La pantalla del chat.",
                "16:28",
                true
        ));

        mensajes.add(new Mensaje(
                "Ah, justo estoy haciendo esa.",
                "16:29",
                false
        ));

        mensajes.add(new Mensaje(
                "Entonces estamos igual.",
                "16:29",
                true
        ));

        mensajes.add(new Mensaje(
                "Jajaja, sí.",
                "16:30",
                false
        ));

        mensajes.add(new Mensaje(
                "Bueno, te dejo trabajar.",
                "16:31",
                true
        ));

        mensajes.add(new Mensaje(
                "Gracias, nos vemos.",
                "16:31",
                false
        ));

        mensajes.add(new Mensaje(
                "Nos vemos.",
                "16:32",
                true
        ));
    }

    @Override
    public void onClick(View v) {
        Intent intentUsuarios = new Intent(this,UsuariosActivity.class);
        startActivity(intentUsuarios);
    }
}