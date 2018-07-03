package com.worldmer.activeandroidexample.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.worldmer.activeandroidexample.R;
import com.worldmer.activeandroidexample.activity.EditActivity;
import com.worldmer.activeandroidexample.activity.MainActivity;
import com.worldmer.activeandroidexample.database.ActiveAndroidHelper;
import com.worldmer.activeandroidexample.modal.Contacts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yagnik on 03-Jan-18.
 */

public class ContactAdapter extends BaseAdapter {
    LayoutInflater inflater = null;
    Context context;
    List<Contacts> contactList;
    ActiveAndroidHelper activeAndroidHelper;

    public ContactAdapter(Context contaxt, List<Contacts> contactList) {
        this.activeAndroidHelper = new ActiveAndroidHelper();
        this.contactList = new ArrayList<>();
        this.contactList = contactList;
        this.context = contaxt;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        TextView tvName, tvPhone;
        Button btnDelete,btnEdit;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        View rowView;
        rowView = inflater.inflate(R.layout.row_contact, null);
        holder.tvName = (TextView) rowView.findViewById(R.id.tvname);
        holder.tvPhone = (TextView) rowView.findViewById(R.id.tvphone);
        holder.btnEdit = (Button) rowView.findViewById(R.id.btnedit);
        holder.btnDelete = (Button) rowView.findViewById(R.id.btndelete);

        holder.tvName.setText(contactList.get(position).name);
        holder.tvPhone.setText(contactList.get(position).phone);

        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent editIntent = new Intent(context, EditActivity.class);
                long index =contactList.get(position).getId();
                editIntent.putExtra("Index", index);
                context.startActivity(editIntent);
            }
        });
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activeAndroidHelper.deleteContact(contactList.get(position).getId());
                Toast.makeText(context, contactList.get(position).name
                        + " Delete Successfully.", Toast.LENGTH_SHORT).show();

                Intent mainIntent = new Intent(context, MainActivity.class);
                context.startActivity(mainIntent);
            }
        });
        return rowView;
    }
}

