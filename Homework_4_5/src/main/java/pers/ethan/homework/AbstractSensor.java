package pers.ethan.homework;

import java.text.DecimalFormat;

public abstract class AbstractSensor implements Sensable{
	/** 正常范围的最低值 */
	protected double min;
	/** 正常范围的最高值 */
	protected double max;
	/** 调节器 */
	protected Adjustable adjustable;
	
	public void sense(double value) {
		if (value < min || value > max) {
			warn(Double.parseDouble(new DecimalFormat("##.00").format(value)));
			adjust();
		}
	}
	
	/**
	 * desc:警报
	 * <p>创建人：huangzhe , 2016年5月20日下午2:27:53</p>
	 * @param value
	 */
	protected abstract void warn(double value);
	
	/**
	 * desc:调节
	 * <p>创建人：huangzhe , 2016年5月20日下午2:27:59</p>
	 */
	protected void adjust(){
		adjustable.adjust();
	}
}
