package com.aks.whiterabbitmt.utils.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.aks.whiterabbitmt.data.local.EmployeeDetails;

@Database(entities = {EmployeeDetails.class}, version = 1, exportSchema = false)
public abstract class RoomDataBase extends RoomDatabase {
    public static RoomDataBase provideRoomDb(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(), RoomDataBase.class, "users_database")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

    public abstract RoomDbDao getRoomDbDao();
}
