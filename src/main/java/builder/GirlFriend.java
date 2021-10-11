package builder;

import java.util.*;
import java.util.function.Function;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/3/29 下午4:55
 */
public class GirlFriend {

    private int height;
    private int weight;
    private List<String> hobbys;

    private String name;

    private int age;

    private Map<String,String> gift;


    public static String kiss(String bf,String time,Function<String,String> f){
        String apply = f.apply(bf);
        return apply;
    }


    public void addHobby(String hobby){
        this.hobbys = Optional.ofNullable(this.hobbys).orElse(new ArrayList<>());
        this.hobbys.add(hobby);
    }

    public void addGift(String day,String gift){
        this.gift = Optional.ofNullable(this.gift).orElse(new HashMap<>());
        this.gift.put(day, gift);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<String> getHobbys() {
        return hobbys;
    }

    public void setHobbys(List<String> hobbys) {
        this.hobbys = hobbys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public Map<String, String> getGift() {
        return gift;
    }

    public void setGift(Map<String, String> gift) {
        this.gift = gift;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "height=" + height +
                ", weight=" + weight +
                ", hobbys=" + hobbys +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gift=" + gift +
                '}';
    }
}
