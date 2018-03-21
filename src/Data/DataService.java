package Data;
import Data.Interfaces.IEntity;
import HelperObjects.ModelTypes;

public class DataService
{
	
	public static IEntity[] getValues(ModelTypes type)
	{
		switch (type)
		{
			case Dormitory:
				return getDorms();
			case MealPlan:
				return getMealPlans();
			case AddedOption:
				return getOptions();
			default:
				throw new IllegalArgumentException();
		}
	}
	
	protected static Dormitory[] getDorms()
	{
		return new Dormitory[] 
				{
						new Dormitory("Allen Hall", 1500d),
						new Dormitory("Pike Hall", 1600d), 
						new Dormitory("Farthing Hall", 1200d), 
						new Dormitory("University Suites", 1800d)
				};
	}
	
	protected static MealPlan[] getMealPlans()
	{
		return new MealPlan[]
				{
						new MealPlan(7, 560d),
						new MealPlan(14, 1095),
						new MealPlan(-1, 1500)
				};
	}
	
	protected static AddedOption[] getOptions()
	{
		return new AddedOption[]
				{
						new AddedOption("Weekly Laundry Service", 750d),
						new AddedOption("Alien Probe Protection", 500d),
						new AddedOption("Party Shuttle Service", 875d),
						new AddedOption("Vegan Meal Option", 650d),
				};
	}
}
