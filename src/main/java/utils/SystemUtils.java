package utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/12/26 下午2:27
 */
public class SystemUtils {

    public static void main(String[] args) {
//        System.out.println(System.getenv());
//        System.out.println("=====");
//        System.out.println(System.getProperties());
//
//        Date date = new Date();
//
//        LocalDate localDate = LocalDate.from(date.toInstant().atZone(ZoneId.systemDefault()));
//
//        System.out.println(date);
//        System.out.println(localDate);
//
//        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
//        Date from = Date.from(zonedDateTime.toInstant());
//        System.out.println(from);
        getCpuCount();
    }


    private static int getCpuCount(){
        System.out.println(Runtime.getRuntime().availableProcessors());
//        Runtime.getRuntime().exec()
        return 0;
    }
}
