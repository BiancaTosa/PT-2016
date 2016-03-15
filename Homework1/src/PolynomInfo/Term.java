package PolynomInfo;

public class Term {
	private double coeff;
	private int degree;
	
	public Term (double coeff, int degree){
		this.coeff = coeff;
		this.degree = degree;
	}
	 public void setCoeff(double coeff){
		 this.coeff = coeff;
	 }
	public double getCoeff() {
		return coeff;
	}

	public int getDegree() {
		return degree;
	}

	
	
	
	
}
