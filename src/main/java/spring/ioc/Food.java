package spring.ioc;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/9/1 10:47
 */
public class Food {

    private String color;
    private String taste;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    @Override
    public String toString() {
        return "Food{" +
                "color='" + color + '\'' +
                ", taste='" + taste + '\'' +
                '}';
    }
}
