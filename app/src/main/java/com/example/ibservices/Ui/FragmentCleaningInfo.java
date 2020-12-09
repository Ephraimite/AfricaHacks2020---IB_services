package com.example.ibservices.Ui;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.ibservices.Data.CleaningInfoParcel;
import com.example.ibservices.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.text.DateFormat;
import java.util.Calendar;

import static com.example.ibservices.Utils.Constants.DATE;
import static com.example.ibservices.Utils.Constants.PARCELS;
import static com.example.ibservices.Utils.Constants.SERVICE_TYPE;
import static com.example.ibservices.Utils.Constants.TIME;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCleaningInfo extends Fragment {

    Button btn_cleaningInfo_next;
    EditText et_name, et_email, et_phone, et_date, et_location, et_special_requirement;
    ChipGroup chipGroup_time;
    Calendar mCalendar;
    DatePickerDialog mDatePickerDialog;

    private FragmentTransaction mFragmentTransaction;
    private String mCurrentTime;
    private String mCurrentDate;
    private String mServiceType;
    private Chip mChip;

    public FragmentCleaningInfo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragmentcleaninginfo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        et_date = view.findViewById(R.id.select_date);
        et_name = view.findViewById(R.id.et_name);
        et_email = view.findViewById(R.id.et_email);
        et_phone = view.findViewById(R.id.et_phone);
        et_location = view.findViewById(R.id.select_location);
        et_special_requirement = view.findViewById(R.id.special_text_area);
        chipGroup_time = view.findViewById(R.id.chipGroup_info);
        btn_cleaningInfo_next = view.findViewById(R.id.btn_info_next);

        if (getArguments() != null) {
            Bundle service = getArguments();
            mServiceType = service.getString(SERVICE_TYPE);

        }

        btn_cleaningInfo_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Fragment fragment = new FragmentAppartmentType();

                for (int i=0; i<chipGroup_time.getChildCount(); i++){
                    mChip = (Chip) chipGroup_time.getChildAt(i);
                    if (mChip.isChecked()){
                        mCurrentTime = mChip.getText().toString();
                    }
                }

                String name = et_name.getText().toString().trim();
                String email = et_email.getText().toString().trim();
                String phone = et_phone.getText().toString().trim();
                String location = et_location.getText().toString().trim();
                String date = et_date.getText().toString().trim();

                if (TextUtils.isEmpty(name)){
                    et_name.setError("this field cannot be empty");
                }else if (TextUtils.isEmpty(email)) {
                    et_email.setError("email cannot be empty");
                }else if (TextUtils.isEmpty(phone)){
                    et_phone.setError("input phone number");
                }else if (TextUtils.isEmpty(location)) {
                    et_location.setError("type your location");
                }else if (mCurrentTime == null){
                    Toast.makeText(getContext(), "please select your time", Toast.LENGTH_LONG).show();
                }else if (TextUtils.isEmpty(date)){
                    et_date.setError("choose your appointment date");
                }else {
                    mFragmentTransaction.replace(R.id.fragmentContainer, fragment, getTag()).commit();
                }

                final CleaningInfoParcel mCleaningInfoParcel = new CleaningInfoParcel();
                mCleaningInfoParcel.setName(et_name.getText().toString().trim());
                mCleaningInfoParcel.setEmail(et_email.getText().toString().trim());
                mCleaningInfoParcel.setPhone(et_phone.getText().toString().trim());
                mCleaningInfoParcel.setLocation(et_location.getText().toString().trim());
                mCleaningInfoParcel.setSpecial_requirement(et_special_requirement.getText().toString().trim());

                Bundle bundle = new Bundle();
                bundle.putParcelable(PARCELS, mCleaningInfoParcel);
                bundle.putString(TIME, mCurrentTime);
                bundle.putString(DATE, mCurrentDate);
                bundle.putString(SERVICE_TYPE, mServiceType);
                fragment.setArguments(bundle);

            }


        });

        et_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickDate();
            }
        });

        mFragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();


    }

    public void pickDate() {
        mCalendar = Calendar.getInstance();
        final int day = mCalendar.get(Calendar.YEAR);
        int month = mCalendar.get(Calendar.MONTH);
        final int year = mCalendar.get(Calendar.DAY_OF_MONTH);

        mDatePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int mYear, int mMonth, int mDay) {
                mCalendar.set(Calendar.YEAR, mYear);
                mCalendar.set(Calendar.MONTH, mMonth);
                mCalendar.set(Calendar.DAY_OF_MONTH, mDay);

                mCurrentDate = DateFormat.getDateInstance(DateFormat.FULL).format(mCalendar.getTime());
                et_date.setText(mCurrentDate);
            }
        }, day, month, year);
        mDatePickerDialog.show();

    }

}
