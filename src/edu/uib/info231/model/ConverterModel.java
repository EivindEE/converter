package edu.uib.info231.model;

public class ConverterModel {
	private Unit from;
	private Unit to;
	public ConverterModel(Unit from, Unit to) {
		super();
		this.from = from;
		this.to = to;
	}
	
	public double convert(int fromAmout) {
		return (from.getRate() / to.getRate()) * fromAmout;
	}
}