package com.example.mdevelop.restaurantapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.mdevelop.restaurantapp.fragments.MainFragment;
import com.example.mdevelop.restaurantapp.fragments.MeetingFragment;
import com.example.mdevelop.restaurantapp.fragments.MenuFragment;
import com.example.mdevelop.restaurantapp.fragments.ReservationFragment;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationViewEx navigation;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    replaceFragment(new MainFragment());
                    return true;
                case R.id.navigation_dashboard:
                    replaceFragment(new MenuFragment());

                    return true;
                case R.id.navigation_notifications:
                    replaceFragment(new MeetingFragment());
                    return true;
                case R.id.navigation_reservation:
                    replaceFragment(new ReservationFragment());
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigation = (BottomNavigationViewEx ) findViewById(R.id.navigation);
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) navigation.getChildAt(0);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.enableShiftingMode(false);
        navigation.enableItemShiftingMode(false);
        initfirstFragment();
    }

    private void initfirstFragment(){
        mOnNavigationItemSelectedListener.onNavigationItemSelected(navigation.getMenu().getItem(0));
    }
    private void replaceFragment(Fragment fragment){
        getFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
    }

    private void writeMenu(){
         for(int i = 1; i<15;i++){
             com.example.mdevelop.restaurantapp.model.menu.MenuItem item = new com.example.mdevelop.restaurantapp.model.menu.MenuItem("Блюдо "+i,
                     "Описани "+ i,
                     "eat",
                     "images/absento.jpg",i*100.0);
             item.write();
         }
    }

}
