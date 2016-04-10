package prs.rfh.datagen;

import java.util.HashSet;
import java.util.Set;

/**
 * @since 2016-04-07
 * @author swift
 * 读取车号列表，如果从网络中获取为空，则读取本地缓存列表
 * 如果可以从网络中获取，则将获取的列表存储到    日期.bak 中，以xml形式存储和读取
 * 需要分级加载，该加载只运行一次，分级顺序 1.from xml 2 from internet ，如果2获取到列表，则
 */
public class CarNoReader {
	
	public static final Set set = new HashSet();
	
	public static Set getCarSet(){
		return set;
	}
	/**
	 * 获取已经初始化的车辆列表
	 */
	public static Set generateCarSet(){
		getCarFromXml();
		getCarFromInternet();
		return set;
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
		if(false){
			set.clear();
//			set.add
		}
		return set;
	}
	public static void main(String[] args) {
		System.out.println(getCarFromXml());
	}
	
}
