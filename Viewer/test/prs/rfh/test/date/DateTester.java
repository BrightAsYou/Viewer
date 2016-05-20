package prs.rfh.test.date;

import java.util.Date;

public class DateTester {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date.getHours());
		
		Date currentDate = new Date();
		if(currentDate.getHours()>=12){
			currentDate.setDate(currentDate.getDate()+1);
		}
		System.out.println(currentDate.getDate());
	}
}
