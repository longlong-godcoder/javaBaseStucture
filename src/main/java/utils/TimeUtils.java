package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    private static final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");

    public interface Task{
        void execute();
    }

    public static void test(String title, Task task){
        if (task == null) return;
        title = (title == null) ? "default" : ("[" + title + "]");
        System.out.println("-------------------------------------");
        System.out.println("Task: " + title);
        System.out.println("starting: " + format.format(new Date()));
        long startTimestamp = System.currentTimeMillis();
        task.execute();
        long endTimestamp = System.currentTimeMillis();
        System.out.println("end: " + format.format(new Date()));
        double delta = (endTimestamp - startTimestamp) / 1000.0;
        System.out.println("Time cost: " + delta + "seconds");
        System.out.println("-------------------------------------");
    }
}
