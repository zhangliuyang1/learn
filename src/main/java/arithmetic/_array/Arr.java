package arithmetic._array;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;

/**
 * @author: zhangliuyang01
 * @date: 2023/3/20 19:08
 */
public class Arr {

    // [0,1,2,3,4,5,6,7,0,0]
    private static int length = 10;
    public static int arr[] = new int[length];
    private static int size;


    public static void add(int index, int val) {
        if (size == 10) {
            return;
        }

        if (index > arr.length - 1) {
            throw  new ArrayIndexOutOfBoundsException();
//            return;
        }
        // 从增加位置开始，后面的元素向后移动一位（从末位遍历向后移动）
        for (int i = length - 1; i > index ; i--) {
            arr[i] = arr[i-1];
        }

//        for (int i = index + 1; i < length; i++) {
//            arr[i] = arr[i-1];
//        }
        arr[index] = val;
        size++;
    }

    public static void delete(int index){
        if (index > arr.length - 1){
            throw new ArrayIndexOutOfBoundsException();
        }


        // 由删除位置开始，后面的元素向前移动一位（从index位置开始遍历，向前移动）
        for (int i = index; i < length - 1; i++) {
            arr[i] = arr[i+1];
        }

    }

    public static void arrCopy(){

    }

    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {

            add(i,i);
        }
        System.out.println(JSONObject.toJSONString(Arr.arr));

        add(7,100);
        System.out.println(JSONObject.toJSONString(Arr.arr));

        delete(2);

        System.out.println(JSONObject.toJSONString(Arr.arr));

    }
}
