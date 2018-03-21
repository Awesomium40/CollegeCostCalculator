package UI;
import java.awt.event.ActionListener;
import javax.swing.*;
import EventListeners.ActionEventListener;
import EventRaisers.ActionEventRaiser;

public class Selector extends ActionEventRaiser
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5495885531825275677L;
	private JComboBox<Object> combo_selector;
	private JLabel lbl_prompt;
	private ActionListener _handler;
	
	public Selector(String name, Object[] listItems)
	{
		super();
		lbl_prompt = new JLabel(name);
		combo_selector = new JComboBox<Object>(listItems);
		
		this.add(lbl_prompt);
		this.add(combo_selector);
		
		_handler = new ActionEventListener(this::onSelectionChanged);
		combo_selector.addActionListener(_handler);
	}
	
	public int getSelectedIndex()
	{
		return combo_selector.getSelectedIndex();
	}
	
}
