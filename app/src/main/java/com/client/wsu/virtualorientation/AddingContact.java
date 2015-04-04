package com.client.wsu.virtualorientation;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.client.wsu.shared.Shared;


public class AddingContact extends ActionBarActivity implements View.OnClickListener{

    TextView name,email,phone,extra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_adding_contact, menu);
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
        if(extra.getText().length()<1)
            Shared.advisors.add("Name:" + name.getText() + " \n Phone:" + phone.getText() + " \n Email:" + email.getText());
        else
            Shared.advisors.add("Name:" + name.getText() + " \n Phone:" + phone.getText() + " \n Email:" + email.getText()+" \n Extra:"+extra.getText());

        this.finish();
    }
}
