package io.channel;


import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * buffer中的flip方法涉及到bufer中的Capacity,Position和Limit三个概念。
 * 其中Capacity在读写模式下都是固定的，就是我们分配的缓冲大小,
 * Position类似于读写指针，表示当前读(写)到什么位置,Limit在写模式下表示最多能写入多少数据，此时和Capacity相同，
 * 在读模式下表示最多能读多少数据，此时和缓存中的实际数据大小相同。
 * 在写模式下调用flip方法，那么limit就设置为了position当前的值(即当前写了多少数据),postion会被置为0，
 * 以表示读操作从缓存的头开始读。也就是说调用flip之后，读写指针指到缓存头部，
 * 并且设置了最多只能读出之前写入的数据长度(而不是整个缓存的容量大小)。
 * @Author: zhangliuyang01
 * @Date: 2021/6/2 下午5:01
 */
public class FileChannelDemo {
    public static void main(String[] args) throws Exception {
        String path = "/Users/liuyangzhang/Documents/58/project/learn/src/main/java/io/copy.txt";
        String dest = "/Users/liuyangzhang/Documents/58/project/learn/src/main/java/io/copy-1.txt";
        StringBuffer sb = new StringBuffer();
        FileInputStream fis = new FileInputStream(path);
        FileChannel fileChannel = fis.getChannel();
        FileChannel fileChannel1 = new FileInputStream(dest).getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(128);

        int read = fileChannel.read(byteBuffer);
        while (read != -1) {
            // 调整这个buffer的当前位置position，设置position=0
            // 即：将缓存字节数组的指针设置为数组的开始序列即数组下标0。这样就可以从buffer开头，对该buffer进行遍历（读取）了
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                sb.append((char) byteBuffer.get());
            }

            byteBuffer.clear();
            read = fileChannel.read(byteBuffer);
//            fileChannel.write(byteBuffer)
        }
        System.out.println(sb.toString());
        System.out.println("end");

    }
}
