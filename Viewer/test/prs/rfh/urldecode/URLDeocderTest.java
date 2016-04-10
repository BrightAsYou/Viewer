package prs.rfh.urldecode;

import java.net.URLDecoder;

public class URLDeocderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = URLDecoder.decode("ipaddress=192.168.1.109&ossdk=22&os=an&trainType=&appversion=2.9.1&params=18006.2016%E5%B9%B404%E6%9C%8811%E6%97%A5.15.&version=2.9.1&jlcbh=&xxzh=51513605&isJcsdYyMode=5&imei=357143048886748&appkey=ab916c7221df52f79d4debbaab51f794&osversion=5.1.1");
		System.out.println(str);
	}

}
