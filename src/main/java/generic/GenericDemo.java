package generic;

import extend.People;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/6/29 上午10:46
 */
public class GenericDemo<T> {

    private T t;

    private String id;

    private String name;

    public GenericDemo(T t, String id, String name) {
        this.t = t;
        this.id = id;
        this.name = name;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        GenericDemo<People> demo = new GenericDemo<>(new People(),"1","zzz");


    }
}
