package Controller.Interfaces;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeListener;
import HelperObjects.ModelTypes;
import HelperObjects.Events.INotifyPriceChanged;
import HelperObjects.Events.IPriceChangeListener;

public interface ICollegeCostsController extends ActionListener, ChangeListener, INotifyPriceChanged, IPriceChangeListener
{
	Object[] getModelValues(ModelTypes type);
	void refreshView();
}
