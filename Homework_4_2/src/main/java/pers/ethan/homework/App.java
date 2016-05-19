package pers.ethan.homework;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Staff aBusinessStaff = new BusinessStaff();
    	Staff aProductStaff = new ProductStaff();
    	Staff aDeveloper = new Developer();
    	Staff aTester = new Tester();
    	Staff aOperationsStaff = new OperationsStaff();
    	aBusinessStaff.work();
    	aProductStaff.work();
    	aDeveloper.work();
    	aTester.work();
    	aOperationsStaff.work();
    }
}
