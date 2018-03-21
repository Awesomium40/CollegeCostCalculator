package Data;
import Data.BaseClasses.EntityBase;

public class Dormitory extends EntityBase
{
	private String _name;
	private static final String FORMAT_STRING = "%1$s: %2$10s/semester";
	
	public Dormitory (String name, double price)
	{
		super(price);
		_name = name;
	}
	
	public String getName()
	{
		return _name;
	}
	
	public String toString()
	{
		return String.format(FORMAT_STRING, _name, dollar.format(super.getPrice()));
	}
	
	public Dormitory clone()
	{
		return new Dormitory(this._name, super.getPrice());
	}
}
