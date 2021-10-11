package object_form;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 对象的布局-对象的组成
 * 实例数据
 * 对象头：
 * mark word ： 8字节  gc状态， hashcode，锁信息
 * unused:25  hashcode:31  age:4  unused:1 bised_lock:1 lock:2
 *
 * klass pointer：4字节
 *
 * 数据对齐(保证是8的倍数)
 *
 *
 * @Author: zhangliuyang01
 * @Date: 2020/3/17 20:31
 */
public class Demo implements Runnable {


    private int count = 0;

    @Override
    public void run() {
        synchronized (TestLock.class) {
            count++;
        }

    }

    public static void main(String[] args) {
//        ClassLayou
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(i);
            list.remove(list.get(i));
            System.out.println("list size:" + list.size());

        }

        System.out.println(Arrays.toString(list.toArray()));
    }
}
