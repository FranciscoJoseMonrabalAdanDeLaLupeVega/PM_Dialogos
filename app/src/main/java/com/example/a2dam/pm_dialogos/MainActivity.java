package com.example.a2dam.pm_dialogos;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,DateFragment.OnFragmentInteractionListener{

    private Button date, hour, color;
    private TextView tDate, tHour, tColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date = (Button) findViewById(R.id.btnDate);
        hour = (Button) findViewById(R.id.btnHour);
        color = (Button) findViewById(R.id.btnColor);
        tDate = (TextView) findViewById(R.id.txtDate);
        tHour = (TextView) findViewById(R.id.txtHour);
        tColor = (TextView) findViewById(R.id.txtColor);

        date.setOnClickListener(this);
        hour.setOnClickListener(this);
        color.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == date.getId()) {

            final Calendar c = Calendar.getInstance();
            int currentYear = c.get(Calendar.YEAR);
            int currentMonth = c.get(Calendar.MONTH);
            int currentDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            tDate.setText("Date: " + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                        }
                    }, currentYear, currentMonth, currentDay);
            datePickerDialog.show();
        } else {
            if (view.getId() == hour.getId()) {

                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);

                 TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {

                        tHour.setText( "Hour: " + selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);

                timePickerDialog.show();

            } else {
                if (view.getId() == color.getId()) {

                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    Fragment prev = getFragmentManager().findFragmentByTag("dialog");
                    if (prev != null) {
                        ft.remove(prev);
                    }
                    ft.addToBackStack(null);

                    // Create and show the dialog.
                    DateFragment fDate = DateFragment.newInstance(null, null);
                    fDate.show(ft, "dialog");
                }
            }
        }
    }

    @Override
    public void getSelectedColor(String color) {
        tColor.setText("Color: " + color);
    }
}
