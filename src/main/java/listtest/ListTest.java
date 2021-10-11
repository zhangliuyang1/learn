package listtest;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/5/6 下午5:16
 */
public class ListTest {


    public static void main(String[] args) {

        List<String> list = Lists.newArrayList("a", "b", "c", "d", "e");

        List<String> list1 = list.subList(2, 4);

        System.out.println(list);
        System.out.println(list1);


        list1.set(0,"hh");
        System.out.println(list);
        System.out.println(list1);



        list1.add("jj");
        System.out.println(list);
        System.out.println(list1);

        List<String> collect = list.stream().skip(1).limit(3).collect(Collectors.toList());
        System.out.println(collect);

        System.out.println(0x7fffffff);
        System.out.println(Integer.MIN_VALUE);
        int   HASH_BITS = 0x7fffffff;
        String key = "name";
        int h = key.hashCode();

        int m = h >>> 16;
        int n = h ^ m;

        int res = (h ^ (h >>> 16)) & HASH_BITS;
        System.out.println(res);

        ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
        map.put("a","b");


    }
}
