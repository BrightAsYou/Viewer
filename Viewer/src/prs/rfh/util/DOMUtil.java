package prs.rfh.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.dom.DOMDocument;
import org.dom4j.io.SAXReader;

import prs.rfh.crack.lqyc.model.UserInfoResponse;

public class DOMUtil {
	
	private static Document document = new DOMDocument();
	
	
	public static List<UserInfoResponse> getListByLocationXML(File file) throws DocumentException{
		SAXReader sr = new SAXReader();//��ȡ��ȡxml�Ķ���
		Document doc = sr.read(file);//�õ�xml����λ�á�Ȼ��ʼ��ȡ���������ݷ���doc��
		Element el_root = doc.getRootElement();//����ȡ���ݣ���ȡxml�ĸ��ڵ㡣
		Iterator it = el_root.elementIterator();//�Ӹ��ڵ������α�������ȡ���ڵ��������ӽڵ�
		List<UserInfoResponse> userList = new ArrayList<UserInfoResponse>();
		while(it.hasNext()){//�����ڵ�
		    UserInfoResponse userInfo = new UserInfoResponse();
		    Iterator el_ename = ((Element)it.next()).elementIterator();//��ȡ�ýڵ��µ��������ݡ�
		    while(el_ename.hasNext()){
		    	Element elem = (Element)el_ename.next();
		    	if("xxzh".equals(elem.getName())){
		    		userInfo.setXxzh(elem.getText());
		    	}else if("password".equals(elem.getName())){
		    		userInfo.setPassword(elem.getText());
		    	}else if("jgid".equals(elem.getName())){
		    		userInfo.setJgid(elem.getText());
		    	}else if("dealdate".equals(elem.getName())){
		    		userInfo.setDealdate(elem.getText());
		    	}
		    }
		    userList.add(userInfo);
		    System.out.println(userInfo);
		}
		return userList;
	}
	
	
	
	
	public static void main(String[] args) throws DocumentException {
//		getListByLocationXML(new File(Class.class.getClass().getResource("/").getPath()+"/userDatas.xml"));
	
		Document document = new DOMDocument();
//		document.createXPath(Class.class.getClass())
		
	}
	
}
