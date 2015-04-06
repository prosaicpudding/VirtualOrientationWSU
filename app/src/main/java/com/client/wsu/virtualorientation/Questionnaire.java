package com.client.wsu.virtualorientation;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.client.wsu.shared.Shared;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class Questionnaire extends ActionBarActivity implements View.OnClickListener {

    private final String[] majors = {"Computer Science","Electrical Engineering", "Biology", "Chemistry", "Art"};
    private final String[] level = {"Undergraduate", "Graduate"};
    private final String[] sems = {"In-State", "Out-of-state","International"};
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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_questionnaire, menu);
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
        advisors = new HashMap<>();
        advisors.put("Computer Science Graduate", " Name: Joe Schmoe \n Number: 509-234-1234 \n Email: JS@wsu.edu");
        advisors.put("Computer Science Undergraduate"," Name: Grace Hopper \n Number: 509-234-1234 \n Email: GH@wsu.edu");
        advisors.put("Electrical Engineering Graduate"," Name: Alan Turing \n Number: 509-234-1234 \n Email: AT@wsu.edu");
        advisors.put("Electrical Engineering Undergraduate"," Name: Neil Armstrong \n Number: 509-234-1234 \n Email: NA@wsu.edu");

        reqtasks =new HashSet<>();
        reqtasks.add("Get Cougar Card : 1/13");
        reqtasks.add("Submit W4 form : 1/14");
        reqtasks.add("Register for Classes : 1/15");
        reqtasks.add("Meet Sidra : 1/15");

        unreqtasks =new HashSet<>();
        unreqtasks.add("Check Walmart");
        unreqtasks.add("Check Car Rentals");
        unreqtasks.add("Check Chinese Food");



    }
}



