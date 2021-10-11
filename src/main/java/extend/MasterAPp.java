package extend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/7/4 下午7:51
 */
public class MasterAPp {
    public static void main(String[] args) throws Exception{
        String path = "/Users/liuyangzhang/Documents/58/doc/C端收徒-数据补发/sub.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));


        String line = null;
        int sum = 0;
        while ((line = br.readLine()) != null) {
            String[] split = line.split(",");
            int diff = Integer.parseInt(split[10]);
            sum += diff;
        }
        System.out.println(sum);


    }


}
