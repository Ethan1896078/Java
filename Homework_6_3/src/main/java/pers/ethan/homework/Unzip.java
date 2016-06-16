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

public class Unzip {
	public static void main(String[] args) {
    	String fileName = null;
    	String targetDir = null;
		if (args.length == 1) {
    		fileName = args[0];
    		targetDir = fileName.substring(0, fileName.lastIndexOf("\\"));
    	} else if (args.length == 2) {
    		fileName = args[0];
    		targetDir = args[1];
    	} else {
    		System.out.println("输入参数有误，两种合法的命令格式：1.java Unzip 待解压文件；2.java Unzip 待解压文件 目标文件夹");
    		System.out.println("示例：1.java Unzip D:\\temp\\ziped.zip；2.java Unzip D:\\temp\\ziped.zip C:\\Users\\ethanhuang\\Desktop");
    		System.exit(0);
    	}
		
		
		System.out.println("解压开始");  
		ZipInputStream zipInputStream = null;
		BufferedInputStream bufferedInputStream = null;
		FileOutputStream fileOutputStream = null;  
		BufferedOutputStream bufferedOutputStream = null;  
        try {  
            zipInputStream = new ZipInputStream(new FileInputStream(fileName));
            bufferedInputStream = new BufferedInputStream(zipInputStream);  
            File file = null;  
            ZipEntry entry;  
            while((entry = zipInputStream.getNextEntry()) != null && !entry.isDirectory()){  
                file = new File(targetDir, entry.getName());  
                if(!file.exists()){  
                    (new File(file.getParent())).mkdirs();  
                }  
                fileOutputStream = new FileOutputStream(file);  
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);  
                int b;  
                while((b=bufferedInputStream.read()) != -1){  
                    bufferedOutputStream.write(b);  
                }  
                bufferedOutputStream.close();  
                fileOutputStream.close();  
                System.out.println("解压 " + file);      
            }  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedInputStream != null) {
					bufferedInputStream.close();
				}
				if (zipInputStream != null) {
					zipInputStream.close();
				}
				if (fileOutputStream != null) {
					fileOutputStream.close();
				}
				if (bufferedOutputStream != null) {
					bufferedOutputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}  
		}
        System.out.println("解压完成");  
	}
}
