package prs.rfh.test.timer;

import java.util.Date;
import java.util.Timer;

import org.junit.Test;

public class TimerTest {

	@Test
	public void execute(){
		
		Timer timer = new Timer();
		Date date = new Date(new Date().getYear(), 3, 9, 18, 21, 00);
		System.out.println(date);
		timer.schedule(new DealTimerTask(),date );
		
	}
	
	public static void main(String[] args) {
		TimerTest test = new  TimerTest();
		test.execute();
	}
}
