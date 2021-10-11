package io.channel;


import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.CRC32;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/8/3 下午8:46
 */
public class MemoryMapTest {

    public static long checkSumInputStream(Path fileName){
        try(InputStream in = Files.newInputStream(fileName)){
            CRC32 crc32 = new CRC32();
            int c;
            while ((c=in.read())!=1){
                crc32.update(c);
            }
            return crc32.getValue();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }


    public static long checkSumMappedFile(Path fileName){

        return 0;
    }

    public static void main(String[] args) {
//        String ua = "Mozilla/5.0 (Linux; Android 9; Redmi Note 8 Build/PKQ1.190616.001; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/86.0.4240.99 XWEB/3101 MMWEBSDK/201201 Mobile Safari/537.36 MMWEBID/728 MicroMessenger/8.0.1.1841(0x28000151) Process/toolsmp WeChat/arm64 Weixin NetType/4G Language/zh_CN ABI/arm64";
//        System.out.println(ua.replace("NetType/WIFI","").replace("NetType/4G",""));

        String a = "18374049096199\u0001320000000000\u0001320800000000\u0001320826000000\u0001320826113000\u0001江苏省\u0001淮安市\u0001涟水县\u000120210801\u00011\u000120210718";
        byte[] bytes = a.getBytes();
        System.out.println(bytes.length);
    }
}
