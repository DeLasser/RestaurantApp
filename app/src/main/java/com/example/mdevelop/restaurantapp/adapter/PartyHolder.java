package com.example.mdevelop.restaurantapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.mdevelop.restaurantapp.R;

/**
 * Created by mdevelop on 25.08.2017.
 */

public class PartyHolder extends RecyclerView.ViewHolder {
    public TextView partyName;
    public PartyHolder(View itemView) {
        super(itemView);
        partyName = (TextView) itemView.findViewById(R.id.party_name);
    }
}
