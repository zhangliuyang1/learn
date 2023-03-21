package arithmetic.other;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/4/14 16:17
 */
public class AddBinary {

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a,b));
    }


    public static String addBinary(String a, String b) {


        int i = Integer.parseInt(a, 2);
        int i1 = Integer.parseInt(b, 2);
        return Integer.toBinaryString(i+i1);
    }
}
