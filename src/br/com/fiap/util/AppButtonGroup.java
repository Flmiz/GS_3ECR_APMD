package br.com.fiap.util;

import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class AppButtonGroup extends JPanel {
	
	private static final long serialVersionUID = 1L;

	private List<String> options;
	private List<AppCheckBox> checkBoxOptions = new ArrayList<>();

	private ButtonGroup group = new ButtonGroup();
	
	public List<AppCheckBox> GetCheckBoxOptions() {
		return checkBoxOptions;
	}
	
	public AppButtonGroup(List<String> options, OptionType type) {
		super();
		this.options = options;
		init(type);
	}
	
	public void init(OptionType type) {
		if (type == OptionType.RADIO_BUTTON) {
			options.forEach(option -> {
				JRadioButton radio = new JRadioButton(option);
				this.add(radio);
				group.add(radio);
			});		
		}
		else {
			options.forEach(option -> {
				AppCheckBox checkBox = new AppCheckBox(option);
				this.add(checkBox);				
				checkBoxOptions.add(checkBox);
			});		
		}
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
}
