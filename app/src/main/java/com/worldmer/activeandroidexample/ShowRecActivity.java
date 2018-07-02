package com.worldmer.activeandroidexample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.activeandroid.query.Select;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yagnik on 01-Jul-18.
 */

public class ShowRecActivity extends Activity{

    ArrayList<String> arrayList;
    ArrayAdapter CountryAdapter;
    ListView lvCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        lvCountry = (ListView)findViewById(R.id.lvcountry);
        arrayList = new ArrayList<>();
        show();
    }
    public void show()
    {
        List<Countries> countries = new ArrayList<>();
        countries = getAll();
        for (int i=0;i<countries.size();i++)
        {
            arrayList.add(""+countries.get(i).getId());
        }
        CountryAdapter = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,arrayList);
        lvCountry.setAdapter(CountryAdapter);
    }
    private List<Countries> getAll()
    {
        return new Select().from(Countries.class).execute();
    }

}
