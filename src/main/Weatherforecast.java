package main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.util.ArrayList;

public class Weatherforecast implements X509TrustManager{

	@Override
	public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public X509Certificate[] getAcceptedIssuers() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static String httpsRequest(String requestUrl,String requestMethod,String outputStr) {
		StringBuffer buffer=null;
		try{
			//創建SSLContext
			SSLContext sslContext=SSLContext.getInstance("SSL");
			TrustManager[] tm={new Weatherforecast()};
			//初始化
			sslContext.init(null, tm, new java.security.SecureRandom());;
			//取SSLSocketFactory對象
			SSLSocketFactory ssf=sslContext.getSocketFactory();
			URL url=new URL(requestUrl);
			HttpsURLConnection conn=(HttpsURLConnection)url.openConnection();
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod(requestMethod);
			//設置當前實例使用的SSLSoctetFactory
			conn.setSSLSocketFactory(ssf);
			conn.connect();
			//往服務器端寫内容
			if(null!=outputStr){
				OutputStream os=conn.getOutputStream();
				os.write(outputStr.getBytes("utf-8"));
				os.close();
			}
			
			//讀取服務器端返回的内容
			InputStream is=conn.getInputStream();
			InputStreamReader isr=new InputStreamReader(is,"utf-8");
			BufferedReader br=new BufferedReader(isr);
			buffer=new StringBuffer();
			String line=null;
			while((line=br.readLine())!=null){
				buffer.append(line);
			}
			}catch(Exception e){
				e.printStackTrace();
			}
			return buffer.toString();
	}
	public String todaysWeather() {
		String str = httpsRequest("https://www.cwb.gov.tw/rss/forecast/36_01.xml","GET",null);
		String[] tokens = str.split("CDATA");
		String nowWeather = tokens[5];
		int last = nowWeather.indexOf("]");
		nowWeather = nowWeather.substring(1,last);
		return nowWeather;
	}
		
	public String weeksWeather() {
		
		String result = "";
		String str = httpsRequest("https://www.cwb.gov.tw/rss/forecast/36_01.xml","GET",null);
		String[] tokens = str.split("CDATA");
		String nowWeather = tokens[5];
		int last = nowWeather.indexOf("]");
		String keep = tokens[6];
		int last1 = keep.indexOf("<br>");
		last = keep.indexOf("]");
		String tomorrowWeather = keep.substring(1,last1) + "\n"+keep.substring(last1+4,last);
		result += tomorrowWeather + "\n\n";
		
		String weekWeatherString = tokens[8];
		String[] weeks = weekWeatherString.split("<BR>");
		weeks[0] = weeks[0].substring(1);
		int x = 0;
		while(x < weeks.length-1) {
			result += weeks[x].substring(1) + "\n";
			x++;
		}
		
		return result;
	}
}
