package com.example.smartpantrymanager.fragment;
import android.os.Bundle;
import android.view.*;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.smartpantrymanager.R;
import com.example.smartpantrymanager.SmartPantryApp;
import com.example.smartpantrymanager.model.RecipeIngredient;
import java.util.List;
public class RecipeDetailFragment extends Fragment{
    public View onCreateView(@NonNull LayoutInflater i,ViewGroup c,Bundle b){
        View v=i.inflate(R.layout.fragment_recipe_detail,c,false);
        int id=getArguments().getInt("recipeId");
        TextView name=v.findViewById(R.id.txtDetailName), ing=v.findViewById(R.id.txtDetailIng), steps=v.findViewById(R.id.txtDetailSteps);
        new Thread(()->{
            var recipe=SmartPantryApp.db.recipeDao().getRecipeById(id);
            List<RecipeIngredient> list=SmartPantryApp.db.recipeDao().getIngredientsForRecipe(id);
            if(getActivity()!=null) getActivity().runOnUiThread(()->{
                name.setText(recipe.name); StringBuilder sb=new StringBuilder(); for(RecipeIngredient ri:list) sb.append("• ").append(ri.ingredientName).append(" - ").append(ri.quantity).append(" ").append(ri.unit).append("\n"); ing.setText(sb.toString()); steps.setText(recipe.steps);
            });
        }).start();
        return v;
    }
}
