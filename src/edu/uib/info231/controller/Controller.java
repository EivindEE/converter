package edu.uib.info231.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import edu.uib.info231.Converter;
import edu.uib.info231.model.Unit;

public class Controller {
	
	private List<Unit> currencies = Arrays.asList(new Unit("EUR", 7.442), 
			new Unit("NOK", 1), 
			new Unit("USD", 5.588)
	);
	private Converter converter = new Converter(currencies);
	public static void main(String[] args) {
		new Controller();
	}
}