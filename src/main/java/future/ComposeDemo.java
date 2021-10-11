package future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/6/9 下午3:19
 */
public class ComposeDemo {

    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "hello");


        CompletableFuture<String> compose = future
                .thenCompose(a -> CompletableFuture.supplyAsync(() -> a + " world"))
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s +" i am evil"));
        try {
            System.out.println(compose.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        CompletableFuture<String> combine = future
                .thenCombine(CompletableFuture.supplyAsync(() -> " word"), (s1, s2) -> s1 + s2);
        try {
            System.out.println(combine.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        try {
            future.thenAccept(System.out::println).get();
            System.out.println(future.thenApply(a -> a + " world").get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
