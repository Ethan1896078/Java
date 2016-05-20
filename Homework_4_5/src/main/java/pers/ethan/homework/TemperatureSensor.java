package pers.ethan.homework;

public class TemperatureSensor extends AbstractSensor {

	public TemperatureSensor(double min, double max) {
		this.min = min;
		this.max = max;
		this.adjustable = new TemperatureAdjuster();
	}
	
	@Override
	protected void warn(double value) {
		System.out.println("警报警报！当前温度" + value + "℃，超过正常范围：(" + min + ", " + max +")");
	}

}
