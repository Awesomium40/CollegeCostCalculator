package UI;
import java.awt.GridLayout;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.*;
import javax.swing.event.*;
import Controller.CollegeCostsController;
import Controller.Interfaces.ICollegeCostsController;
import Data.Dormitory;
import Data.MealPlan;
import EventListeners.*;
import HelperObjects.Events.PriceChangeEvent;

public class SelectionPanel extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2149153541319965759L;
	private Selector sel_dorms;
	private Selector sel_mealPlans;
	private JLabel lbl_pricePrompt;
	private JTextField txt_priceDisplay;
	private ActionListener _listener;
	private static final NumberFormat dollar = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
	private ICollegeCostsController _controller;
	
	public SelectionPanel(Dormitory[] dorms, MealPlan[] mealPlans)
	{
		super(new GridLayout(2, 2));
		
		_controller = new CollegeCostsController();
		
		sel_dorms = new Selector("Dorms", dorms);
		sel_mealPlans = new Selector("Meal Plans", mealPlans);
		lbl_pricePrompt = new JLabel("Total Cost:");
		txt_priceDisplay = new JTextField();
		txt_priceDisplay.setEditable(false);
		lbl_pricePrompt = new JLabel("Total Cost:");
		
		_listener = new ActionEventListener(this::onSelectionChanged);	
		sel_dorms.addActionListener(_listener);
		sel_mealPlans.addActionListener(_listener);
		
		this.add(sel_dorms);
		this.add(sel_mealPlans);
		
		this.add(lbl_pricePrompt);
		this.add(txt_priceDisplay);
		
		this.onSelectionChanged(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Initialize"));
	} 
	
	private void onSelectionChanged(ActionEvent e)
	{

	}
	
	private void onModelUpdated(PriceChangeEvent e)
	{
		txt_priceDisplay.setText(dollar.format(e.getChangedPrice()));
	}

}
