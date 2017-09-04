package com.example.mdevelop.restaurantapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mdevelop.restaurantapp.R;

import java.util.List;

/**
 * Created by mdevelop on 25.08.2017.
 */

public class PartyAdapter extends RecyclerView.Adapter<PartyHolder> {
    List<String> partyList ;
    int viewId;

    public PartyAdapter(List<String> partyList,int viewId) {
        this.partyList = partyList;
        this.viewId = viewId;
    }

    @Override
    public PartyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewId,parent,false);
        return new PartyHolder(view);
    }

    @Override
    public void onBindViewHolder(PartyHolder holder, int position) {
        holder.partyName.setText(partyList.get(position));

    }

    @Override
    public int getItemCount() {
        return partyList.size();
    }
}
