package pers.ethan.anytest;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Maps;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
/*    	List<String> list1 = new ArrayList<String>();
    	List<String> list2 = new ArrayList<String>();
    	System.out.println(list1.equals(list2));
    	list1.add("1");
    	list2.add("1");
    	System.out.println(list1.equals(list2));
    	
    	int [] intArray1 = new int[5];
    	int [] intArray2 = new int[5];
    	System.out.println(intArray1.equals(intArray2));
    	System.out.println(Arrays.equals(intArray1, intArray2));*/
    	
    	/*Integer[] i = {2, 1, 5, 3, 4};
    	print(i);
    	Arrays.sort(i);
    	print(i);
    	Arrays.sort(i, Collections.reverseOrder());
    	print(i);
    	
    	System.out.println(new Integer(1).equals(new Integer(1)));*/
    	
		/*Map<String, Object> singerInfo = Maps.newHashMap(); 
		Map<String, Object> SINGER_TYPE_MAPPING = Maps.newHashMap();
		Map<String, Object> SINGER_REGION_MAPPING = Maps.newHashMap();
		SINGER_REGION_MAPPING.put("area_id", "");
		String singerName = String.valueOf(singerInfo.get("author_name"));
		Object typeObj = singerInfo.get("type");
		Integer singerTypeFromKugou = typeObj != null && StringUtils.isNotBlank(typeObj.toString()) ? Integer.valueOf(typeObj.toString()) : null;
		Object areaId = singerInfo.get("area_id");
		Integer singerRegionFromKugou = areaId != null && StringUtils.isNotBlank(areaId.toString()) ? Integer.valueOf(areaId.toString()) : null;*/
    	
    	Integer a = null;
    	System.out.println("null".equals(String.valueOf(a)));
		
    }
    
    public static void print(Integer[] args){
    	for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
    	System.out.println("-------------！！！！");
    }
}

class A{
	
}