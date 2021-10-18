package tznew;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.params.CoreConnectionPNames;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.Map.Entry;

public class HttpClientUtil {
	
	private static final Log logger = LogFactory.getLog(HttpClientUtil.class);

	private static final PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
	private static CloseableHttpClient sslhttpClient = null;
	private static CloseableHttpClient httpClient = null;

	static {
		try {
			X509TrustManager x509mgr = new X509TrustManager() {
				@Override
				public void checkClientTrusted(X509Certificate[] xcs, String authType) throws CertificateException {
				}
				@Override
				public void checkServerTrusted(X509Certificate[] xcs, String authType) throws CertificateException {
				}
				@Override
				public X509Certificate[] getAcceptedIssuers() {
					return new X509Certificate[] {};
				}
			};

			SSLContext sslContext = SSLContext.getInstance("TLS");
			sslContext.init(null, new TrustManager[] { x509mgr }, null);
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			// https协议
			sslhttpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
			// http协议
			connectionManager.setMaxTotal(30);
			connectionManager.setDefaultMaxPerRoute(10);
			httpClient = HttpClients.custom().setConnectionManager(connectionManager).build();
		} catch (Exception e) {
			logger.error("初始化 tznew.HttpClientUtil 失败", e);
		}

	}
	

	public static String doHttpGet(String requestURL) throws Exception {
		return doHttpGet(requestURL, 2000);
	}
	
	public static String doHttpGet(String requestURL, int timeout) throws Exception {
		return doHttpGet(requestURL, null, timeout);
	}

	
	public static String doHttpGet(String requestURL, Map<String, String> headerMap, int timeout) throws Exception {
		
		HttpGet httpGet = new HttpGet(requestURL);
		// 设置请求和传输超时时间
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(timeout).setConnectionRequestTimeout(timeout).build();
		httpGet.setConfig(requestConfig);
		if(headerMap!=null){
			for (Entry<String, String> entry : headerMap.entrySet()) {
				httpGet.setHeader(entry.getKey(), entry.getValue());
			}
		}
		
		CloseableHttpResponse response = null;
		InputStream responseStream = null;
		try {
			
			response = httpClient.execute(httpGet, HttpClientContext.create());
			StatusLine statusLine = response.getStatusLine();
			int responseCode = statusLine.getStatusCode();
			
			logger.debug("request " + requestURL + " get response code:" + responseCode);
			
			if (HttpStatus.SC_OK == responseCode) {
				responseStream = response.getEntity().getContent();
				String responseContent = getStringForInputStream(responseStream, "UTF-8");
				
				logger.debug("request " + requestURL + " get response content is:" + responseContent);
				return responseContent;
			}else{
				logger.info("获取数据失败 responseCode="+responseCode+" requestURL="+requestURL);
			}
			
			
		} catch (Exception e) {
			
			throw e;
			
		}finally{
			
			if(responseStream != null){
				responseStream.close();
			}
			
			if(response != null){
				response.close();
			}
			
		}

		return null;
	}

	public static HttpResponse httpPostWithJson(JSONObject jsonObj, String url){
		HttpResponse response = null;
		HttpPost post = null;
		try {
			HttpClient httpClient = new DefaultHttpClient();

			// 设置超时时间
			httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 2000);
			httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 2000);

			post = new HttpPost(url);
			// 构造消息头
			post.setHeader("Content-type", "application/json; charset=utf-8");
			post.setHeader("Connection", "Close");

			// 构建消息实体
			StringEntity entity = new StringEntity(jsonObj.toString(), Charset.forName("UTF-8"));
			entity.setContentEncoding("UTF-8");
			// 发送Json格式的数据请求
			entity.setContentType("application/json");
			post.setEntity(entity);

			response = httpClient.execute(post);
			// 检验返回码
			int statusCode = response.getStatusLine().getStatusCode();
			return response;

		} catch (Exception e) {
			e.printStackTrace();

		}finally{
			if(null != post){
				try {
					post.releaseConnection();
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		return response;
	}
	
	private static String getStringForInputStream(InputStream inputStream, String encode) throws IOException {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		byte[] data = new byte[1024];
		int len = 0;
		String result = "";
		if (inputStream != null) {
			while ((len = inputStream.read(data)) != -1) {
				stream.write(data, 0, len);
			}
			result = new String(stream.toByteArray(), encode);
		}
		return result;
	}

}
