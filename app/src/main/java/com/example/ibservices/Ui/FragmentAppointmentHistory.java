package com.example.ibservices.Ui;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.ibservices.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentAppointmentHistory extends Fragment {


    public FragmentAppointmentHistory() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_history, container, false);
    }

}
