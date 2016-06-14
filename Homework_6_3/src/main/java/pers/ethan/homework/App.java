package pers.ethan.homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Hello world!
 *
 */
public class App 
{
	static int BUFFERSIZE = 8 * 1024;
	
    public static void main( String[] args )
    {
    	zip();
    	unzip();
    }
    
    public static void zip(){
    	FileInputStream fileInputStream = null;
    	ZipOutputStream zipOutputStream = null;
    	try {
    		String inputFileName = "toBeZiped";
    		String outputFileName = "ziped.zip";
    		File inputFile = new File(inputFileName);
    		System.out.println(inputFile.exists());
			fileInputStream = new FileInputStream(inputFile);
			zipOutputStream = new ZipOutputStream(new FileOutputStream(outputFileName));
			zipOutputStream.putNextEntry(new ZipEntry(inputFileName));
			byte bufferArray[]  = new byte[BUFFERSIZE];
			int len = 0;
			while ((len = fileInputStream.read(bufferArray, 0, BUFFERSIZE)) != -1) {
				zipOutputStream.write(bufferArray, 0, BUFFERSIZE);
				System.out.write(bufferArray, 0, BUFFERSIZE);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				zipOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    }
    
    public static void unzip(){
    	ZipInputStream zipInputStream = null;
    	FileOutputStream fileOutputStream = null;
    	
    	try {
			zipInputStream = new ZipInputStream(new FileInputStream("ziped.zip"));
			ZipEntry zipEntry = null;
			while ((zipEntry = zipInputStream.getNextEntry()) != null) {
				String fileName = zipEntry.getName();
				fileOutputStream = new FileOutputStream("_" + fileName);
				byte bufferArray[]  = new byte[BUFFERSIZE];
				int len = 0;
				while ((len = zipInputStream.read(bufferArray, 0, BUFFERSIZE)) != -1) {
					fileOutputStream.write(bufferArray, 0, BUFFERSIZE);
					System.out.write(bufferArray, 0, BUFFERSIZE);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				zipInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				fileOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    	
    }
}
