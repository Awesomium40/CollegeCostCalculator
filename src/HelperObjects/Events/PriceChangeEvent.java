package HelperObjects.Events;

import java.awt.event.ActionEvent;

public class PriceChangeEvent extends ActionEvent
{
	private double _value;
	public PriceChangeEvent(Object source, int id, String command, double value)
	{
		super(source, id, command);
		_value = value;
	}
	
	public double getChangedPrice()
	{
		return _value;
	}
}
