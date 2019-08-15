package com.spm.model;

public class ComplexityElement {
	public ComplexityElement(String name, double complexity) {
		this.name = name;
		this.complexity = complexity;
	}
	private String name;
	private double complexity;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getComplexity() {
		return complexity;
	}
	public void setComplexity(double complexity) {
		this.complexity = complexity;
	}
}
