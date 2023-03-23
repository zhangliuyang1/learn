package arithmetic.linkedlist;

import java.lang.Integer;

/**
 * @author: zhangliuyang01
 * @date: 2023/3/23 17:17
 */
public class LinkedFunc {
    public static void main(String[] args) {
        LinkedNode<Integer> node1 = new LinkedNode(8, new LinkedNode(100, new LinkedNode(200, null)));
        LinkedNode<Integer> node2 = new LinkedNode(9, new LinkedNode(19, null));

        LinkedNode<Integer> merge = merge(node1, node2);

        printAll(merge);

    }

    /**
     * 合并两个有序链表
     *
     * @param node1
     * @param node2
     * @return
     */
    public static LinkedNode<Integer> merge(LinkedNode<Integer> node1, LinkedNode<Integer> node2) {
        if (node1 == null) return node2;
        if (node2 == null) return node1;

        LinkedNode<Integer> node = new LinkedNode<>();
        LinkedNode<Integer> tmp = node;
        while (node1 != null && node2 != null) {
            if (node1.getVal().compareTo(node2.getVal()) < 0) {
                node.setNext(node1);
                node1 = node1.getNext();
            }else {
                node.setNext(node2);
                node2 = node2.getNext();
            }
            node = node.getNext();
        }

        if (node1 != null) {
            node.setNext(node1);
        }

        if (node2 != null) {
            node.setNext(node2);
        }
        tmp = tmp.getNext();
        return tmp;
    }

    public static void printAll(LinkedNode node) {
        LinkedNode p = node;
        while (p != null) {
            System.out.print(p.getVal() + ",");
            p = p.getNext();
        }
        System.out.println("");
    }
}
