package pers.ethan.socketclient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClientBase 
{
    public static void main( String[] args )
    {
    	System.out.println("client:");
    	
    	Socket socket = null;
    	try {
    		// 这里完成三次握手
			socket = new Socket("127.0.0.1", 8765);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	InputStream is = System.in;
    	OutputStream os = null;;
    	try {
			os = socket.getOutputStream();
			int data;
			while ((data = is.read()) != -1) {
				os.write(data);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (os != null) {
				try {
					os.flush();
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (socket != null) {
				try {
					// 这里完成四次握手
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
    	
    }
}
