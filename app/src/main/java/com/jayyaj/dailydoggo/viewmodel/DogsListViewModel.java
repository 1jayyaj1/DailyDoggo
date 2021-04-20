package com.jayyaj.dailydoggo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.jayyaj.dailydoggo.model.DogBreed;

import java.util.ArrayList;
import java.util.List;

public class DogsListViewModel extends AndroidViewModel {
    private MutableLiveData<List<DogBreed>> dogBreedList;
    private MutableLiveData<Boolean> dogLoadError;
    private MutableLiveData<Boolean> loading;

    public DogsListViewModel(@NonNull Application application) {
        super(application);
        this.dogBreedList = new MutableLiveData<>();
        this.dogLoadError = new MutableLiveData<>();
        this.loading = new MutableLiveData<>();
    }

    public void refresh() {
        DogBreed dog1 = new DogBreed("1",
                "Corgi",
                "15 years",
                "",
                "",
                "",
                "");
        DogBreed dog2 = new DogBreed("2",
                "Shitzhu",
                "11 years",
                "",
                "",
                "",
                "");
        DogBreed dog3 = new DogBreed("3",
                "Golden",
                "69 years",
                "",
                "",
                "",
                "");
        List<DogBreed> dogs = new ArrayList<>();
        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog3);

        dogBreedList.setValue(dogs);
        dogLoadError.setValue(false);
        loading.setValue(false);
    }
}
