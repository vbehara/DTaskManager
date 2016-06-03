package taskManager.observers;

import taskManager.filter.DashboardFilter;
import taskManager.util.MyLogger;

public class DefaultTabFilterImpl implements DashboardFilter{

	/***
	 * To check for default filter
	 */
	@Override
	public Boolean check(String filter) 
	{
		MyLogger.getInstance().printToStdout(4, "DEBUG MESSAGE FROM filter of Default observer");
		filter = filter.replaceAll("Begin", "");
		filter = filter.replaceAll("End", "");
		if(filter.isEmpty())
		{
			return true;
		} else {
			return false;
		}
	}


	// Overriding toString method in DefaultTabFilterImpl class
	public String toString() {
		return "\nOverriding toString in DefaultTabFilterImpl Class";
	}

	
}
