package pers.ethan.file;

import java.io.File;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        showFile(new File("dir0"));
    }
    
    public static void showFile(File file){
    	if (!file.exists()) {
			System.out.println("file does not exists.");
		}
    	
    	if (file.isDirectory()) {
			File[] listFiles = file.listFiles();
			for (int i = 0; i < listFiles.length; i++) {
				showFile(listFiles[i]);
			}
		} else {
			System.out.println(file.getAbsolutePath());
		}
    }
}
