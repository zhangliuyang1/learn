/**
 * @Author: zhangliuyang01
 * @Date: 2021/4/29 下午5:10
 */
public class StringTest {

    public static void main(String[] args) {
        String a = "hellosfdfsdfds";

        int i = a.indexOf("llo") + "llo".length();
        int length = a.length();

        System.out.println(a.substring(i));
    }
}
