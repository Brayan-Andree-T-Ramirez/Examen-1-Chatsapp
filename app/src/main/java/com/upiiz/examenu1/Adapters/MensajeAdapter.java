package com.upiiz.examenu1.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.upiiz.examenu1.Model.Mensaje;
import com.upiiz.examenu1.R;

import java.util.List;

public class MensajeAdapter extends ArrayAdapter<Mensaje> {
    public MensajeAdapter(Context context, List<Mensaje> mensajes){
        super(context,0,mensajes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_mensaje,parent,false);
        }

        //Obtener los elemetnos del XML
        LinearLayout contenedorMensaje = convertView.findViewById(R.id.contenedorMensaje);

        LinearLayout burbuja = convertView.findViewById(R.id.burbuja);

        TextView txtMensaje = convertView.findViewById(R.id.txtMensaje);

        TextView txtHora = convertView.findViewById(R.id.txtHora);

        TextView txtPalomita = convertView.findViewById(R.id.txtPalomita);

        Mensaje mensaje = getItem(position);

        txtMensaje.setText(mensaje.getTexto());
        txtHora.setText(mensaje.getHora());

        //Elegir si el mensaje se envia o recibe
        if(mensaje.isEnviado()){
            contenedorMensaje.setGravity(Gravity.END);

            //Fondo azul
            burbuja.setBackgroundResource(R.drawable.fondo_mensaje_enviado);

            //Texto blanco
            txtMensaje.setTextColor(Color.WHITE);
            txtHora.setTextColor(Color.WHITE);

            txtPalomita.setVisibility(View.VISIBLE);
        }else{
            contenedorMensaje.setGravity(Gravity.START);

            burbuja.setBackgroundResource(
                    R.drawable.fondo_mensaje_recibido);

            txtMensaje.setTextColor(Color.rgb(33,37,41));
            txtHora.setTextColor(Color.GRAY);

            txtPalomita.setVisibility(View.GONE);
        }

        return convertView;
    }

}
