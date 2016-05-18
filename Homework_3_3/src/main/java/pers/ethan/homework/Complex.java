package pers.ethan.homework;

public class Complex {
	
	private double imaginary;
	private double real;
	
	public Complex(double imaginary, double real){
		this.imaginary = imaginary;
		this.real = real;
	}
	
	public Complex add(Complex complex){
		double imaginary = this.imaginary + complex.imaginary;
		double real = this.real + complex.real;
		return new Complex(imaginary, real);
	}
	
	public Complex substract(Complex complex){
		double imaginary = this.imaginary - complex.imaginary;
		double real = this.real - complex.real;
		return new Complex(imaginary, real);
	}
	
	public Complex multiply(Complex complex){
		double imaginary = this.imaginary * complex.real + this.real * complex.imaginary;
		double real = this.imaginary * complex.imaginary * -1 + this.real * complex.real;
		return new Complex(imaginary, real);
	}
	
	/**
	 * 计算除法的过程是分子分母同乘以分母的共轭表达式，使得分母常数化
	 * @param complex
	 * @return
	 */
	public Complex divide(Complex complex){
		Complex adjoint = new Complex(complex.imaginary, complex.real * -1);
		double denominator = (complex.multiply(adjoint)).real;
		Complex numerator = this.multiply(adjoint);
		return new Complex(numerator.imaginary / denominator, numerator.real / denominator);
	}
	
	@Override
	public String toString() {
		return "" + imaginary + "i + " + real;
	}

	public static void main(String[] args) {
		Complex c2_4 = new Complex(2, 4);
		Complex c3_1 = new Complex(3, 1);
		System.out.println(c2_4.add(c3_1));
		System.out.println(c2_4.substract(c3_1));
		System.out.println(c2_4.multiply(c3_1));
		System.out.println(c2_4.multiply(c3_1).divide(c2_4));
	}
}
