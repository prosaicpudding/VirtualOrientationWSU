package com.client.wsu.shared;

import android.content.SharedPreferences;
import android.widget.CheckBox;

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

    public static String types[]={"Required","UnRequired"};

    public static int selectedId=-999;
    public static List<String> taskDetails;
    public static List<String> advisors;

    public static Map<CheckBox,Integer> cbintmap;
    public static int running=0;
    public static List<String> reqtasks;
    public static List<String> unreqtasks;

    public static List<String> reqtasksdetails;
    public static List<String> unreqtasksdetails;

    public static int postition=0;
    public static String notifyies[]={"Notifications OFF","Notifications ON"};
    public static int noti=0;

    public static void loadTasks(){
        reqtasksdetails=new ArrayList<>();
        unreqtasksdetails=new ArrayList<>();

        reqtasks =new ArrayList<>();
        reqtasks.add("Get Cougar Card : 1/13 # shared ");
        reqtasks.add("Submit W4 form : 1/14 # shared");
        reqtasks.add("Register for Classes : 1/15 ");
        reqtasks.add("Meet Sidra : 1/15");
        reqtasks.add("Attend seminar : 1/15");
        reqtasks.add("Register for exam : 1/15");
        reqtasks.add("Create Osble Account: 1/15");
        reqtasks.add("Buy Clicker : 1/15");
        reqtasks.add("Buy Books : 1/15");
        reqtasks.add("Visit Library : 1/15");
        reqtasks.add("Buy Freedom Board KL25Z : 1/15");
        reqtasks.add("Join student association : 1/15");
        reqtasks.add("Submit bio : 1/15");

        unreqtasks =new ArrayList<>();
        unreqtasks.add("Check Walmart # shared");
        unreqtasks.add("Check Car Rentals # shared");
        unreqtasks.add("Check Chinese Food");
        unreqtasks.add("Eat Ice-cream");
        unreqtasks.add("Get Mexican Food");
        unreqtasks.add("Go to dissmores");
        unreqtasks.add("Get Veggies");
        unreqtasks.add("Attend a party");
        unreqtasks.add("Buy bag");
        unreqtasks.add("Ride bus");

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

    }
}
