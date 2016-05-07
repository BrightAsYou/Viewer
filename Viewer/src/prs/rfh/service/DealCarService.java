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
		String timeOfDay = null;
		if("AM".equals(user.getDealdate().split("\\|")[1])){
			timeOfDay = "811";
		}else if("PM".equals(user.getDealdate().split("\\|")[1])){
			timeOfDay = "1215";
		}else{
			timeOfDay = "1518";
		}//1820
		//1.构建请求路径
		requestPath = dealCarPath.replace("{1}", deal.getCarNo()+"."+deal.getDealdate()).replace("{2}", user.getXxzh()).replace("{3}",timeOfDay );
		log.debug("dealCarPath["+deal.getCarNo()+"]["+user.getXxzh()+"]"+requestPath);
		//http://longquanapi.xuechebu.com 	
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
