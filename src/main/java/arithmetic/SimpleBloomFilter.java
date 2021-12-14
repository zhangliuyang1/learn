package arithmetic;

import java.util.BitSet;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/10/25 下午5:39
 */
public class SimpleBloomFilter {
    /**
     * 位数组大小
     */
    private int bitSize;
    /**
     * hash函数个数
     */
    private int numHashFunctions;

    /**
     * 按位存储：位集合
     */
    private BitSet bits;


    /**
     * 构造器
     * @param insertSize 需要插入的元素个数
     * @param errJudge 误判率
     */
    public SimpleBloomFilter(int insertSize, double errJudge) {
        bitSize = optimalNumOfBits(insertSize, errJudge);
        numHashFunctions = optimalNumOfHashFunctions(insertSize, bitSize);
        bits = new BitSet(bitSize);
    }


    /**
     * 插入方法
     */
    public void add(String v) {
        for (int i = 0; i < numHashFunctions; i++) {
            int hash = hash(v, i);
            bits.set(hash);
        }
    }
    /**
     * 判断某个元素是否可能存在
     */
    public boolean mightContains(String v) {
        boolean ret = true;
        for (int n = 0; n < numHashFunctions; n++) {
            ret = ret && bits.get(hash(v, n));
        }
        return ret;
    }

    /**
     * @param n 插入的数据量
     * @param p 误判率
     */
    static int optimalNumOfBits(long n, double p) {
        if (p == 0) {
            p = Double.MIN_VALUE;
        }
        return (int) (-n * Math.log(p) / (Math.log(2) * Math.log(2)));
    }
    /**
     * @param n 插入的数据量
     * @param m 总长度
     */
    static int optimalNumOfHashFunctions(long n, long m) {
        // (m / n) * log(2), but avoid truncation due to division!
        return Math.max(1, (int) Math.round((double) m / n * Math.log(2)));
    }


    /**
     * hash函数
     * @param value
     * @param seed
     * @return
     */
    public int hash(String value, int seed) {
        int ret = 0;
        int len = value.length();
        for (int i = 0; i < len; i++) {
            ret = seed * ret + value.charAt(i);
        }
        return ret % bitSize;
    }

    public static void main(String[] args) {
        SimpleBloomFilter bloomFilter = new SimpleBloomFilter(1000000, 0.01);
        for (int i = 0; i < 1000000; i++) {
            bloomFilter.add("test"+i);
        }

        System.out.println(bloomFilter.mightContains("test1"));
        System.out.println(bloomFilter.mightContains("test101"));
        System.out.println(bloomFilter.mightContains("test999"));
        System.out.println(bloomFilter.mightContains("test9999999"));
        System.out.println(bloomFilter.mightContains("hello1"));
        System.out.println(bloomFilter.mightContains("hello word "));
        System.out.println(bloomFilter.mightContains("hello success"));
    }

}
