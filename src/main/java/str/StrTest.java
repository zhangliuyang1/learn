package str;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/7/26 下午12:54
 */
public class StrTest {

    public static void main(String[] args) {
        String a = "http://tznew.58.com/<>\"";
        String replace = a.replace("<", "\\<")
                .replace(">", "\\>")
                .replace("\"", "\\\"")
                .replace("'", "\\'");
        System.out.println(replace);
    }
}
