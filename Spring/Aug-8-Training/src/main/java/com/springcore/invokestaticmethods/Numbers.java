package com.springcore.invokestaticmethods;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Numbers {
	
	@Value("#{22 + 11}")
	private Integer a;
	
	@Value("#{22 + 11}")
	private Integer b;
	
	
	@Value("#{ T(java.lang.Math).PI }")
	private double c;

	public Integer getA() {
		return a;
	}

	public void setA(Integer a) {
		this.a = a;
	}

	public Integer getB() {
		return b;
	}

	public void setB(Integer b) {
		this.b = b;
	}
	
	

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "Numbers [a=" + a + ", b=" + b + ", c=" + c + "]";
	}

	
	
	
}
