package com.example.a2dam.pm_dialogos;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

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

            FragmentTransaction ft = getFragmentManager().beginTransaction();
            Fragment prev = getFragmentManager().findFragmentByTag("dialog");
            if (prev != null) {
                ft.remove(prev);
            }
            ft.addToBackStack(null);

            // Create and show the dialog.
            DateFragment fDate = DateFragment.newInstance(null, null);
            fDate.show(ft);

        } else {
            if (view.getId() == hour.getId()) {

            } else {
                if (view.getId() == color.getId()) {

                }
            }
        }
    }


}
