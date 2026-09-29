package com.example.smartpantrymanager.fragment;
import android.os.Bundle;
import android.view.*;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.*;
import com.example.smartpantrymanager.*;
import com.example.smartpantrymanager.adapter.RecipeAdapter;
import com.example.smartpantrymanager.model.Recipe;
import com.example.smartpantrymanager.utils.StrictMatcher;
public class SuggestedFragment extends Fragment{
    RecyclerView rv; RecipeAdapter ad; TextView empty;
    public View onCreateView(@NonNull LayoutInflater inf,ViewGroup c,Bundle b){
        View v=inf.inflate(R.layout.fragment_suggested,c,false);
        rv=v.findViewById(R.id.recyclerSuggested); empty=v.findViewById(R.id.txtEmptySuggest);
        ad=new RecipeAdapter(r->{ Bundle bun=new Bundle(); bun.putInt("recipeId",r.id); RecipeDetailFragment f=new RecipeDetailFragment(); f.setArguments(bun); ((MainActivity)getActivity()).openFragment(f);});
        rv.setLayoutManager(new LinearLayoutManager(getContext())); rv.setAdapter(ad);
        load();
        return v;
    }
    void load(){
        new Thread(()->{
            var pantry=SmartPantryApp.db.pantryDao().getAllSync();
            var all=SmartPantryApp.db.recipeDao().getAllRecipesSync();
            var suggested=StrictMatcher.getSuggested(pantry,all,SmartPantryApp.db.recipeDao());
            if(getActivity()!=null) getActivity().runOnUiThread(()->{
                ad.setList(suggested);
                if(suggested.isEmpty()){empty.setVisibility(View.VISIBLE); empty.setText("No recipes match your pantry yet - add more ingredients"); rv.setVisibility(View.GONE);}
                else{empty.setVisibility(View.GONE); rv.setVisibility(View.VISIBLE);}
            });
        }).start();
    }
}
