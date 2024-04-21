package com.example.customcrud;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ShowData extends AppCompatActivity {

    TextView Vdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_show_data);

        Vdata = findViewById(R.id.textView2);

        // Retrieve the data from the intent

        Intent intent = getIntent();
        String tabledata = intent.getStringExtra("tabledata");
        Vdata.setText(tabledata);

    }
}