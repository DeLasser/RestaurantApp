package com.example.mdevelop.restaurantapp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mdevelop.restaurantapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mdevelop on 24.08.2017.
 */

public class NewsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news,container,false);
        initNews(view);
        return view;
    }

    private void initNews(View view){
        ListView listView =(ListView) view.findViewById(R.id.list);
        List<String> list = new ArrayList<>();
        for(int i = 1;i<=15;i++){
            list.add("Новость "+i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(),R.layout.item_list,R.id.item_text,list);
        listView.setAdapter(adapter);

    }
}
