package edu.uib.info231.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
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
	private Container contentPane = this.getContentPane();
	private ToggelButton button = new TextToggleButton(">");
	private JPanel unitPanel = new JPanel();
	private JPanel panelBottom = new JPanel();
	private JComboBox unit1 = new JComboBox();
	private JComboBox unit2 = new JComboBox();
	private JTextField value1 = new JTextField("");
	private JTextField value2 = new JTextField("");
	private JButton convert = new JButton("Convert!!!");

	public ConverterFrame(List<Unit> units) {
		this.unit1 = new JComboBox(new DefaultComboBoxModel(units.toArray()));
		this.unit2 = new JComboBox(new DefaultComboBoxModel(units.toArray()));
	}
	public void initialize() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.contentPane.setLayout(new BorderLayout());
		this.initUnitPanel();
		this.initInputPanel();
		
		this.convert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int fromValue = Integer.parseInt(value1.getText());
				ConverterModel converterModel = new ConverterModel((Unit) unit1.getSelectedItem(), (Unit) unit2.getSelectedItem());
				value2.setText(converterModel.convert(fromValue) + "");
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
