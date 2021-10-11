package future;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/6/9 下午2:45
 */
public class FutureDemo {

    public static void main(String[] args) throws Exception{
        List<CompletableFuture<Integer>> list = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            list.add(CompletableFuture.supplyAsync(() ->finalI));
        }

        List<Integer> collect = list.stream().map(CompletableFuture::join).collect(Collectors.toList());
        System.out.println(JSONObject.toJSONString(collect));


    }
}
