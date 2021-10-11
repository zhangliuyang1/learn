package builder;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/3/29 下午4:58
 */
public class BuilderTest {


    public static void main(String[] args) {
        GirlFriend girlFriend = Builder.of(GirlFriend::new)
                .with(GirlFriend::setAge, 20)
                .with(GirlFriend::addHobby,"film")
                .with(GirlFriend::addHobby,"beauty")
                .with(GirlFriend::setHeight,20)
                .with(GirlFriend::setWeight,30)
                .with(GirlFriend::addGift,"2.14","mac")
                .with(GirlFriend::addGift,"7.7","gaidilao")
                .build();

        System.out.println(girlFriend);

        String kiss = GirlFriend.kiss("zz", "at", s -> s);
        System.out.println(kiss);

        Consumer consumer = o -> System.out.println(o);

        consumer.andThen(b -> System.out.println(b));
        consumer.accept("a");

    }

}
