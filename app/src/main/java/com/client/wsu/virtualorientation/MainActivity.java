package com.client.wsu.virtualorientation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.client.wsu.shared.Shared;
import com.client.wsu.simplejava.TaskAdapter;
import com.client.wsu.simplejava.TaskItem;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener,View.OnClickListener {

    TaskAdapter adapterView;
    private Spinner mListViewFilter;
    ArrayAdapter<String> adapterViewFilter;
    ArrayAdapter<String> advisorsList;
    private AbsListView mListView;
    private AbsListView advisorListView;
    Context ctx;

    Button notify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListViewFilter=(Spinner)findViewById(R.id.spinner);
        mListViewFilter.setOnItemSelectedListener(this);
        mListView=(ListView)findViewById(R.id.listView);
        advisorListView=(ListView)findViewById(R.id.textView5);
        mListView.setClickable(false);
        Button b=(Button)findViewById(R.id.add);
        b.setOnClickListener(this);
        b=(Button)findViewById(R.id.button2);
        b.setOnClickListener(this);
        Shared.loadTasks();
        ctx=this;



    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Log","Inresume");
        Shared.prefs = getSharedPreferences(Shared.key, Context.MODE_PRIVATE);
        String str=Shared.prefs.getString("major", "-999");
        if(str.equals("-999")){
            Intent i=new Intent(this,Questionnaire.class);
            startActivityForResult(i,50);
        }else{
            if(adapterViewFilter==null){
                if(Shared.reqtasks!=null && Shared.unreqtasks!=null) {
                    adapterViewFilter=new ArrayAdapter<String>(this,R.layout.spinner_layout, Shared.types);
                    mListViewFilter.setAdapter(adapterViewFilter);
                    adapterView=new TaskAdapter(this,android.R.layout.simple_spinner_item, sort(Shared.reqtasks),new CheckBoxListener(),new ButtonListener(),new DeleteListsner());
                    mListView.setAdapter(adapterView);
                    mListView.setClickable(true);
                    mListView.invalidate();
                    if(Shared.advisors==null){
                       // Shared.advisors=new ArrayList<>();
                       // Shared.advisors.add(Shared.prefs.getString("advisor","Details Not found"));
                    }

                }
            }
            advisorsList=new ArrayAdapter<String>(this,R.layout.address_item,R.id.textView41, Shared.advisors);
            advisorListView.setAdapter(advisorsList);
            advisorListView.invalidate();

        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_adding_contact, menu);
        MenuItem item=menu.findItem(R.id.notification_settings);
        item.setTitle(Shared.notifyies[Shared.noti]);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if(id==R.id.notification_settings){
            if(item.getTitle().equals(Shared.notifyies[0])) {
                item.setTitle(Shared.notifyies[1]);
                Shared.noti=1;
                Toast.makeText(this, "You Turned OFF Notifications", Toast.LENGTH_LONG).show();

            }else if(item.getTitle().equals(Shared.notifyies[1])) {
                item.setTitle(Shared.notifyies[0]);
                Shared.noti=0;
                Toast.makeText(this, "You Turned ON Notifications", Toast.LENGTH_LONG).show();
            }
        }else if(id==R.id.reset){
            Intent i=new Intent(this,Questionnaire.class);
            startActivity(i);
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("Log",""+requestCode);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if(position==0){
                adapterView=new TaskAdapter(this,android.R.layout.simple_spinner_item, sort(Shared.reqtasks),new CheckBoxListener(),new ButtonListener(),new DeleteListsner());
                mListView.setAdapter(adapterView);
                mListView.setClickable(true);
                mListView.invalidate();
                Shared.running=0;
            }else{
                adapterView=new TaskAdapter(this,android.R.layout.simple_spinner_item, sort(Shared.unreqtasks),new CheckBoxListener(),new ButtonListener(),new DeleteListsner());
                mListView.setAdapter(adapterView);
                mListView.setClickable(true);
                mListView.invalidate();
                Shared.running=1;
            }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.add){
            Intent i=new Intent(this,AddingContact.class);
            startActivity(i);
        }else if(v.getId()==R.id.button2){
            Intent i=new Intent(this,TaskActicity.class);
            startActivity(i);
        }
    }





    public class CheckBoxListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Log.i("Log","Check Box CLicked");
            if(mListViewFilter.getSelectedItemPosition()==0){
                TaskItem taskItem=Shared.reqtasks.get(Shared.cbintmap.get((CheckBox)v));
                taskItem.setChecked(!taskItem.isChecked());
                adapterView=new TaskAdapter(ctx,android.R.layout.simple_spinner_item, sort(Shared.reqtasks),new CheckBoxListener(),new ButtonListener(),new DeleteListsner());
                mListView.setAdapter(adapterView);
                mListView.setClickable(true);
                mListView.invalidate();
            }else{
                TaskItem taskItem=Shared.unreqtasks.get(Shared.cbintmap.get((CheckBox)v));
                taskItem.setChecked(!taskItem.isChecked());
                adapterView=new TaskAdapter(ctx,android.R.layout.simple_spinner_item, sort(Shared.unreqtasks),new CheckBoxListener(),new ButtonListener(),new DeleteListsner());
                mListView.setAdapter(adapterView);
                mListView.setClickable(true);
                mListView.invalidate();
            }

        }
    }

    public class ButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Log.i("Log", "Info Box CLicked");
            Shared.postition = Shared.bintmap.get((ImageButton) v);
            Shared.selectedId = Shared.postition;
            Intent i = new Intent(ctx, TaskDetails.class);
            startActivity(i);

        }
    }

    public class DeleteListsner implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Log.i("Log", "DELETE Box CLicked");

            if(mListViewFilter.getSelectedItemPosition()==0){
                Log.i("YO",""+Shared.reqtasks.size());
                Log.i("YO1",""+Shared.dintmap.get((ImageButton) v));
                int pos=Shared.dintmap.get((ImageButton) v);
                TaskItem t=Shared.reqtasks.get(Shared.dintmap.get((ImageButton) v));
                Shared.reqtasks.remove(t);
                Log.i("YO",""+Shared.reqtasks.size());
                Shared.dintmap.remove((ImageButton)v);
                Shared.bintmap.remove(pos);
                Shared.cbintmap.remove(pos);
                adapterView=new TaskAdapter(ctx,android.R.layout.simple_spinner_item, sort(Shared.reqtasks),new CheckBoxListener(),new ButtonListener(),new DeleteListsner());
                mListView.setAdapter(adapterView);
                mListView.setClickable(true);
                mListView.invalidate();

            }else{
                int pos=Shared.dintmap.get((ImageButton) v);
                TaskItem t=Shared.unreqtasks.get(Shared.dintmap.get((ImageButton) v));
                Shared.unreqtasks.remove(t);
                Shared.dintmap.remove((ImageButton)v);
                Shared.bintmap.remove(pos);
                Shared.cbintmap.remove(pos);
                adapterView=new TaskAdapter(ctx,android.R.layout.simple_spinner_item, sort(Shared.unreqtasks),new CheckBoxListener(),new ButtonListener(),new DeleteListsner());
                mListView.setAdapter(adapterView);
                mListView.setClickable(true);
                mListView.invalidate();
            }

        }
    }


    public List<TaskItem> sort(List<TaskItem> list){
        Collections.sort(list, new Comparator<TaskItem>() {
            public int compare(TaskItem o1, TaskItem o2) {
                if (o1.getDate() == null || o2.getDate() == null)
                    return 0;
                return o1.getDate().compareTo(o2.getDate());
            }
        });
        return list;
    }
}
