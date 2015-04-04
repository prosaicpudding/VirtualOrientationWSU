package com.client.wsu.virtualorientation;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.client.wsu.shared.Shared;


public class TaskActicity extends ActionBarActivity implements View.OnClickListener{
    EditText name,date,details;
    CheckBox cb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_acticity);
        Button b=(Button)findViewById(R.id.button3);
        b.setOnClickListener(this);
        name=(EditText)findViewById(R.id.name);
        date=(EditText)findViewById(R.id.date);
        details=(EditText)findViewById(R.id.details);
        cb=(CheckBox)findViewById(R.id.checkBox);
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
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(cb.isChecked()){
            Toast.makeText(this, "Saved and Shared", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
        }
        switch (Shared.running){
            case 0:
                if(cb.isChecked()) {
                    Shared.reqtasks.add(name.getText().toString() + " : " + date.getText().toString()+" # shared");
                }else{
                    Shared.reqtasks.add(name.getText().toString() + " : " + date.getText().toString());
                }
                Shared.reqtasksdetails.add(details.getText().toString());
                break;
            case 1:
                if(cb.isChecked()) {
                    Shared.unreqtasks.add(name.getText().toString() + " : " + date.getText().toString() + " # shared");
                }else{
                    Shared.unreqtasks.add(name.getText().toString() + " : " + date.getText().toString());
                }
                Shared.unreqtasksdetails.add(details.getText().toString());
                break;
        }
        this.finish();
    }
}
