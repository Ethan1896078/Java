package pers.ethan.myassert;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Account account = new Account();
    	account.deposit(-1);
    }
    
}

class Account{
	public double balance = 0;
	
	public void deposit(double amount){
		assert amount > 0 && balance >= 0;
		System.out.println("存入" + amount + "元");
		balance += amount;
		assert balance >= 0;
	}
}

