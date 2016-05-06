package pers.ethan.socketserver;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MyInetAddress {

	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
			System.out.println("hostName:" + inetAddress.getHostName());
			System.out.println("hostAddress:" + inetAddress.getHostAddress());
			System.out.println("localhost:" + InetAddress.getLocalHost());
			System.out.println("address:" + inetAddress.getAddress());
			System.out.println("canonicalHostName:" + inetAddress.getCanonicalHostName());
			InetAddress[] addresses = InetAddress.getAllByName("www.sina.com.cn");
			System.out.println(addresses.length);
			for (int i = 0; i < addresses.length; i++) {
				System.out.println(addresses[i]);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
