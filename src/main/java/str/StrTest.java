package str;

import org.roaringbitmap.RoaringBitmap;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/7/26 下午12:54
 */
public class StrTest {

    public static void main(String[] args) {
//        String a = "http://tznew.58.com/<>\"";
//        String replace = a.replace("<", "\\<")
//                .replace(">", "\\>")
//                .replace("\"", "\\\"")
//                .replace("'", "\\'");
//        System.out.println(replace);
//
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
//        long maxValue = Integer.MAX_VALUE;
//        long minValue = Integer.MIN_VALUE;
//        System.out.println(maxValue+Math.abs(minValue));

        RoaringBitmap map1 = RoaringBitmap.bitmapOf(1,2,3,1000);
        RoaringBitmap map2 = new RoaringBitmap();
        map2.add(4000L,4255L);

        System.out.println(map1.select(3));
        System.out.println(map1.rank(2));
        System.out.println(map1.contains(1000));
        System.out.println(map1.contains(7));

        System.out.println(map1.getLongCardinality());
        System.out.println(map2.contains(4002));
//        for (Integer integer : map2) {
//            System.out.println(integer);
//        }
        System.out.println("map1.foreach");

        for (Integer integer : map1) {
            System.out.println(integer);
        }

    }
}
