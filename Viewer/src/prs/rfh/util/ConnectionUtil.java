package prs.rfh.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public class ConnectionUtil {
	
	
	
	public static URLConnection conn ;
	
	
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://222.35.42.116:801/eaccount/checkNetImgSave.do?Mobile=1111");
//		InputStream is = conn.getInputStream();
		conn = url.openConnection();
		conn.setDoOutput(true);
		
		conn.setDoInput(true);
		conn.setReadTimeout(60*1000);
		conn.setUseCaches(false);
		conn.connect();
		OutputStream os = conn.getOutputStream();
		
//		conn.set
		os.flush();
		InputStream is = conn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		String currentLine ="";
		while((currentLine = br.readLine() )!= null){
			System.out.println(currentLine);
		}
		os.close();
		
//		 DefaultHttpClient httpClient = new DefaultHttpClient();
//		 HttpPost post = new HttpPost("http://222.35.42.116:801/eaccount/checkNetImgSave.do?Mobile=1111");
//			HttpResponse resp = httpClient.execute(post);
	}
	
}
