package prs.rfh.thread;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import prs.rfh.httpclient.HttpClientTest;

public class StuBean {

	Logger log = LoggerFactory.getLogger(HttpClientTest.class);
	
	private final  List<Deal> list = new ArrayList<Deal>();
	StuBean(){
		list.add(new Deal("A","1"));//1代表尚未执行
		list.add(new Deal("B","1"));
		list.add(new Deal("C","1"));
//		list.add(new Deal("D","1"));
//		list.add(new Deal("E","1"));
//		list.add(new Deal("F","1"));
//		list.add(new Deal("G","1"));
//		list.add(new Deal("H","1"));
//		list.add(new Deal("I","1"));
	}
	public List getStuList() {
		return list;
	}
	
	public Deal getAvailableDeal(){
		
		for(Deal deal : list ){
			if("1".equals(deal.getIsFinished())){
				log.debug("StuBean["+deal.getName()+"]selected and finished");
				deal.setFinish();
				return deal;
			}
		}
		return null;
	}
	public Deal next(){
		return getAvailableDeal();
	}
	
	public boolean hasNext(){
		for(Deal deal : list ){
			if("1".equals(deal.getIsFinished())){
				log.debug("StuBean["+deal.getName()+"]hasNext");
				return true;
			}
		}
		return false;
	}
	
	public void printList(){
		for(Deal deal:list){
			log.debug(deal.toString());
		}
	}
	
}
