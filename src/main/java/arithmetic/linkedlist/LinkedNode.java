package arithmetic.linkedlist;

import java.util.Stack;

/**
 *
 * 单向链表
 * @author: zhangliuyang01
 * @date: 2023/3/20 14:24
 */
public class LinkedNode {

    private int val;

    private LinkedNode next;

    public LinkedNode() {
    }

    public LinkedNode(int val, LinkedNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }

    public static void main(String[] args) {
        LinkedNode node = new LinkedNode(1, new LinkedNode(2, new LinkedNode(3, new LinkedNode(4, new LinkedNode(5, null)))));
        LinkedNode next = node;
        while (next != null) {
            System.out.println(next.getVal());
            next = next.next;
        }

        System.out.println("========");


        LinkedNode linkedNode = reverseStack(node);
        LinkedNode tmp = linkedNode;
        while (tmp != null) {
            System.out.println(tmp.getVal());
            tmp = tmp.next;
        }

    }

    /**
     * 迭代遍历--两个指针
     * @param node
     * @return
     */
    private static LinkedNode reverse(LinkedNode node) {
        // n1 n2 n3 n4
        LinkedNode pre = null;
        LinkedNode curr = node;

        while (curr != null) {
            LinkedNode next = curr.next;

            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }


    /**
     * 、栈 - 先进后出
     * @param node
     * @return
     */
    private static LinkedNode reverseStack(LinkedNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        Stack<LinkedNode> stack = new Stack<>();
        LinkedNode next = node;
        while (next != null){
            stack.push(next);
            next = next.next;
        }

        LinkedNode head = stack.pop();
        LinkedNode tmp = head;
        while (!stack.isEmpty()){
            LinkedNode nextTmp = stack.pop();
            nextTmp.next = null;
            tmp.setNext(nextTmp);
            tmp = nextTmp;
        }

        return head;
    }

    /**
     * 递归
     * @param node
     * @return
     */
    private static LinkedNode reverse2Recurve(LinkedNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        // n4
        // n5
        LinkedNode newNode = reverse2Recurve(node.next);
        node.next.next = node;  // n5 -> n4
        node.next = null; // n5 ->n4 -> null
        return newNode;
    }


    //n5->null          return  n5 ->null
    //n4 -> n5 -> null  return  n5 -> n4 -> null
    //n3 -> n4 -> null  return  n5 -> n4 > n3 -> null
    //n2 -> n3 -> null  return  n5 -> n4 -> n3 -> n2 -> null
    //n1 -> n2 -> null  return  n5 -> n4 -> n3 -> n2 -> n1 -> null


}
