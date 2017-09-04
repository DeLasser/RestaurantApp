package com.example.mdevelop.restaurantapp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.mdevelop.restaurantapp.R;
import com.example.mdevelop.restaurantapp.adapter.ImageAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mdevelop on 25.08.2017.
 */

public class GalleryActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        GridView gridView = (GridView) findViewById(R.id.grid_view);
        final List<Integer> images = new ArrayList<>();
        for(int i =1;i<50;i++){
            images.add(R.drawable.image2);
            images.add(R.drawable.image3);
        }

        gridView.setAdapter(new ImageAdapter(this,images));
    }
}
