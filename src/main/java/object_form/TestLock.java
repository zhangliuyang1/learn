package object_form;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/3/17 20:32
 */
public class TestLock {

    public void m0(){
        synchronized (this){
            System.out.println("11");
        }
    }

    public static synchronized void m1(){

    }

    public synchronized void m2(){

    }

    public static void main(String[] args) {
//        System.out.println(68984849417479L & 15);
        String a = "x-errno";
        String b = "X-ErrNo";
        System.out.println(b.equalsIgnoreCase(a));
    }



}
