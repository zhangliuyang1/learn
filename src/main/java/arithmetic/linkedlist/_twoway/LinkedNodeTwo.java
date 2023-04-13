package arithmetic.linkedlist._twoway;

/**
 * @author: zhangliuyang01
 * @date: 2023/3/23 19:25
 */
public class LinkedNodeTwo<T> {
    private T val;

    private LinkedNodeTwo pre;
    private LinkedNodeTwo next;

    public LinkedNodeTwo() {
    }

    public LinkedNodeTwo(T val, LinkedNodeTwo pre, LinkedNodeTwo next) {
        this.val = val;
        this.pre = pre;
        this.next = next;
    }

    public LinkedNodeTwo(T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public LinkedNodeTwo getPre() {
        return pre;
    }

    public void setPre(LinkedNodeTwo pre) {
        this.pre = pre;
    }

    public LinkedNodeTwo getNext() {
        return next;
    }

    public void setNext(LinkedNodeTwo next) {
        this.next = next;
    }
}
