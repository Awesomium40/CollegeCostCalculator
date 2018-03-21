package UI;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;
import HelperObjects.ModelTypes;

public class RoomAndBoardMenuBar extends JMenuBar
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2963925400347068976L;

	public RoomAndBoardMenuBar(String name, HashMap<ModelTypes, Object[]> modelInfo, ActionListener controller)
	{
		super();
		this.setName(name);
		
		for (ModelTypes t: modelInfo.keySet())
		{
			RadioMenu mnu = new RadioMenu(modelInfo.get(t), controller, t);
			this.add(mnu);
		}
	}

}
