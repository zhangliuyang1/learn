package arithmetic;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/3/3 21:18
 */
public class BloomTest {

    long expectedInsertions = 1000000;


    public static void main(String[] args) {
        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(),1000000,0.01);
        long l = bloomFilter.approximateElementCount();
        for (int i = 0; i < 1000000; i++) {
            bloomFilter.put(i);
        }

        int count = 0;
        for (int i = 1000000; i < 2000000; i++) {
            if (bloomFilter.mightContain(i)){
                count++;
                System.out.println("wu pan:" + i);
            }
        }
        System.out.println("wupancishu:" + count);
    }


    /**
     * 根据要插入的数据量和误判率，计算数组的总长度
     * @param n
     * @param p
     * @return
     */
    static long optimalNumOfBits(long n, double p) {
        if (p == 0) {
            p = Double.MIN_VALUE;
        }
        return (long) (-n * Math.log(p) / (Math.log(2) * Math.log(2)));
    }

    /**
     * 根据要插入的数据量和总长度，计算hash函数个数
     * @param n
     * @param m
     * @return
     */
    static int optimalNumOfHashFunctions(long n, long m) {
        // (m / n) * log(2), but avoid truncation due to division!
        return Math.max(1, (int) Math.round((double) m / n * Math.log(2)));
    }
}

