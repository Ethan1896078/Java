package pers.ethan.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

public class InputStreamReaderDemo {
	public static void main(String[] args) {
		// 直接对字节流读写，碰到中文时显示乱码
		/*try {
			int t = 0;
			while ((t = System.in.read()) != -1) {
				System.out.print((char)t);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		// 将字节流转换成字符流
		Reader inputStreamReader = null;
		try {
			inputStreamReader = new InputStreamReader(new FileInputStream(new File("/Users/huangzhe/Documents/temp/source")));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Writer printWriter = new PrintWriter(System.out);
		int tStr = 0;
		try {
			while ((tStr = inputStreamReader.read()) != -1) {
				printWriter.write(tStr);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				inputStreamReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				printWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
