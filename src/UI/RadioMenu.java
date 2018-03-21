package UI;
import java.awt.event.ActionListener;

import javax.swing.*;

import Data.Interfaces.IEntity;
import HelperObjects.ModelTypes;

public class RadioMenu extends JMenu
{
	private ButtonGroup grp;
	
	public RadioMenu(Object[] elements, ActionListener controller, ModelTypes type)
	{
		super(type.name());
		
		grp = new ButtonGroup();
	
		for(int i = 0; i < elements.length; i++)
		{
			JRadioButtonMenuItem m = new JRadioButtonMenuItem(elements[i].toString());
			m.setActionCommand(type.name() + "=" + String.valueOf(i));
			grp.add(m);
			this.add(m);
			m.addActionListener(controller);
		}
	}

}
