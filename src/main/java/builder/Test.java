package builder;

import java.util.*;

public class Test {

    public static void main(String[] args) {

//
//        People people = new People.Builder("1","zzzlllyyy")
//                .sex("man")
//                .hw("170","65")
//                .others("brown","big").build();
//
//        System.out.println(people.toString());

        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }

        System.out.println(set);
        System.out.println(list);
        for (int i = 0; i < 3; i++) {
            set.remove(i);
            list.remove(i);
        }
        System.out.println(set);
        System.out.println(list);
    }


}
