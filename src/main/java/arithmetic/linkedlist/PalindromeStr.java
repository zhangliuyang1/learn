package arithmetic.linkedlist;

/**
 * @author: zhangliuyang01
 * @date: 2023/3/20 18:37
 */
public class PalindromeStr {

    public static void main(String[] args) {
        LinkedNode node = new LinkedNode(1, new LinkedNode(3, new LinkedNode(3, new LinkedNode(2, new LinkedNode(1, null)))));


        System.out.println(isPalindromeStr(node));

    }

    public static boolean isPalindromeStr(LinkedNode node) {
        if (node == null) {
            return false;
        }
        if (node.getNext() == null) {
            return true;
        }
        LinkedNode slow = node;
        LinkedNode fast = node;

        LinkedNode tmp = null;

        // 1 -> 2 -> 3 -> 4 -> 5
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            LinkedNode next = slow.getNext();
            slow.setNext(tmp);
            tmp = slow;
            slow = next;
        }
        // 奇数节点
        if (fast != null) {
            slow = slow.getNext();
        }

        while (slow != null) {
            if (slow.getVal() != tmp.getVal()) {
                return false;
            }
            slow = slow.getNext();
            tmp = tmp.getNext();
        }
        return true;
    }


    private static boolean judge() {
        // 前后双指针
        String[] strings = {"a", "b", "c", "d", "c", "s", "a"};
        for (int i = 0; i < strings.length; i++) {
            int j = strings.length - 1 - i;
            if (i >= j) {
                if (!strings[i].equals(strings[j])) {
                    return false;
                }
            }
        }
        return true;
    }


}
