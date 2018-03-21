package Data;

import Data.BaseClasses.EntityBase;

public class MealPlan extends EntityBase
{
	private int _mealsPerWeek;
	private static final String FORMAT_STRING = "%1$s meals/week: %2$10s/semester";
	
	public MealPlan(int meals, double price)
	{
		super(price);
		_mealsPerWeek = meals;
	}
	
	public int getMealsPerWeek()
	{
		return _mealsPerWeek;
	}
	
	
	public String toString()
	{
		return String.format(FORMAT_STRING, _mealsPerWeek < 0 ? "Unlimited" : _mealsPerWeek, dollar.format(super.getPrice()));
	}
	
	public MealPlan clone()
	{
		return new MealPlan(this._mealsPerWeek, super.getPrice());
	}
}
