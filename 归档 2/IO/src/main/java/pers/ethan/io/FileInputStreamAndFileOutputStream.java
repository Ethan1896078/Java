package pers.ethan.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamAndFileOutputStream {
	public static void main(String args[]){
		File text = new File("/Users/huangzhe/Documents/temp/text");
		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(text);
			fos.write("黄哲 said 'hello world'\n".getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) {
					fos.flush();
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(text);
			int data;
			System.out.print("字节流一个个读：");
			while ((data = fis.read()) != -1) {
				System.out.write(data);
			}
			
			fis = new FileInputStream(text);
			System.out.print("字节流一段段读：");
			byte[] buffer = new byte[3];
			int len;
			while ((len = fis.read(buffer)) != -1) {
				System.out.write(buffer, 0, len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
