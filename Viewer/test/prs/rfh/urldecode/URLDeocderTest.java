package prs.rfh.urldecode;

import java.net.URLDecoder;

public class URLDeocderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = URLDecoder.decode("ipaddress=192.168.1.109&ossdk=22&os=an&trainType=&appversion=2.9.1&params=18006.2016%E5%B9%B404%E6%9C%8811%E6%97%A5.15.&version=2.9.1&jlcbh=&xxzh=51513605&isJcsdYyMode=5&imei=357143048886748&appkey=ab916c7221df52f79d4debbaab51f794&osversion=5.1.1");
		String str1 = URLDecoder.decode("ipaddress=192.168.1.117&ossdk=22&os=an&trainType=&appversion=3.0.0&params=16005.2016%E5%B9%B404%E6%9C%8828%E6%97%A5.812.&version=3.0.0&jlcbh=&xxzh=51513605&isJcsdYyMode=5&imei=357143048886748&osversion=5.1.1");
		String str3 = URLDecoder.decode("ipaddress=192.168.1.117&ossdk=22&os=an&trainType=&appversion=3.0.0&params=18044.2016%E5%B9%B404%E6%9C%8828%E6%97%A5.58.&version=3.0.0&jlcbh=&xxzh=51513605&isJcsdYyMode=5&imei=357143048886748&osversion=5.1.1");
		//ipaddress=192.168.1.117&ossdk=22&os=an&trainType=&appversion=3.0.0&params=18044.2016%E5%B9%B404%E6%9C%8828%E6%97%A5.58.&version=3.0.0&jlcbh=&xxzh=51513605&isJcsdYyMode=5&imei=357143048886748&osversion=5.1.1
		String str4 = URLDecoder.decode("KM2/ClYyCars2?&ipaddress=192.168.1.107&os=an&ossdk=22&filters%5Bxnsd%5D=2811&appversion=3.0.3&filters%5Bxxzh%5D=51513605&version=3.0.3&filters%5Byyrq%5D=2016%E5%B9%B406%E6%9C%8804%E6%97%A5&filters%5Bjlcbh%5D=&xxzh=51513605&filters%5BtrainType%5D=&imei=357143048886748&osversion=5.1.1");
		//http://longquanapi.xuechebu.com/KM2/ClYyCars2?&ipaddress=192.168.1.107&os=an&ossdk=22&filters[xnsd]=2811&appversion=3.0.3&filters[xxzh]=51513605&version=3.0.3&filters[yyrq]=2016年06月04日&filters[jlcbh]=&xxzh=51513605&filters[trainType]=&imei=357143048886748&osversion=5.1.1
		System.out.println(str);
		System.out.println(str1);
		System.out.println(str3);
		System.out.println(str4);
	}

}
