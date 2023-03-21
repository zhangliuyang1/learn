package arithmetic.other;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/3/3 11:21
 */
public class OddEven {

    private static int[] arr = {8, 6, 4, 3, 1, 2, 9, 7, 0, 5};
    // {8,4,2,0,6,5,3,1,9,7}

    public static void main(String[] args) {


        calcThree(arr);

        for (int i : arr) {
            System.out.print(i + ",");
        }

    }


    public static void calc(int[] arr) {
        int length = arr.length;
        int a = 0;
        int temp;
        for (int i = 0; i < length; i++) {
            if ((arr[i] & 1) == 1) { // i=4

                temp = arr[i]; //temp = 1

                for (int j = i; j > a; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[a] = temp;
                a++;
            }
        }
    }


    public static void calcTwo(int[] arr) {
        int innerIndex = arr.length - 1;
        int temp;

        for (int i = 0; i < arr.length; i++) {

            if ((arr[i] & 1) == 0) {

                temp = arr[i];

                for (int j = innerIndex; j >= i; j--) {
                    if ((arr[j] & 1) == 1){
                        arr[i] = arr[j];
                        arr[j] = temp;
                        break;
                    }
                }
            }
        }
    }


    public static void calcThree(int[] arr){
        int begin = 0;
        int end = arr.length - 1;
        while (begin < end){

            while ((arr[begin] & 1) != 0 && begin < end){
                begin++;
            }
            while ((arr[end] & 1) != 1 && begin < end){
                end--;
            }
            int temp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = temp;
        }

    }
}
