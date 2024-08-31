package com.example.jet_compose_live_data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

public class ListManager {
    private static ListManager instance;
    private final MutableLiveData<ArrayList<String>> listLiveData;

    private ListManager() {
        listLiveData = new MutableLiveData<>(new ArrayList<>());
    }

    public static synchronized ListManager getInstance() {
        if (instance == null) {
            instance = new ListManager();
        }
        return instance;
    }

    public LiveData<ArrayList<String>> getListLiveData() {
        return listLiveData;
    }

    public void addItem(String item) {
        ArrayList<String> currentList = listLiveData.getValue();
        if (currentList != null) {
            currentList.add(item);
            listLiveData.setValue(currentList);
        }
    }

    public void removeItem(String item) {
        ArrayList<String> currentList = listLiveData.getValue();
        if (currentList != null) {
            currentList.remove(item);
            listLiveData.setValue(currentList);
        }
    }
}
