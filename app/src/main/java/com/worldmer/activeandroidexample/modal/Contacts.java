package com.worldmer.activeandroidexample.modal;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by yagnik on 1/1/17.
 */

@Table(name="Contacts")
public class Contacts extends Model {

    @Column(name = "name")
    public String name;

    @Column(name = "phone")
    public String phone;
}
