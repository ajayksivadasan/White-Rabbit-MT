package com.aks.whiterabbitmt.utils.room;


import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Insert;

import com.aks.whiterabbitmt.data.local.EmployeeDetails;

import java.util.List;

@Dao
public interface RoomDbDao {
    @Insert(onConflict = REPLACE)
    void insertIntoEmployeeDetails(List<EmployeeDetails> remoteList);
}
