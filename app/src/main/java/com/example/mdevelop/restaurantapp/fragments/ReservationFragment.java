package com.example.mdevelop.restaurantapp.fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.mdevelop.restaurantapp.R;

import java.util.Calendar;

/**
 * Created by mdevelop on 01.09.2017.
 */

public class ReservationFragment extends Fragment implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    private NumberPicker numberPicker;
    private Button reservationButton;
    private String date;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reservation, container, false);
        final Calendar c = Calendar.getInstance();
        final int year = c.get(Calendar.YEAR);
        final int month = c.get(Calendar.MONTH);
        final int day = c.get(Calendar.DAY_OF_MONTH);
        numberPicker = (NumberPicker) view.findViewById(R.id.numberPicker);
        numberPicker.setMaxValue(15);
        reservationButton = (Button) view.findViewById(R.id.reservation_button);
        reservationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dialog picker = new DatePickerDialog(getActivity(), ReservationFragment.this,
                        year, month, day);
                picker.show();
            }
        });
        return view;
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        TimePickerDialog tpd = new TimePickerDialog(getActivity(), ReservationFragment.this, 0, 0, true);
        tpd.show();
        date = i + "/" + i1 + "/" + i2;
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        date +=" в "+i+":"+i1;
        Toast.makeText(getActivity(),"Забронировано на "+date+" место: "+numberPicker.getValue(),Toast.LENGTH_LONG).show();
    }
}
