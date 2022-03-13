package com.aks.whiterabbitmt.di;

import android.content.Context;

import com.aks.whiterabbitmt.utils.retrofit.RetroPublicInterface;
import com.aks.whiterabbitmt.utils.retrofit.RetrofitNetwork;
import com.aks.whiterabbitmt.utils.room.RoomDataBase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;

@Module
@InstallIn(SingletonComponent.class)
public class DiModule {
    @Provides
    @Singleton
    public Retrofit providesRetrofitInstance() {
        return RetrofitNetwork.getRetrofitInstance();
    }

    @Provides
    @Singleton
    public RoomDataBase provideDataBase(@ApplicationContext Context context) {
        return RoomDataBase.provideRoomDb(context);
    }

    @Provides
    @Singleton
    public RetroPublicInterface providesRetroPublicInterface(Retrofit retrofit) {
        return retrofit.create(RetroPublicInterface.class);
    }

}
