package prs.rfh.crack.lqyc;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javassist.bytecode.Descriptor.Iterator;
import prs.rfh.crack.lqyc.model.UserInfoResponse;
import prs.rfh.thread.PersonThread;
import prs.rfh.util.DOMUtil;

public class TOSTART {
	private static final Logger log = LoggerFactory.getLogger(PersonThread.class);
	
	public static void main(String[] args) throws DocumentException {
		// TODO Auto-generated method stub
		
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
		
		log.debug("合法性检查结束，将对合法的【"+list.size()+"】个用户进行登录");
		for(UserInfoResponse user:list){
			new PersonThread(user).start();
		}
	}

}
