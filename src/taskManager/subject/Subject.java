package taskManager.subject;
import taskManager.filter.DashboardFilter;
import taskManager.observers.Observer;

public interface Subject 
{
	public void registerObserver(Observer o,DashboardFilter filter);
	public void removeObserver(Observer o);
	public void notifyObservers(String msg);
}

