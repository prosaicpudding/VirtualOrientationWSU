package com.client.wsu.simplejava;

import java.util.Date;

/**
 * Created by nitinpanuganti on 4/5/15.
 */
public class TaskItem{

    Date date;
    String name;
    boolean checked;
    boolean shared;


    public TaskItem(String name, Date date) {
        this.date = date;
        this.name=name;
        checked=false;
        shared=false;
    }

    public TaskItem(String name, Date date,boolean shared) {
        this.date = date;
        this.name=name;
        checked=false;
        this.shared=shared;

    }

    public TaskItem(String name) {

        this.name = name;
        checked = false;
        shared = false;

    }

    public TaskItem(String name, boolean shared) {
        this.name=name;
        checked=false;
        this.shared = shared;

    }

    public boolean isShared() {
        return shared;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "TaskItem{" +
                "date=" + date +
                ", name='" + name + '\'' +
                ", checked=" + checked +
                ", shared=" + shared +
                '}';
    }
}
