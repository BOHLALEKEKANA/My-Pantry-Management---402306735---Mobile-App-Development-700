package com.example.smartpantrymanager.adapter;
import android.view.*;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.smartpantrymanager.R;
import com.example.smartpantrymanager.model.Recipe;
import java.util.*;
public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.VH>{
    List<Recipe> list=new ArrayList<>(); OnClick l;
    public interface OnClick{void onClick(Recipe r);}
    public RecipeAdapter(OnClick c){l=c;}
    public void setList(List<Recipe> li){list=li;notifyDataSetChanged();}
    @NonNull public VH onCreateViewHolder(@NonNull ViewGroup p,int t){return new VH(LayoutInflater.from(p.getContext()).inflate(R.layout.item_recipe,p,false));}
    public void onBindViewHolder(@NonNull VH h,int pos){h.name.setText(list.get(pos).name); h.itemView.setOnClickListener(v->l.onClick(list.get(pos)));}
    public int getItemCount(){return list.size();}
    static class VH extends RecyclerView.ViewHolder{ TextView name; public VH(View v){super(v);name=v.findViewById(R.id.txtRecipeName);}}
}
