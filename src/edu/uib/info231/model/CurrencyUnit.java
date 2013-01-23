package edu.uib.info231.model;

public class Unit {
	private double rate;
	private String type;

	public Unit(String type, double rate) {
		super();
		this.rate = rate;
		this.type = type;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return type;
	}
}
