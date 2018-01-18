package com.example.a2dam.pm_dialogos;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Bundle;
import android.app.DialogFragment;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TimePicker;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DateFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DateFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DateFragment extends DialogFragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String stringDate = null;
    private  String rbColor;
    private RadioButton rbGreen, rbRed, rbBlue;
    private CharSequence[] item = {"Red", "Green", "Blue"};

    private OnFragmentInteractionListener comunicator;

    public DateFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DateFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DateFragment newInstance(String param1, String param2) {
        DateFragment fragment = new DateFragment();
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
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.fragment_date, null);
        alertDialog.setView(v);

        rbRed = v.findViewById(R.id.rbRed);
        rbBlue = v.findViewById(R.id.rbBlue);
        rbGreen = v.findViewById(R.id.rbGreen);

        rbRed.setOnClickListener(this);
        rbBlue.setOnClickListener(this);
        rbGreen.setOnClickListener(this);


        alertDialog.setMessage("Choose a color please");
        alertDialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (rbColor != null) {

                    comunicator.getSelectedColor(rbColor);
                } else {

                    Toast.makeText(getActivity(), "Select a color", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alertDialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


            }
        });


        return alertDialog.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            comunicator = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement getSelectedDate()");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        comunicator = null;
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == rbRed.getId()) {

            rbColor = "red";
        } else {
            if (view.getId() == rbGreen.getId()) {

                rbColor = "green";
            } else {
                if (view.getId() == rbBlue.getId()) {

                    rbColor = "blue";
                }
            }
        }

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
        void getSelectedColor(String color);
    }
}
