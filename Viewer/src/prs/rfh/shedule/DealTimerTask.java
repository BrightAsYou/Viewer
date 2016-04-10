package prs.rfh.shedule;

import java.util.TimerTask;

import org.apache.http.client.CookieStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import prs.rfh.crack.lqyc.model.CarDeal;
import prs.rfh.crack.lqyc.model.UserInfoResponse;
import prs.rfh.thread.DealThread;
import prs.rfh.thread.PersonThread;

public class DealTimerTask extends TimerTask {
	
	private CookieStore cookieStore = null;
	private CarDeal deal = null;
	private UserInfoResponse user = null;
	
	private static final Logger log = LoggerFactory.getLogger(DealTimerTask.class);
	@Override
	public void run() {
		log.debug("定时任务开始触发约车流程");
		new DealThread(deal, user,cookieStore).start();
		
	}
	public DealTimerTask(CarDeal deal ,UserInfoResponse user, CookieStore cookieStore){
//		super();
		this.cookieStore = cookieStore;
		this.deal = deal;
		this.user = user;
	}
	
}
