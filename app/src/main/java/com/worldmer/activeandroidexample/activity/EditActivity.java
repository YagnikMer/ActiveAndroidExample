package com.worldmer.activeandroidexample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.worldmer.activeandroidexample.R;
import com.worldmer.activeandroidexample.database.ActiveAndroidHelper;
import com.worldmer.activeandroidexample.modal.Contacts;

/**
 * Created by yagnik on 1/1/18.
 */

public class EditActivity extends AppCompatActivity {
    EditText edtName, edtPhone;
    Button btnCreate;
    long index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        bindView();
        initialize();
        listeners();
    }

    public void bindView() {
        edtName = (EditText) findViewById(R.id.edtname);
        edtPhone = (EditText) findViewById(R.id.edtphone);
        btnCreate = (Button) findViewById(R.id.btncreate);
    }

    private void initialize() {
        edtName.requestFocus();
        try {
            index = getIntent().getLongExtra("Index", -1);
            Contacts contacts = new Contacts();
            ActiveAndroidHelper activeAndroidHelper = new ActiveAndroidHelper();
            contacts = activeAndroidHelper.getContact(index);
            edtName.setText(contacts.name);
            edtPhone.setText(contacts.phone);
        } catch (Exception e) {
        }

    }

    private void listeners() {
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtName.getText().toString().trim().length() > 0
                        && edtPhone.getText().toString().trim().length() > 0) {
                    Contacts contact = new Contacts();
                    contact.name = edtName.getText().toString();
                    contact.phone = edtPhone.getText().toString();
                    ActiveAndroidHelper.updateContact(contact, index);
                    Toast.makeText(getApplicationContext(), "Update Contacts Successfully",
                            Toast.LENGTH_SHORT).show();
                    Intent mainIntent = new Intent(EditActivity.this, MainActivity.class);
                    startActivity(mainIntent);
                } else {
                    Toast.makeText(getApplicationContext(), "Required Field are empty",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}