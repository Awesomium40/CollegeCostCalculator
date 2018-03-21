package HelperObjects.Events;

public interface INotifyPriceChanged
{
	void addPriceChangeListener(IPriceChangeListener l);
	void removePriceChangeListener(IPriceChangeListener l);
}
