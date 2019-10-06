package com.example.inmobiliaria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.inmobiliaria.modelo.Propiedad;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PropiedadAdapter extends ArrayAdapter {
    private Context context;
    private List<Propiedad> propiedades;
    private LayoutInflater li;

    public PropiedadAdapter(@NonNull Context context, int resource, @NonNull List<Propiedad> propiedades, LayoutInflater li) {
        super(context, resource, propiedades);

        this.context = context;
        this.propiedades = propiedades;
        this.li = li;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;

        if(itemView == null) {
            itemView = li.inflate(R.layout.item_propiedad, parent, false);
        }

        Propiedad propiedad = propiedades.get(position);

        ImageView foto = itemView.findViewById(R.id.imageView2);

        TextView direccion = itemView.findViewById(R.id.textView10);
        direccion.setText(propiedad.getDireccion());

        TextView disponible = itemView.findViewById(R.id.textView11);

        if(!propiedad.isDisponible()) {
            foto.setImageResource(R.drawable.ic_home_black_24dp_no_disponible);
            disponible.setText("No disponible");
        }

        return itemView;
    }
}
