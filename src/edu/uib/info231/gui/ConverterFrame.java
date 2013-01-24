package edu.uib.info231.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.uib.info231.model.ConverterModel;
import edu.uib.info231.model.Unit;
/**
 * ConverterFrame is the frame that holds the interface for the converter application
 */
public class ConverterFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private Container contentPane = this.getContentPane();
	private ToggelButton button = new TextToggleButton(">");
	private JPanel unitPanel = new JPanel();
	private JPanel panelBottom = new JPanel();
	private JComboBox unit1 = new JComboBox();
	private JComboBox unit2 = new JComboBox();
	private JTextField value1 = new JTextField("");
	private JTextField value2 = new JTextField("");
	private JButton convert = new JButton("Convert!!!");
	private ComboBoxModel units1;
	private ComboBoxModel units2;

	/**
	 * Creates a new ConverterFrame. The units provided will be the units one can convert between
	 * @param currencies, the currencies one can convert between
	 */
	public ConverterFrame(Unit[] currencies) {
		this.units1 = new DefaultComboBoxModel(currencies);
		this.units2 = new DefaultComboBoxModel(currencies);
		this.unit1 = new JComboBox(this.units1);
		this.unit2 = new JComboBox(this.units2);
	}
	/**
	 * Initializes the ConverterFrame to the default state
	 */
	public void initialize() {
		final DecimalFormat Currency = new DecimalFormat("#0.00");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.contentPane.setLayout(new BorderLayout());
		this.initUnitPanel();
		this.initInputPanel();
		
		this.convert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField from = null;
				Unit fromUnit = null;
				JTextField to = null;
				Unit toUnit = null;
				if (button.getText().equals(">")) {
					from = value1;
					fromUnit = (Unit) unit1.getSelectedItem();
					to = value2;
					toUnit = (Unit) unit2.getSelectedItem();
				} else {
					from = value2;
					fromUnit = (Unit) unit2.getSelectedItem();
					to = value1;
					toUnit = (Unit) unit1.getSelectedItem();
				}
				double fromValue = Double.parseDouble(from.getText());
				ConverterModel converterModel = new ConverterModel(fromUnit, toUnit);
				to.setText(Currency.format(converterModel.convert(fromValue)));
			}
		});
		
		this.contentPane.add(unitPanel, BorderLayout.NORTH);
		this.contentPane.add(panelBottom, BorderLayout.CENTER);
		this.contentPane.add(convert, BorderLayout.SOUTH);
		this.setSize(350, 150);
		this.setVisible(true);

	}
	
	private void initInputPanel() {
		this.value1.setColumns(5);
		this.value2.setColumns(5);
		
		this.button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				button.toggle();
			}
		});
		this.panelBottom.add(value1);
		this.panelBottom.add(button);
		this.panelBottom.add(value2);
		
	}
	
	private void initUnitPanel() {
		this.unitPanel.setLayout(new FlowLayout());
		this.unitPanel.add(unit1);
		this.unitPanel.add(unit2);
	}
}
