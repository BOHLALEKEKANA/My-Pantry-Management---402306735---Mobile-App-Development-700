package com.example.smartpantrymanager.db;
import androidx.lifecycle.LiveData;
import androidx.room.*;
import com.example.smartpantrymanager.model.PantryItem;
import java.util.List;
@Dao
public interface PantryDao {
    @Query("SELECT * FROM pantry_items ORDER BY name") LiveData<List<PantryItem>> getAll();
    @Query("SELECT * FROM pantry_items") List<PantryItem> getAllSync();
    @Insert void insert(PantryItem i); @Update void update(PantryItem i); @Delete void delete(PantryItem i);
    @Query("SELECT * FROM pantry_items WHERE id=:id") PantryItem getById(int id);
}
