package common;

public class App {


    /**
     * 2020-02-05
     * 1。equals方法：自反性、对称性、传递性、一致性、null特点，需要的域去比较
     * 2。覆盖equals方法，必须覆盖hashcode方法：equals相同，hashcode必须相同；equals不同，hashcode不一定不同；实现逻辑要使用相同的域
     * 3。散列表：散列码，散列函数（尽量保证equals不同，hashcode不同），列入hashtable，hashmap，hashset
     *
     * 4。浅拷贝：
     * 基本类型复制值copy，引用类型复制内存地址（指向同一地址，不开辟新的内存，改变原对象的属性，新的对象也会改变）
     * 实现方式：
     *   1：构造函数传入对象
     *   2：clone  （实现Cloneable接口，重写clone方法，super.clone）
     * 5。深拷贝：基本类型复制值copy，引用类型创建新的对象，开辟新内存（改变原对象的属性，新的对象属性不会改变）
     * 实现方式：
     *   1。重写clone方法，与浅拷贝思路一样，需要为对象图的每一层的每个对象都实现Cloneable接口并重写clone方法，最后在顶层对象重写的clone方法中调用所有的clone方法实现深拷贝
     *   2。通过对象序列化实现深拷贝
     *
     * 6。Comparable<T>.compareTo(T o)
     */

    public static void main(String[] args) {
        String url = "https://pic1.58cdn.com.cn/mobile/big/n_v20e930b4b7d46465c9868ee0cff6d942a.jpg?t=1";
        if (url.contains("?")){
            String res = url.substring(0,url.indexOf("?") + 1);
            System.out.println(res + "w=300");
        }

    }
}
