package com.example.ibservices.Ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ibservices.R;

import static com.example.ibservices.Utils.Constants.CLOTH_TYPE;

public class LaundrySummary extends Fragment {
    TextView summary;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_laundry_summary, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        summary = view.findViewById(R.id.laundry_summary);

        if (getArguments() != null){
            Bundle laundrySummary = getArguments();
            String allSummary = laundrySummary.getString(CLOTH_TYPE);
            summary.setText(allSummary);
        }
    }
}