package extend;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/8/28 17:59
 */
public class App {


    public static void main(String[] args) throws Exception {

//        Student student = new Student();
//        student.setAge("11");
//        student.setHeight("11");
//        student.setName("zzz");
//        student.setClazz("1");
//        student.setGarde("22");
//        student.setScore("100");
//        System.out.println(JSON.toJSONString(student));

        String path = "/Users/liuyangzhang/Documents/58/doc/C端收徒-数据补发/fill.txt";
        String addPath = "/Users/liuyangzhang/Documents/58/doc/C端收徒-数据补发/add.txt";
        String subPath = "/Users/liuyangzhang/Documents/58/doc/C端收徒-数据补发/sub.txt";

        BufferedReader br = new BufferedReader(new FileReader(path));
        BufferedWriter bwadd = new BufferedWriter(new FileWriter(addPath));
        BufferedWriter bwsub = new BufferedWriter(new FileWriter(subPath));

        String line = null;
//        int sum = 0;
//        while ((line = br.readLine()) != null) {
//            String[] split = line.split(",");
//            int diff = Integer.parseInt(split[10]);
//            sum += diff;
//        }
//        System.out.println(sum);

        while ((line = br.readLine()) != null) {
            String[] split = line.split(",");
            int diff = Integer.parseInt(split[10]);

            if (diff > 0) {
                bwadd.write(line);
                bwadd.newLine();
            } else {
                bwsub.write(line);
                bwsub.newLine();
            }
        }

        bwadd.flush();
        bwsub.flush();
        bwadd.close();
        bwsub.close();
    }
}
