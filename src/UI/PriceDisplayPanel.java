package UI;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.*;
import HelperObjects.Events.INotifyPriceChanged;
import HelperObjects.Events.IPriceChangeListener;
import HelperObjects.Events.PriceChangeEvent;

public class PriceDisplayPanel extends JPanel implements IPriceChangeListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7627565181501607569L;
	private JLabel lbl_pricePrompt;
	private JLabel lbl_priceDisplay;
	private static final NumberFormat dollar = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
	
	public PriceDisplayPanel(INotifyPriceChanged controller)
	{
		super(new FlowLayout(FlowLayout.LEFT));
		
		lbl_pricePrompt = new JLabel("Total Costs:");
		lbl_priceDisplay = new JLabel(dollar.format(0));
		
		add(lbl_pricePrompt);
		add(lbl_priceDisplay);
		
		//Subscribe to notifications that price has changed so that the label can be updated with the right price. 
		controller.addPriceChangeListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public void priceChangePerformed(PriceChangeEvent e)
	{
		lbl_priceDisplay.setText(dollar.format(e.getChangedPrice()));
	}
}
