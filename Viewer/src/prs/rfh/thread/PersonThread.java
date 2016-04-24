package prs.rfh.thread;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Timer;

import javax.servlet.http.HttpUtils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import prs.rfh.crack.lqyc.model.CarDeal;
import prs.rfh.crack.lqyc.model.UserInfoResponse;
import prs.rfh.datagen.PersonDealGenerator;
import prs.rfh.shedule.DealTimerTask;
import prs.rfh.util.PropertiesReader;

/**
 * 用户级别线程
 * 该线程中包含所有单个用户级别信息
 * 用户登录状态应该在此完成
 * @author Talent
 *
 */
public class PersonThread extends Thread {

	private static final Logger log = LoggerFactory.getLogger(PersonThread.class);
	private static final File properties = new File(Class.class.getClass().getResource("/").getPath()+"/address_LQ.properties");
	private UserInfoResponse user  = null;
	
	public List<CarDeal> list = null;
	public final DefaultHttpClient sender = new DefaultHttpClient();
	
	public PersonThread(UserInfoResponse user){
		this.user = user;
		list =  PersonDealGenerator.buildPersonDeals(user);
	}
	
	/**
	 * 创建用户对象
	 * 包含该用户的身份信息，登录的上下文，约车信息等
	 * swift
	 */
	@Override
	public void run() {
		//1 校验信息
		if(checkUser(user)&&checkDealList(list)){
			try {
				throw new Exception("用户级别信息校验错误！");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//TODO 添加登录状态
		
		String login_addr = null;
		try {
			login_addr = PropertiesReader.getPropertieyByKey("login_addr",properties);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.debug("login_addr:"+login_addr);
		String urlStr = login_addr.replace("{1}", user.getPassword()).replace("{2}",user.getXxzh());
		HttpPost httpPost = new HttpPost(urlStr);
		HttpResponse res = null;
		try {
			res = sender.execute(httpPost);
		} catch (ClientProtocolException e) {
			log.debug("用户级登录访问出错");
			e.printStackTrace();
		} catch (IOException e) {
			log.debug("用户级登录访问出错");
			e.printStackTrace();
		}
		log.debug("启动预约线程监听");
		//TODO 监听事件
		HttpEntity entity = res.getEntity();
		String jsonStr = null;
		try {
			jsonStr = EntityUtils.toString(entity);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		httpPost.releaseConnection();
		log.debug(jsonStr);
		JSONObject json = null;
		try {
			json = new JSONObject(jsonStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Date currentDate = new Date();
		Date dealDate = new Date(currentDate.getYear(),currentDate.getMonth(),currentDate.getDate(),6,59,58);
		for(CarDeal deal :list){
			try {
				this.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Timer timer = new Timer();
			timer.schedule(new DealTimerTask(deal, user,sender.getCookieStore()), dealDate);
			try {
				this.sleep(25);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private boolean checkUser(UserInfoResponse user){
		if(user!=null&&user.getPassword()!=null&&user.getXybh()!=null)return true;
		return false;
	}
	
	private boolean checkDealList(List list){
		if(list!=null&&list.size()>0)return true;
		return false;
	}
	
}
