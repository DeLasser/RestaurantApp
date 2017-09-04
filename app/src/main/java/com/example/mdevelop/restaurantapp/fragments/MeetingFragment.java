package com.example.mdevelop.restaurantapp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.mdevelop.restaurantapp.R;
import com.example.mdevelop.restaurantapp.adapter.PartyAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mdevelop on 25.08.2017.
 */

public class MeetingFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news,container,false);
        initNews(view);
        initPartyList(view );
        return view;
    }

    private void initPartyList(View view){
        RecyclerView partylist = (RecyclerView) view.findViewById(R.id.party_list);
        partylist.setVisibility(View.VISIBLE);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        layoutManager.setOrientation(LinearLayout.HORIZONTAL);
        partylist.setLayoutManager(layoutManager);
        List<String> list = new ArrayList<>();
        for(int i = 1;i<=15;i++){
            list.add("Party "+i);
        }
        partylist.setAdapter(new PartyAdapter(list,R.layout.item_party));
    }

    private void initNews(View view){
        ListView listView =(ListView) view.findViewById(R.id.list);
        List<String> list = new ArrayList<>();
        for(int i = 1;i<=500;i++){
            list.add("News "+i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(),R.layout.item_list,R.id.item_text,list);
        listView.setAdapter(adapter);

    }
}