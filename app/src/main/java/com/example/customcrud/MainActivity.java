package com.example.customcrud;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        DBHelper dbHelper = new DBHelper(MainActivity.this,"DBTMEP.db",null,1);


        spinner = findViewById(R.id.spinner);
        btn = findViewById(R.id.showRecords);


        String[] data = {"Student" , "Department" , "Courses"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this , android.R.layout.simple_spinner_item , data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        btn.setOnClickListener(v -> {
            if (spinner.getSelectedItem() != null) {
                Intent intent = new Intent(MainActivity.this, ShowData.class);

                Cursor cursor = dbHelper.ViewData(spinner.getSelectedItem().toString());

                StringBuilder stringBuilder = new StringBuilder();

                if (cursor != null && cursor.moveToFirst()) {
                    do {
                        for (int i = 0; i < cursor.getColumnCount(); i++) {
                            String columnName = cursor.getColumnName(i);
                            String columnValue = cursor.getString(i);

                            stringBuilder.append(columnName).append(": ").append(columnValue).append("\n");
                        }
                    } while (cursor.moveToNext());

                    cursor.close();
                }

                String temp = stringBuilder.toString();
                intent.putExtra("tabledata", temp);

                startActivity(intent);

            }
        });
    }
}