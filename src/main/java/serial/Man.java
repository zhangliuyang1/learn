package serial;

import java.io.Serializable;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/6/1 下午4:42
 */
public class Man implements Serializable {

    private static final long serialVersionUID = 55L;

    private String height;
    private String weight;


    public String hello(){
        return "hello";
    }


    public Man(String height, String weight) {
        this.height = height;
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Man{" +
                "height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}
