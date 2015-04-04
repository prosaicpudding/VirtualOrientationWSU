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


    public static void loadTasks(){
        reqtasksdetails=new ArrayList<>();
        unreqtasksdetails=new ArrayList<>();
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
        unreqtasksdetails.add("1. Go to Bus Stop\n" +
                "2.Take express 2 or 1\n" +
                "3.Get down at walmart\n");
        unreqtasksdetails.add("1. Go to Bus Stop\n" +
                "2.Take express 2 or 1\n" +
                "3.Get down at enterprise rentals\n");
        unreqtasksdetails.add("1. Go to Bus Stop\n" +
                "2.Take express 2 or 1\n" +
                "3.Get down at Chinese restaurant\n");
    }
}
