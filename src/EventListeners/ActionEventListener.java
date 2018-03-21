package EventListeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

public class ActionEventListener implements ActionListener
{

	private Consumer<ActionEvent> _method;
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (_method != null)
			_method.accept(e);
		
	}
	
	public ActionEventListener(Consumer<ActionEvent> method)
	{
		if (method == null)
			throw new NullPointerException("method");
		
		_method = method;
	}

}
