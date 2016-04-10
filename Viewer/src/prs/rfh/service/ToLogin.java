package prs.rfh.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import prs.rfh.util.PropertiesReader;

public class ToLogin extends BaseService{

	private static final Logger log = LoggerFactory.getLogger(ToLogin.class);
	static {
		try {
			final String loginPath = PropertiesReader.getPropertieyByKey("login_addr", properties);
		} catch (FileNotFoundException e) {
			log.debug("properties文件未找到");
			e.printStackTrace();
		} catch (IOException e) {
			log.debug("properties文件读取失败");
			e.printStackTrace();
		}
	}
	
}
