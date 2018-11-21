package com.drkiettran.financemath.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SimpleInterest {
	@JsonProperty("current_value")
	private BigDecimal cv;
	
	@JsonProperty("future_value")
	private BigDecimal fv;
	
	@JsonProperty("interest")
	private BigDecimal i;
	
	@JsonProperty("number_of_periods")
	private BigDecimal n;
	
	@JsonProperty("rate")
	private BigDecimal r;

	public BigDecimal getCv() {
		return cv;
	}

	public void setCv(BigDecimal cv) {
		this.cv = cv;
	}

	public BigDecimal getFv() {
		return fv;
	}

	public void setFv(BigDecimal fv) {
		this.fv = fv;
	}

	public BigDecimal getI() {
		return i;
	}

	public void setI(BigDecimal i) {
		this.i = i;
	}

	public BigDecimal getN() {
		return n;
	}

	public void setN(BigDecimal n) {
		this.n = n;
	}

	public BigDecimal getR() {
		return r;
	}

	public void setR(BigDecimal r) {
		this.r = r;
	}
	
}
