package pers.ethan.homework;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author ethanhuang
 *
 */
public class Zip 
{
    public static void main( String[] args )
    {
    	String fileName = null;
    	String target = null;
    	if (args.length == 1) {
    		fileName = args[0];
    		target = fileName + ".zip";
    	} else if (args.length == 2) {
    		fileName = args[0];
    		target = args[1];
    	} else {
    		System.out.println("输入参数有误，两种合法的命令格式：1.java Zip 待压缩文件；2.java Zip 待压缩文件 目标文件");
    		System.out.println("示例：1.java Zip D:\\temp\\dir0；2.java Zip D:\\temp\\dir0 D:\\temp\\ziped.zip");
    		System.exit(0);
    	}
    	File file = new File(fileName);
    	try {
    		zip(file, target);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	
    }
    
    /**
     * 递归压缩
     * @param zipFileName
     * @param inputFile
     */
    private static void zip(File inputFile, String zipFileName) {  
        System.out.println("压缩开始，被压缩文件/文件夹：" + inputFile + "，目标文件：" + zipFileName);  
        ZipOutputStream zipOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
		try {
			zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFileName));
			bufferedOutputStream = new BufferedOutputStream(zipOutputStream);  
			zip(zipOutputStream, inputFile, inputFile.getName(), bufferedOutputStream);  
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedOutputStream != null) {
					bufferedOutputStream.close();
				}
				if (zipOutputStream != null) {
					zipOutputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
        System.out.println("压缩完成");  
    }  
  
    private static void zip(ZipOutputStream zipOutputStream, File inputFile, String baseDir, BufferedOutputStream bufferedOutputStream){
    	FileInputStream fileInputStream = null;
    	BufferedInputStream bufferedInputStream = null;
    	try {
    		if (inputFile.isDirectory()) {  
    			File[] file = inputFile.listFiles();  
    			if (file.length == 0) {  
    				zipOutputStream.putNextEntry(new ZipEntry(baseDir + "/"));  
    				System.out.println("压缩 " + baseDir + "/");  
    			}  
    			for (int i = 0; i < file.length; i++) {  
    				zip(zipOutputStream, file[i], baseDir + "/" + file[i].getName(), bufferedOutputStream);
    			}  
    		} else {  
    			zipOutputStream.putNextEntry(new ZipEntry(baseDir)); 
    			System.out.println("压缩 " + baseDir);  
    			fileInputStream = new FileInputStream(inputFile);  
    			bufferedInputStream = new BufferedInputStream(fileInputStream);  
    			int temp;  
    			while ((temp = bufferedInputStream.read()) != -1) {  
    				bufferedOutputStream.write(temp); 
    			}  

    		}  
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedInputStream != null) {
					bufferedInputStream.close();
				}
				if (fileInputStream != null) {
					fileInputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
    }  
    
}
