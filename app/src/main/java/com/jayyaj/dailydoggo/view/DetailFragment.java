package com.jayyaj.dailydoggo.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jayyaj.dailydoggo.R;
import com.jayyaj.dailydoggo.databinding.FragmentDetailBinding;
import com.jayyaj.dailydoggo.databinding.FragmentListBinding;
import com.jayyaj.dailydoggo.model.DogBreed;
import com.jayyaj.dailydoggo.viewmodel.DogsDetailViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {
    private FragmentDetailBinding binding;
    private int dogUuid;
    private DogsDetailViewModel dogsDetailViewModel;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        binding = DataBindingUtil.setContentView(getActivity(), R.layout.fragment_detail);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dogsDetailViewModel = ViewModelProviders.of(getActivity()).get(DogsDetailViewModel.class);

        dogsDetailViewModel.getSelectedDog().observe(getActivity(), dog -> {
            if (dog.getDogBreed() != null) {
                binding.dogName.setText(dog.getDogBreed());
            }
            if (dog.getBredFor() != null) {
                binding.dogPurpose.setText(dog.getBredFor());
            }
            if (dog.getTemperament() != null) {
                binding.dogTemperament.setText(dog.getTemperament());
            }
            if (dog.getLifeSpan() != null) {
                binding.dogLifespan.setText(dog.getLifeSpan());
            }
        });
    }
}