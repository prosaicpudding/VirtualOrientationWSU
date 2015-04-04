package com.client.wsu.virtualorientation;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.client.wsu.shared.Shared;


public class TaskActicity extends ActionBarActivity implements View.OnClickListener{
    EditText name,date,details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_acticity);
        Button b=(Button)findViewById(R.id.button3);
        b.setOnClickListener(this);
        name=(EditText)findViewById(R.id.name);
        date=(EditText)findViewById(R.id.date);
        details=(EditText)findViewById(R.id.details);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_task_acticity, menu);
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
        switch (Shared.running){
            case 0:
                Shared.reqtasks.add(name.getText().toString()+" : "+date.getText().toString());
                Shared.reqtasksdetails.add(details.getText().toString());
                break;
            case 1:
                Shared.unreqtasks.add(name.getText().toString()+" : "+date.getText().toString());
                Shared.unreqtasksdetails.add(details.getText().toString());
                break;
        }
        this.finish();
    }
}
