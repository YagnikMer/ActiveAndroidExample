package com.worldmer.activeandroidexample.database;

import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.activeandroid.query.Update;
import com.worldmer.activeandroidexample.modal.Contacts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yagnik on 01-Jul-18.
 */

public class ActiveAndroidHelper {

    public static long insertContact(Contacts contact) {
        return contact.save();
    }

    public static List<Contacts> getAllContact() {
        return new Select()
                .from(Contacts.class)
                .execute();
    }

    public static void deleteContact(long id) {
        new Delete()
                .from(Contacts.class)
                .where("id = ?", id)
                .execute();
    }

    public static List<Contacts> getContact(String search) {
        return new Select()
                .from(Contacts.class)
                .where("name LIKE '" + search + "%'")
                .execute();
    }

    public static void updateContact(Contacts contact, long id) {
        new Update(Contacts.class)
                .set("name='" + contact.name+"',phone='" + contact.phone+"'")
                .where("id = ?",id)
                .execute();
    }

    public static Contacts getContact(long index)
    {
        Contacts contact = new Contacts();
        List<Contacts> contactsList = new ArrayList<>();
        contactsList= new Select()
                .from(Contacts.class)
                .where("id = ?", index)
                .execute();
        if (contactsList.size()>0)
        {
            contact = contactsList.get(0);
        }
        return contact;
    }
}