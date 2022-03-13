package com.aks.whiterabbitmt.ui.main.view_model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.aks.whiterabbitmt.data.remote.EmployeeDetailsRemote;
import com.aks.whiterabbitmt.ui.main.repository.MainRepository;
import com.aks.whiterabbitmt.utils.retrofit.RetroPublicInterface;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.disposables.CompositeDisposable;

@HiltViewModel
public class MainViewModel extends ViewModel {
    private final MutableLiveData<List<EmployeeDetailsRemote>> listMutableLiveData;
    CompositeDisposable disposable;
    @Inject
    RetroPublicInterface publicInterface;

    @Inject
    public MainViewModel() {
        disposable = new CompositeDisposable();
        listMutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<EmployeeDetailsRemote>> getListMutableLiveData() {
        return listMutableLiveData;
    }

    public void makeApiCall() {
        MainRepository mainRepository = new MainRepository(publicInterface);
        mainRepository.makeApiCall(listMutableLiveData, disposable);
    }
}
