package com.upiiz.examenu1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.upiiz.examenu1.Adapters.UsuarioAdapter;
import com.upiiz.examenu1.Model.Usuario;

import java.util.ArrayList;

public class UsuariosActivity extends AppCompatActivity {

    ListView listViewUsuarios;
    ArrayList<Usuario> usuarios;
    UsuarioAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_usuarios);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listViewUsuarios = findViewById(R.id.listViewUsuarios);

        usuarios = new ArrayList<>();

        agegarUsuarios();

        adapter = new UsuarioAdapter(this, usuarios);

        listViewUsuarios.setAdapter(adapter);

        listViewUsuarios.setOnItemClickListener((parent, view, position, id) -> {

            Usuario usuario = usuarios.get(position);

            Intent intent = new Intent(this, ChatsActivity.class);

            intent.putExtra("nombre", usuario.getNombre());
            intent.putExtra("alias", usuario.getAlias());
            intent.putExtra("foto", usuario.getFoto());

            startActivity(intent);
        });


    }

    private void agegarUsuarios() {

        usuarios.add(new Usuario("Juan", "juanp", R.drawable.profile));
        usuarios.add(new Usuario("Maria", "maria_l", R.drawable.profile2));
        usuarios.add(new Usuario("Carlos", "carlosr", R.drawable.profile3));
        usuarios.add(new Usuario("Ana", "ana_m", R.drawable.profile));
        usuarios.add(new Usuario("Luis", "luisg", R.drawable.profile2));
        usuarios.add(new Usuario("Sofia", "sofia_h", R.drawable.profile3));
        usuarios.add(new Usuario("Pedro", "pedrot", R.drawable.profile));
        usuarios.add(new Usuario("Laura", "lauraf", R.drawable.profile2));
        usuarios.add(new Usuario("Diego", "diegoc", R.drawable.profile3));
        usuarios.add(new Usuario("Daniela", "danielam", R.drawable.profile));
        usuarios.add(new Usuario("Miguel", "miguel_o", R.drawable.profile2));
        usuarios.add(new Usuario("Fernanda", "fer_v", R.drawable.profile3));
        usuarios.add(new Usuario("Jorge", "jorgem", R.drawable.profile));
        usuarios.add(new Usuario("Valeria", "valeriar", R.drawable.profile2));
        usuarios.add(new Usuario("Andres", "andresn", R.drawable.profile3));
        usuarios.add(new Usuario("Gabriela", "gabic", R.drawable.profile));
        usuarios.add(new Usuario("Ricardo", "ricardor", R.drawable.profile2));
        usuarios.add(new Usuario("Elena", "elenaj", R.drawable.profile3));
        usuarios.add(new Usuario("Alejandro", "alexs", R.drawable.profile));
        usuarios.add(new Usuario("Paola", "paolar", R.drawable.profile2));
    }
}