package shorturl;

/**
 * 65-90 -> A-Z
 * 97-122 -> a-z
 * @Author: zhangliuyang01
 * @Date: 2021/8/12 下午7:33
 */
public class CharToLetter {
    public static void main(String[] args) {

        char[] chars = new char[26];
        for (int i = 65; i < 91; i++) {
            chars[i-65] = (char) i;
        }


        String str = "";
        for (char c : chars) {
            str = str + "'" + c + "',";
        }
        System.out.println(str);
    }
}
