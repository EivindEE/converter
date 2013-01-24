package edu.uib.info231.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import edu.uib.info231.gui.ConverterFrame;
import edu.uib.info231.model.CurrencyUnit;
import edu.uib.info231.model.Unit;
/**
 * The Controller class is responsible for setting up the Converter application
 *
 */
public class Controller {
	private ConverterFrame frame;
	private ComboBoxModel comboBoxModel;
	/**
	 * Constructs an instance of Controller using a List<Unit> as an argument
	 * @param currencies A List of currencies
	 */
	public Controller(List<Unit> currencies) {
		this(currencies.toArray(new Unit[0]));
	}
	/**
	 * Constructs an instance of Controller using an array of units (Unit[]) as an argument
	 * @param currencies
	 */
	public Controller(Unit[] currencies) {
		this(new DefaultComboBoxModel(currencies));
	}
	/**
	 * Creates an instance of Controller using a ComboBoxModel as an argument
	 * @param comboBoxModel
	 */
	public Controller(ComboBoxModel comboBoxModel) {
		super();
		this.comboBoxModel = comboBoxModel;
		this.frame = new ConverterFrame(this.comboBoxModel);
	}
	
	public static void main(String[] args) {
		List<Unit> units = new ArrayList<Unit>();
		Unit[] unitArray = new Unit[]{new CurrencyUnit("EUR", 7.442),
		                    new CurrencyUnit("NOK", 1),
		                    new CurrencyUnit("USD", 5.588)};
		for (int i = 0; i < unitArray.length; i += 1 ) {
			units.add(unitArray[i]);
		}
		Controller controller = new Controller(units);
		controller.frame.setTitle("INFO231 converter");
		controller.frame.initialize();

	}
}
