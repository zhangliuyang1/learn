package arithmetic.linkedlist;

import java.util.Scanner;

/**
 * @author: zhangliuyang01
 * @date: 2023/3/20 19:53
 */
public class LruLinked<T> {

    private final static int DEFAULT_CAPACITY = 5;

    private LinkedNode<T> head;

    /**
     * 链表长度
     */
    private int length;

    /**
     * 链表容量
     */
    private int capacity;

    public LruLinked() {
        this.head = new LinkedNode<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LruLinked(int capacity) {
        this.head = new LinkedNode<>();
        this.capacity = capacity;
        this.length = 0;
    }


    public void add(T data) {
        // TODO: 2023/3/21
        LinkedNode<T> preNode = findPreNode(data);
        if (preNode != null){
            deleteElemOptim(preNode);
            insertAtBegin(data);
        }else {
            if (length >= this.capacity){
                deleteEndNode();
            }
            insertAtBegin(data);
        }

    }

    /**
     * 获取查找到元素的前一个结点
     *
     * @param data
     * @return
     */
    private LinkedNode<T> findPreNode(T data) {
        LinkedNode<T> node = head;

        while (node.getNext() != null) {
            if (data.equals(node.getNext().getVal())) {
                return node;
            }
            node = node.getNext();
        }

        return null;
    }

    private void insertAtBegin(T data) {
        LinkedNode next = head.getNext();
        head.setNext(new LinkedNode(data, next));
        length++;
    }

    /**
     * 删除preNode节点的下一个元素
     *
     * @param preNode
     */
    private void deleteElemOptim(LinkedNode preNode) {
        LinkedNode next = preNode.getNext();
        preNode.setNext(next.getNext());
        next = null;
        length--;
    }

    private void deleteEndNode() {
        if (head.getNext() == null) {
            return;
        }
        LinkedNode p = head;
        // 1 > 2 ->3 ->4 ->5 ->null
        while (p.getNext().getNext() != null) {
            p = p.getNext();
        }

        LinkedNode last = p.getNext();

        p.setNext(null);
        last = null;
        length--;
    }


    private void printAll() {
        LinkedNode next = head.getNext();
        while (next != null) {
            System.out.print(next.getVal() + ",");
            next = next.getNext();
        }
    }

    public static void main(String[] args) {
        LruLinked<Integer> linked = new LruLinked<>();
        Scanner scanner = new Scanner(System.in);
        while (true){
            linked.add(scanner.nextInt());
            linked.printAll();
        }
    }
}


