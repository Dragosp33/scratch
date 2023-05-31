package com.example.scratch;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AnuntDao {

    // LiveData is a data holder class that can be observed within a given lifecycle.
    // Always holds/caches latest version of data. Notifies its active observers when the
    // data has changed. Since we are getting all the contents of the database,
    // we are notified whenever any of the database contents have changed.
    @Query("SELECT * from anunt_table ORDER BY description ASC")
    LiveData<List<Anunt>> getAllAnunts();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Anunt anunt);

    @Query("DELETE FROM anunt_table")
    void deleteAll();


    @Delete
    void deleteAnunt(Anunt anunt);

    @Update
    void update(Anunt... anunt);

    @Query("SELECT * from anunt_table LIMIT 1")
    int[] getAnyAnunt();
}