package arithmetic.other;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author: zhangliuyang01
 * @date: 2023/3/24 09:57
 */
public class BubbleSort {
    public static void main(String[] args) {

        int a[] = new int[]{1,2,3,5,8,13,21,34};

        int arr[] = new int[]{10, 6, 7, 9, 3, 5, 8};
        System.out.println(JSON.toJSONString(arr));
        chooseSort(arr);

    }

    /**
     * 插入排序
     * 1.每次倒序遍历前n个，比arr[n]大的值，依次往后放6
     * 2.最后把arr[n] 放到合适位置（前面没有比他大）
     * @param arr
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1]) {
                continue;
            }
            int temp = arr[i];
            int j = i;
            for (; j > 0; j--) {
                if (temp < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                    System.out.println(JSONObject.toJSON(arr));
                    continue;

                }
                break;
            }

            arr[j] = temp;
            System.out.println(JSONObject.toJSON(arr));
        }
    }

    /**
     * 1.循环比较相邻的元素，每一遍大循环会把最大值放到后面
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }

            }
            System.out.println(JSONObject.toJSON(arr));
        }
    }

    public static void chooseSort2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }

        }

    }

    /**
     * 选择排序
     * 1.每次遍历找到最小值的index
     * 2.交换i offset和index的值
     * @param arr
     */
    public static void chooseSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < temp) {
                    temp = arr[j];
                    minIndex = j;
                }
            }
            arr[minIndex] = arr[i];
            arr[i] = temp;
            System.out.println(JSON.toJSONString(arr));

        }
        System.out.println(JSON.toJSONString(arr));
    }

    public static void otherSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    continue;
                }
                break;

            }
            System.out.println(JSONObject.toJSON(arr));
        }

    }
}
