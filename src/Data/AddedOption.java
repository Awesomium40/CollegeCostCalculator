package Data;

import Data.BaseClasses.EntityBase;

public class AddedOption extends EntityBase
{
	private String _name;
	private boolean _isSelected;
	private static final String formatString = "%1$s: %2$s";
	
	public AddedOption(String name, double price)
	{
		super(price);
		_name = name;
		_isSelected = false;
	}
	
	public String toString()
	{
		return String.format(formatString, _name, dollar.format(super.getPrice()));
	}
	
	public boolean getIsSelected()
	{
		return this._isSelected;
	}
	
	public void setIsSelected(boolean value)
	{
		this._isSelected = value;
	}
}
