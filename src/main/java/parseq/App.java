package parseq;

import com.linkedin.parseq.Task;
import com.linkedin.parseq.Tuple2Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/8/25 15:48
 */
public class App {


    public static void main(String[] args) {
        ParseqEngine.init();

//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
//        List<Integer> collect = list.stream().map(a -> Task.callable(() -> a + 1)).parallel().map(ParseqEngine::run).collect(Collectors.toList());
//
//        System.out.println(list);
//        System.out.println(collect);


//        List<Task> tasks = new ArrayList<>();
        long start = System.currentTimeMillis();
        People people = new People();
//        Task<Integer> ageTask = Task.callable(App::getAge);
//        Task<String> sexTask = Task.callable(App::getSex);
//        tasks.add(ageTask);
//        tasks.add(sexTask);
//        Object collect = tasks.parallelStream().map(ParseqEngine::run).collect(Collectors.toList());
//        System.out.println(collect);
        Tuple2Task<Integer, String> tuple2Task = Task.par(Task.callable(() -> getAge()), Task.callable(App::getSex));
//        tuple2Task.map
        Task<People> peopleTask = tuple2Task.map((a, b) ->{
            people.setAge(a);
            people.setSex(b);
            return people;
        });
//        ParseqEngine.run(peopleTask);

//        people.setAge(ParseqEngine.run(ageTask));
//        people.setSex(ParseqEngine.run(sexTask));
//        System.out.println(people);

        System.out.println(System.currentTimeMillis() - start);

    }



    public static int getAge(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 5;
    }


    public static String getSex(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "male";
    }

    public static String getHeigh(){
        return "170cm";
    }


}
