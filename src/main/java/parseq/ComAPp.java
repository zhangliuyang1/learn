package parseq;

import java.util.concurrent.CompletableFuture;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/8/25 16:39
 */
public class ComAPp {


    public static void main(String[] args) throws Exception{
        long start = System.currentTimeMillis();
        CompletableFuture<Integer> ageTask = CompletableFuture.supplyAsync(App::getAge);
        CompletableFuture<String> sexTask = CompletableFuture.supplyAsync(App::getSex);

        People people = new People();
        people.setAge(ageTask.get());
        people.setSex(sexTask.get());

        System.out.println(System.currentTimeMillis() - start);


    }
}
