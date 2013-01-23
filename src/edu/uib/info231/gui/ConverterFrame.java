package edu.uib.info231.gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.uib.info231.model.ConverterModel;
import edu.uib.info231.model.Unit;

public class ConverterFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton button = new JButton(">");
	private JComboBox unit1 = new JComboBox();
	private JComboBox unit2 = new JComboBox();
	private JTextField value1 = new JTextField("");
	private JTextField value2 = new JTextField("");
	private List<Unit> units;

	public ConverterFrame(List<Unit> units) {
		this.units = units;
		this.initialize();
	}
	public void initialize() {

		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panelTop = new JPanel();

		for (Unit unit : units) {
			unit1.addItem(unit);
			unit2.addItem(unit);
		}

		panelTop.add(unit1);
		panelTop.add(unit2);

		JPanel panelBottom = new JPanel();
		
		value1.setColumns(5);

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (button.getText().equals(">")) {
					button.setText("<");
				} else {
					button.setText(">");
				}

			}

		});

		
		value2.setColumns(5);
		panelBottom.add(value1);
		panelBottom.add(button);
		panelBottom.add(value2);

		panelTop.setLayout(new FlowLayout());

		JButton convert = new JButton("Convert!!!");
		convert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int fromValue = Integer.parseInt(value1.getText());
				ConverterModel converterModel = new ConverterModel((Unit) unit1.getSelectedItem(), (Unit) unit2.getSelectedItem());
				value2.setText(converterModel.convert(fromValue) + "");

			}

		});

		contentPane.add(panelTop);
		contentPane.add(panelBottom);
		contentPane.add(convert);
		setSize(350, 350);
		setVisible(true);

	}

}
