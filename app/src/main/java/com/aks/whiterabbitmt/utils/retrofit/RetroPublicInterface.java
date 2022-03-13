package com.aks.whiterabbitmt.utils.retrofit;

import com.aks.whiterabbitmt.data.remote.EmployeeDetailsRemote;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RetroPublicInterface {
    @GET("v2/5d565297300000680030a986")
    Observable<List<EmployeeDetailsRemote>> getDataFromWeb();
}
