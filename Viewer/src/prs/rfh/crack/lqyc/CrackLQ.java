package prs.rfh.crack.lqyc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.DocumentException;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import prs.rfh.crack.lqyc.model.UserInfoResponse;
import prs.rfh.crack.lqyc.model.UserSet;
import prs.rfh.util.DOMUtil;
import prs.rfh.util.PropertiesReader;
/**
 * 启动主函数
 * 1.加载公共资源
 * 2.创建登录上下文(多线程)
 * 3.监听预约时间
 * 4.启动预约线程
 */
public class CrackLQ {
	
	private static final Logger log = LoggerFactory.getLogger(CrackLQ.class);
	private static final File properties = new File(Class.class.getClass().getResource("/").getPath()+"/address_LQ.properties");
	private static URLConnection conn ;
	public static void main(String[] args) throws FileNotFoundException, IOException, DocumentException {
		// TODO Auto-generated method stub
		//获取用户基本数据列表
		log.debug("用户数据地址"+Class.class.getClass().getResource("/").getPath()+"userDatas.xml");
		List<UserInfoResponse> userList = DOMUtil.getListByLocationXML(new File(Class.class.getClass().getResource("/").getPath()+"/userDatas.xml"));
		if(userList.size()<1){
			log.error("读取用户基本数据失败"+userList.size());
			log.error("程序意外中止");
			return;
		}
		log.debug("获取了【"+userList.size()+"】条用户数据，将进行合法性检查...");
		List<UserInfoResponse> list = new ArrayList<UserInfoResponse>();
		boolean boo= true;
		for(int i=0 ;i< userList.size()-1; i++){
			for(int j=0;j< list.size();j++){
				if(userList.get(i).equals(userList.get(j))){
					boo=false;
					break;
				}
			}
			if(boo)list.add(userList.get(i));
		}
		
		log.debug("合法性检查结束，将对合法的【"+list.size()+"】个用户进行登录");
		
		
		String login_addr = PropertiesReader.getPropertieyByKey("login_addr",properties);
		System.out.println(login_addr);
		String urlStr = login_addr.replace("{1}", list.get(1).getPassword()).replace("{2}", list.get(1).getXxzh());
//		String urlStr = "http://longquanapi.xuechebu.com/Student/setbadingstuinfo?password=19920820&xxzh=51513605&jgid=117001&id_type=1"; 
		log.debug(urlStr);
		URL url;
		BufferedReader in = null;
		String result = null;
		UserInfoResponse userinfo = new UserInfoResponse();
		try {
			result = sendMessage(urlStr,null);
            
            try {
            	JSONObject json = new JSONObject(result);
				JSONObject data = json.getJSONObject("data");
				userinfo.setXxzh(data.getString("Xxzh"));
				userinfo.setPassWord(data.getString("PassWord"));
				userinfo.setXybh(data.getString("Xybh"));
				userinfo.setSfzh(data.getString("Sfzh"));
				userinfo.setJgid(data.getString("Jgid"));
				userinfo.setXm(data.getString("xm"));
				userinfo.setJxmc(data.getString("jxmc"));
				userinfo.setId_type(data.getString("id_type"));
				userinfo.setPassword(data.getString("password"));
				userinfo.setCode(json.getString("code"));
				userinfo.setMessage(json.getString("message"));
				System.out.println(userinfo);
			} catch (JSONException e) {
				log.debug("the result of login:"+result);
				e.printStackTrace();
			}
            
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
		//开始预约
		log.debug("开始预约...");
		String deal = null;
		deal = new String(PropertiesReader.getPropertieyByKey("dealCar",properties).getBytes("ISO-8859-1"),"UTF-8");
		deal = deal.replace("{1}",userinfo.getXxzh());
		log.debug("上送报文:"+deal);
//		deal = URLEncoder.encode(deal);
//		log.debug("上送报文编码:"+deal);
		String dealresult = sendMessage(deal,"?ipaddress=192.168.1.109&ossdk=22&os=an&trainType=&appversion=2.9.1&params=18006.2016年04月11日.15.&version=2.9.1&jlcbh=&xxzh=51513605&isJcsdYyMode=5&imei=357143048886748&appkey=ab916c7221df52f79d4debbaab51f794&osversion=5.1.1");
		log.debug("约车结果:"+dealresult);
		
	}
	
	public static Map cookieMap = null;

	private static String sendMessage(String urlStr, String post)
			throws MalformedURLException, IOException, UnsupportedEncodingException {
		URL url;
		String result = "";
		BufferedReader in;
		url = new URL(urlStr);
		conn = url.openConnection();
		conn.setDoOutput(true);
		OutputStream out =null ;
		
		conn.setRequestProperty("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		conn.setRequestProperty("connection", "Keep-Alive");
		conn.setRequestProperty("user-agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");
		conn.setRequestProperty("Accept-Encoding","gzip, deflate, sdch");
		conn.setRequestProperty("Accept-Language","zh-CN,zh;q=0.8");
		
//		conn.set
		if(cookieMap!=null) {
			conn.setRequestProperty("Set-Cookie", cookieMap.get("Set-Cookie").toString());
		}
		
		Map<String, List<String>> map = conn.getHeaderFields();
		if(post==null){
			cookieMap = map;
			
		}
		conn.connect();
//		if(post != null){
//			out = conn.getOutputStream();
//			out.write(post.getBytes());
//			out.flush();
//		}
		
		//获取头文件信息
//		for (String key : map.keySet()) {
//		    System.out.println(key + ":" + map.get(key));
//		}
		// ���� BufferedReader����������ȡURL����Ӧ
		in = new BufferedReader(new InputStreamReader(
				conn.getInputStream(),"UTF-8"));
		String line;
		while ((line = in.readLine()) != null) {
		   result += line;
		}
		
		return result;
	}
	
}
