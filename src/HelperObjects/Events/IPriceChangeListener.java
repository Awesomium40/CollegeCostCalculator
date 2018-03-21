package HelperObjects.Events;
import java.awt.event.ActionListener;

public interface IPriceChangeListener extends ActionListener
{
	void priceChangePerformed(PriceChangeEvent e);
}
