package Data.BaseClasses;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Data.Interfaces.IModel;
import HelperObjects.Events.IPriceChangeListener;
import HelperObjects.Events.PriceChangeEvent;

public abstract class ModelBase implements IModel
{
	private ArrayList<IPriceChangeListener> _priceChangeSubscribers;

	public ModelBase()
	{
		_priceChangeSubscribers = new ArrayList<IPriceChangeListener>();
	}
	
	public void addPriceChangeListener(IPriceChangeListener l)
	{
		synchronized(_priceChangeSubscribers)
		{
			if (!_priceChangeSubscribers.contains(l))
			{
				_priceChangeSubscribers.add(l);
			}
		}
	}
	
	public void removePriceChangeListener(IPriceChangeListener l)
	{
		synchronized(_priceChangeSubscribers)
		{
			_priceChangeSubscribers.remove(l);
		}
	}
	
	protected void onPriceChanged(PriceChangeEvent e)
	{
		synchronized(this._priceChangeSubscribers)
		{
			_priceChangeSubscribers.forEach(s -> s.priceChangePerformed(e));
		}
			
	}

	@Override
	public abstract double getPrice();
	
	public abstract double getMinimumBalance();
	public abstract double getMaximumBalance();

}
