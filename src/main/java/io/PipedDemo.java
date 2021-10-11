package io;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import utils.DateUtils;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/6/11 上午11:20
 */
public class PipedDemo {


    public static void main(String[] args) throws Exception{
//        PipedReader pipedReader = new PipedReader();
//        try {
//            pipedReader.connect(new PipedWriter());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        System.out.println(System.currentTimeMillis());
        System.out.println(new Date(1320681600000L));
        long l = System.currentTimeMillis();
        System.out.println(l);
        System.out.println(1320681600000L);
        System.out.println(l - 1320681600000L);
//        System.out.println(System.currentTimeMillis() - 1320681600000L);

        String format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);

        Date parse = dateFormat.parse("2021-06-14 20:12:07");
        Date parse1 = dateFormat.parse("2021-06-14 20:12:03");


        System.out.println(parse.getTime());
        System.out.println(parse1.getTime());
    }
}
