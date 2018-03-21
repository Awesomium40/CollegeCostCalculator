package Data.BaseClasses;

import java.text.NumberFormat;
import java.util.Locale;

import Data.Interfaces.IEntity;

public abstract class EntityBase implements IEntity
{
	private double _price;
	protected static final NumberFormat dollar = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
	
	public double getPrice()
	{
		return _price;
	}
	
	public EntityBase(double price)
	{
		_price = price;
	}
	
}
