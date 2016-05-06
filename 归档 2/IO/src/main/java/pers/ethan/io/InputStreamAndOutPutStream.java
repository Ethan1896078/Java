package pers.ethan.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InputStreamAndOutPutStream {
	public static void main(String[] args) {
		InputStream in = null;
		OutputStream out = null;
		in = System.in;
		out = System.out;
		int data;
		try {
			while ((data = in.read()) != -1) {
				out.write(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				if (out != null) {
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
