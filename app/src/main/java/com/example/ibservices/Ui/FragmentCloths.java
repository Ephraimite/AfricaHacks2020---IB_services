package com.example.ibservices.Ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ibservices.Adapters.LaundryAdapter;
import com.example.ibservices.R;
import com.example.ibservices.ViewModels.LaundryViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCloths extends Fragment {

    FragmentTransaction mFragmentTransaction;

    private Button btn_cloth_next;
    private LaundryAdapter mAdapter;
    private RecyclerView rv_cloths;
    private LaundryViewModel mLaundryViewModel;
    TextView tv_laundry_price;

    public FragmentCloths() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cloths, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rv_cloths = view.findViewById(R.id.rv_men_laundry);
        btn_cloth_next = view.findViewById(R.id.cloths_next);
        tv_laundry_price = view.findViewById(R.id.tv_laundry_price);

        mAdapter = new LaundryAdapter();


        rv_cloths.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_cloths.setHasFixedSize(true);
        rv_cloths.setAdapter(mAdapter);
        mFragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mLaundryViewModel = new ViewModelProvider(getActivity()).get(LaundryViewModel.class);
        mLaundryViewModel.getLaundryListModelData().observe(getViewLifecycleOwner(), laundryModelList -> {
            mAdapter.setmList(laundryModelList);
            mAdapter.notifyDataSetChanged();
        });

    }

}
