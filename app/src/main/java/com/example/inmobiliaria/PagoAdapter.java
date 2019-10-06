package com.example.inmobiliaria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.inmobiliaria.modelo.Pago;
import com.example.inmobiliaria.modelo.Propiedad;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PagoAdapter extends ArrayAdapter {
    private Context context;
    private List<Pago> pagos;
    private LayoutInflater li;

    public PagoAdapter(@NonNull Context context, int resource, @NonNull List<Pago> pagos, LayoutInflater li) {
        super(context, resource, pagos);

        this.context = context;
        this.pagos = pagos;
        this.li = li;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;

        if(itemView == null) {
            itemView = li.inflate(R.layout.item_pago, parent, false);
        }

        Pago pago = pagos.get(position);

        TextView direccion = itemView.findViewById(R.id.textView18);
        direccion.setText(pago.getAlquiler().getPropiedad().getDireccion());

        TextView importe = itemView.findViewById(R.id.textView19);
        importe.setText("$"+pago.getImporte());

        return itemView;
    }
}
