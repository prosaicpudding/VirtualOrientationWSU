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
    public static String notifyies[]={"Turn Notifications OFF","Turn Notifications ON"};
    public static int noti=0;

    public static void loadTasks(){
        try{
        reqtasksdetails=new ArrayList<>();
        unreqtasksdetails=new ArrayList<>();

        reqtasks =new ArrayList<>();
        reqtasks.add(new TaskItem("Log into Zzusis", DateUtils.parseDate("01/03/2015", new String[]{"MM/dd/yyyy"})));
        reqtasks.add(new TaskItem("Get Cougar Card", DateUtils.parseDate("01/13/2015",new String[]{"MM/dd/yyyy"})));
        reqtasks.add(new TaskItem("Fill out I4", DateUtils.parseDate("01/14/2015", new String[]{"MM/dd/yyyy"})));
        reqtasks.add(new TaskItem("Register for classes", DateUtils.parseDate("01/15/2015", new String[]{"MM/dd/yyyy"})));
        reqtasks.add(new TaskItem("Set up Direct Deposit", DateUtils.parseDate("01/14/2015", new String[]{"MM/dd/yyyy"})));
        reqtasks.add(new TaskItem("Activate your WSU email", DateUtils.parseDate("01/16/2015", new String[]{"MM/dd/yyyy"})));
        reqtasks.add(new TaskItem("Read program handbook", DateUtils.parseDate("01/14/2015", new String[]{"MM/dd/yyyy"})));
        reqtasks.add(new TaskItem("Pick up office key", DateUtils.parseDate("01/13/2015", new String[]{"MM/dd/yyyy"}),true));
        reqtasks.add(new TaskItem("Buy Books", DateUtils.parseDate("01/18/2015", new String[]{"MM/dd/yyyy"})));
        reqtasks.add(new TaskItem("Check on financial aid", DateUtils.parseDate("01/15/2015", new String[]{"MM/dd/yyyy"})));
        reqtasks.add(new TaskItem("Attend TA orientation", DateUtils.parseDate("01/17/2015", new String[]{"MM/dd/yyyy"})));
        reqtasks.add(new TaskItem("Join student association", DateUtils.parseDate("01/12/2015", new String[]{"MM/dd/yyyy"})));


        unreqtasks =new ArrayList<>();
        unreqtasks.add(new TaskItem("Visit the grizzly bears"));
        unreqtasks.add(new TaskItem("Join a club"));
        unreqtasks.add(new TaskItem("Download the CougTransit App",true));
        unreqtasks.add(new TaskItem("Check out the ice cream at Ferdinand's",true));
        unreqtasks.add(new TaskItem("Check out the Mexican food at Rancho Viejo",true));
        unreqtasks.add(new TaskItem("Look into on campus employment"));
        unreqtasks.add(new TaskItem("Go to the mall in Moscow",true));
        unreqtasks.add(new TaskItem("Visit Brused Books downtown",true));
        unreqtasks.add(new TaskItem("Buy a parking permit"));
        unreqtasks.add(new TaskItem("Load some CougarCash"));

        reqtasksdetails.add("1. Go to portal.wsu.edu\n" +
                "2. Your username will be [firstname].[lastname]"+"\n" +
                "3. Your password is the same one you used for your application\n" +
                "4. If you have trouble signing in, email helpdesk@wsu.edu\n");
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
                "3.Meet sidra at room 303\n");
        reqtasksdetails.add("1. Go to Sloan\n" +
                "2.Go to third floor\n" +
                "3.Meet sidra at room 303\n");
        reqtasksdetails.add("1. Go to Sloan\n" +
                "2.Go to third floor\n" +
                "3.Meet sidra at room 303\n");
        reqtasksdetails.add("1. Go to Sloan\n" +
                "2.Go to third floor\n" +
                "3.Meet sidra at room 303\n");
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
        unreqtasksdetails.add("1. Take Grand Ave. south, through downtown\n" +
                "2.Phikun's will be on the left hand side, right after the furniture store\n" +
                "3. Alternately, search Phikun's in Google maps\n"+
                "4. Try the avocado curry or the green curry");
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
        advisors.add("General: Sidra Gleason");// \n Number: 234234 \n Email: kfghkfjgh@dkjfhkgjh.com");
        advisors.add("Employment: Kelly Nigro");// \n Number: 234234 \n Email: kfghkfjgh@dkjfhkgjh.com");
        advisors.add("Registration: Matthew Zimmerman");// \n Number: 234234 \n Email: kfghkfjgh@dkjfhkgjh.com");

        }catch(Exception e){
            Log.i("Error:",e.getMessage(),e);
        }

    }
}
