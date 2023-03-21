package arithmetic.other;

import java.util.Arrays;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/4/14 15:05
 */
public class PlusOne {

    public static void main(String[] args) {

        int[] arr = {0};

        System.out.println(Arrays.toString(plusOne(arr)));
    }


    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] % 10 != 0){
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
