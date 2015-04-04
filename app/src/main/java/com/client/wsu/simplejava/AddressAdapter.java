package com.client.wsu.simplejava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.client.wsu.virtualorientation.R;

import java.util.List;

/**
 * Created by nitinpanuganti on 3/24/15.
 */
public class AddressAdapter extends ArrayAdapter<String> {
    public AddressAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {

            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(android.R.layout.simple_list_item_1, null);

        }
        TextView tv=(TextView)v.findViewById(R.id.textView4);
        tv.setText(getItem(position));

        return v;
    }
}
