package pers.ethan.homework;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
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
	
	 private int k = 1; // 定义递归次数变量 
	
    public static void main( String[] args )
    {
    /*	zip("toBeZiped");
    	unzip();*/
    	
    	App app = new App();
    	try {
			app.zip("ziped.zip", new File("dir0"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    
    
    private void zip(String zipFileName, File inputFile) throws Exception {  
        System.out.println("压缩中...");  
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(  
                zipFileName));  
        BufferedOutputStream bo = new BufferedOutputStream(out);  
        zip(out, inputFile, inputFile.getName(), bo);  
        bo.close();  
        out.close(); // 输出流关闭  
        System.out.println("压缩完成");  
    }  
  
    private void zip(ZipOutputStream out, File f, String base,  
            BufferedOutputStream bo) throws Exception { // 方法重载  
        if (f.isDirectory()) {  
            File[] fl = f.listFiles();  
            if (fl.length == 0) {  
                out.putNextEntry(new ZipEntry(base + "/")); // 创建zip压缩进入点base  
                System.out.println(base + "/");  
            }  
            for (int i = 0; i < fl.length; i++) {  
                zip(out, fl[i], base + "/" + fl[i].getName(), bo); // 递归遍历子文件夹  
            }  
            System.out.println("第" + k + "次递归");  
            k++;  
        } else {  
            out.putNextEntry(new ZipEntry(base)); // 创建zip压缩进入点base  
            System.out.println(base);  
            FileInputStream in = new FileInputStream(f);  
            BufferedInputStream bi = new BufferedInputStream(in);  
            int b;  
            while ((b = bi.read()) != -1) {  
                bo.write(b); // 将字节流写入当前zip目录  
            }  
            bi.close();  
            in.close(); // 输入流关闭  
        }  
    }  
    
    
    public static void zip(String inputFileName){
    	File inputFile = new File(inputFileName);
    	String dirPath = null;
    	if (inputFile.isDirectory()) {
    		dirPath = inputFile.getName();
    		File[] listFiles = inputFile.listFiles();
    		for (int i = 0; i < listFiles.length; i++) {
    			File file = listFiles[i];
    			zip(listFiles[i].getName());
    		}
		} else {
			FileInputStream fileInputStream = null;
			ZipOutputStream zipOutputStream = null;
			try {
				String outputFileName = "dirPath.zip";
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
