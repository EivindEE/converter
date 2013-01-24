package edu.uib.info231.model;
/**
 * The ConverterModel is tasked with converting from one unit to another
 */
public class ConverterModel {
	private Unit from;
	private Unit to;
	public ConverterModel(Unit from, Unit to) {
		super();
		this.from = from;
		this.to = to;
	}
	/**
	 * Returns the value of the from Unit to the equivalent amount in the to Unit for the given amount
	 * @param fromAmount The number of from units
	 * @return the value in the to Unit
	 */
	public double convert(double fromAmount) {
		return (from.getValue() / to.getValue()) * fromAmount;
	}
}
