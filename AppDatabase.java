package com.example.smartpantrymanager.db;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.example.smartpantrymanager.model.PantryItem;
import com.example.smartpantrymanager.model.Recipe;
import com.example.smartpantrymanager.model.RecipeIngredient;
import com.example.smartpantrymanager.utils.RecipeSeeder;
@Database(entities={PantryItem.class, Recipe.class, RecipeIngredient.class}, version=1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PantryDao pantryDao(); public abstract RecipeDao recipeDao();
    public static Callback getCallback(){
        return new Callback(){
            public void onCreate(@NonNull SupportSQLiteDatabase db){
                super.onCreate(db);
                new Thread(() -> { try { Thread.sleep(1500); RecipeSeeder.seed(com.example.smartpantrymanager.SmartPantryApp.db); } catch (Exception e){} }).start();
            }
        };
    }
}
