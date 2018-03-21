package Data.Interfaces;

import javax.swing.event.ListSelectionListener;

public interface INotifySelectionChanged
{
	void addListSelectionListener(ListSelectionListener l);
	void removeListSelectionListener(ListSelectionListener l);
}
