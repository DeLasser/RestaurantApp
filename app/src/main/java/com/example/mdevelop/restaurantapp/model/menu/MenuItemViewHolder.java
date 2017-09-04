package com.example.mdevelop.restaurantapp.model.menu;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mdevelop.restaurantapp.R;
import com.firebase.ui.storage.images.FirebaseImageLoader;


/**
 * Created by mdevelop on 01.09.2017.
 */

public class MenuItemViewHolder extends RecyclerView.ViewHolder {
    private ImageView image;
    private TextView name;
    private TextView price;
    private CardView card;

    public MenuItemViewHolder(View itemView) {
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.menuItem_image);
        name = (TextView) itemView.findViewById(R.id.menuItem_name);
        price = (TextView) itemView.findViewById(R.id.menuItem_price);
        card = (CardView) itemView.findViewById(R.id.card);
    }

    public void bindToPost(MenuItem menuItem, Context context) {
        name.setText(menuItem.getName());
        price.setText("Цена: "+menuItem.getPrice()+" Руб.");
        Glide.with(context)
                .using(new FirebaseImageLoader())
                .load(menuItem.getImageReferences(context))
                .into(image);
    }

    public void setOnClickListener(View.OnClickListener listener){
        card.setOnClickListener(listener);
    }
}
