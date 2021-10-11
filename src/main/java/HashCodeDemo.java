import com.linkedin.parseq.Task;
import parseq.ParseqEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/8/26 13:52
 */
public class HashCodeDemo {
    public static void main(String[] args) {
//        String a = "aaaaa";
//        String aa = new String("aaaaa");
//        String b = "bbbbb";
//        System.out.println(a.hashCode());
//        System.out.println(aa.hashCode());
//        System.out.println(b.hashCode());;
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            a.add(i);
        }
//
//
        List<Integer> alist = new CopyOnWriteArrayList<>();
        List<Integer> blist = new ArrayList<>();
//
//        long start = System.currentTimeMillis();
//        a.parallelStream().forEach(alist::add);
//        long start2 = System.currentTimeMillis();
//        System.out.println(start2 - start);
//
//
//
//        a.forEach(integer -> blist.add(integer));
//        System.out.println(System.currentTimeMillis() - start2);
        ParseqEngine.init();

        long start = System.currentTimeMillis();
        a.parallelStream().forEach(i -> {
            alist.add(get());
        });
        long start2 = System.currentTimeMillis();
        System.out.println(alist);
        System.out.println(start2 - start);


        a.stream().forEach(i -> {
            blist.add(get());
        });
        long start3 = System.currentTimeMillis();
        System.out.println(blist);
        System.out.println(start3 - start2);

        List<Integer> collect = a.parallelStream().map(i -> Task.callable(() -> get())).map(ParseqEngine::run).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(System.currentTimeMillis() - start3);

    }


    public static int get() {
        int i = new Random().nextInt(10);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i;
    }
}
