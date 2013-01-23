package edu.uib.info231.gui;

public class TextToggleButton extends ToggelButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TextToggleButton(String text) {
		this.setText(text);
	}

	@Override
	public void toggle() {
		String text = this.getText().equals("<") ? ">" : "<";
		this.setText(text);
	}

}
