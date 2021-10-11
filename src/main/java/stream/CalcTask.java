package stream;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/12/31 下午3:55
 */
public class CalcTask extends RecursiveTask<List<String>> {

    private List<Long> list;

    public CalcTask(List<Long> list) {
        this.list = list;
    }

    @Override
    protected List<String> compute() {
        List<String> l = list.parallelStream().map(a -> {
            Thread thread = Thread.currentThread();
            System.out.println(thread.getClass() + "===" + thread.getName() + "===" + thread.getId());
            return thread.getClass() + "===" + thread.getName() + "===" + thread.getId();
        }).collect(Collectors.toList());

        return l;
    }


    public static void main(String[] args) throws Exception{
        List<Long> list = LongStream.rangeClosed(0, 50).boxed().collect(Collectors.toList());
        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
//        ForkJoinTask<List<String>> task = pool.submit(()-> {
//            List<String> l = list.parallelStream().map(a -> {
//                Thread thread = Thread.currentThread();
//                System.out.println(thread.getClass() + "===" + thread.getName() + "===" + thread.getId());
//                return thread.getClass() + "===" + thread.getName() + "===" + thread.getId();
//            }).collect(Collectors.toList());
//            return l;
//        });
//        task.get();

        ForkJoinTask<List<String>> submit = pool.submit(new CalcTask(list));
        submit.get();

    }
}
