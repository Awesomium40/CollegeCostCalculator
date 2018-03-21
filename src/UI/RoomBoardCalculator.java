package UI;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import javax.swing.*;
import Controller.CollegeCostsController;
import HelperObjects.ModelTypes;

public class RoomBoardCalculator extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1885069587075053586L;
	private static final String TITLE = "Room and Board Calculator";
	private RoomAndBoardMenuBar bar_optionSelect;
	private CollegeCostsController controller;
	private ChargeAccountSelectPanel pnl_chargeAcct;
	private AddedOptionsPanel pnl_options;
	private PriceDisplayPanel pnl_priceDisplay;

	public static void main(String[] args)
	{

		new RoomBoardCalculator();
	}
	
	public RoomBoardCalculator()
	{
		this.setLayout(new BorderLayout());
		//Instantiate the controller, which will handle all the interaction between the UI and the data
		controller = new CollegeCostsController();
		
		//Retrieve data from the controller in order to construct the menu appropriately
		HashMap<ModelTypes, Object[]> modelInfo = new HashMap<ModelTypes, Object[]>();
		for (ModelTypes t: ModelTypes.values())
			if (t != ModelTypes.AddedOption)
				modelInfo.put(t, controller.getModelValues(t));
		
				
		//Construct the UI components and add them to the UI
		bar_optionSelect = new RoomAndBoardMenuBar("MainMenu", modelInfo, controller);
		pnl_chargeAcct = new ChargeAccountSelectPanel(controller, (int)controller.getMinAccoutValue(), (int)controller.getMaxAccountValue());
		pnl_priceDisplay = new PriceDisplayPanel(controller);
		pnl_options = new AddedOptionsPanel(controller, ModelTypes.AddedOption, controller.getModelValues(ModelTypes.AddedOption));
		
		this.setJMenuBar(bar_optionSelect);	
		add(pnl_chargeAcct, BorderLayout.NORTH);
		add(pnl_priceDisplay, BorderLayout.SOUTH);
		add(pnl_options, BorderLayout.WEST);
		
		//Force an update of the view from the controller
		controller.refreshView();
		
		//perform the layout and display
		this.setTitle(TITLE);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setMinimumSize(this.getSize());
		this.setMaximumSize(this.getSize());
		this.setVisible(true);	
	}
}
