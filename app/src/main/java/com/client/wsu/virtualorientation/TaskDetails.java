package com.client.wsu.virtualorientation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.client.wsu.shared.Shared;


public class TaskDetails extends Activity {

    TextView b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Details");
        setContentView(R.layout.activity_task_details);
        b=(TextView)findViewById(R.id.details);
        RelativeLayout lay=(RelativeLayout)findViewById(R.id.rellay);
        LinearLayout view=(LinearLayout)b.getParent();
        RadioButton rb=(RadioButton)findViewById(R.id.radioButton);
        ViewGroup vg=(ViewGroup)lay;
        ToggleButton tb=(ToggleButton)findViewById(R.id.toggleButton);
        vg.removeView(tb);
        rb.setChecked(false);
        switch (Shared.running){
            case 0:
                if(Shared.reqtasks.get(Shared.postition).isShared()) {
                    rb.setChecked(true);
                    vg.addView(tb);
                }break;
            case 1:
                if(Shared.unreqtasks.get(Shared.postition).isShared()) {
                    rb.setChecked(true);
                    vg.addView(tb);
                }break;
        }
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
        view.removeView(lay);
        view.addView(tv);
        view.addView(lay);
        view.invalidate();


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
}
