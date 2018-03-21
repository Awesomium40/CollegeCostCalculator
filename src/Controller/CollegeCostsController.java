package Controller;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import Controller.Interfaces.ICollegeCostsController;
import Data.DataService;
import Data.CollegeCostModel;
import Data.Interfaces.IEntity;
import HelperObjects.ModelTypes;
import HelperObjects.Events.IPriceChangeListener;
import HelperObjects.Events.PriceChangeEvent;

public class CollegeCostsController implements ICollegeCostsController
{
	private Data.CollegeCostModel _model;
	private ArrayList<IPriceChangeListener> _pcListeners;
	
	public CollegeCostsController()
	{
		_model = new CollegeCostModel();
		_pcListeners = new ArrayList<IPriceChangeListener>();
		_model.addPriceChangeListener(this);
	}

	public IEntity[] getModelValues(ModelTypes type)
	{
		return DataService.getValues(type);
	}
	//ENDREGION
	
	/**
	 * Implementation of the ActionListener class
	 * Responds to events by Button objects, menu items, and checkbox/radio buttons
	 * and tells the model to update its state according to the information provied in the ActionCommand
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
	
		//Parse the action command into its tokens in order to choose a course of action
		String cmd = e.getActionCommand();
		String[] tokens = cmd.split("=");
		int index = Integer.parseInt(tokens[1]);
		
		//Act based on the action command specified
		if (tokens[0].equals(ModelTypes.Dormitory.name()))
		{
			_model.updateSelectedDorm(index);
		}
		else if (tokens[0].equals(ModelTypes.MealPlan.name()))
		{
			_model.updateSelectedMealPlan(index);
		}
		else if (tokens[0].equals(ModelTypes.AddedOption.name()))
		{
			JCheckBox box = (JCheckBox)e.getSource();
			_model.updateOption(index, box.isSelected());
		}
		
	}

	/**
	 * Implementation of the ChangeListener interface 
	 * This method handles events from the Slider class and update the model accordingly
	 */
	@Override
	public void stateChanged(ChangeEvent e)
	{
		JSlider s = (JSlider)e.getSource();
		
		if (!s.getValueIsAdjusting())
			_model.updateChargeAccount(s.getValue());		
	}

	/**
	 * Implementation of the INotifyPriceChange interface
	 * Allows the UI to subscribe to the PriceChanged event and receive notifications to update itself
	 */
	@Override
	public void addPriceChangeListener(IPriceChangeListener l)
	{
		synchronized(_pcListeners)
		{
			if (!_pcListeners.contains(l))
				_pcListeners.add(l);
		}	
	}

	/**
	 * Implementation of the INotifyPriceChange interface
	 * removes the listener from the list of subscribers
	 */
	@Override
	public void removePriceChangeListener(IPriceChangeListener l)
	{
		synchronized(_pcListeners)
		{
			_pcListeners.remove(l);
		}		
	}

	/**
	 * Implements the INotifyPriceChange interface
	 * Informs the UI that the price in the model has changed
	 */
	@Override
	public void priceChangePerformed(PriceChangeEvent e)
	{
		synchronized(_pcListeners)
		{
			_pcListeners.forEach(l -> l.priceChangePerformed(e));
		}
			
	}
	
	public double getMinAccoutValue()
	{
		return _model.getMinimumBalance();
	}
	
	public double getMaxAccountValue()
	{
		return _model.getMaximumBalance();
	}
	
	/**
	 * Forces an update of the UI with fresh model data
	 */
	public void refreshView()
	{
		_model.refresh();
	}

}
