package abs;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/4/22 下午3:50
 */
public abstract class AbstractAnimal {


    String hello(){
        System.out.println("hello");
        return "hello";
    }

    public static AbstractAnimal newInstance(){
        return new AbstractAnimal() {
        };
    }


    public static void main(String[] args) {
//        AbstractAnimal abstractAnimal = new AbstractAnimal() {
//        };
//        abstractAnimal.hello();
//        AbstractAnimal.newInstance().hello();
        int sum = 10504 + 6690+4314+3336+  2793+2274+2411+2606+3502+6052+10961+16038+23591+31245+33072+31194+30202
                +29925 +28957+26435+26374+32234+43383+28377+32003+35970+34737+31835+31448+30155+27829+28008+9093;
        System.out.println(sum);
    }

}
