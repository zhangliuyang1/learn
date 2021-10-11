package arithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zhangliuyang01
 * @Date: 2020/3/13 23:36
 */
public class MajorityElement {


    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 2};
        System.out.println(two(nums));
    }

    public static int majorityElement(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
                if (map.get(nums[i]) > nums.length / 2) {
                    res = nums[i];
                }
            } else {
                map.put(nums[i], 1);
            }
        }

        return res;

    }


    public static int two(int[] nums) {



        int res = nums[0];
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                res = nums[i];
                count++;
            } else {
                if (res == nums[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return res;
    }
}
