package com.client.wsu.shared;

import android.content.SharedPreferences;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.ImageButton;

import com.client.wsu.simplejava.TaskItem;

import org.apache.http.impl.cookie.DateUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by nitinpanuganti on 3/23/15.
 */
public class Shared {

    public static SharedPreferences prefs;
    public static final String required="REQUIRED";
    public static final String optional="OPTIONAL";
    public static final String dtw="DUETHISWEEK";
    public static final String personal="PERSONAL";
    public static final String key="virtualorientationwsu";

    public static int level;
    public static int major;

    public static String types[]={"Required","Optional"};

    public static int selectedId=-999;
    public static List<String> taskDetails;
    public static List<String> advisors;

    public static Map<CheckBox,Integer> cbintmap;
    public static Map<ImageButton,Integer> bintmap;
    public static Map<ImageButton,Integer> dintmap;
    public static int running=0;
    public static List<TaskItem> reqtasks;
    public static List<TaskItem> unreqtasks;

    public static List<String> reqtasksdetails;
    public static List<String> unreqtasksdetails;

    public static int postition=0;
    public static String notifyies[]={"Notifications OFF","Notifications ON"};
    public static int noti=0;

    public static void loadTasks(){
        try{
        reqtasksdetails=new ArrayList<>();
        unreqtasksdetails=new ArrayList<>();

        reqtasks =new ArrayList<>();
        reqtasks.add(new TaskItem("Get Cougar Card", DateUtils.parseDate("01/13/2015",new String[]{"MM/dd/yyyy"}),true));
        reqtasks.add(new TaskItem("Submit W4 form", DateUtils.parseDate("01/14/2015", new String[]{"MM/dd/yyyy"})));
        reqtasks.add(new TaskItem("Register for Classes", DateUtils.parseDate("01/15/2015", new String[]{"MM/dd/yyyy"}),true));
        reqtasks.add(new TaskItem("Meet Sidra", DateUtils.parseDate("01/14/2015", new String[]{"MM/dd/yyyy"})));
        reqtasks.add(new TaskItem("Attend seminar", DateUtils.parseDate("01/16/2015", new String[]{"MM/dd/yyyy"}),true));
        reqtasks.add(new TaskItem("Register for exam", DateUtils.parseDate("01/14/2015", new String[]{"MM/dd/yyyy"})));
        reqtasks.add(new TaskItem("Create Osble Account", DateUtils.parseDate("01/17/2015", new String[]{"MM/dd/yyyy"}),true));
        reqtasks.add(new TaskItem("Buy Clicker", DateUtils.parseDate("01/13/2015", new String[]{"MM/dd/yyyy"})));
        reqtasks.add(new TaskItem("Buy Books", DateUtils.parseDate("01/18/2015", new String[]{"MM/dd/yyyy"})));
        reqtasks.add(new TaskItem("Visit Library", DateUtils.parseDate("01/15/2015", new String[]{"MM/dd/yyyy"}),true));
        reqtasks.add(new TaskItem("Buy Freedom Board KL25Z", DateUtils.parseDate("01/17/2015", new String[]{"MM/dd/yyyy"})));
        reqtasks.add(new TaskItem("Join student association", DateUtils.parseDate("01/12/2015", new String[]{"MM/dd/yyyy"})));
        reqtasks.add(new TaskItem("Submit bio ", DateUtils.parseDate("01/12/2015", new String[]{"MM/dd/yyyy"})));

        unreqtasks =new ArrayList<>();
        unreqtasks.add(new TaskItem("Check Walmart",true));
        unreqtasks.add(new TaskItem("Check Car Rentals"));
        unreqtasks.add(new TaskItem("Check Chinese Food",true));
        unreqtasks.add(new TaskItem("Eat Ice-cream"));
        unreqtasks.add(new TaskItem("Get Mexican Food",true));
        unreqtasks.add(new TaskItem("Go to dissmores"));
        unreqtasks.add(new TaskItem("Get Veggies"));
        unreqtasks.add(new TaskItem("Attend a party",true));
        unreqtasks.add(new TaskItem("Buy bag"));
        unreqtasks.add(new TaskItem("Ride bus"));

        reqtasksdetails.add("1. Make Sure you have your WSU ID Number\n" +
                "2.Go to Cub"+"\n" +
                "3.Go to lower level1\n" +
                "4.Get your cougar card\n" +
                "5.If possible create bank account(optional)");
        reqtasksdetails.add("1. Make Sure you have your WSU ID Number\n" +
                "2.Go French Admin Building\n" +
                "3.Fill the W4 form at financial office\n" +
                "4.Submit the W4 form at financial office\n");
        reqtasksdetails.add("1. Login to Zzusis\n" +
                "2.Search Classes\n" +
                "3.Pick Classes\n" +
                "4.Register\n");
        reqtasksdetails.add("1. Go to Sloan\n" +
                "2.Go to third floor\n" +
                "3.Mett sidra at room 303\n");
        reqtasksdetails.add("1. Go to Sloan\n" +
                "2.Go to third floor\n" +
                "3.Mett sidra at room 303\n");
        reqtasksdetails.add("1. Go to Sloan\n" +
                "2.Go to third floor\n" +
                "3.Mett sidra at room 303\n");
        reqtasksdetails.add("1. Go to Sloan\n" +
                "2.Go to third floor\n" +
                "3.Mett sidra at room 303\n");
        reqtasksdetails.add("1. Go to Sloan\n" +
                "2.Go to third floor\n" +
                "3.Mett sidra at room 303\n");
        reqtasksdetails.add("1. Go to Sloan\n" +
                "2.Go to third floor\n" +
                "3.Mett sidra at room 303\n");
        reqtasksdetails.add("1. Go to Sloan\n" +
                "2.Go to third floor\n" +
                "3.Mett sidra at room 303\n");
        reqtasksdetails.add("1. Go to Sloan\n" +
                "2.Go to third floor\n" +
                "3.Mett sidra at room 303\n");
        reqtasksdetails.add("1. Go to Sloan\n" +
                "2.Go to third floor\n" +
                "3.Mett sidra at room 303\n");
        reqtasksdetails.add("1. Go to Sloan\n" +
                "2.Go to third floor\n" +
                "3.Mett sidra at room 303\n");
        unreqtasksdetails.add("1. Go to Bus Stop\n" +
                "2.Take express 2 or 1\n" +
                "3.Get down at walmart\n");
        unreqtasksdetails.add("1. Go to Bus Stop\n" +
                "2.Take express 2 or 1\n" +
                "3.Get down at enterprise rentals\n");
        unreqtasksdetails.add("1. Go to Bus Stop\n" +
                "2.Take express 2 or 1\n" +
                "3.Get down at Chinese restaurant\n");
        unreqtasksdetails.add("1. Go to Bus Stop\n" +
                "2.Take express 2 or 1\n" +
                "3.Get down at Chinese restaurant\n");
        unreqtasksdetails.add("1. Go to Bus Stop\n" +
                "2.Take express 2 or 1\n" +
                "3.Get down at Chinese restaurant\n");
        unreqtasksdetails.add("1. Go to Bus Stop\n" +
                "2.Take express 2 or 1\n" +
                "3.Get down at Chinese restaurant\n");
        unreqtasksdetails.add("1. Go to Bus Stop\n" +
                "2.Take express 2 or 1\n" +
                "3.Get down at Chinese restaurant\n");
        unreqtasksdetails.add("1. Go to Bus Stop\n" +
                "2.Take express 2 or 1\n" +
                "3.Get down at Chinese restaurant\n");
        unreqtasksdetails.add("1. Go to Bus Stop\n" +
                "2.Take express 2 or 1\n" +
                "3.Get down at Chinese restaurant\n");
        unreqtasksdetails.add("1. Go to Bus Stop\n" +
                "2.Take express 2 or 1\n" +
                "3.Get down at Chinese restaurant\n");

        advisors = new ArrayList<>();
        advisors.add("Name:Sidra");// \n Number: 234234 \n Email: kfghkfjgh@dkjfhkgjh.com");
        advisors.add("Name:Gleson");// \n Number: 234234 \n Email: kfghkfjgh@dkjfhkgjh.com");
        advisors.add("Name:Amanda");// \n Number: 234234 \n Email: kfghkfjgh@dkjfhkgjh.com");
        advisors.add("Name:Nicole");// \n Number: 234234 \n Email: kfghkfjgh@dkjfhkgjh.com");
        }catch(Exception e){
            Log.i("Error:",e.getMessage(),e);
        }

    }
}
