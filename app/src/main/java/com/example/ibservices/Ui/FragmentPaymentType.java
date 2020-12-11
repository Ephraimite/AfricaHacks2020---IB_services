package com.example.ibservices.Ui;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ibservices.Api.VonageSmsApi;
import com.example.ibservices.ApiClient.SmsClient;
import com.example.ibservices.Data.CleaningInfoParcel;
import com.example.ibservices.Data.Message;
import com.example.ibservices.Data.SmsResponse;
import com.example.ibservices.R;
import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

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

    private String FROM = "IB services";
    private String TO = "";
    public String MESSAGE =  "Thank you for choosing IB services..." + " " + "your order has been recorded, " +
            "our representative will get in touch shortly";
    public String API_KEY = "9638fb73";
    public String SECRET_KEY = "e9P0XjIdc3lGsQuu";

    Button proceed_pay;
    RadioGroup radioGroup;
    RadioButton pay_card, pay_after_service;

    TextView tv_name, tv_email, tv_phone, tv_location, tv_time, tv_service_type,
            tv_date, tv_special_requirement, tv_house_type, tv_noOf_roooms;


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

        proceed_pay = view.findViewById(R.id.btn_payment);
        radioGroup = view.findViewById(R.id.myRadioGroup);
        pay_card = view.findViewById(R.id.rb_payWithCard);
        pay_after_service = view.findViewById(R.id.rb_payAfterService);


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
            TO = cleaningInfoParcel.getPhone();
            String location = cleaningInfoParcel.getLocation();
            String special_requirement = cleaningInfoParcel.getSpecial_requirement();


            tv_service_type.setText(service);
            tv_name.setText(name);
            tv_email.setText(email);
            tv_phone.setText(TO);
            tv_date.setText(date);
            tv_location.setText(location);
            tv_time.setText(t);
            tv_special_requirement.setText(special_requirement);
            tv_house_type.setText(house_type);
            tv_noOf_roooms.setText(number_of_rooms);

        }

        RadioGroup rg = radioGroup;
        int ID = rg.getCheckedRadioButtonId();

        if (ID == R.id.rb_payWithCard) {

            Toast.makeText(getContext(), "Payment Method Called", Toast.LENGTH_LONG).show();
        } else if (ID == R.id.rb_payAfterService) {

            sendSmsNotificationToUser( API_KEY, TO, FROM, MESSAGE,SECRET_KEY); }

    }

    private void sendSmsNotificationToUser(String apiKey, String secret_key, String from, String to, String message ) {
        Retrofit retrofit = SmsClient.getRetrofitInstance();
        VonageSmsApi vonageSmsAp  = retrofit.create(VonageSmsApi.class);
        Call<SmsResponse> call = vonageSmsAp.sendSmsOrderConfirmation(apiKey,secret_key,from,to,message);

        call.enqueue(new Callback<SmsResponse>() {
            @Override
            public void onResponse(Call<SmsResponse> call, Response<SmsResponse> response) {
                if (response.body() !=null){

                    List<Message> message = response.body().getMessages();
                    String status = String.valueOf(message);

                    Toast.makeText(getContext(), status, Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<SmsResponse> call, Throwable t) {

            }
        });
    }
}
