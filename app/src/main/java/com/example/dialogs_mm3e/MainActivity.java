package com.example.dialogs_mm3e;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button but1 = findViewById(R.id.but1);
        Button but2 = findViewById(R.id.but2);
        Button but3 = findViewById(R.id.but3);
        Button but4 = findViewById(R.id.but4);
        Button but5 = findViewById(R.id.but5);

        but5.setOnClickListener(v->{
            showAlertDialog();
        });

        but4.setOnClickListener(v->{
            showListDialog();
        });

        but3.setOnClickListener(v->{
            showDatePickerDialog();
        });

        }

        private void showAlertDialog(){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Prosty AlertDialog");
            builder.setMessage("fuoibdgoeibgnpeirbprob");

            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialogInterface, int i){
                    Toast.makeText(MainActivity.this, "Kliknieto ok", Toast.LENGTH_SHORT).show();
                }
            });

            builder.setNegativeButton("Anuluj", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainActivity.this, "Kliknieto anuluj", Toast.LENGTH_SHORT).show();
                }
            });

            builder.create().show();
        }

        private void showListDialog(){
        final String[] items = {"Case 1", "Case 2", "Case 3"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose: ");

        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Wybrano: " + items[which], Toast.LENGTH_SHORT).show();
            }

        });

        builder.create().show();
        }

        private void showDatePickerDialog(){

            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int day){
                    Toast.makeText(MainActivity.this, "Wybrana data: " + day + "/" + (month+1) + "/" + year, Toast.LENGTH_SHORT).show();
                }
            }, year, month, day);

            datePickerDialog.show();

        }



}
