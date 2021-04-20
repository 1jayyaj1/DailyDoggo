package com.jayyaj.dailydoggo.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jayyaj.dailydoggo.R;
import com.jayyaj.dailydoggo.adapter.DogsListAdapter;
import com.jayyaj.dailydoggo.adapter.OnDogClickListener;
import com.jayyaj.dailydoggo.databinding.FragmentListBinding;
import com.jayyaj.dailydoggo.model.DogBreed;
import com.jayyaj.dailydoggo.viewmodel.DogsDetailViewModel;
import com.jayyaj.dailydoggo.viewmodel.DogsListViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment implements OnDogClickListener {
    private FragmentListBinding binding;
    private DogsListViewModel dogsListViewModel;
    private DogsListAdapter dogsListAdapter;
    private DogsDetailViewModel dogsDetailViewModel;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
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
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        binding = DataBindingUtil.setContentView(getActivity(), R.layout.fragment_list);
        dogsListAdapter = new DogsListAdapter(new ArrayList<>(), this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dogsListViewModel = ViewModelProviders.of(this).get(DogsListViewModel.class);
        dogsListViewModel.refresh();

        binding.dogsRecyclerView.setLayoutManager(new LinearLayoutManager((getContext())));
        binding.dogsRecyclerView.setAdapter(dogsListAdapter);

        dogsDetailViewModel = ViewModelProviders.of(getActivity()).get(DogsDetailViewModel.class);

        obeserveViewModel();
    }

    private void obeserveViewModel() {
        dogsListViewModel.getDogBreedList().observe(getActivity(), dogs -> {
            if (dogs != null) {
                binding.dogsRecyclerView.setVisibility(View.VISIBLE);
                dogsListAdapter.updateDogsList(dogs);
            }
        });

        dogsListViewModel.getDogLoadError().observe(getActivity(), loadError -> {
            if (loadError != null) {
                binding.recyclerErrorText.setVisibility(loadError ? View.VISIBLE : View.INVISIBLE);
            }
        });

        dogsListViewModel.getDogLoadError().observe(getActivity(), isLoading -> {
            if (isLoading != null) {
                binding.recyclerProgressBar.setVisibility(isLoading ? View.VISIBLE : View.INVISIBLE);
                if (isLoading) {
                    binding.recyclerErrorText.setVisibility(View.INVISIBLE);
                    binding.dogsRecyclerView.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    public void onToDetails() {
        NavDirections action = ListFragmentDirections.actionDetail(0);
        NavHostFragment.findNavController(this).navigate(action);
    }

    @Override
    public void onDogClicked(DogBreed dogBreed) {
        Log.d("dog", dogBreed.getDogBreed());
        dogsDetailViewModel.setSelectedDog(dogBreed);
        onToDetails();
    }
}