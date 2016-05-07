package prs.rfh.crack.lqyc.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

/**
 * 
 * @author swift
 * @since 2016-04-07
 * 存储约车交易，若已经被该用户试图预约isFinish由0置为1
 * 若该车已经被预约则isDealed由0置为1
 */
public class CarDeal {

	public CarDeal(String carNo){
		Date date = new Date();
		date.setDate(date.getDate()+6);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		String dataStr = sdf.format(date);
		this.dealdate = dataStr;
		this.isFinish = "0";
		this.isDealed = "0";
		this.carNo = carNo;
	}
	
	public CarDeal(String carNo,String flag){
		if(flag.equals("A")){
			Date date = new Date();
			date.setDate(date.getDate()+2);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
			String dataStr = sdf.format(date);
			this.dealdate = dataStr;
			this.isFinish = "0";
			this.isDealed = "0";
			this.carNo = carNo;
		}else if(flag.equals("B")){
			Date date = new Date();
			date.setDate(date.getDate()+3);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
			String dataStr = sdf.format(date);
			this.dealdate = dataStr;
			this.isFinish = "0";
			this.isDealed = "0";
			this.carNo = carNo;
		}
	}
	
	public CarDeal(String carNo, String dealdate, String isFinish, String isDealed) {
		super();
		this.carNo = carNo;
		this.dealdate = dealdate;
		this.isFinish = isFinish;
		this.isDealed = isDealed;
	}
	
	private String carNo;
	private String dealdate;
	private String isFinish;
	private String isDealed;
	
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public String getDealdate() {
		return dealdate;
	}
	public void setDealdate(String dealdate) {
		this.dealdate = dealdate;
	}
	public String getIsFinish() {
		return isFinish;
	}
	public void setIsFinish(String isFinish) {
		this.isFinish = isFinish;
	}
	public String getIsDealed() {
		return isDealed;
	}
	public void setIsDealed(String isDealed) {
		this.isDealed = isDealed;
	}
	public static void main(String[] args) {
		new CarDeal("123");
		Date today = new Date();
		today.setDate(today.getDate()+2);
			
		System.out.println(today);
	}
	
}
