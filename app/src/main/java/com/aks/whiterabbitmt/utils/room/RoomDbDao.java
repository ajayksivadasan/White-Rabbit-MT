package com.aks.whiterabbitmt.utils.room;

import android.arch.persistence.room.Insert;

import com.aks.whiterabbitmt.data.remote.EmployeeDetailsRemote;

import java.util.List;

public interface RoomDbDao {
    @Insert
    long insertIntoEmployeeDetails(List<EmployeeDetailsRemote> remoteList);
}
