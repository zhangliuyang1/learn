package arithmetic._sort;

import com.alibaba.fastjson.JSON;

/**
 * @author: zhangliuyang01
 * @date: 2023/3/29 11:36
 */
public class MergeS {
    public static void main(String[] args) {
        int[] arr = new int[]{8,1,4,9,3,2,5};
        mergeSort(arr,0,arr.length-1);
        System.out.println(JSON.toJSONString(arr));
    }


    /**
     * 归并
     *
     * 分而治之：先分解，再合并
     * @param arr
     * @param left
     * @param right
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {

            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[arr.length];
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i<=mid){
            temp[k++] = arr[i++];
        }

        while (j<=right){
            temp[k++] = arr[j++];
        }

        for (k = left; k <= right; k++) {
            arr[k] = temp[k];
        }

        System.out.println(JSON.toJSONString(arr));
    }
}
