package arithmetic.other;

import java.util.LinkedList;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/3/10 17:11
 */
public class BinaryTree {

    private int val;
    private BinaryTree left;
    private BinaryTree right;

    public BinaryTree(int val) {
        this.val = val;
    }

    public static BinaryTree inverse(BinaryTree root) {
        if (root == null) {
            return null;
        }
        BinaryTree left = inverse(root.left);
        BinaryTree right = inverse(root.right);
        root.left = right;
        root.right = left;
        return root;

    }

    public static void main(String[] args) {

        BinaryTree root = initTree();


        System.out.println("先序遍历");
        preOrder(root);
        System.out.println();
        System.out.println("中序遍历");

        inOrder(root);
        System.out.println();
        System.out.println("后序遍历");
        postOrder(root);
        System.out.println();
        System.out.println("层次遍历");
        levelOrder(root);
//        inverse(root);
//        preOrder(root);
    }

    /**
     * 初始化二叉树
     *
     * @return
     */
    public static BinaryTree initTree() {
        BinaryTree root = new BinaryTree(1);
        root.setLeft(new BinaryTree(2));
        root.setRight(new BinaryTree(3));
        root.getLeft().setLeft(new BinaryTree(4));
        root.getLeft().setRight(new BinaryTree(5));
        root.getRight().setLeft(new BinaryTree(6));
        root.getRight().setRight(new BinaryTree(7));
        return root;
    }

    /**
     * 先序遍历:根左右
     *
     * @param root
     */
    public static void preOrder(BinaryTree root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + "，");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历：左根右
     *
     * @param root
     */
    public static void inOrder(BinaryTree root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + "，");
        inOrder(root.right);
    }

    /**
     * 后序遍历：左右根
     *
     * @param root
     */
    public static void postOrder(BinaryTree root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + "，");
    }

    /**
     * 层次遍历
     *
     * @param root
     */
    public static void levelOrder(BinaryTree root) {
        if (root == null) {
            return;
        }
        LinkedList<BinaryTree> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTree node = queue.poll();
            System.out.print(node.val + "，");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }


    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public BinaryTree getLeft() {
        return left;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public BinaryTree getRight() {
        return right;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }
}
