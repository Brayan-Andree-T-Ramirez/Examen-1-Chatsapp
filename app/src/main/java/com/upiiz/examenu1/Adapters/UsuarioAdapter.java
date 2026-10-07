package com.upiiz.examenu1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.upiiz.examenu1.Model.Usuario;
import com.upiiz.examenu1.R;

import java.util.ArrayList;

public class UsuarioAdapter extends ArrayAdapter<Usuario> {
    public UsuarioAdapter(Context context, ArrayList<Usuario> usuarios) {
        super(context, 0, usuarios);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_user, parent, false);
        }

        ImageView ivUser = convertView.findViewById(R.id.ivUser);
        TextView tvUser = convertView.findViewById(R.id.tvUser);
        TextView tvSurnameUser = convertView.findViewById(R.id.tvAlias);

        Usuario usuario = getItem(position);

        tvUser.setText(usuario.getNombre());
        tvSurnameUser.setText(usuario.getAlias());
        ivUser.setImageResource(usuario.getFoto());

        return convertView;
    }

}
