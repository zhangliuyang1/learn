package shorturl;


import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/8/12 上午11:29
 */
public class ShortUrlUtils {


    private static final char[] DIGITS = {'0','1','2','3','4','5','6','7','8','9',
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n',
            'o','p','q','r','s','t','u','v','w','x','y','z',
            'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
            'O','P','Q','R','S','T','U','V','W','X','Y','Z',};

    public static String base62(long count){
        StringBuilder builder = new StringBuilder();
        while (count > 0){
            builder.append(DIGITS[(int) (count % 62)]);
            count /= 62;
        }

        return builder.toString();
    }


    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        for (int i = 0; i < 1000000000; i++) {
            System.out.println(base62(i));
            set.add(base62(i));
        }

        System.out.println(set.size());

    }
}
