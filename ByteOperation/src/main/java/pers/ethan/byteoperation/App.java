package pers.ethan.byteoperation;

/**
 * desc:位操作
 * <p>创建人：huangzhe 创建日期：2016年6月3日</p>
 * @version V1.0
 */
public class App 
{
    public static void main( String[] args )
    {
    	Byte byteValue = 8;
    	printBit(byteValue);
    	Byte reverse = (byte) ~byteValue;
    	printBit(reverse);
    }
    
    public static void printBit(Byte byteValue){
    	for (int i = 7; i >= 0; i--) {
			System.out.print(byteValue >> i & 1);
		}
    	System.out.println();
    }
}
