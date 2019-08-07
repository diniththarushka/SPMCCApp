package com.spm.model;

public class ComplexityFactor {
	private double complexity;
	private double sTotalComplexity;
	private double sComplexity_Size;
	private double sComplexity_ContrStruct;
	private double sComplexity_NestContrStruct;
	private double sComplexity_Inherit;
	private double complexity_Recursion;
	private double[] statementComplexityArr;
	
	public ComplexityFactor(String[] SC) {
		this.setComplexity(0);
		this.setsTotalComplexity(0);
		this.statementComplexityArr = new double[SC.length];
		
		//loop to go through each statement while calculating complexity
		
	}
	
	public void calc_sComplexity_Size(String statement) {
		int Cs = 0;
		
		if(statement.contains("&")) {
			//if(statement.contains("*"))
		}else if(statement.contains("*")) {
			
		}
	}
	
	public double getComplexity() {
		return complexity;
	}
	public void setComplexity(double complexity) {
		this.complexity = complexity;
	}
	public double getsTotalComplexity() {
		return sTotalComplexity;
	}
	public void setsTotalComplexity(double sTotalComplexity) {
		this.sTotalComplexity = sTotalComplexity;
	}
	public double getsComplexity_Size() {
		return sComplexity_Size;
	}
	public void setsComplexity_Size(double sComplexity_Size) {
		this.sComplexity_Size = sComplexity_Size;
	}
	public double getsComplexity_ContrStruct() {
		return sComplexity_ContrStruct;
	}
	public void setsComplexity_ContrStruct(double sComplexity_ContrStruct) {
		this.sComplexity_ContrStruct = sComplexity_ContrStruct;
	}
	public double getsComplexity_NestContrStruct() {
		return sComplexity_NestContrStruct;
	}
	public void setsComplexity_NestContrStruct(double sComplexity_NestContrStruct) {
		this.sComplexity_NestContrStruct = sComplexity_NestContrStruct;
	}
	public double getsComplexity_Inherit() {
		return sComplexity_Inherit;
	}
	public void setsComplexity_Inherit(double sComplexity_Inherit) {
		this.sComplexity_Inherit = sComplexity_Inherit;
	}
	public double getComplexity_Recursion() {
		return complexity_Recursion;
	}
	public void setComplexity_Recursion(double complexity_Recursion) {
		this.complexity_Recursion = complexity_Recursion;
	}
}
