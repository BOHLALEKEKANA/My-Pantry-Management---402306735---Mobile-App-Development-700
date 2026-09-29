package com.example.smartpantrymanager.db;
import androidx.lifecycle.LiveData;
import androidx.room.*;
import com.example.smartpantrymanager.model.Recipe;
import com.example.smartpantrymanager.model.RecipeIngredient;
import java.util.List;
@Dao
public interface RecipeDao {
    @Query("SELECT * FROM recipes") LiveData<List<Recipe>> getAllRecipes();
    @Query("SELECT * FROM recipes") List<Recipe> getAllRecipesSync();
    @Query("SELECT * FROM recipe_ingredients WHERE recipeId=:id") List<RecipeIngredient> getIngredientsForRecipe(int id);
    @Insert long insertRecipe(Recipe r); @Insert void insertIngredient(RecipeIngredient ri);
    @Query("SELECT * FROM recipes WHERE id=:id") Recipe getRecipeById(int id);
}
