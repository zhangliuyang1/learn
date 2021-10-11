package designpattern.observer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Observable;

public class Test {

    public static void main(String[] args) throws Exception{
//        Observable observable = new Observable();
//
//        Subject subject = new Subject();
//
//        subject.addObserver(new Aobserver());
//        subject.addObserver(new Bobserver());
//        subject.addObserver(new Cobserver());
//
//        subject.setMsg("hhhhh");
        String path = "/Users/liuyangzhang/Documents/aaaaaaaaa.txt";
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        StringBuffer sb = new StringBuffer();
        String line = null;
        while ((line=br.readLine()) != null){
            sb.append(line).append(",");
        }
        System.out.println(sb.toString());
    }
}
