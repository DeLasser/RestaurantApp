package com.example.mdevelop.restaurantapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by mdevelop on 25.08.2017.
 */

public class ReservationDialog extends DialogFragment{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view =  getActivity().getLayoutInflater().inflate(R.layout.dialog_reservation,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Бронирование").setPositiveButton("Забронировать", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),"Место забронировано", Toast.LENGTH_SHORT).show();
            }
        }).setView(view);
        return builder.create();
    }
}
