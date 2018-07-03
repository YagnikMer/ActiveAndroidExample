package com.worldmer.activeandroidexample.activity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.worldmer.activeandroidexample.R;

public class MainActivity extends AppCompatActivity {
    Button btninsert, btndisplay, btnsearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
        listeners();
    }
    private void bindView() {
        btninsert = (Button) findViewById(R.id.btninsert);
        btndisplay = (Button) findViewById(R.id.btndisplay);
        btnsearch = (Button) findViewById(R.id.btnsearch);
    }
    private void listeners() {
        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent insertIntent = new Intent(MainActivity.this, InsertActivity.class);
                startActivity(insertIntent);
            }
        });
        btndisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent displayIntent = new Intent(MainActivity.this, DisplayActivity.class);
                startActivity(displayIntent);
            }
        });
        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchIntent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(searchIntent);
            }
        });
    }
}
