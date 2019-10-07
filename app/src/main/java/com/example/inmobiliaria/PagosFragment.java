package com.example.inmobiliaria;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.inmobiliaria.modelo.Alquiler;
import com.example.inmobiliaria.modelo.Inquilino;
import com.example.inmobiliaria.modelo.Pago;
import com.example.inmobiliaria.modelo.PagoData;
import com.example.inmobiliaria.modelo.Propiedad;
import com.example.inmobiliaria.modelo.Propietario;

import net.sourceforge.jtds.jdbc.DateTime;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PagosFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PagosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PagosFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private String idInmueble;

    public PagosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PagosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PagosFragment newInstance(String param1, String param2) {
        PagosFragment fragment = new PagosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        Bundle bundle = getArguments();
        if(bundle == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("tipo", "pagos");
            Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.action_pagosFragment_to_propiedadesFragment, bundle2);
        }
        else{
            this.idInmueble = bundle.getString("idInmueble");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_pagos, container, false);

        final ArrayList<Pago> pagos = new PagoData().obtenerPagosDePropiedad(Integer.parseInt(this.idInmueble));

        /*final ArrayList<Pago> pagos = new ArrayList<Pago>();//Obtener pagos del modelo
        Inquilino i = new Inquilino(1, "12345", "Gustavo", "Bic", "La Punta", "26634543");

        Propietario propietario = new Propietario(1, "264343534", "Gates", "Bill", "2664123432", "excample@gmail.com","nada");
        Propiedad p = new Propiedad(1, "asd", 3, "Departamento", "Comercial", 10000, true, propietario);

        Alquiler alquiler = new Alquiler(1, 10000, null, null, i, p);
        pagos.add(new Pago(1, 1, null, 10000, alquiler));*/

        PagoAdapter pagoAdapter = new PagoAdapter(getContext(), R.layout.item_pago, pagos, getLayoutInflater());

        ListView listView = view.findViewById(R.id.listViewPagos);
        listView.setAdapter(pagoAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                verInformacionPago(pagos.get(position));
            }
        });

        return view;
    }

    public void verInformacionPago(Pago p) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Información del pago");
        builder.setMessage("Dirección: "+p.getAlquiler().getPropiedad().getDireccion()+"\nNro de pago: "+p.getNroPago()+"\nFecha: "+p.getFecha().toString()+"\nImporte: "+p.getImporte());
        builder.setPositiveButton("Ok",null);
        builder.create();
        builder.show();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
