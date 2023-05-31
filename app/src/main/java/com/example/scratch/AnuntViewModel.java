package com.example.scratch;

import android.app.Application;


import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * The AnuntViewModel provides the interface between the UI and the data layer of the app,
 * represented by the Repository
 */

public class AnuntViewModel extends AndroidViewModel {

    private AnuntRepository mRepository;

    private LiveData<List<Anunt>> mAllAnunts;

    public AnuntViewModel(Application application) {
        super(application);
        mRepository = new AnuntRepository(application);
        mAllAnunts = mRepository.getAllAnunts();
    }

    LiveData<List<Anunt>> getAllAnunts() {
        return mAllAnunts;
    }

    public void insert(Anunt Anunt) {
        mRepository.insert(Anunt);
    }

    public void deleteAll() {
        mRepository.deleteAll();
    }

    public void deleteAnunt(Anunt Anunt) {
        mRepository.deleteAnunt(Anunt);
    }

    public void update(Anunt Anunt) {
        mRepository.update(Anunt);
    }
}