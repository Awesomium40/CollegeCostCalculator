package UI;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;
import HelperObjects.ModelTypes;

public class AddedOptionsPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5942839365648290172L;
	private static final int COLUMNS = 2;
	
	public AddedOptionsPanel(ActionListener controller, ModelTypes t, Object[] options)
	{
		super();
		
		//I didn't want everything laid out in a row, so we do some quick integer division to create a grid
		//Grid will have the appropriate number of rows and columns to layout everything neatly. 
		int rows = (options.length / COLUMNS) + (options.length % COLUMNS == 0 ? 0 : 1);
		this.setLayout(new GridLayout(rows, COLUMNS));
		this.setBorder(BorderFactory.createTitledBorder("Additional Options"));
		
		//Now, create a CheckBox for each possible option and add it to the panel,
		//Making sure to set the appropriate event handler and ActionCommand
		for (int i = 0; i < options.length; i++)
		{
			JCheckBox chk = new JCheckBox(options[i].toString());
			chk.addActionListener(controller);
			chk.setActionCommand(t.name() + "=" + String.valueOf(i));
			this.add(chk);
		}
	}
}
