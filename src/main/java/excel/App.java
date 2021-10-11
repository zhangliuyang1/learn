package excel;

import com.alibaba.excel.EasyExcel;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/7/30 上午10:56
 */
public class App {

    public static void main(String[] args) {
//        String file =System.getProperty("user.dir") + ".xls";
//        List<List<String>> dataList = new ArrayList<>();
//        List<List<String>> headList = new ArrayList<>();
//        headList.add(Arrays.asList("uid"));
//        headList.add(Arrays.asList("name"));
//        headList.add(Arrays.asList("age"));
//
//
//        headList.add(new ArrayList<>(Arrays.asList("2021-07-28","总收入")));
//        headList.add(new ArrayList<>(Arrays.asList("2021-07-28","分享收入")));
//        headList.add(new ArrayList<>(Arrays.asList("2021-07-28","提现总额")));
//
//        EasyExcel.write(new File(file))
//                .head(headList)
//                .sheet("test")
//                .doWrite(dataList);


        int a = 10;
        int b = 6;

        a-=b;
        System.out.println(a);


    }
}
