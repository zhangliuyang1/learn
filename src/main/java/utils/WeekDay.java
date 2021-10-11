package utils;

import org.joda.time.DateTime;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/7/8 16:39
 */
public class WeekDay {


    public static void main(String[] args) {
        DateTime time = DateTime.now();
        int dayOfWeek = time.getDayOfWeek();

        System.out.println(time.toString());
        System.out.println(dayOfWeek);
    }
}


