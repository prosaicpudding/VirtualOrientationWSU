package com.client.wsu.virtualorientation;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.client.wsu.shared.Shared;

import java.util.HashMap;
import java.util.Set;


public class Questionnaire extends Activity implements View.OnClickListener {

    private final String[] majors = {"Computer Science","Electronics and Electricals"};
    private final String[] level = {"UnderGrad", "Graduate"};
    private final String[] sems = {"Spring", "Fall"};
    ArrayAdapter<String> adaptermajor;
    ArrayAdapter<String> adapterlevel;
    ArrayAdapter<String> adaptersem;
    Button b;
    private Spinner mListViewMajor;
    private Spinner mListViewLevel;
    private Spinner mListViewSem;
    private HashMap<String, String> advisors;
    private Set<String> reqtasks;
    private Set<String> unreqtasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);
        populate();
        adaptermajor = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, majors);
        adapterlevel = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, level);
        adaptersem = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sems);
        mListViewMajor = (Spinner) findViewById(R.id.major);
        mListViewLevel = (Spinner) findViewById(R.id.level);
        mListViewSem = (Spinner) findViewById(R.id.sem);
        mListViewMajor.setAdapter(adaptermajor);
        mListViewLevel.setAdapter(adapterlevel);
        mListViewSem.setAdapter(adaptersem);
        b = (Button) findViewById(R.id.button);
        b.setOnClickListener(this);
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
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button) {
            Shared.level = mListViewLevel.getSelectedItemPosition();
            Shared.major = mListViewMajor.getSelectedItemPosition();
            SharedPreferences.Editor edit = Shared.prefs.edit();
            edit.putString("major", majors[mListViewMajor.getSelectedItemPosition()]);
            edit.putString("level", level[mListViewLevel.getSelectedItemPosition()]);
            edit.putString("advisor", advisors.get(majors[mListViewMajor.getSelectedItemPosition()]+" "+level[mListViewLevel.getSelectedItemPosition()]));
            edit.putStringSet(Shared.types[0], reqtasks);
            edit.putStringSet(Shared.types[1], unreqtasks);
            edit.commit();
            Log.i("Log", adaptermajor.getItem(mListViewMajor.getSelectedItemPosition()));
            Log.i("Log", adapterlevel.getItem(mListViewLevel.getSelectedItemPosition()));
            this.finishActivity(80);
            this.finish();

        }
    }

    private void populate() {





    }
}



