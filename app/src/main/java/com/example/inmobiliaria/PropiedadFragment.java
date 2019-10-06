package com.example.inmobiliaria;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PropiedadFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PropiedadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PropiedadFragment extends Fragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public PropiedadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PropiedadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PropiedadFragment newInstance(String param1, String param2) {
        PropiedadFragment fragment = new PropiedadFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_propiedad, container, false);

        EditText etDirección = view.findViewById(R.id.editText9);
        etDirección.setText("");

        EditText etAmbientes = view.findViewById(R.id.editText10);
        etAmbientes.setText("");

        EditText etPrecio = view.findViewById(R.id.editText11);
        etPrecio.setText("");

        Spinner spTipo = view.findViewById(R.id.spinner);
        String[] arrayTipos = new String[]{"Departamento", "Local", "Depósito", "Oficina individual"};
        ArrayAdapter<String> adapterTipos = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, arrayTipos);
        adapterTipos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTipo.setAdapter(adapterTipos);
        spTipo.setSelection(0);

        Spinner spUso = view.findViewById(R.id.spinner2);
        String[] arrayUsos = new String[]{"Comercial", "Residencial"};
        ArrayAdapter<String> adapterUsos = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, arrayUsos);
        adapterUsos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spUso.setAdapter(adapterUsos);
        spUso.setSelection(0);

        CheckBox cbDisponibilidad = view.findViewById(R.id.checkBox);

        Button btnEditar = view.findViewById(R.id.button3);
        
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "En construcción...", Toast.LENGTH_SHORT).show();
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
