package pers.ethan.homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author ethanhuang
 *
 */
public class App 
{
	static class EncodeInputStream extends FilterInputStream{

		protected EncodeInputStream(InputStream paramInputStream) {
			super(paramInputStream);
		}

		@Override
		public int read() throws IOException {
			int read = super.read();
			if (read == -1) {
				return -1;
			}
			// 读取时取反
			byte reverse = (byte)~read;
			return reverse;
		}
	}
	
	static class DecodeOutputStream extends FilterOutputStream{

		public DecodeOutputStream(OutputStream paramOutputStream) {
			super(paramOutputStream);
		}

		@Override
		public void write(int paramInt) throws IOException {
			// 写的时候取反
			out.write(~paramInt);
		}
		
	}
	
    public static void main( String[] args )
    {
    	EncodeInputStream encodeInputStream = null;
    	DecodeOutputStream decodeFileOutputStream = null;
    	DecodeOutputStream decodePrintStream = null;
    	FileOutputStream fileOutputStream = null;
    	try {
    		encodeInputStream = new EncodeInputStream(new FileInputStream(new File("/Users/huangzhe/Documents/temp/source")));
    		decodeFileOutputStream = new DecodeOutputStream(new FileOutputStream(new File("/Users/huangzhe/Documents/temp/decodeTarget")));
    		decodePrintStream = new DecodeOutputStream(System.out);
    		fileOutputStream = new FileOutputStream("/Users/huangzhe/Documents/temp/undecodeTarget");
    		int t = 0;
			while ((t = encodeInputStream.read()) != -1) {
				// 普通的FileOutputStream无法正确读取EncodeInputStream的内容
				fileOutputStream.write(t);
				// 带有解密功能的处理流DecodeOutputStream可以正确读取EncodeInputStream的内容
				decodeFileOutputStream.write(t);
				decodePrintStream.write(t);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				encodeInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				decodeFileOutputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fileOutputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
    
    
}
