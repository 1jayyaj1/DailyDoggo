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
        DogBreed dog4 = new DogBreed("4",
                "Corgi",
                "15 years",
                "",
                "",
                "",
                "");
        DogBreed dog5 = new DogBreed("5",
                "Shitzhu",
                "11 years",
                "",
                "",
                "",
                "");
        DogBreed dog6 = new DogBreed("6",
                "Golden",
                "69 years",
                "",
                "",
                "",
                "");
        DogBreed dog7 = new DogBreed("7",
                "Corgi",
                "15 years",
                "",
                "",
                "",
                "");
        DogBreed dog8 = new DogBreed("8",
                "Shitzhu",
                "11 years",
                "",
                "",
                "",
                "");
        DogBreed dog9 = new DogBreed("9",
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
        dogs.add(dog4);
        dogs.add(dog5);
        dogs.add(dog6);
        dogs.add(dog7);
        dogs.add(dog8);
        dogs.add(dog9);

        dogBreedList.setValue(dogs);
        dogLoadError.setValue(false);
        loading.setValue(false);
    }

    public MutableLiveData<List<DogBreed>> getDogBreedList() {
        return dogBreedList;
    }

    public void setDogBreedList(MutableLiveData<List<DogBreed>> dogBreedList) {
        this.dogBreedList = dogBreedList;
    }

    public MutableLiveData<Boolean> getDogLoadError() {
        return dogLoadError;
    }

    public void setDogLoadError(MutableLiveData<Boolean> dogLoadError) {
        this.dogLoadError = dogLoadError;
    }

    public MutableLiveData<Boolean> getLoading() {
        return loading;
    }

    public void setLoading(MutableLiveData<Boolean> loading) {
        this.loading = loading;
    }
}
