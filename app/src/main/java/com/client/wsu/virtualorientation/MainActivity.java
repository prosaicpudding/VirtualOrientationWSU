package com.client.wsu.virtualorientation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.client.wsu.shared.Shared;
import com.client.wsu.simplejava.TaskAdapter;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemSelectedListener,View.OnClickListener,AdapterView.OnItemClickListener {

    TaskAdapter adapterView;
    private Spinner mListViewFilter;
    ArrayAdapter<String> adapterViewFilter;
    ArrayAdapter<String> advisorsList;
    private AbsListView mListView;
    private AbsListView advisorListView;
    CheckBox[] reqtaskboxes,unreqtaskboxes;
    Context ctx;

    Button notify;
    String notifyies[]={"Notifications OFF","Notifications ON"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListViewFilter=(Spinner)findViewById(R.id.spinner);
        mListViewFilter.setOnItemSelectedListener(this);
        mListView=(ListView)findViewById(R.id.listView);
        advisorListView=(ListView)findViewById(R.id.textView5);
        notify=(Button)findViewById(R.id.offnotify);
        notify.setOnClickListener(this);
        notify.setText(notifyies[0]);
        mListView.setClickable(true);
        mListView.setOnItemClickListener(this);
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
                Shared.reqtasks=new ArrayList<>(Shared.prefs.getStringSet(Shared.types[0],null));
                Shared.unreqtasks=new ArrayList<>(Shared.prefs.getStringSet(Shared.types[1],null));
                if(Shared.reqtasks!=null && Shared.unreqtasks!=null) {
                    adapterViewFilter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, Shared.types);
                    mListViewFilter.setAdapter(adapterViewFilter);
                    adapterView=new TaskAdapter(this,android.R.layout.simple_spinner_item, Shared.reqtasks,new CheckBoxListener());
                    mListView.setAdapter(adapterView);
                    mListView.setClickable(true);
                    mListView.invalidate();
                    if(Shared.advisors==null){
                        Shared.advisors=new ArrayList<>();
                        Shared.advisors.add(Shared.prefs.getString("advisor","Details Not found"));
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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
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
                adapterView=new TaskAdapter(this,android.R.layout.simple_spinner_item, Shared.reqtasks,new CheckBoxListener());
                mListView.setAdapter(adapterView);
                mListView.setClickable(true);
                mListView.invalidate();
                Shared.running=0;
            }else{
                adapterView=new TaskAdapter(this,android.R.layout.simple_spinner_item, Shared.unreqtasks,new CheckBoxListener());
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
        if(v.getId()==R.id.offnotify) {
            if (notify.getText().equals(notifyies[0])) {
                notify.setText(notifyies[1]);
                Toast.makeText(this,"You Turned ON Notifications",Toast.LENGTH_LONG).show();

            } else {
                notify.setText(notifyies[0]);
                Toast.makeText(this,"You Turned OFF Notifications",Toast.LENGTH_LONG).show();
            }
        }else if(v.getId()==R.id.add){
            Intent i=new Intent(this,AddingContact.class);
            startActivity(i);
        }else if(v.getId()==R.id.button2){
            Intent i=new Intent(this,TaskActicity.class);
            startActivity(i);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i("Log","Item Clicked");
        Shared.postition=position;
        Intent i=new Intent(this,TaskDetails.class);
        Shared.selectedId=position;
        startActivity(i);
    }



    public class CheckBoxListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Log.i("Log","Check Box CLicked");
            if(mListViewFilter.getSelectedItemPosition()==0){
                String str[]=Shared.reqtasks.get(Shared.cbintmap.get((CheckBox)v)).split("bca");
                if(str.length>1){
                    if(str[1].equals("1"))
                        Shared.reqtasks.set(Shared.cbintmap.get((CheckBox)v),str[0]+"bca0");
                    else
                        Shared.reqtasks.set(Shared.cbintmap.get((CheckBox)v),str[0]+"bca1");
                }else{
                    Shared.reqtasks.set(Shared.cbintmap.get((CheckBox)v),str[0]+"bca1");
                }

                adapterView=new TaskAdapter(ctx,android.R.layout.simple_spinner_item, Shared.reqtasks,new CheckBoxListener());
                mListView.setAdapter(adapterView);
                mListView.setClickable(true);
                mListView.invalidate();
            }else{

                String str[]=Shared.unreqtasks.get(Shared.cbintmap.get((CheckBox)v)).split("bca");
                if(str.length>1){
                    if(str[1].equals("1"))
                        Shared.unreqtasks.set(Shared.cbintmap.get((CheckBox)v),str[0]+"bca0");
                    else
                        Shared.unreqtasks.set(Shared.cbintmap.get((CheckBox)v),str[0]+"bca1");
                }else{
                    Shared.unreqtasks.set(Shared.cbintmap.get((CheckBox)v),str[0]+"bca1");
                }

                adapterView=new TaskAdapter(ctx,android.R.layout.simple_spinner_item, Shared.unreqtasks,new CheckBoxListener());
                mListView.setAdapter(adapterView);
                mListView.setClickable(true);
                mListView.invalidate();
            }

        }
    }
}
