package arithmetic.linkedlist;

/**
 * @author: zhangliuyang01
 * @date: 2023/3/20 19:53
 */
public class LruLinked<T> {

    private final static int DEFAULT_CAPACITY = 10;

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

    private void insertAtBegin(T data){

    }
}


