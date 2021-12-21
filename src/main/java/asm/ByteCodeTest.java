package asm;

public class ByteCodeTest {

    public static int test1(int a) {
        try {
            a += 20;
            return a;
        } finally {
            a += 30;
            return a;
        }
    }

    public static int test2(int a) {
        try {
            a += 20;
            return a;
        } finally {
            a += 20;
        }
    }

    public static Count test3(int a) {
        Count count = new Count();
        try {
            count.setNum(a);
            System.out.println(count.getNum());
            return count;
        } finally {
            count.setNum(a + 10);
        }
//        System.out.println(count.getNum());
//        return count.getNum();
    }


    public static int test4(int a) {
        Count count = new Count();
        try {
            count.setNum(a);
            System.out.println(count.getNum());

            return count.getNum();
        } finally {
            count.setNum(a + 10);
        }
//        System.out.println(count.getNum());
//        return count.getNum();
    }

    public static void main(String[] args) {
        System.out.println(test4(10));
    }

    private static class Count {
        private int num;
        private int rank;

        public Count() {
        }

        public Count(int num, int rank) {
            this.num = num;
            this.rank = rank;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }
    }
}
