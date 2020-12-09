package com.example.ibservices.Ui;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.ibservices.Data.CleaningInfoParcel;
import com.example.ibservices.R;
import com.google.android.material.snackbar.Snackbar;

import static com.example.ibservices.Utils.Constants.DATE;
import static com.example.ibservices.Utils.Constants.HOUSE_TYPE;
import static com.example.ibservices.Utils.Constants.NO_OF_ROOMS;
import static com.example.ibservices.Utils.Constants.PARCELS;
import static com.example.ibservices.Utils.Constants.SERVICE_TYPE;
import static com.example.ibservices.Utils.Constants.TIME;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentAppartmentType extends Fragment {

    private RadioGroup mRadioGroup_house_type, mRadioGroup_noOf_rooms;
    private RadioButton rb_House_Type;
    private RadioButton rb_noOf_rooms;
    private Button selectAppartment_next;
    FragmentTransaction mFragmentTransaction;
    private CleaningInfoParcel mCleaningInfoParcel;
    private String mTime;
    private String mDate;
    private String mService;
    private String selectedRooms;
    private String selected_house;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_appartment_type, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRadioGroup_house_type = view.findViewById(R.id.radioGroup_house_type);
        mRadioGroup_noOf_rooms = view.findViewById(R.id.radioGroup_house_rooms);


        selectAppartment_next = view.findViewById(R.id.appartment_type_next);

        if (getArguments() != null) {
            mCleaningInfoParcel = getArguments().getParcelable(PARCELS);
            mTime = getArguments().getString(TIME);
            mDate = getArguments().getString(DATE);
            mService = getArguments().getString(SERVICE_TYPE);
        }
        mFragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();

        mRadioGroup_house_type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb_House_Type = view.findViewById(mRadioGroup_house_type.getCheckedRadioButtonId());
                if (rb_House_Type.isChecked()){
                    selected_house = rb_House_Type.getText().toString();
                }

            }
        });

        mRadioGroup_noOf_rooms.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb_noOf_rooms = view.findViewById(mRadioGroup_noOf_rooms.getCheckedRadioButtonId());
                if (rb_noOf_rooms.isChecked()) {
                    selectedRooms = rb_noOf_rooms.getText().toString();
                }
            }
        });


        selectAppartment_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new FragmentPaymentType();


                Bundle bundle = new Bundle();
                bundle.putString(SERVICE_TYPE, mService);
                bundle.putParcelable(PARCELS, mCleaningInfoParcel);
                bundle.putString(DATE, mDate);
                bundle.putString(TIME, mTime);
                bundle.putString(HOUSE_TYPE, selected_house);
                bundle.putString(NO_OF_ROOMS, selectedRooms);
                fragment.setArguments(bundle);

                if (selectedRooms == null){
                    Snackbar snackbar = Snackbar.make
                            (getView(),"choose the number of rooms you have", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }else if (selected_house == null){
                    Snackbar snackbar = Snackbar.make
                            (getView(),"please choose your type of appartment", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                else{
                    mFragmentTransaction.replace(R.id.fragmentContainer, fragment, getTag()).addToBackStack(null).commit();
                }


            }
        });

    }

}
