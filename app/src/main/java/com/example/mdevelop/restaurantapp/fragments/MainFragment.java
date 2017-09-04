package com.example.mdevelop.restaurantapp.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.mdevelop.restaurantapp.activity.GalleryActivity;
import com.example.mdevelop.restaurantapp.activity.HallActivity;
import com.example.mdevelop.restaurantapp.activity.NewsActivity;
import com.example.mdevelop.restaurantapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mdevelop on 24.08.2017.
 */

public class MainFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_main,container,false);
        final List<Integer> images = new ArrayList<>();
        images.add(R.drawable.absento);
        PagerAdapter adapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return images.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == ((LinearLayout) object);
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = LayoutInflater.from(getActivity().getBaseContext()).inflate(R.layout.pager_image_item,container,false);
                ImageView image = (ImageView) view.findViewById(R.id.pager_image);
                image.setImageResource(images.get(position));
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View)object);
            }
        };
        ViewPager pager = (ViewPager) view.findViewById(R.id.viewPager);
        pager.setAdapter(adapter);

        initContacts(view);
        //initQR(view);
        initHallPlan(view);
        initGalary(view);
        initShares(view);
        return view;
    }

//    private void initQR(View view){
//        ImageButton button = (ImageButton) view.findViewById(R.id.qr_button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity().getBaseContext(), "QR", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

    private void initContacts(View view){
        final Button button = (Button) view.findViewById(R.id.contacts_button);
        Button hideContacts = (Button) view.findViewById(R.id.hide_contacts);
        final RelativeLayout buttonLqyout = (RelativeLayout) view.findViewById(R.id.buttons_layout);
        final ScrollView contactsLayout = (ScrollView) view.findViewById(R.id.contacts_layout);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonLqyout.setVisibility(View.GONE);
                contactsLayout.setVisibility(View.VISIBLE);
            }
        });
        hideContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonLqyout.setVisibility(View.VISIBLE);
                contactsLayout.setVisibility(View.GONE);
            }
        });
    }

    private void initHallPlan(View view){
        Button button = (Button) view.findViewById(R.id.hall_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(),HallActivity.class));
            }
        });
    }

    private void initGalary(View view){
        Button button =(Button) view.findViewById(R.id.reservation_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),GalleryActivity.class));
            }
        });
    }

    private void initShares(View view){
        Button button =(Button) view.findViewById(R.id.shares_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),NewsActivity.class));
            }
        });
    }


}
