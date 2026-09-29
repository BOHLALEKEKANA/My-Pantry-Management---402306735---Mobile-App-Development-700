package com.example.smartpantrymanager.utils;
import com.example.smartpantrymanager.db.RecipeDao;
import com.example.smartpantrymanager.model.PantryItem;
import com.example.smartpantrymanager.model.Recipe;
import com.example.smartpantrymanager.model.RecipeIngredient;
import java.util.ArrayList;
import java.util.List;
public class StrictMatcher {
    public static String normalize(String s){
        s=s.toLowerCase().trim();
        if(s.endsWith("ies") && s.length()>3) return s.substring(0,s.length()-3)+"y";
        if(s.endsWith("oes")||s.endsWith("ses")||s.endsWith("ches")||s.endsWith("shes")) return s.substring(0,s.length()-2);
        if(s.endsWith("s") && s.length()>3) return s.substring(0,s.length()-1);
        return s;
    }
    public static List<Recipe> getSuggested(List<PantryItem> pantry, List<Recipe> all, RecipeDao dao){
        List<Recipe> res=new ArrayList<>();
        for(Recipe r:all){
            List<RecipeIngredient> reqs=dao.getIngredientsForRecipe(r.id);
            boolean canMake=true;
            for(RecipeIngredient req:reqs){
                boolean found=false;
                for(PantryItem p:pantry){ if(normalize(p.name).equals(normalize(req.ingredientName)) && p.quantity>=req.quantity){found=true;break;}}
                if(!found){canMake=false;break;}
            }
            if(canMake) res.add(r);
        }
        return res;
    }
}
