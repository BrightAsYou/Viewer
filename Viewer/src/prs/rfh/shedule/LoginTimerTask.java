package prs.rfh.shedule;

import java.util.List;
import java.util.TimerTask;

import org.apache.http.client.CookieStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import prs.rfh.crack.lqyc.model.CarDeal;
import prs.rfh.crack.lqyc.model.UserInfoResponse;
import prs.rfh.thread.DealThread;
import prs.rfh.thread.PersonThread;

public class LoginTimerTask extends TimerTask {
	

	private List<UserInfoResponse> userList;
	private static final Logger log = LoggerFactory.getLogger(LoginTimerTask.class);
	@Override
	public void run() {
		log.debug("定时任务开始触发约车流程");
		for(UserInfoResponse user:userList){
			new PersonThread(user).start();
		}
		
	}
	public LoginTimerTask(List<UserInfoResponse> userList){
//		super();
		this.userList= userList;
	}
	
}
