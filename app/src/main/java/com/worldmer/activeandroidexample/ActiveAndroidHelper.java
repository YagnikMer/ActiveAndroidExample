package com.worldmer.activeandroidexample;

import android.content.Context;

import com.activeandroid.query.Select;
import com.activeandroid.query.Update;

import java.util.List;

/**
 * Created by Yagnik on 01-Jul-18.
 */

public class ActiveAndroidHelper {

    Countries mCountries;
    Context context;
    public ActiveAndroidHelper(Context context)
    {
        this.context=context;
        mCountries = new Countries();
    }
    private Long insertCountry(Countries countries)
    {
        return countries.save();
    }
    private void deleteCountry(int CountryId)
    {
        Countries item = mCountries.load(Countries.class, CountryId);
        item.delete();
    }
    private void updateCountry(Countries countries)
    {
        new Update(Countries.class)
                .set("Country ="+countries.Country+",Capital="+countries.Capital+",Currency="+countries.Currency)
                .where("Account = ?", countries.getId())
                .execute();
    }
    private List<Countries> getAllCountry()
    {
        return new Select().from(Countries.class).execute();
    }
    private Countries getCountry(int CountryID)
    {
        Countries countries=null;
        new Select().from(Countries.class).where("id="+CountryID).execute();
        return countries;
    }
}