package taskManager.observers;

import taskManager.filter.DashboardFilter;
import taskManager.util.MyLogger;

public class ProcessesTabFilterImpl implements DashboardFilter
{
	/***
	 * Checks the filter Type
	 */
	@Override
	public Boolean check(String filter) {
		MyLogger.getInstance().printToStdout(4, "DEBUG MESSAGE FROM filter check method of ProcessesTabFilterImpl");
		if(filter.contains("Processes"))
		return true;
		else
		return false;
	}
	

	// Overriding toString method in ProcessesTabFilterImpl class
	public String toString() {
		return "\nOverriding toString in ProcessesTabFilterImpl Class";
	}


}
