
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName="pantry_items")
public class PantryItem {
    @PrimaryKey(autoGenerate=true) public int id;
    public String name; public double quantity; public String unit; public String expiryDate;
    public PantryItem(String n,double q,String u,String e){name=n.toLowerCase().trim();quantity=q;unit=u.toLowerCase();expiryDate=e;}
}
