package spring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/10/27 下午7:29
 */
public class DomainFilter {
    public static void main(String[] args) throws Exception{
        String path = "/Users/liuyangzhang/Downloads/335483.csv";
        String backup = "/Users/liuyangzhang/Downloads/335491.csv";
        List<NewDomain> list =new ArrayList<>();
        list.addAll(getDomain(path));
        list.addAll(getDomain(backup));

        for (NewDomain newDomain : list) {
            String domain = newDomain.getDomain();
            String s = filterDomain(domain);
            if (s != null){
                System.out.println(domain +","+s+"," + newDomain.getState());
            }
        }

    }


    public static List<NewDomain> getDomain(String path) throws Exception{
        List<NewDomain> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String line;
        while ((line=br.readLine()) != null){
            try {
//                System.out.println(line);
                line = line.replaceAll("\"","");
                String[] strings = line.split(",");
                list.add(new NewDomain(strings[0],Integer.parseInt(strings[3])));
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return list;

    }

    public static String filterDomain(String domain) {
        String str = "document,script,src,location,href,history,alert,javascript,function,window,assgin,setTimeout,atob,top,javascri,replace";
        String[] list = str.split(",");
        for (String s : list) {
            if (domain.contains(s)) {
                return s;
            }
        }
        return null;
    }



    private static class NewDomain{
        private String domain;
        private int state;

        public NewDomain(String domain, int state) {
            this.domain = domain;
            this.state = state;
        }

        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }
    }

}
