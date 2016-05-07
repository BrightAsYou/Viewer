package prs.rfh.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import prs.rfh.crack.lqyc.model.CarDeal;
import prs.rfh.crack.lqyc.model.UserInfoResponse;
import prs.rfh.util.PropertiesReader;

public class QueryCarList extends BaseService {

	
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
	
	
	public JSONObject queryCarList(String timeCode , CookieStore cookieStore) throws ClientProtocolException, IOException{
		//TODO 
		
		
		return null;
	}
	
//	public static clss TimeCode{
//		
//	}
}
