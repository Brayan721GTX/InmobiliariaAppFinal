package com.example.inmobiliaria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.inmobiliaria.modelo.Inquilino;
import com.example.inmobiliaria.modelo.Propiedad;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class InquilinoAdapter extends ArrayAdapter {
    private Context context;
    private List<Inquilino> inquilinos;
    private LayoutInflater li;

    public InquilinoAdapter(@NonNull Context context, int resource, @NonNull List<Inquilino> inquilinos, LayoutInflater li) {
        super(context, resource, inquilinos);

        this.context = context;
        this.inquilinos = inquilinos;
        this.li = li;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;

        if(itemView == null) {
            itemView = li.inflate(R.layout.item_inquilino, parent, false);
        }

        Inquilino inquilino = inquilinos.get(position);

        TextView nombre = itemView.findViewById(R.id.textView17);
        nombre.setText(inquilino.getNombre()+" "+inquilino.getApellido());

        return itemView;
    }
}
