package com.worldmer.activeandroidexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.activeandroid.query.From;
import com.activeandroid.query.Select;


/**
 * Created by Yagnik on 01-Jul-18.
 */

public class UpdateRecActivity extends Activity implements View.OnClickListener{

    EditText edtCountry,edtCapital,edtCurrency;
    Button btnCreate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        edtCountry = (EditText)findViewById(R.id.edtcountry);
        edtCapital = (EditText)findViewById(R.id.edtcapital);
        edtCurrency = (EditText)findViewById(R.id.edtcurrency);
        btnCreate= (Button)findViewById(R.id.btncreate);
        btnCreate.setOnClickListener(this);
    }
    public void createRec()
    {
        Countries countries = new Countries();
        countries.Country = edtCountry.getText().toString();
        countries.Capital = edtCapital.getText().toString();
        countries.Currency = edtCurrency.getText().toString();

        Long id=countries.save();
        Toast.makeText(getApplicationContext(),id+" Save Record Successfully",Toast.LENGTH_SHORT).show();
    }
    public void checkTextValidation(View view)
    {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btncreate:
//                createRec();
        }
    }
    public void displayRecord()
    {
        From from  = new Select().from(Countries.class).where("");
    }
}
