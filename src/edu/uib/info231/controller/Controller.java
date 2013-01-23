package edu.uib.info231.controller;

import java.util.ArrayList;
import java.util.List;

import edu.uib.info231.gui.ConverterFrame;
import edu.uib.info231.model.CurrencyUnit;
import edu.uib.info231.model.Unit;

public class Controller {
	private ConverterFrame frame;


	public Controller(List<Unit> currencies) {
		super();
		this.frame = new ConverterFrame(currencies);
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
		controller.frame.initialize();

	}
}
