package com.example.myapplication.ui.a_propos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProposViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ProposViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Hugo Clergue");

    }

    public LiveData<String> getText() {
        return mText;
    }
}