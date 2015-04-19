package com.client.wsu.virtualorientation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.client.wsu.shared.Shared;


public class AddingContact extends Activity implements View.OnClickListener{

    TextView name,email,phone,extra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Add Contact");
        setContentView(R.layout.activity_adding_contact);
        name=(TextView)findViewById(R.id.name);
        email=(TextView)findViewById(R.id.email);
        phone=(TextView)findViewById(R.id.phone);
        extra=(TextView)findViewById(R.id.extras);
        Button b=(Button)findViewById(R.id.save);
        b.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_questionnaire, menu);
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

    @Override
    public void onClick(View v) {
      if(v.getId()==R.id.save) {
          if (extra.getText().length() < 1)
              Shared.advisors.add(name.getText().toString());
          else
              Shared.advisors.add(name.getText().toString());
      }
        this.finish();
    }
}
