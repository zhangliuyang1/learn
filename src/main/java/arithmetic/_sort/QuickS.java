package arithmetic._sort;

import com.alibaba.fastjson.JSON;

/**
 * @author: zhangliuyang01
 * @date: 2023/3/29 11:31
 */
public class QuickS {

    public static void main(String[] args) {
        int arr[] = new int[]{4, 6, 5, 2, 1, 3};
        quick(arr);
        System.out.println(JSON.toJSONString(arr));
    }


    /**
     * quick sort
     * 1.指定一个支点，比这个值小的放前面，比这个值大的放后面
     * 2.支点放到中间位置，分成两部分
     * 3.重复1，2
     *
     * @param arr
     */
    public static void quick(int[] arr) {
        quickInner(arr, 0, arr.length - 1);
    }

    public static void quickInner(int[] arr, int p, int r) {
//        if (p >= r) return;
//        int q = partition2(arr, p, r);
//        quickInner(arr, p, q - 1);
//        quickInner(arr, q + 1, r);

        partition2(arr, p, r);

    }

    //快排实现方法
    public static void quickRow(int[] array, int low, int high) {
        int i, j, pivot;
        //结束条件
        if (low >= high) {
            return;
        }
        i = low;
        j = high;
        //选择的节点，这里选择的数组的第一数作为节点
        pivot = array[low];
        while (i < j) {
            //从右往左找比节点小的数，循环结束要么找到了，要么i=j
            while (array[j] >= pivot && i < j) {
                j--;
            }
            //从左往右找比节点大的数，循环结束要么找到了，要么i=j
            while (array[i] <= pivot && i < j) {
                i++;
            }
            //如果i!=j说明都找到了，就交换这两个数
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        //i==j一轮循环结束，交换节点的数和相遇点的数
        array[low] = array[i];
        array[i] = pivot;
        //数组“分两半”,再重复上面的操作
        quickRow(array, low, i - 1);
        quickRow(array, i + 1, high);
    }

    public static int partition2(int[] arr, int p, int r) {
        if (p >= r) return 0;
        int pivot = arr[p];
        int i = p;
        int j = r;
        while (i < j) {
            while (arr[j] >= pivot && i < j) {
                j--;
            }
            while (arr[i] <= pivot && i < j) {
                i++;
            }

            if (i < j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }

        }

        arr[p] = arr[i];
        arr[i] = pivot;
        System.out.println(JSON.toJSONString(arr));
        partition2(arr, p, i - 1);
        partition2(arr, i + 1, r);

        return i;
    }

    /**
     * 4,6,0,2,1,3
     * <p>
     * 2,6,5,4,1,3
     * 2,1,5,4,6,3
     * 2,1,3,4,6,5
     *
     * @param arr
     * @param p
     * @param r
     * @return
     */
    public static int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i = p;//2
        for (int j = p; j < r; j++) {
            if (arr[j] < pivot) {
                if (i == j) {
                    i++;
                } else {
                    // j = 4
                    int tmp = arr[i];
                    arr[i++] = arr[j];
                    arr[j] = tmp;
                }

            }
        }

        int tmp = arr[i];
        arr[i] = pivot;
        arr[r] = tmp;

        System.out.println(i);
        System.out.println(JSON.toJSONString(arr));
        return i;
    }
}
