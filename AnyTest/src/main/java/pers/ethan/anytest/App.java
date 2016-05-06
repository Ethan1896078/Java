package pers.ethan.anytest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Map<Integer, String> map = new HashMap<Integer, String>();
    	Integer i = 0;
    	while (i <= 800000) {
    		map.put(i++, String.valueOf(i*i*i));
    		System.out.println(i);
		}
    	List<String> list = new ArrayList<String>();
    	
    }
}

class A{
	
}