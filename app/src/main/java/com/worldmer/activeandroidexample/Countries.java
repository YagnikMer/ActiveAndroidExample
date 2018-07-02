package com.worldmer.activeandroidexample;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Yagnik on 01-Jul-18.
 */

@Table(name="Countries")
public class Countries extends Model {

    @Column(name="Country")
    public String Country;

    @Column(name="Capital")
    public String Capital;

    @Column(name="Currency")
    public String Currency;
}
