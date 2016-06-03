package taskManager.observers;

import taskManager.filter.DashboardFilter;
import taskManager.util.MyLogger;


public class PerformanceTabFilterImpl implements DashboardFilter
{

	/***
	 * Checks if filter is of type Performance
	 */
	@Override
	public Boolean check(String filter) {
		MyLogger.getInstance().printToStdout(4, "DEBUG MESSAGE FROM filter check method of PerformanceTabFilterImpl");
		if(filter.contains("Performance"))
		return true;
		else
		return false;
	}
	

	// Overriding toString method in PerformanceTabFilterImpl class
	public String toString() {
		return "\nOverriding toString in PerformanceTabFilterImpl Class";
	}

	
}
