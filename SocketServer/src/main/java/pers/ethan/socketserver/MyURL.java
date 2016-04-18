package pers.ethan.socketserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MyURL {

	private static byte i;	
	
	public static void main(String[] args) {
		try {
			URL url = new URL("http://115.182.230.9:8094/baseplat/");
			URLConnection urlConnection = url.openConnection();
			System.out.println(urlConnection.getContent());
			System.out.println(urlConnection.getURL());
			System.out.println(urlConnection.getContentEncoding());
			System.out.println(urlConnection.getURL());
			System.out.println(urlConnection.getURL().getProtocol());
			System.out.println(i);
			BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			System.out.println(sb);
			/*HttpURLConnection httpURLConnection = null;
			if (urlConnection instanceof HttpURLConnection) {
				httpURLConnection = (HttpURLConnection)urlConnection;
				BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
				StringBuilder sb = new StringBuilder();
				String line = null;
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				System.out.println(sb);
			}*/
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
