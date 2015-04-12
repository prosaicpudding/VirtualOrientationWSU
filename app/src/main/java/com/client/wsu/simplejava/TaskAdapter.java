package com.client.wsu.simplejava;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import com.client.wsu.shared.Shared;
import com.client.wsu.virtualorientation.MainActivity;
import com.client.wsu.virtualorientation.R;

import org.apache.http.impl.cookie.DateUtils;

import java.util.HashMap;
import java.util.List;

/**
 * Created by nitinpanuganti on 3/23/15.
 */
public class TaskAdapter extends ArrayAdapter<TaskItem>{
    MainActivity.CheckBoxListener listener;
    MainActivity.ButtonListener boxListener;
    MainActivity.DeleteListsner deleteListsner;

    public TaskAdapter(Context context, int resource, List<TaskItem> objects,MainActivity.CheckBoxListener listener,MainActivity.ButtonListener boxListener,MainActivity.DeleteListsner deletelistener) {
        super(context, resource, objects);
        this.listener=listener;
        this.boxListener=boxListener;
        this.deleteListsner=deletelistener;
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

        TaskItem taskItem=getItem(position);
        String str=taskItem.getName();
        CheckBox cb=(CheckBox)v.findViewById(R.id.checkBox1);
        cb.setChecked(taskItem.isChecked());
        cb.setOnClickListener(listener);
        ImageButton b=(ImageButton)v.findViewById(R.id.bt4);
        b.setOnClickListener(boxListener);
        if(Shared.cbintmap==null)
            Shared.cbintmap=new HashMap<>();
        if(Shared.bintmap==null)
            Shared.bintmap=new HashMap<>();
        if(Shared.dintmap==null)
            Shared.dintmap=new HashMap<>();
        Shared.cbintmap.put(cb,position);
        Shared.bintmap.put(b,position);
        b=(ImageButton)v.findViewById(R.id.bt5);
        b.setOnClickListener(deleteListsner);
        Shared.dintmap.put(b,position);


        TextView tv=(TextView)v.findViewById(R.id.textView4);
        if(taskItem.isShared()){
            tv.setTextColor(Color.rgb(146,1,1));
        }
        if(taskItem.getDate()!=null)
            tv.setText(str+"\t\t"+ DateUtils.formatDate(taskItem.getDate(),"MM/dd/yyyy"));
        else
            tv.setText(str);

        return v;
    }
}
