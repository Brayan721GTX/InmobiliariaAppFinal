package com.example.inmobiliaria;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.inmobiliaria.modelo.Propiedad;
import com.example.inmobiliaria.modelo.PropiedadData;
import com.example.inmobiliaria.modelo.Propietario;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PropiedadesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PropiedadesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PropiedadesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private String tipo;

    private OnFragmentInteractionListener mListener;

    public PropiedadesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PropiedadesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PropiedadesFragment newInstance(String param1, String param2) {
        PropiedadesFragment fragment = new PropiedadesFragment();
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
        
        if (getArguments() != null) {
            Toast.makeText(getContext(), "Elija una propiedad para continuar", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_propiedades, container, false);

        //Obtener del modelo
        final ArrayList<Propiedad> propiedades = new PropiedadData().obtenerPropiedades(Home.idPropietario);
        //final ArrayList<Propiedad> propiedades = new ArrayList<Propiedad>();
        //Propietario propietario = new Propietario(1, "264343534", "Gates", "Bill", "2664123432", "excample@gmail.com","nada");
        //propiedades.add(new Propiedad(1, "asd", 3, "Departamento", "Comercial", 10000, true, propietario));

        PropiedadAdapter adapter = new PropiedadAdapter(getContext(), R.layout.item_propiedad, propiedades, inflater);

        ListView listViewPropiedades = view.findViewById(R.id.listViewPropiedades);
        listViewPropiedades.setAdapter(adapter);

        listViewPropiedades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putString("idInmueble", propiedades.get(position).getId()+"");

                if(getArguments() == null) {
                    Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.action_propiedadesFragment_to_propiedadFragment, bundle);
                }
                else{
                    if (getArguments().getString("tipo").equals("inquilinos")) {
                        Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.action_propiedadesFragment_to_inquilinosFragment, bundle);
                    }
                    else if (getArguments().getString("tipo").equals("pagos")) {
                        Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.action_propiedadesFragment_to_pagosFragment, bundle);
                    }
                    else if (getArguments().getString("tipo").equals("contratos")) {
                        Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.action_propiedadesFragment_to_contratosFragment, bundle);
                    }
                }
            }
        });

        return view;
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
