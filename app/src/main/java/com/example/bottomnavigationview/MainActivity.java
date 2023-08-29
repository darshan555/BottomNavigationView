package com.example.bottomnavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnv = findViewById(R.id.bnv);

        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if(id==R.id.nav_home){
                    changeView(new FragmentHome(),false);
                }else if(id==R.id.nav_search){
                    changeView(new FragmentSearch(),false);
                }else if(id==R.id.nav_add){
                    changeView(new Fragment_Add(),false);
                }else if(id==R.id.nav_contactus){
                    changeView(new FragmentContactus(),false);
                }else{
                    changeView(new FragmentProfile(),true);
                }
                return true;
            }
        });
        bnv.setSelectedItemId(R.id.nav_profil);
    }
    public void changeView(Fragment fragment,boolean flag){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if(flag){
            ft.add(R.id.container,fragment);
        }else {
            ft.replace(R.id.container,fragment);
        }

        ft.commit();
    }
}