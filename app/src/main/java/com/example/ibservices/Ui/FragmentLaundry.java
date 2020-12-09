package com.example.ibservices.Ui;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.ibservices.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentLaundry extends Fragment {

    private CardView washing;


    public FragmentLaundry() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_laundry, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        washing = view.findViewById(R.id.cardview_washing);
        washing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentCloths fragmentCloths = new FragmentCloths();
                FragmentTransaction fragmentTransaction =requireActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer, fragmentCloths,getTag()).commit();
            }
        });
    }
}
