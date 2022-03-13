package com.aks.whiterabbitmt.ui.main.repository;

import androidx.lifecycle.MutableLiveData;

import com.aks.whiterabbitmt.data.remote.EmployeeDetailsRemote;
import com.aks.whiterabbitmt.utils.retrofit.RetroPublicInterface;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainRepository {
    RetroPublicInterface publicInterface;
    MutableLiveData<List<EmployeeDetailsRemote>> listMutableLiveData;

    public MainRepository(RetroPublicInterface publicInterface) {
        this.publicInterface = publicInterface;
    }

    public void makeApiCall(MutableLiveData<List<EmployeeDetailsRemote>> listMutableLiveData, CompositeDisposable disposable) {
        Observable<List<EmployeeDetailsRemote>> listObservable = publicInterface.getDataFromWeb();
        listObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<EmployeeDetailsRemote>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onNext(List<EmployeeDetailsRemote> remoteList) {
                        listMutableLiveData.postValue(remoteList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        //nothing to do here now
                    }
                });

    }
}
