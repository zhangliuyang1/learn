package asm;

import javax.naming.Context;

public class Test {
    private int num = 1;
    public static int no = 2;

    public int func(int a, int b) {
        return add(a, b);
    }

    public int add(int a, int b) {
        return a + b + num;
    }

    public int sub(int a, int b) {
        return a - b - no;
    }

}
