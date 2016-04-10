package prs.rfh.httpclient;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HttpClientTest {
	Logger log = LoggerFactory.getLogger(HttpClientTest.class);
	@Test
	public void testHttpClient() throws ClientProtocolException, IOException{
		 String url = "http://longquanapi.xuechebu.com/Student/setbadingstuinfo?password=19920820&xxzh=51513605&jgid=117001&id_type=1";
		 @SuppressWarnings("deprecation")
		 HttpClient httpClient = new DefaultHttpClient();
		 HttpGet httpGet = new HttpGet(url);
		 HttpResponse res = httpClient.execute(httpGet);
		 Header [] header = res.getAllHeaders();
//		 httpClient.getConnectionManager()
		 
		 HttpEntity loginEntity = res.getEntity();
	     String loginEntityContent = EntityUtils.toString(loginEntity);
	     System.out.println("登录状态:" + loginEntityContent);

		 httpGet.releaseConnection();
		 log.debug("****************************");
		 String url2 = "http://longquanapi.xuechebu.com/KM2/ClYyAddByMutil?ipaddress=192.168.1.121&ossdk=22&os=an&trainType=&appversion=2.9.1&params=16063.2016年04月12日.15.&version=2.9.1&jlcbh=&xxzh=51513605&isJcsdYyMode=5&imei=357143048886748&appkey=ab916c7221df52f79d4debbaab51f794&osversion=5.1.1";
		 HttpPost httpPost = new HttpPost(url2);
//		 for(Header he :header){
//			 log.debug(he.toString());
//			 httpPost.addHeader(he);
//		 }
		 res = httpClient.execute(httpPost);
		 log.debug("***********************");
		 log.debug(EntityUtils.toString(res.getEntity()));
		 
	}
	
	

}
