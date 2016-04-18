package pers.ethan.socketserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class TcpServerBase 
{
    public static void main( String[] args )
    {
    	System.out.println("server:");
    	
    	ServerSocket server = null;
    	try {
			server = new ServerSocket(8765);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	Socket socket = null;
    	try {
    		socket = server.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	InputStream in = null;
    	OutputStream os = System.out;
    	try {
			in = socket.getInputStream();
			int data;
			while ((data = in.read()) != -1) {
				os.write(data);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
