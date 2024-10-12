package com.example.sandbox4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;
    Button bnt, bnt2;
    ProgressBar progressBar;
    int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = findViewById(R.id.datePicker);
        bnt = findViewById(R.id.bnt);

        bnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String day = "Day|" + datePicker.getDayOfMonth();
                String month = "Month|" + (datePicker.getMonth() + 1);
                String year = "Year|" + datePicker.getYear();
                String s = day + " " + month + " " + year;

                Toast.makeText(
                        getApplicationContext()
                        , s
                        , Toast.LENGTH_SHORT
                ).show();
            }
        });

        progressBar = findViewById(R.id.progressBar);
        bnt2 = findViewById(R.id.bnt2);

        bnt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress += 5;

                progressBar.setProgress(progress);
            }
        });

    }
}