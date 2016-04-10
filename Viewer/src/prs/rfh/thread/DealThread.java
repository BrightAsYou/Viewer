package prs.rfh.thread;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;

import prs.rfh.crack.lqyc.model.CarDeal;
import prs.rfh.crack.lqyc.model.UserInfoResponse;
import prs.rfh.service.DealCarService;
/**
 * 订单级别线程
 * @author Talent
 * 负责单个用户的单个订单的预约
 */
public class DealThread extends Thread {

	public CookieStore cookieStore = null;
	public CarDeal deal = null;
	public UserInfoResponse user = null;
	
	public DealThread(CarDeal deal , UserInfoResponse user ,CookieStore cookieStore){
		this.deal = deal;
		this.user = user;
		this.cookieStore = cookieStore;
	}
	
	@Override
	public void run() {
		DealCarService dealService = new DealCarService();
		try {
			dealService.dealCar(deal,user,cookieStore);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
}
