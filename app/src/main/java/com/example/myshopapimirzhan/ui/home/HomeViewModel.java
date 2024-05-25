package com.example.myshopapimirzhan.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.myshopapimirzhan.models.ModelM;
import com.example.myshopapimirzhan.repositories.JemRepository;

import java.util.List;

public class HomeViewModel extends ViewModel {
    private JemRepository jemRepository;
    private LiveData<List<ModelM>> modelMResponseLiveData;

    public HomeViewModel() {
        JemRepository jemRepository = new JemRepository();
        modelMResponseLiveData= jemRepository.getDashJeminyList();
    }

    public LiveData<List<ModelM>> getModelMResponseLiveData() {
        return modelMResponseLiveData;
    }

}