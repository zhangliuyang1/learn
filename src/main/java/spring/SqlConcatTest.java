package spring;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/10/27 下午3:50
 */
public class SqlConcatTest {
    private static String sql = "update t_tznew_student_first_invite_task set status = 0 WHERE id BETWEEN %d and %d  and status = 1;";

    public static void main(String[] args) {
//        int begin = 50001;
//        int offset = 10000;
//        int end =begin + offset;
//
//
//        do {
//            System.out.println(String.format(sql, begin, end));
//            begin = end;
//            end = begin + offset;
//        }while (end < 800000);

//        while (true){
//            System.out.println(String.format(sql, begin, end));
//            begin = end;
//            end = begin + offset;
//        }


        String a = "01001011";
        String b ="01000001";
        String c = "01001111";
        System.out.println(Integer.parseInt(a,2));
        System.out.println(Integer.parseInt(b,2));
        System.out.println(Integer.parseInt(c,2));


    }
}
