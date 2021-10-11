import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/10/26 16:40
 */
public class test {

    public static void main(String[] args) {
//        String a = "1:5,2:5,3:2,4:5,5:5,6:5,7:5,8:5,9:2,0:2,a:2,b:2,c:2,d:2,e:2,f:2,g:2,h:2,i:2,j:2,k:2,l:2,m:2,n:2,o:2,p:2,q:2,r:2,s:2,t:2,u:2,v:2,w:2,x:2,y:2,z:2,A:2,B:2,C:2,D:2,E:2,F:2,G:2,H:2,I:2,J:2,K:2,L:2,M:2,N:2,O:2,P:2,Q:2,R:2,S:2,T:2,U:2,V:2,W:2,X:2,Y:2,Z:2";
//
//        String[] split = a.split(",");
//        int m = 0;
//        int n = 0;
//
//        for (int i = 0; i < split.length; i++) {
//            String s = split[i];
//            String[] split1 = s.split(":");
//            String amount = split1[1];
//            if ("2".equals(amount)){
//                m++;
//            }else {
//                n++;
//            }
//        }
//        System.out.println("m=" + m + ",n=" + n);

        String path = "/Users/liuyangzhang/Documents/userid.txt";
        Map<Long, Long> map = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));

            String line = "";
            while ((line = br.readLine()) != null) {
                long userId = Long.parseLong(line);
                if (map.containsKey(userId)) {
                    Long count = map.get(userId);
                    map.put(userId, count + 1);
                } else {
                    map.put(userId, 1L);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        map.entrySet().forEach(entry -> {
            Long key = entry.getKey();
            Long value = entry.getValue();
            if (value > 20) {
                System.out.println(key);
            }
        });








    }
}
