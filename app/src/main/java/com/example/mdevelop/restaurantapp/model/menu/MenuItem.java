package com.example.mdevelop.restaurantapp.model.menu;

import android.content.Context;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mdevelop on 01.09.2017.
 */

public class MenuItem {
    private String name;
    private String description;
    private String category;
    private String image;
    private Double price;

    public MenuItem() {
    }

    public MenuItem(String name, String description, String category, String image, Double price) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.image = image;
        this.price = price;
    }

    private Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("description", description);
        result.put("category", category);
        result.put("image", image);
        result.put("price", price);
        return result;
    }

    public String write() {

        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        String key = database.child("menu").push().getKey();
        Map<String, Object> postValues = this.toMap();
        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/menu/" + key, postValues);
        database.updateChildren(childUpdates);
        return null;
    }

    public StorageReference getImageReferences(Context context){
        StorageReference firebaseReferences = FirebaseStorage.getInstance().getReference();
        return  firebaseReferences.child(image);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
