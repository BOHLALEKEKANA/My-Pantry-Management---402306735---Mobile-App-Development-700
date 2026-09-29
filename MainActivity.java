package com.example.smartpantrymanager;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.example.smartpantrymanager.fragment.*;
import com.google.android.material.bottomnavigation.BottomNavigationView;
public class MainActivity extends AppCompatActivity{
    protected void onCreate(Bundle b){
        super.onCreate(b); setContentView(R.layout.activity_main);
        BottomNavigationView nav=findViewById(R.id.bottom_nav);
        nav.setOnItemSelectedListener(item->{
            Fragment f=item.getItemId()==R.id.nav_pantry?new PantryFragment():item.getItemId()==R.id.nav_suggest?new SuggestedFragment():new SettingsFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container,f).commit(); return true;
        });
        nav.setSelectedItemId(R.id.nav_pantry);
    }
    public void openFragment(Fragment f){getSupportFragmentManager().beginTransaction().replace(R.id.container,f).addToBackStack(null).commit();}
}
