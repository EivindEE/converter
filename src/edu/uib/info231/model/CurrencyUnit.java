package edu.uib.info231.model;

public class CurrencyUnit implements Unit{
	private double value;
	private String type;

	public CurrencyUnit(String type, double rate) {
		super();
		this.setValue(rate);
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see edu.uib.info231.model.Unit#getType()
	 */
	@Override
	public String getType() {
		return type;
	}

	/* (non-Javadoc)
	 * @see edu.uib.info231.model.Unit#setType(java.lang.String)
	 */
	@Override
	public void setType(String type) {
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see edu.uib.info231.model.Unit#toString()
	 */
	@Override
	public String toString() {
		return type;
	}

	/* (non-Javadoc)
	 * @see edu.uib.info231.model.Unit#getValue()
	 */
	@Override
	public double getValue() {
		return value;
	}

	/* (non-Javadoc)
	 * @see edu.uib.info231.model.Unit#setValue(double)
	 */
	@Override
	public void setValue(double value) {
		this.value = value;
	}
}
