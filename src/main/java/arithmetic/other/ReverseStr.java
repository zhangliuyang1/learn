package arithmetic.other;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/4/16 15:30
 */
public class ReverseStr {


    public static void main(String[] args) {

        String str = "the sky is blue";
        System.out.println(resverseOne(str));
    }


    public static String resverseOne(String str){
        String[] split = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0 ; i--) {
            sb.append(split[i]);
            if (i != 0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
