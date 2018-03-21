package Data;
import java.awt.event.ActionEvent;
import java.util.Arrays;

import Data.BaseClasses.ModelBase;
import HelperObjects.Events.PriceChangeEvent;

public class CollegeCostModel extends ModelBase
{
	private Dormitory[] _dorms;
	private MealPlan[] _plans;
	private AddedOption[] _options;
	private static final double MIN_CHARGE = 100;
	private static final double MAX_CHARGE = 1000;
	
	
	private Dormitory _selectedDorm;
	private MealPlan _selectedPlan;
	private int _selectedDormIndex;
	private int _selectedPlanIndex;
	private double _chargeAcct;
	
	public CollegeCostModel()
	{
		super();
		_dorms = DataService.getDorms();
		_plans = DataService.getMealPlans();
		_options = DataService.getOptions();
		
		_selectedDorm = null;
		_selectedPlan = null;
		_selectedDormIndex = -1;
		_selectedPlanIndex = -1;
		_chargeAcct = MIN_CHARGE;
	}
	
	/**
	 * Updates the model, changing which dormitory option is set as the selected option
	 */
	public void updateSelectedDorm(int index)
	{
		//prevent index out of range
		if (index > -1 && index < _dorms.length)
		{
			//Only need to change if the current selection differs from the incoming selection. 
			if (_selectedDormIndex != index)
			{
				_selectedDormIndex = index;
				_selectedDorm = _dorms[index];
				super.onPriceChanged(new PriceChangeEvent(this, ActionEvent.ACTION_PERFORMED, "updateSelectedDorm", computePrice()));
			}
			
		}
		else
			System.out.println("Index out of range on model component _dorms");
	}
	
	/**
	 * Updates the model, changing which meal plan option is set as the selected option
	 */
	public void updateSelectedMealPlan(int index)
	{
		//Prevent index out of range
		if (index > -1 && index < _plans.length)
		{
			//Only need to change if the currently selected item is different from the selection requested. 
			if (_selectedPlanIndex != index)
			{
				_selectedPlanIndex = index;
				_selectedPlan = _plans[index];
				super.onPriceChanged(new PriceChangeEvent(this, ActionEvent.ACTION_PERFORMED, "updateSelectedMealPlan", computePrice()));
			}
		}
		else
			System.out.println("Index out of range on model component _plans");
	}
	
	/**
	 * Updates the model, setting the amount allocated to the student's charge account. 
	 */
	public void updateChargeAccount(double value)
	{
		//make sure not to set a value that's out of range
		if (value < MIN_CHARGE || value > MAX_CHARGE)
			System.out.println("Argument out of range for model parameter: _chargeAcct");
		else
			//Only need to make a change if the requested value is different. 
			if (_chargeAcct != value)
			{
				_chargeAcct = value;
				super.onPriceChanged(new PriceChangeEvent(this, ActionEvent.ACTION_PERFORMED, "updateChargeAccount", computePrice()));
			}
				
	}
	
	/**
	 * Updates the additional options
	 */
	public void updateOption(int index, boolean value)
	{
		//Prevent index out of range exception
		if (index > -1 && index < _options.length)
		{
			//only need to set the fields if the request would make a difference. 
			if (_options[index].getIsSelected() != value)
			{
				_options[index].setIsSelected(value);
				super.onPriceChanged(new PriceChangeEvent(this, ActionEvent.ACTION_PERFORMED, "updateOption", computePrice()));
			}
		}
		else
			System.out.println("Argument out of range for model parameter: _options");
	}
	
	/**
	 * Computes the price of all selected options
	 * @return
	 */
	private double computePrice()
	{
		return _chargeAcct +  
				(_selectedDorm == null ? 0 : _selectedDorm.getPrice()) +  
				(_selectedPlan == null ? 0 : _selectedPlan.getPrice()) + 
				computeOptionsPrice();
	}
	
	/**
	 * Computes the price of all the selected AdditionalOption objects
	 * @return
	 */
	private double computeOptionsPrice()
	{
		double sum = 0d;
		for (AddedOption o: _options)
			sum += o.getIsSelected() ? o.getPrice() : 0;
			
		return sum;
	}
	
	public double getChargeAccountValue()
	{
		return _chargeAcct;
	}
	
	/**
	 * DEPRECATED
	 */
	public double getPrice()
	{
		if (_selectedDorm == null || _selectedPlan == null)
			throw new NullPointerException();
		
		return _selectedDorm.getPrice() + _selectedPlan.getPrice();
	}
	
	public Dormitory[] getDorms()
	{
		return _dorms.clone();
	}
	
	public MealPlan[] getPlans()
	{
		return _plans.clone();
	}
	
	public AddedOption[] getOptions()
	{
		return _options.clone();
	}


	@Override
	public double getMinimumBalance()
	{
		return MIN_CHARGE;
	}

	@Override
	public double getMaximumBalance()
	{
		return MAX_CHARGE;
	}
	
	/**
	 * forces a refresh of the model
	 */
	public void refresh()
	{
		super.onPriceChanged(new PriceChangeEvent(this, ActionEvent.ACTION_PERFORMED, "refresh", computePrice()));
	}
}
