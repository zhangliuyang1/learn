package spring.ioc;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/9/1 10:38
 */
public class People {

    private String sex;

    private int age;

    private String career;

    private Food food;


    public People() {
    }

    public People(String sex, int age, String career) {
        this.sex = sex;
        this.age = age;
        this.career = career;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
//
//    @Override
//    public String toString() {
//        return "People{" +
//                "sex='" + sex + '\'' +
//                ", age=" + age +
//                ", career='" + career + '\'' +
//                ", food=" + food +
//                '}';
//    }
}
