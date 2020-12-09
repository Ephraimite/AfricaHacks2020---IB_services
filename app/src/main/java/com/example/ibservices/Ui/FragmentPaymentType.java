package com.example.ibservices.Ui;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ibservices.Data.CleaningInfoParcel;
import com.example.ibservices.R;

import static com.example.ibservices.Utils.Constants.DATE;
import static com.example.ibservices.Utils.Constants.HOUSE_TYPE;
import static com.example.ibservices.Utils.Constants.NO_OF_ROOMS;
import static com.example.ibservices.Utils.Constants.PARCELS;
import static com.example.ibservices.Utils.Constants.SERVICE_TYPE;
import static com.example.ibservices.Utils.Constants.TIME;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPaymentType extends Fragment {

    TextView tv_name, tv_email, tv_phone, tv_location, tv_time,tv_service_type,
            tv_date, tv_special_requirement,tv_house_type, tv_noOf_roooms;

    public FragmentPaymentType() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_payment_type, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tv_service_type = view.findViewById(R.id.t_service);
        tv_name = view.findViewById(R.id.t_name);
        tv_email = view.findViewById(R.id.t_email);
        tv_phone = view.findViewById(R.id.t_phone);
        tv_date = view.findViewById(R.id.t_date);
        tv_location = view.findViewById(R.id.t_location);
        tv_time = view.findViewById(R.id.t_time);
        tv_special_requirement = view.findViewById(R.id.t_special_requirement);
        tv_house_type = view.findViewById(R.id.t_house_type);
        tv_noOf_roooms = view.findViewById(R.id.t_noOf_rooms);



        if (getArguments() != null) {
            CleaningInfoParcel cleaningInfoParcel = getArguments().getParcelable(PARCELS);
            String t = getArguments().getString(TIME);
            String date = getArguments().getString(DATE);
            String service = getArguments().getString(SERVICE_TYPE);
            String house_type = getArguments().getString(HOUSE_TYPE);
            String number_of_rooms = getArguments().getString(NO_OF_ROOMS);

            assert cleaningInfoParcel != null;
            String name = cleaningInfoParcel.getName();
            String email = cleaningInfoParcel.getEmail();
            String phone = cleaningInfoParcel.getPhone();
            String location = cleaningInfoParcel.getLocation();
            String special_requirement = cleaningInfoParcel.getSpecial_requirement();


            tv_service_type.setText(service);
            tv_name.setText(name);
            tv_email.setText(email);
            tv_phone.setText(phone);
            tv_date.setText(date);
            tv_location.setText(location);
            tv_time.setText(t);
            tv_special_requirement.setText(special_requirement);
            tv_house_type.setText(house_type);
            tv_noOf_roooms.setText(number_of_rooms);

        }
    }
}
