package com.jayyaj.dailydoggo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.jayyaj.dailydoggo.model.DogBreed;

public class DogsDetailViewModel extends AndroidViewModel {
    private MutableLiveData<DogBreed> selectedDog;

    public DogsDetailViewModel(@NonNull Application application) {
        super(application);
        this.selectedDog = new MutableLiveData<>();
    }

    public void setSelectedDog(DogBreed dogBreed) {
        this.selectedDog.setValue(dogBreed);
    }

    public MutableLiveData<DogBreed> getSelectedDog() {
        return this.selectedDog;
    }
}
