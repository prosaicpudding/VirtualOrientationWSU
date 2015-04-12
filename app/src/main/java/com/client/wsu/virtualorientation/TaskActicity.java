package com.client.wsu.virtualorientation;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.client.wsu.shared.Shared;
import com.client.wsu.simplejava.TaskItem;

import org.apache.http.impl.cookie.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class TaskActicity extends Activity implements View.OnClickListener {
    EditText name, date, details;
    private DatePickerDialog toDatePickerDialog;

    private SimpleDateFormat dateFormatter;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Add Task");
        setContentView(R.layout.activity_task_acticity);
        Button b = (Button) findViewById(R.id.button3);
        dateFormatter = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
        b.setOnClickListener(this);
        name = (EditText) findViewById(R.id.name);
        date = (EditText) findViewById(R.id.date);

        details = (EditText) findViewById(R.id.details);
        cb = (CheckBox) findViewById(R.id.checkBox);
        Calendar newCalendar = Calendar.getInstance();
        toDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                date.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        date.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Log.i("Yes got here","Hot");
                toDatePickerDialog.show();
            }
        });

        date.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                toDatePickerDialog.show();
                return true;
            }
        });

}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_adding_contact, menu);
        MenuItem item = menu.findItem(R.id.notification_settings);
        item.setTitle(Shared.notifyies[Shared.noti]);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.notification_settings) {
            if (item.getTitle().equals(Shared.notifyies[0])) {
                item.setTitle(Shared.notifyies[1]);
                Shared.noti = 1;
                Toast.makeText(this, "You Turned OFF Notifications", Toast.LENGTH_LONG).show();

            } else if (item.getTitle().equals(Shared.notifyies[1])) {
                item.setTitle(Shared.notifyies[0]);
                Shared.noti = 0;
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
    public void onClick(View v) {
        if (cb.isChecked()) {
            Toast.makeText(this, "Saved and Shared", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
        }
        try {
            switch (Shared.running) {
                case 0:
                    if(date.getText().length()>4) {
                        Shared.reqtasks.add(new TaskItem(name.getText().toString(), DateUtils.parseDate(date.getText().toString(), new String[]{"MM/dd/yyyy"}), cb.isChecked()));
                    }else{
                        Shared.reqtasks.add(new TaskItem(name.getText().toString(), cb.isChecked()));
                    }
                    Shared.reqtasksdetails.add(details.getText().toString());
                    break;
                case 1:
                    if(date.getText().length()>4) {
                        Shared.unreqtasks.add(new TaskItem(name.getText().toString(), DateUtils.parseDate(date.getText().toString(), new String[]{"MM/dd/yyyy"}), cb.isChecked()));
                    }else{
                        Shared.unreqtasks.add(new TaskItem(name.getText().toString(), cb.isChecked()));
                    }
                    Shared.unreqtasksdetails.add(details.getText().toString());
                    break;
            }
        } catch (Exception e) {
            Log.e("error:",e.getMessage(),e);
        }
        this.finish();
    }
}
