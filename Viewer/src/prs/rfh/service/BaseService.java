package prs.rfh.service;

import java.io.File;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

public class BaseService {
//	public static final PropertiesReader
	public static final File properties = new File(Class.class.getClass().getResource("/").getPath()+"/address_LQ.properties");
	public final HttpClient dealClient =new DefaultHttpClient();
}
