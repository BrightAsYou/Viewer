package prs.rfh.datagen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import prs.rfh.service.DealCarService;

/**
 * @since 2016-04-07
 * @author swift
 * 读取车号列表，如果从网络中获取为空，则读取本地缓存列表
 * 如果可以从网络中获取，则将获取的列表存储到    日期.bak 中，以xml形式存储和读取
 * 需要分级加载，该加载只运行一次，分级顺序 1.from xml 2 from internet ，如果2获取到列表，则
 */
public class CarNoReader {
	private static final Logger log = LoggerFactory.getLogger(DealCarService.class);
	public static final File jsonFile = new File(Class.class.getClass().getResource("/").getPath()+"/carNo.json");
	public static final Set set = new HashSet();
	
	public static Set getCarSet(){
		return set;
	}
	/**
	 * 获取已经初始化的车辆列表
	 */
	public static Set generateCarSet(){
		getCarFromXml();
		getCarFromJson();
		getCarFromInternet();
		return set;
	}
	
	/**
	 * 获取写死的json数据
	 */
	private static void getCarFromJson() {
		BufferedReader reader=null;
		try {
			reader = new BufferedReader(new FileReader(jsonFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		StringBuffer json = new StringBuffer();
		try {
			//注意如果用read()作为判断条件，第一个字符会被忽略掉，所以直接对将readline赋值
			String aa;
			while((aa = reader.readLine())!= null){
				json.append(aa);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		log.debug("read carNo json :"+json);
		JSONObject jsonObj = null;
		try {
			jsonObj = new JSONObject(json.toString());
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			JSONArray  noonArray = jsonObj.getJSONArray("NOON");
			JSONArray  afternoonArray = jsonObj.getJSONArray("AFTERNOON");
			JSONArray  nigthArray = jsonObj.getJSONArray("NIGHT");
//			String [] carNos = noonArray.opt(arg0)
			if(noonArray.length()>0||nigthArray.length()>0||afternoonArray.length()>0)set.clear();
			for(int i=0 ;i<noonArray.length();i++){
				set.add(noonArray.optString(i));
			}
			for(int i=0 ;i<afternoonArray.length();i++){
				set.add(afternoonArray.optString(i));
			}
			for(int i=0 ;i<nigthArray.length();i++){
				set.add(nigthArray.optString(i));
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 因为没有完全可靠的数据，且已知数据大概有规律，所以，你懂的
	 * @return
	 */
	public static Set getCarFromXml(){
		
		for(int i=16001;i<=16100;i++){
			set.add(new Integer(i).toString());
		}
		for(int i=18001;i<18045;i++){
			set.add(new Integer(i).toString());
		}
//		set.add("16001");
//		set.add("18006");
		return set;
	}
	
	public static Set getCarFromInternet(){
		//如果网上获得数据注意不能更改引用，要clear后重装
		//TODO 
		Set set = new HashSet();
		
		if(false){
			set.clear();
//			set.add
		}
		return set;
	}
	public static void main(String[] args) {
//		System.out.println(getCarFromJson());
	}
	
}
