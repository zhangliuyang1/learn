package tznew;

import com.alibaba.fastjson.JSON;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/10/14 下午5:44
 */
public class BlaclListApp {


    public static void main(String[] args) throws Exception {
        String file = "/Users/liuyangzhang/Downloads/uid.log";
        List<Long> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(file)));
            String line;
            while ((line = br.readLine()) != null) {
                String[] splits = line.split(" ");
                for (String split : splits) {
                    if (split.length() > 4) {
                        list.add(Long.parseLong(split));
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        List<Long> blist = new ArrayList<>();
        String path = "http://tzcappadmin.58corp.com/wallet/searchBlack?searchBlackUid=%s";
        for (Long uid : list) {
            String pathd = String.format(path, uid);
            System.out.println(pathd);
            try {
                URL url = new URL(pathd);
                //得到connection对象。
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty("Cookie","_bu=20190514103200533f585c; wmda_uuid=72b30a21c31f06f4ef7af9422dcb8033; wmda_new_uuid=1; c=Lfal7TFV-1632641275526-65aaa3b5a1d22471558131; _fmdata=gwJGpJeSeCTf3liCDr00ty%2FKKV0q4H6jQhPdOWKO19LjRnbP6mQLgjLYpT6p4rvt2BI%2BRoG3c1rlEZ8uETuCuA5vg2qDxcA6n2OQ%2FnZRx1w%3D; wmda_visited_projects=%3B18101072869043; ishare_sso_username=FB6214CA6165736FFB16EEF7084BA19D7AE032BEC9B9CE0293C6A5B4D7039D43; dunCookie=f3ecab3b67282bc422a9dad3ec473c29a23ecfda09aa8fa668e79dd7812840c65fe12013068fc189; _xid=wkyFJQTe3Jl2Np6Bcbi3czP4SeJs9w82G7zsxobHp2%2FPxxUi4lnDUFI88LtxOTqNwDQco24%2BDYPxAX7gsTW3%2FQ%3D%3D; bj58bsp_loginstatus_58_v2=1634208278010; bj58bsp_logininfo=userid%3D20190514103200533f585c%26username%3Dzhangliuyang01%26realname%3D%E5%BC%A0%E5%88%98%E6%B4%8B%26orgid%3D20170703214200523e82f7%26dutyid%3D201101101655507f728cae%26eamil%3Dzhangliuyang01%4058.com%26dutyid%3D201101101655507f728cae%26siteTime%3D7FD4AEDC9C17C7B818EA1D6BA76F4AEE705629C2693E03384%26sitekey%3D1A6BF38AFB12EEA61FBA339F2A02FCE6889D13C78F534FFC2C5AE4306C1C90EAF%26version%3Dv2; bj58bsp_login_token=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1OCBHcm91cCBFbXBsb3llZXMiLCJhdWQiOiJ6aGFuZ2xpdXlhbmcwMSIsImlzcyI6IjU4IG1pcyBlcCIsImV4cCI6MTYzNDI5NDY4MCwiaWF0IjoxNjM0MjA4MjgwLCJqdGkiOiIyMDE5MDUxNDEwMzIwMDUzM2Y1ODVjIn0.Q2rRjxOy8N0Z3IUHZFVKw_kT-TJF4S49PXAX_IrKaUY; bj58bsp_login_token_tzadmin=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1OCBHcm91cCBFbXBsb3llZXMiLCJhdWQiOiJ6aGFuZ2xpdXlhbmcwMSIsImlzcyI6IjU4IG1pcyBlcCIsImV4cCI6MTYzNDI1MTQ4MCwic3lzIjoidHphZG1pbiIsImlhdCI6MTYzNDIwODI4MCwidXNlcklkIjoiMjAxOTA1MTQxMDMyMDA1MzNmNTg1YyIsImp0aSI6IjIwMjExMDE0MTg0NDQwMjllN2EwZjYiLCJvcmdJZCI6IjIwMTcwNzAzMjE0MjAwNTIzZTgyZjciLCJlbWFpbCI6InpoYW5nbGl1eWFuZzAxQDU4LmNvbSIsInJlYWxuYW1lIjoi5byg5YiY5rSLIn0.KCrBnTsHnU0BLOpaSSrklOlSePrkKI4q0mI5Uqdrx4g; JSESSIONID=C911D0F6E8309E19C2C51380DE9DB4CE");
                connection.setRequestMethod("GET");
                //连接
                connection.connect();
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder sb = new StringBuilder();
                String content;
                while ((content=reader.readLine()) != null){
                    sb.append(content);
                }

                System.out.println("uid="+uid+",result="+sb.toString());
                if (sb.toString().contains("已拉黑")){
                    blist.add(uid);
                }

//                String s = HttpClientUtil.doHttpGet(pathd);
//                System.out.println(s);
//                if (s.contains("已拉黑")) {
//                    blist.add(uid);
//                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


        System.out.println("拉黑人数：" + blist.size());
        System.out.println(JSON.toJSON(blist));


    }
}
