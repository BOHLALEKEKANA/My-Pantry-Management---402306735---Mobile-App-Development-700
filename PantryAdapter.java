package com.example.smartpantrymanager.adapter;
import android.view.*;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.smartpantrymanager.R;
import com.example.smartpantrymanager.model.PantryItem;
import java.util.*;
public class PantryAdapter extends RecyclerView.Adapter<PantryAdapter.VH>{
    List<PantryItem> list=new ArrayList<>(); OnItemClickListener listener;
    public interface OnItemClickListener{void onClick(PantryItem i); void onDelete(PantryItem i);}
    public PantryAdapter(OnItemClickListener l){listener=l;}
    public void setList(List<PantryItem> l){list=l;notifyDataSetChanged();}
    @NonNull public VH onCreateViewHolder(@NonNull ViewGroup p,int t){return new VH(LayoutInflater.from(p.getContext()).inflate(R.layout.item_pantry,p,false));}
    public void onBindViewHolder(@NonNull VH h,int pos){ PantryItem i=list.get(pos); h.name.setText(i.name+" - "+i.quantity+" "+i.unit); h.expiry.setText("Exp: "+i.expiryDate); h.itemView.setOnClickListener(v->listener.onClick(i)); h.itemView.setOnLongClickListener(v->{listener.onDelete(i); return true;}); }
    public int getItemCount(){return list.size();}
    static class VH extends RecyclerView.ViewHolder{ TextView name,expiry; public VH(@NonNull View v){super(v);name=v.findViewById(R.id.txtName);expiry=v.findViewById(R.id.txtExpiry);}}
}
