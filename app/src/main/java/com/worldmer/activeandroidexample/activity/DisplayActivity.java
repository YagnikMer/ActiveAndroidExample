package com.worldmer.activeandroidexample.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;


import com.activeandroid.query.Select;
import com.worldmer.activeandroidexample.R;
import com.worldmer.activeandroidexample.adapter.ContactAdapter;
import com.worldmer.activeandroidexample.database.ActiveAndroidHelper;
import com.worldmer.activeandroidexample.modal.Contacts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yagnik on 03-Jan-18.
 */

public class DisplayActivity extends AppCompatActivity {
    ListView lvContacts;
    List<Contacts> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        bindView();
        initialize();
    }

    private void bindView() {
        lvContacts = (ListView) findViewById(R.id.lvcontacts);
    }

    private void initialize() {
        contactList = new ArrayList<Contacts>();
        contactList = ActiveAndroidHelper.getAllContact();
        if (contactList.size() > 0) {
            ContactAdapter customAdapter =
                    new ContactAdapter(DisplayActivity.this, contactList);
            lvContacts.setAdapter(customAdapter);
        } else {
            Toast.makeText(DisplayActivity.this, "Contant Not Found.", Toast.LENGTH_SHORT).show();
        }
    }
    private List<Contacts> getAll()
    {
        return new Select().from(Contacts.class).execute();
    }

}
