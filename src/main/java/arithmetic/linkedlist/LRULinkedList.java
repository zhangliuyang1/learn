package arithmetic.linkedlist;

import java.util.Scanner;

/**
 * @author: zhangliuyang01
 * @date: 2023/3/22 17:37
 */
public class LRULinkedList<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private int capacity;

    private int length;


    private LinkedNode<T> headNode;

    public LRULinkedList() {
        new LRULinkedList<>(DEFAULT_CAPACITY);
    }

    public LRULinkedList(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.headNode = new LinkedNode<>();
    }


    /**
     * 找到元素对应节点
     *
     * @param t
     * @return
     */
    public LinkedNode<T> findNode(T t) {
        LinkedNode<T> node = headNode;
        while (node != null) {
            if (node.getVal() == t) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    /**
     * 删除尾节点
     */
    public void deleteEnd() {
        if (headNode.getNext() == null) {
            return;
        }
        LinkedNode<T> p = this.headNode;

        while (p.getNext().getNext() != null) {
            p = p.getNext();
        }
        LinkedNode last = p.getNext();
        p.setNext(null);
        last = null;
        length--;
    }

    /**
     * 删除其中一个节点
     *
     * @param node
     */
    public void deleteNode(LinkedNode<T> node) {
        if (node == null) {
            return;
        }
        LinkedNode<T> p = headNode;

        while (p != null) {
            if (p.getNext().getVal() == node.getVal()) {
                LinkedNode<T> next = node.getNext();
                p.setNext(next);
                length--;
                return;
            }
            p = p.getNext();
        }
    }

    public void deleteByElem(T t) {
        LinkedNode<T> p = headNode;
        while (p != null && p.getNext() != null) {
            if (p.getNext().getVal() == t) {
                LinkedNode<T> curr = p.getNext();
                LinkedNode<T> next = curr.getNext();
                p.setNext(next);
                length--;
                return;
            }
            p = p.getNext();
        }


    }

    /**
     * 插入头结点
     *
     * @param t
     */
    public void insertHead(T t) {

        LinkedNode next = headNode.getNext();
        headNode.setNext(new LinkedNode<>(t, next));
        length++;
    }


    public void add(T t) {

        deleteByElem(t);
        if (length >= capacity) {
            deleteEnd();
        }

        insertHead(t);


//        LinkedNode<T> node = findNode(t);
//        if (node == null) {
//            if (length < capacity) {
//                insertHead(t);
//            } else {
//                deleteEnd();
//                insertHead(t);
//            }
//            return;
//        }
//        deleteNode(node);
//        insertHead(t);
    }

    /**
     * 1 ,2 ,3, 4
     *
     * @param k
     */
    public void deleteK(int k) {
        LinkedNode p1 = headNode.getNext();
        for (int i = 0; i < k - 1; i++) {
            p1 = p1.getNext();
        }

        LinkedNode p2 = headNode.getNext();
        LinkedNode pre = null;

        while (p1.getNext() != null) {
            p1 = p1.getNext();
            pre = p2;
            p2 = p2.getNext();
        }


        if (p2 == null) {
            headNode = headNode.getNext();
        } else {
            pre.setNext(pre.getNext().getNext());
        }


    }

    private void printALL() {
        if (headNode == null) {
            System.out.println("null");
        }

        LinkedNode<T> p = headNode.getNext();
        while (p != null) {
            System.out.print(p.getVal() + ",");
            p = p.getNext();
        }
    }


    public static void main(String[] args) {
        LRULinkedList<Integer> list = new LRULinkedList(5);
//        Scanner sc = new Scanner(System.in);
//        while (true) {
//            list.add(sc.nextInt());
//            list.printALL();
//        }
        for (int i = 1; i < 6; i++) {
            list.add(i);
            list.printALL();
            System.out.println("=====");
        }
        list.deleteK(2);
        list.printALL();
    }


}
