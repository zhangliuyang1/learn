package arithmetic;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/3/10 15:28
 */
public class BinarySearch {


    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 4, 5, 6, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(arr, 15)));
    }

    public static int[] twoSum(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        int left = 0;
        int right = nums.length - 1;
//        int index = 0;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{++left, ++right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[2];
    }



}
