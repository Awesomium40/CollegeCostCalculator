package EventRaisers;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class ActionEventRaiser extends JPanel
{
	protected ArrayList<ActionListener> _subscribers;
	
	public ActionEventRaiser(LayoutManager m)
	{
		super(m);
		_subscribers = new ArrayList<ActionListener>();
	}
	
	public ActionEventRaiser()
	{
		super();
		_subscribers = new ArrayList<ActionListener>();
		BoxLayout b = new BoxLayout(this, BoxLayout.PAGE_AXIS);
		setLayout(b);
		
	}
	
	protected void onSelectionChanged(ActionEvent e)
	{
		ActionEvent ae = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, this.getName());
		synchronized(_subscribers)
		{
			_subscribers.forEach(s -> s.actionPerformed(ae));
		}
	}
	
	public void addActionListener(ActionListener l)
	{
		synchronized(_subscribers)
		{
			if (!_subscribers.contains(l))
				_subscribers.add(l);
		}
	}
	
	public void removeActionListener(ActionListener l)
	{
		synchronized(_subscribers)
		{
			_subscribers.remove(l);
		}
	}
}
