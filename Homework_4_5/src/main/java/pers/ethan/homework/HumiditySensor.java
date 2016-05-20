package pers.ethan.homework;

public class HumiditySensor extends AbstractSensor{
	
	public HumiditySensor(double min, double max) {
		this.min = min;
		this.max = max;
		this.adjustable = new HumidityAdjuster();
	}

	@Override
	protected void warn(double value) {
		System.out.println("警报警报！当前湿度" + value + "单位，超过正常范围：(" + min + ", " + max +")");
	}
	
}
