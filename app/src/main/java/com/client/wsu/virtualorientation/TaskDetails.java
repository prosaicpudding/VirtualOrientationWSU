package com.client.wsu.virtualorientation;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.client.wsu.shared.Shared;


public class TaskDetails extends ActionBarActivity {

    TextView b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);
        b=(TextView)findViewById(R.id.details);
        LinearLayout view=(LinearLayout)b.getParent();
        int i=1;
            TextView tv=new TextView(this);
        switch (Shared.running){
            case 0:
                tv.setText(Shared.reqtasksdetails.get(Shared.postition));
                break;
            case 1:
                tv.setText(Shared.unreqtasksdetails.get(Shared.postition));
                break;
        }

            view.addView(tv);
        view.invalidate();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_task_details, menu);
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
}
