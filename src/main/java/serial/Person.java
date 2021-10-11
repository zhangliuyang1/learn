package serial;

import java.io.Serializable;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/6/1 下午4:42
 */
public class Person implements Serializable {

    private int age;

    private String sex;


    public static String hello(){
        return "hello";
    }



    public Person(int age, String sex) {
        this.age = age;
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
