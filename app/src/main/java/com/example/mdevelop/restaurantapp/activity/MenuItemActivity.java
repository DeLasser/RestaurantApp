package com.example.mdevelop.restaurantapp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.example.mdevelop.restaurantapp.R;

/**
 * Created by mdevelop on 01.09.2017.
 */

public class MenuItemActivity extends Activity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_menu_item);
    }
}
