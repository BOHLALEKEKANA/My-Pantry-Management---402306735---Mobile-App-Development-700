package com.example.smartpantrymanager.fragment;
import android.os.Bundle;
import android.view.*;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.smartpantrymanager.*;
import com.example.smartpantrymanager.adapter.PantryAdapter;
import com.example.smartpantrymanager.model.PantryItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
public class PantryFragment extends Fragment implements PantryAdapter.OnItemClickListener{
    RecyclerView rv; PantryAdapter ad; TextView empty;
    public View onCreateView(@NonNull LayoutInflater i,ViewGroup c,Bundle b){
        View v=i.inflate(R.layout.fragment_pantry,c,false);
        rv=v.findViewById(R.id.recyclerPantry); empty=v.findViewById(R.id.txtEmptyPantry);
        ad=new PantryAdapter(this); rv.setLayoutManager(new LinearLayoutManager(getContext())); rv.setAdapter(ad);
        SmartPantryApp.db.pantryDao().getAll().observe(getViewLifecycleOwner(), list->{ad.setList(list); empty.setVisibility(list.isEmpty()?View.VISIBLE:View.GONE);});
        FloatingActionButton fab=v.findViewById(R.id.fabAdd); fab.setOnClickListener(view->((MainActivity)getActivity()).openFragment(new AddEditFragment()));
        return v;
    }
    public void onClick(PantryItem item){ Bundle bun=new Bundle(); bun.putInt("id",item.id); AddEditFragment f=new AddEditFragment(); f.setArguments(bun); ((MainActivity)getActivity()).openFragment(f);}
    public void onDelete(PantryItem item){ SmartPantryApp.db.pantryDao().delete(item); }
}
