package com.example.ibservices.Ui;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ibservices.Adapters.ServicesRecyclerAdapter;
import com.example.ibservices.Data.ServicesListModel;
import com.example.ibservices.R;
import com.example.ibservices.Ui.FragmentCarWash;
import com.example.ibservices.Ui.FragmentCleaningInfo;
import com.example.ibservices.Ui.FragmentLaundry;
import com.example.ibservices.ViewModels.ServicesViewModel;

import java.util.Objects;

import static com.example.ibservices.Utils.Constants.SERVICE_TYPE;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHome extends Fragment implements ServicesRecyclerAdapter.servicesListItemClicked {

    RecyclerView listview;


    private ServicesViewModel mServicesViewModel;
    private ServicesRecyclerAdapter mAdapter;

    private Animation fadeInAnim;
    private Animation fadeOutAnim;
    private FragmentTransaction mFragmentTransaction;


    public FragmentHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listview = view.findViewById(R.id.listItems);
        mAdapter = new ServicesRecyclerAdapter(this);

        listview.setLayoutManager(new GridLayoutManager(getContext(), 2));
        listview.setHasFixedSize(true);
        listview.setAdapter(mAdapter);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mFragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();

        mServicesViewModel = new ViewModelProvider(requireActivity()).get(ServicesViewModel.class);
        mServicesViewModel.getServicesListModelData().observe(getViewLifecycleOwner(), servicesListModelList -> {
            mAdapter.setServicesListModels(servicesListModelList);

            mAdapter.notifyDataSetChanged();
        });
    }


    @Override
    public void itemClicked(ServicesListModel model, int position) {
        Fragment fragment;
        if (position == 0){
            fragment = new FragmentCleaningInfo();
        }else if (position == 1){
            fragment = new FragmentLaundry();
        }else if (position == 7){
            fragment = new FragmentCarWash();
        }else{
            fragment = new FragmentCleaningInfo();
        }

        Bundle bundle = new Bundle();
        bundle.putString(SERVICE_TYPE, model.getName());
        fragment.setArguments(bundle);
        mFragmentTransaction.replace(R.id.fragmentContainer, fragment,getTag()).commit();
    }
}

