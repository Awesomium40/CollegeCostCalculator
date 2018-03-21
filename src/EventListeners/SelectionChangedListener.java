package EventListeners;
import java.util.function.Consumer;
import javax.swing.event.ListSelectionEvent;

public class SelectionChangedListener implements javax.swing.event.ListSelectionListener
{

	private Consumer<ListSelectionEvent> _method;
	
	public SelectionChangedListener(Consumer<ListSelectionEvent> method)
	{
		if (method == null)
			throw new NullPointerException("method");
		
		_method = method;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e)
	{
		_method.accept(e);
	}

}
