package prs.rfh.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import prs.rfh.crack.lqyc.CrackLQ;
import prs.rfh.crack.lqyc.model.CarDeal;
import prs.rfh.crack.lqyc.model.UserInfoResponse;
import prs.rfh.httpclient.HttpClientTest;
import prs.rfh.thread.Deal;
import prs.rfh.util.PropertiesReader;

public class DealCarService extends BaseService{
	
	
	private static final Logger log = LoggerFactory.getLogger(DealCarService.class);
	private static String dealCarPath = null;
	
	static {
		try {
			dealCarPath = PropertiesReader.getPropertieyByKey("dealCar", properties);
		} catch (FileNotFoundException e) {
			log.debug("properties文件未找到");
			e.printStackTrace();
		} catch (IOException e) {
			log.debug("properties文件读取失败");
			e.printStackTrace();
		}
	}
	
	private DefaultHttpClient httpClient = new DefaultHttpClient();
	private String requestPath = null;
	
	/**
	 * 约车
	 * @param deal
	 * @return
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public JSONObject dealCar(CarDeal deal,UserInfoResponse user,CookieStore cookieStore) throws ClientProtocolException, IOException{
		//1.构建请求路径
		requestPath = dealCarPath.replace("{1}", deal.getCarNo()+"."+deal.getDealdate()+".15.").replace("{2}", user.getXxzh());
		log.debug("dealCarPath["+deal.getCarNo()+"]["+user.getXxzh()+"]"+requestPath);
		//http://longquanapi.xuechebu.com/KM2/ClYyAddByMutil?ipaddress=192.168.1.129&ossdk=22&os=an&trainType=&appversion=2.9.1&params=18006.2016年04月11日.15.&version=2.9.1&jlcbh=&xxzh={1}&isJcsdYyMode=5&imei=357143048886748&appkey=ab916c7221df52f79d4debbaab51f794&osversion=5.1.1
		ClientConnectionManager manager = dealClient.getConnectionManager();
//		manager.
		Random rand = new  Random();
		int randInt = rand.nextInt();
		httpClient.setCookieStore(cookieStore);
		HttpPost post = new HttpPost(requestPath+"&sb="+randInt);
		HttpResponse resp = httpClient.execute(post);
		HttpEntity entity = resp.getEntity();
		String jsonStr = EntityUtils.toString(entity);
		log.debug("["+deal.getCarNo()+"]["+user.getXxzh()+"]"+jsonStr);
		JSONObject json = null;
		try {
			json = new JSONObject(jsonStr);
		} catch (ParseException e) {
			log.debug("转化json失败");
			e.printStackTrace();
		} catch (JSONException e) {
			log.debug("转化json失败");
			e.printStackTrace();
		}
		post.releaseConnection();
		httpClient.close();
		return json;
	}
}
