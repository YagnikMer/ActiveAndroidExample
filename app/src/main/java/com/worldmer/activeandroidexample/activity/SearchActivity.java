package com.worldmer.activeandroidexample.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import com.worldmer.activeandroidexample.R;
import com.worldmer.activeandroidexample.adapter.ContactAdapter;
import com.worldmer.activeandroidexample.database.ActiveAndroidHelper;
import com.worldmer.activeandroidexample.modal.Contacts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yagnik on 03-Jan-18.
 */

public class SearchActivity extends AppCompatActivity {
    ListView lvContacts;
    List<Contacts> contactList;
    EditText edtName;
    Button btnSearch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        bindView();
        initialize();
        listeners();
    }
    private void bindView() {
        lvContacts = (ListView) findViewById(R.id.lvcontacts);
        edtName = (EditText) findViewById(R.id.edtname);
        btnSearch = (Button) findViewById(R.id.btnsearch);
    }

    private void initialize() {
        contactList = new ArrayList<Contacts>();
    }

    private void listeners() {
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edtName.getText().toString();
                contactList = ActiveAndroidHelper.getContact(text);
                if (contactList.size() > 0) {
                    ContactAdapter customAdapter = new ContactAdapter(SearchActivity.this, contactList);
                    lvContacts.setAdapter(customAdapter);
                } else {
                    lvContacts.setAdapter(null);
                    Toast.makeText(SearchActivity.this, "Contant Not Found.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
