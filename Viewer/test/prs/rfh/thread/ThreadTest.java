package prs.rfh.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadTest {
	private static final Logger log = LoggerFactory.getLogger(ThreadTest.class);
	
	public static void main(String[] args) {
		StuBean stuList = new StuBean();
		
		while(stuList.hasNext()){
			new CrackThread(stuList.next()).start();
		}
		stuList.printList();
		
	}
}

