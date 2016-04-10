package prs.rfh.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import prs.rfh.crack.lqyc.CrackLQ;

public class CrackThread extends Thread{
	private static final Logger log = LoggerFactory.getLogger(CrackThread.class);
	private Deal deal;
	public CrackThread(Deal deal){
		log.debug("init CrackThread");
		this.deal = deal;
		
	}
	@Override
	public void run() {
		log.debug("Thread["+this.getId()+"]-["+this.getName()+"] is running...");
		
		log.debug("dealing a deal for ["+deal.getName()+"]");
		
	}

}