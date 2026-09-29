package com.example.smartpantrymanager.model;
import android.app.Application;
import androidx.room.Room;
import com.example.smartpantrymanager.db.AppDatabase;
public class SmartPantryApp extends Application {
    public static AppDatabase db;
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(this, AppDatabase.class, "pantry_db")
                .allowMainThreadQueries().fallbackToDestructiveMigration()
                .addCallback(AppDatabase.getCallback()).build();
    }
}
