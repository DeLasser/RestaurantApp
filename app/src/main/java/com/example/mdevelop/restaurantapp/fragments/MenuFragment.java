package com.example.mdevelop.restaurantapp.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mdevelop.restaurantapp.R;
import com.example.mdevelop.restaurantapp.activity.MenuItemActivity;
import com.example.mdevelop.restaurantapp.adapter.PartyAdapter;
import com.example.mdevelop.restaurantapp.model.menu.MenuItem;
import com.example.mdevelop.restaurantapp.model.menu.MenuItemViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mdevelop on 24.08.2017.
 */

public class MenuFragment extends Fragment {
    FirebaseRecyclerAdapter<MenuItem,MenuItemViewHolder> adapter ;
    private DatabaseReference database;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu,container,false);
        initMenu(view);
        initFilter(view);
        return view;
    }

    private void initMenu(View view){;
        RecyclerView listView =(RecyclerView) view.findViewById(R.id.list);
        database = FirebaseDatabase.getInstance().getReference().child("menu");
        adapter = new FirebaseRecyclerAdapter<MenuItem, MenuItemViewHolder>(MenuItem.class,R.layout.item_menu,MenuItemViewHolder.class,database.orderByChild("aroma")) {
            @Override
            protected void populateViewHolder(MenuItemViewHolder viewHolder, MenuItem model, int position) {
                viewHolder.bindToPost(model,getActivity().getBaseContext());
//                viewHolder.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        startActivity(new Intent(getActivity(), MenuItemActivity.class));
//                    }
//                });
            }
        };
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        listView.setLayoutManager(layoutManager);
        listView.setAdapter(adapter);
    }

    private void initFilter(View view){
        RecyclerView recyclerView = view.findViewById(R.id.left_drawer);
        List<String> list = new ArrayList<>();
        for(int i = 1;i<=15;i++){
            list.add("Категория "+i);
        }
        PartyAdapter adapter = new PartyAdapter(list,R.layout.item_party);
        LinearLayoutManager layoutManager= new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
