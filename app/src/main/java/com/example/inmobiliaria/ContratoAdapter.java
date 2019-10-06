package com.example.inmobiliaria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.inmobiliaria.modelo.Alquiler;
import com.example.inmobiliaria.modelo.Pago;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ContratoAdapter extends ArrayAdapter {
    private Context context;
    private List<Alquiler> contratos;
    private LayoutInflater li;

    public ContratoAdapter(@NonNull Context context, int resource, @NonNull List<Alquiler> contratos, LayoutInflater li) {
        super(context, resource, contratos);

        this.context = context;
        this.contratos = contratos;
        this.li = li;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;

        if(itemView == null) {
            itemView = li.inflate(R.layout.item_contrato, parent, false);
        }

        Alquiler contrato = contratos.get(position);

        TextView fechaFin = itemView.findViewById(R.id.textView20);
        fechaFin.setText(contrato.getFechaFin().toString());

        TextView importe = itemView.findViewById(R.id.textView21);
        importe.setText("$"+contrato.getPrecio());

        return itemView;
    }
}
