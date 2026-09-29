package com.example.smartpantrymanager.utils;
import com.example.smartpantrymanager.db.AppDatabase;
import com.example.smartpantrymanager.model.Recipe;
import com.example.smartpantrymanager.model.RecipeIngredient;
public class RecipeSeeder {
    public static void seed(AppDatabase db){
        if(!db.recipeDao().getAllRecipesSync().isEmpty()) return;
        add(db,"Tomato Pasta","1. Boil pasta\n2. Fry tomato + garlic\n3. Mix with oil","pasta:200:g,tomato:2:unit,garlic:2:unit,oil:1:tbsp");
        add(db,"Scrambled Eggs","1. Beat 3 eggs\n2. Fry in pan\n3. Add salt","egg:3:unit,milk:50:ml,salt:1:tsp,butter:10:g");
        add(db,"Chicken Fried Rice","1. Cook rice\n2. Fry chicken\n3. Mix with egg + soy","rice:200:g,chicken:200:g,egg:2:unit,oil:1:tbsp,soy sauce:2:tbsp");
        add(db,"Veggie Stir Fry","1. Chop veggies\n2. Stir fry with oil","bell pepper:1:unit,rice:100:g,oil:1:tbsp,soy sauce:1:tbsp");
        add(db,"Bread Toast","1. Toast bread\n2. Butter it","bread:2:slice,butter:10:g");
        add(db,"Milk Tea","1. Boil water\n2. Add tea + milk + sugar","milk:200:ml,sugar:2:tsp,tea:1:unit");
        add(db,"Tomato Omelette","1. Chop tomato\n2. Beat eggs with tomato\n3. Fry","egg:2:unit,tomato:1:unit,salt:1:tsp,oil:1:tbsp");
        add(db,"Garlic Rice","1. Cook rice\n2. Fry garlic + mix","rice:200:g,garlic:3:unit,oil:1:tbsp");
        add(db,"Egg Sandwich","1. Boil egg\n2. Put in bread","bread:2:slice,egg:2:unit,butter:5:g");
        add(db,"Butter Pasta","1. Boil pasta\n2. Add butter + salt","pasta:200:g,butter:20:g,salt:1:tsp");
        add(db,"Rice and Beans","1. Cook rice + beans\n2. Mix","rice:200:g,beans:100:g,salt:1:tsp");
        add(db,"Tomato Soup","1. Boil tomato\n2. Blend + salt","tomato:4:unit,salt:1:tsp,water:500:ml");
        add(db,"Fried Eggs","1. Heat oil\n2. Fry eggs","egg:2:unit,oil:1:tbsp,salt:1:tsp");
        add(db,"Milk Porridge","1. Boil milk\n2. Add oats","milk:300:ml,oats:50:g,sugar:1:tsp");
        add(db,"Chicken Soup","1. Boil chicken + veggies","chicken:200:g,water:500:ml,salt:1:tsp,tomato:1:unit");
        add(db,"Garlic Bread","1. Butter bread\n2. Add garlic\n3. Toast","bread:2:slice,garlic:2:unit,butter:15:g");
        add(db,"Sweet Tea","1. Boil tea + sugar","water:300:ml,sugar:2:tsp,tea:1:unit");
        add(db,"Boiled Rice","1. Wash rice\n2. Boil with water + salt","rice:200:g,water:400:ml,salt:1:tsp");
        add(db,"Omelette Rice","1. Make omelette\n2. Serve with rice","rice:150:g,egg:2:unit,oil:1:tbsp");
        add(db,"Tomato Rice","1. Cook rice with tomato sauce","rice:200:g,tomato:2:unit,oil:1:tbsp,salt:1:tsp");
    }
    private static void add(AppDatabase db,String name,String steps,String ing){
        long id=db.recipeDao().insertRecipe(new Recipe(name,steps));
        for(String s:ing.split(",")){ String[] p=s.split(":"); db.recipeDao().insertIngredient(new RecipeIngredient((int)id,p[0],Double.parseDouble(p[1]),p[2])); }
    }
}
