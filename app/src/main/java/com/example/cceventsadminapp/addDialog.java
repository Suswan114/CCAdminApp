package com.example.cceventsadminapp;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorLong;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.cceventsadminapp.fragments.HomeFragment;

import java.time.Year;
import java.util.Calendar;
import org.jetbrains.annotations.NotNull;

public class addDialog extends AppCompatDialogFragment implements DatePickerDialog.OnDateSetListener {
    public EditText editTextEventName;
    public EditText editTextEventLocation;
    public EditText editTextEventDate;
    public ImageView calenderButton;

    @NonNull
    @NotNull
    @Override
    public Dialog onCreateDialog(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view =inflater.inflate(R.layout.add_dialog,null);
        builder.setView(view)
                .setNegativeButton("cancel", (dialog, which) -> {
                })
                .setPositiveButton("add", (dialog, which) -> {

                });
        editTextEventName=view.findViewById(R.id.eventName);
        editTextEventLocation=view.findViewById(R.id.eventLocation);
        editTextEventDate=view.findViewById(R.id.eventDate);
        calenderButton=view.findViewById(R.id.calenderImage);
        calenderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
        return builder.create();
    }
    private void showDatePickerDialog(){
        DatePickerDialog datePickerDialog=new DatePickerDialog(
                getActivity(),
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date= dayOfMonth+"/"+month+"/"+year;
        editTextEventDate.setText(date);
    }
}
