package builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/3/29 下午4:30
 */
public class Builder<T> {

    private final Supplier<T> instantiaor;

    private List<Consumer<T>> modifiers = new ArrayList<>();

    public Builder(Supplier<T> instantiaor) {
        this.instantiaor = instantiaor;
    }

    public static <T> Builder<T> of(Supplier<T> supplier) {
        return new Builder<>(supplier);
    }


    public <P1> Builder<T> with(Consumer1<T, P1> consumer, P1 p1) {
        Consumer<T> c = instance -> consumer.accept(instance, p1);
        modifiers.add(c);
        return this;
    }

    public <P1, P2> Builder<T> with(Consumer2<T, P1, P2> consumer, P1 p1, P2 p2) {
        Consumer<T> c = instance -> consumer.accept(instance, p1, p2);
        modifiers.add(c);
        return this;
    }

    public <P1, P2, P3> Builder<T> with(Consumer3<T, P1, P2, P3> consumer, P1 p1, P2 p2, P3 p3) {
        Consumer<T> c = instance -> consumer.accept(instance, p1, p2, p3);
        modifiers.add(c);
        return this;
    }

    public T build(){
        T t = instantiaor.get();
        modifiers.forEach(tConsumer -> tConsumer.accept(t));
        modifiers.clear();
        return t;
    }


    @FunctionalInterface
    public interface Consumer1<T, P1> {
        void accept(T t, P1 p1);
    }

    @FunctionalInterface
    public interface Consumer2<T, P1, P2> {
        void accept(T t, P1 p1, P2 p2);
    }

    public interface Consumer3<T, P1, P2, P3> {
        void accept(T t, P1 p1, P2 p2, P3 p3);
    }
}

