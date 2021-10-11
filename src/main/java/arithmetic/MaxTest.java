package arithmetic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/3/9 23:21
 */
public class MaxTest {

    public static void main(String[] args) {
//        int[] arr = {7, 3, 1, 2, 6, 5, 8, 9, 10};
//
//        int[] nums = {2,5,5,10};
//
//        System.out.println(Arrays.toString(calc(nums, 10)));

//        System.out.println(maxProfit(arr));
//        System.out.println(maxProfilt2(arr));
        int a =0;
        for (int i = 0; i < 10; i++) {
            System.out.println(a++);
        }
        System.out.println("=======");
//        for (int i = 0; i < 10; ++i) {
//            int a = i;
//            System.out.println(a);
//        }

    }


    public static int maxProfit(int arr[]) {
        int maxPro = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                maxPro = Math.max(maxPro, arr[j] - arr[i]);
            }
        }
        return maxPro;
    }

    public static int maxProfilt2(int arr[]) {
        int maxPro = 0;
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else {
                maxPro = Math.max(maxPro, arr[i] - min);
            }
        }
        return maxPro;
    }

    public static int[] calc(int[] nums,int target){
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                int sum = nums[i] + nums[j];
//                if (sum == target){
//                    System.out.println("i=" + i + ";j=" + j);
//                }
//            }
//        }

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if (map.containsKey(sub) && map.get(sub) != i){
                return new int[] { i, map.get(sub) };
            }
        }

//
//        for (int i = 0; i < nums.length; i++) {
//            int sub = target - nums[i];
//            if (map.containsKey(sub)){
//                return new int[]{i,map.get(sub)};
//            }
//            map.put(nums[i],i);
//        }

        return new int[2];
    }
}
