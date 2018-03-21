package UI;
import javax.swing.*;
import javax.swing.event.ChangeListener;

public class ChargeAccountSelectPanel extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2548939274029540782L;
	private JSlider slider_chargeAcct;
	
	public ChargeAccountSelectPanel(ChangeListener controller, int minValue, int maxValue)
	{
		super();
		slider_chargeAcct = new JSlider(minValue, maxValue, minValue);
		slider_chargeAcct.setPaintTicks(true);
		slider_chargeAcct.setMinorTickSpacing(50);
		slider_chargeAcct.setPaintLabels(true);
		slider_chargeAcct.setMajorTickSpacing(300);
		
		//Setting this property ensures that users can only select values on the tick marks
		slider_chargeAcct.setSnapToTicks(true);
		
		slider_chargeAcct.addChangeListener(controller);
		
		setBorder(BorderFactory.createTitledBorder("Charge Account Balance:"));
		
		add(slider_chargeAcct);
	}

}
