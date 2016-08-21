package prs.rfh.crack.lqyc;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javassist.bytecode.Descriptor.Iterator;
import prs.rfh.crack.lqyc.model.UserInfoResponse;
import prs.rfh.shedule.LoginTimerTask;
import prs.rfh.thread.PersonThread;
import prs.rfh.util.DOMUtil;

public class TOSTART {
	private static final Logger log = LoggerFactory.getLogger(PersonThread.class);
	public static void main(String[] args) throws DocumentException {
		// TODO Auto-generated method stub
		Map map = new HashMap();
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
		for(int i=0 ;i< userList.size(); i++){
			for(int j=0;j< list.size();j++){
				if(userList.get(i).equals(userList.get(j))){
					boo=false;
					break;
				}
			}
			if(boo)list.add(userList.get(i));
		}
		Date currentDate = new Date();
		if(currentDate.getHours()>=12){
			currentDate.setDate(currentDate.getDate()+1);
		}
		Date dealDate = new Date(currentDate.getYear(),currentDate.getMonth(),currentDate.getDate(),6,57,59);
		Timer timer = new Timer();
		log.debug("合法性检查结束，将对合法的【"+list.size()+"】个用户进行登录，时间"+dealDate.toLocaleString());
		timer.schedule(new LoginTimerTask(list), dealDate);

	}

}
