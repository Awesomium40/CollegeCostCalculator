package Data.Interfaces;

import Data.*;

public interface IModel extends IEntity, HelperObjects.Events.INotifyPriceChanged
{
	Dormitory[] getDorms();
	MealPlan[] getPlans();
	AddedOption[] getOptions();
	double getMinimumBalance();
	double getMaximumBalance();
	
	void updateSelectedDorm(int index);
	void updateSelectedMealPlan(int index);
	void updateChargeAccount(double value);
	void updateOption(int index, boolean value);
	
	void refresh();
}
