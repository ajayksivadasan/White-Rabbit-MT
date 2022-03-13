package com.aks.whiterabbitmt.utils.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.aks.whiterabbitmt.data.room.EmployeeDetails;

@Database(entities = {EmployeeDetails.class}, version = 1, exportSchema = false)

public abstract class RoomDataBase extends RoomDatabase {
    public static RoomDataBase provideRoomDb(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(), RoomDataBase.class, "users_database")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }
}
