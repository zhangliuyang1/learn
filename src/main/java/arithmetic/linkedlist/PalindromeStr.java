package arithmetic.linkedlist;

/**
 * @author: zhangliuyang01
 * @date: 2023/3/20 18:37
 */
public class PalindromeStr {

    public static void main(String[] args) {
        LinkedNode node = new LinkedNode(1, new LinkedNode(2, new LinkedNode(3, new LinkedNode(2, new LinkedNode(1, null)))));

        LinkedNode slow = null;
        LinkedNode fast = null;
        System.out.println(judge());
        // TODO: 2023/3/20  

    }


    private static boolean judge(){
        String[] strings = {"a","b","c","d","c","s","a"};
        for (int i = 0; i < strings.length; i++) {
            int j = strings.length - 1 - i;
            if (i >= j){
                if (strings[i] != strings[j]){
                    return false;
                }
            }
        }
        return true;
    }



}
