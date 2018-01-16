package com.conscience.motivator;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class NewGoalActivity extends AppCompatActivity {

    int DIALOG_DATE = 1;

    private EditText editText;
    private DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_goal);

        editText = (EditText)findViewById(R.id.editText2);
        datePicker = (DatePicker)findViewById(R.id.datePicker);


        Calendar today = Calendar.getInstance();

        datePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
                today.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
                        Toast.makeText(getApplicationContext(),
                                "on date changed", Toast.LENGTH_SHORT).show();
                        editText.setText("YEAR: " + year + "\n" +
                                        "MONTH: " + month + "\n" +
                                            "DAY:" + day);
                    }
                });
        /*Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(new StringBuilder()
                        .append(datePicker.getDayOfMonth()).append(".")
                        .append(datePicker.getMonth() + 1).append(".")
                        .append(datePicker.getYear()));
            }
        });

        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                currentDate();
                return true;
            }
        });*/
    }

    public void currentDate(){
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        editText.setText(new StringBuilder()
                .append(day).append(".")
                .append(month + 1).append(".")
                .append(year));

        datePicker.init(year, month, day, null);
    }
}
