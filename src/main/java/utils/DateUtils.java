package utils;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.Date;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/5/12 15:54
 */
public class DateUtils {


    /**
     * 以当前周周一的月份为标准
     *
     * @param date
     * @return
     */
    public static int getMonthForGift(Date date) {
        Date monday = startTimeOfCurrentWeek(date);
        LocalDate localDate = monday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//        LocalDate localDate = LocalDateTime.ofInstant(monday.toInstant(), ZoneId.systemDefault());
        System.out.println(localDate.getMonth().getValue());
        return localDate.getMonthValue();
    }

    public static int getWeekForGift(Date date) {
        int week = 1;
        LocalDateTime dateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        dateTime.toEpochSecond(ZoneOffset.of("+8"));
        LocalDate localDate = dateTime.toLocalDate();

        // 当月1号
        LocalDate firstDay = LocalDate.of(dateTime.getYear(), dateTime.getMonthValue(), 1);

        DayOfWeek weekDay = firstDay.getDayOfWeek();
        // 当月1号是一周中的第几天
        int n = weekDay.getValue();

        int sunday = 7;
        // 当月1号这周的最后一天
        LocalDate sundaydd = firstDay.plusDays(7 - n);

        // 当月1号不是周一 并且当前时间 大于 第一周周末
        if (n != 1) {
            if (localDate.compareTo(sundaydd) > 0) {
                int sub = 7 - n + 1;
                int divisor = localDate.getDayOfMonth() - sub;
                int i = divisor % 7;
                week = i == 0 ? divisor / 7 : divisor / 7 + 1;
            } else if (localDate.compareTo(firstDay) >= 0 && localDate.compareTo(sundaydd) <= 0) {
                // 按上个月计算
                LocalDate lastMonthDay = firstDay.minusDays(1);
                return getWeekForGift(Date.from(lastMonthDay.atStartOfDay(ZoneId.systemDefault()).toInstant()));
            }
        } else {
            int i = localDate.getDayOfMonth() % 7;
            week = i == 0 ? localDate.getDayOfMonth() / 7 : localDate.getDayOfMonth() / 7 + 1;
        }
        return week;
    }


    public static void main(String[] args) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = simpleDateFormat.parse("2020-04-27");
        Date date2 = simpleDateFormat.parse("2020-04-30");
        Date date3 = simpleDateFormat.parse("2020-05-01");
        Date date4 = simpleDateFormat.parse("2020-05-03");
        Date date5 = simpleDateFormat.parse("2020-05-04");
        Date date6 = simpleDateFormat.parse("2020-05-10");
        Date date7 = simpleDateFormat.parse("2020-05-11");
        Date date8 = simpleDateFormat.parse("2020-05-31");
        System.out.println(startTimeOfCurrentWeek(date1));
        System.out.println(startTimeOfCurrentWeek(date2));
        System.out.println(startTimeOfCurrentWeek(date3));
        System.out.println(startTimeOfCurrentWeek(date4));
        System.out.println(startTimeOfCurrentWeek(date5));
//
//        System.out.println(getWeekForGift(date1));
//        System.out.println(getWeekForGift(date2));
//        System.out.println(getWeekForGift(date3));
//        System.out.println(getWeekForGift(date4));
//        System.out.println(getWeekForGift(date5));
//        System.out.println(getWeekForGift(date6));
//        System.out.println(getWeekForGift(date7));
//        System.out.println(getWeekForGift(date8));

//        LocalDate localDate = LocalDate.of(2020, 5, 3);
//
//
//        Date date9 = simpleDateFormat.parse("2020-05-07");
//        Date date10 = simpleDateFormat.parse("2020-05-06");
//        Date date11 = simpleDateFormat.parse("2020-05-05");
//        Date date12 = simpleDateFormat.parse("2020-05-03");
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date12);
//        int i = calendar.get(Calendar.WEEK_OF_MONTH);
//
//        System.out.println(i);

//        LocalDateTime localDateTime = LocalDateTime.now();
//
//        Date from = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
//
//        System.out.println(localDateTime);
//        System.out.println(from);
//
//
//        LocalDateTime localDateTime1 = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//        System.out.println(localDateTime1);
//
//        LocalDate localDate = LocalDate.of(2020, 3, 1);
//        LocalDate localDate1 = LocalDate.of(2020, 3, 8);
//        LocalDate localDate2 = LocalDate.of(2020, 3, 15);
//        LocalDate localDate3 = LocalDate.of(2020, 3, 22);
//        LocalDate localDate4 = LocalDate.of(2020, 3, 29);
//        LocalDate localDate5 = LocalDate.of(2020, 4, 5);
//        LocalDate localDate6 = LocalDate.of(2020, 3, 30);
//
//        System.out.println(week(localDate));
//        System.out.println(week(localDate1));
//        System.out.println(week(localDate2));
//        System.out.println(week(localDate3));
//        System.out.println(week(localDate4));
//        System.out.println(week(localDate5));
//        System.out.println(week(localDate6));


    }


    public static Date startTimeOfCurrentWeek(Date date) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int value = localDate.getDayOfWeek().getValue();
        // 如果是周一，则直接返回
        if (value == 1) {
            return date;
        } else {
            // 如果不是周一，则计算出本周一的日期
            int n = value - 1;
            LocalDate firstDayOfWeek = localDate.minusDays(n);
            return Date.from(firstDayOfWeek.atStartOfDay(ZoneId.systemDefault()).toInstant());
        }


//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        // 解决周日会出现 并到下一周的情况
//        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
//        if (1 == dayOfWeek) {
//            calendar.add(Calendar.DAY_OF_MONTH, -1);
//        }
//        calendar.setFirstDayOfWeek(Calendar.MONDAY);
//        int day = calendar.get(Calendar.DAY_OF_WEEK);
//        calendar.add(Calendar.DATE, calendar.getFirstDayOfWeek() - day);
//        calendar.set(Calendar.HOUR_OF_DAY, 0);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        calendar.set(Calendar.MILLISECOND, 0);
//        return calendar.getTime();
    }


    public static int week(LocalDate localDate) {
//        LocalDate localDate = LocalDate.of(2020, 7, 1);
        WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY, 7);
        int i = localDate.get(weekFields.weekOfMonth());
        if (i == 0) {
            LocalDate pre = localDate.minusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
            return pre.get(weekFields.weekOfMonth());
        } else {
            return i;
        }
    }

}
