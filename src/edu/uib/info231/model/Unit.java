package edu.uib.info231.model;

public interface Unit {

	public abstract String getType();

	public abstract void setType(String type);

	public abstract String toString();

	public abstract double getValue();

	public abstract void setValue(double value);

}