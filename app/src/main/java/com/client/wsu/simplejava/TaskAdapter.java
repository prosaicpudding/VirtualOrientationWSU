package com.client.wsu.simplejava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.client.wsu.shared.Shared;
import com.client.wsu.virtualorientation.MainActivity;
import com.client.wsu.virtualorientation.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by nitinpanuganti on 3/23/15.
 */
public class TaskAdapter extends ArrayAdapter<String>{
    MainActivity.CheckBoxListener listener;


    public TaskAdapter(Context context, int resource, List<String> objects,MainActivity.CheckBoxListener listener) {
        super(context, resource, objects);
        this.listener=listener;
        Shared.cbintmap=null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {

            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.task_item, null);

        }
        String str[]=getItem(position).split("bca");
        CheckBox cb=(CheckBox)v.findViewById(R.id.checkBox1);
        if(str.length>1 ){
            if(str[1].equals("1"))
            cb.setChecked(true);
        }else
            cb.setChecked(false);

        cb.setOnClickListener(listener);

        if(Shared.cbintmap==null)
            Shared.cbintmap=new HashMap<>();

        Shared.cbintmap.put(cb,position);

        TextView tv=(TextView)v.findViewById(R.id.textView4);
        tv.setText(str[0]);


        return v;
    }
}
