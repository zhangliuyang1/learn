package parseq;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/8/25 16:14
 */
public class People {

    private int age;

    private String sex;

    private String height;

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

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "People{" +
                "age=" + age +
                ", sex='" + sex + '\'' +
                ", height='" + height + '\'' +
                '}';
    }
}
