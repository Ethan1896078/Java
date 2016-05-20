package pers.ethan.homework;

import java.text.DecimalFormat;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	DecimalFormat decimalFormat = new DecimalFormat("0.00");
    	
    	Sensable temperatureSensor = new TemperatureSensor(25D, 35D);
    	for (int i = 0; i < 5; i++) {
    		double temperature = 20 + Math.random() * 20;
    		temperatureSensor.sense(temperature);
		}
    	
    	Sensable humiditySendor = new HumiditySensor(70D, 80D);
    	for (int i = 0; i < 5; i++) {
    		double humidity = 65 + Math.random() * 20;
    		humiditySendor.sense(humidity);
		}
    }
}
