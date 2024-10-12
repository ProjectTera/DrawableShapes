package com.example.sandbox3;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox;
    RadioGroup radioGroup;
    Spinner spinner;
    TimePicker timePicker;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox = findViewById(R.id.checkBox);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String s = "CheckBox is not Checked";

                if (isChecked) {
                    s = "CheckBox is Checked";
                }

                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
            }
        });

        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkedRDB = findViewById(checkedId);

                Toast.makeText(getApplicationContext()
                        , "You clicked " + checkedRDB.getText().toString()
                        , Toast.LENGTH_SHORT).show();
            }
        });

        spinner = findViewById(R.id.spinner);

        //Data Source
        String[] weapons = {"Sword", "Claymore", "Polearm", "Catalyst", "Bow"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getApplicationContext()
                ,   android.R.layout.simple_spinner_item
                ,   weapons
        );

        spinner.setAdapter(adapter);

        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        getApplicationContext()
                        , (String) spinner.getSelectedItem()
                        , Toast.LENGTH_SHORT
                ).show();
            }
        });

        timePicker = findViewById(R.id.timePicker);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                String message = hourOfDay + ":" + minute;

                Toast.makeText(
                        getApplicationContext()
                        , message
                        , Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}