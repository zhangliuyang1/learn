package SnowFlake;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/2/18 下午4:52
 */
public class SnowflakeUtils {

    /**
     * 定义起始时间 2015-01-01 00:00:00
     */
    private static final long START_TIME = 1420041600000L;

    /**
     * 上次生成ID的时间截
     */
    private static long LAST_TIME_STAMP = -1L;


    private static final long DATA_ID = getDataId();
    private static final long WORK_ID = getWordId();


    private static long LAST_SEQ = 0L;


    public static long genId() {
        long now = System.currentTimeMillis();

        //如果当前时间小于上一次ID生成的时间戳，说明系统时钟回退过这个时候应当抛出异常
        if (now < LAST_TIME_STAMP) {
            throw new RuntimeException(String.format("系统时间错误！ %d 毫秒内拒绝生成雪花ID！", START_TIME - now));
        }

        if (now == LAST_TIME_STAMP) {
            LAST_SEQ = LAST_SEQ + 1L & 4095L;
            if (LAST_SEQ > 4095L) {
                now = nextMillis(LAST_TIME_STAMP);
                LAST_SEQ = 0L;
            }
        } else {
            LAST_SEQ = 0;
        }

        //上次生成ID的时间截
        LAST_TIME_STAMP = now;

        long timePart = now - START_TIME;

        return (now << 22) | (DATA_ID << 17) | (WORK_ID << 12) | LAST_SEQ;
    }


    public static long nextMillis(long lastMillis) {
        long now = System.currentTimeMillis();
        while (now <= lastMillis) {
            now = System.currentTimeMillis();
        }
        return now;
    }

    private static int getHostId(String s, int max) {
        byte[] bytes = s.getBytes();
        int sum = 0;
        for (byte aByte : bytes) {
            sum += aByte;
        }
        return sum % max;
    }


    /**
     * 根据 host address 取余，发生异常就获取 0到31之间的随机数
     */
    public static int getWordId() {
        try {
            return getHostId(Inet4Address.getLocalHost().getHostAddress(), 31);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return new Random().nextInt(31);
        }
    }

    /**
     * 根据 host name 取余，发生异常就获取 0到31之间的随机数
     */
    public static int getDataId() {
        try {
            return getHostId(Inet4Address.getLocalHost().getHostName(), 31);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return new Random().nextInt(31);
        }
    }


    public static void main(String[] args) {
//        try {
//            System.out.println(getHostId(Inet4Address.getLocalHost().getHostAddress(),31));
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//        for (int i = 0; i < 20; i++) {
//            long l = genId();
//            System.out.println(l);
//        }

//        System.out.println(1&4095);
//        System.out.println(2&4095);
//        System.out.println(3&4095);
//        System.out.println(4&4095);
//        System.out.println(5&4095);
//        System.out.println(4096&4095);

//        long workId = time % 1024;
//        long seqMax = 4095;
//
//        long v = time << 22 | workId << 12 | seqMax;
//        for (int i = 0; i <= seqMax; i++) {
//            long a = time << 22 | workId << 12 | i;
//            System.out.println(a);
//            System.out.println(LongUtils.toBinary(a));
//        }
        for (int i = 0; i < 100; i++) {
            long time = System.currentTimeMillis();
            System.out.println(time);

            System.out.println(Long.toBinaryString(time));
            System.out.println(Long.toBinaryString(time).length());
            System.out.println(time << 22);
            System.out.println(LongUtils.toBinary(time << 22));


            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

}
