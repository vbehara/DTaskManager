package taskManager.observers;

import taskManager.filter.DashboardFilter;
import taskManager.util.MyLogger;

public class UsersTabFilterImpl implements DashboardFilter {

	/***
	 * Checks if filter is type Users
	 */
	@Override
	public Boolean check(String filter) {
		MyLogger.getInstance().printToStdout(4, "DEBUG MESSAGE FROM filter check method of UsersTabFilterImpl");
		if (filter.contains("Users"))
			return true;
		else
			return false;
	}
	

	// Overriding toString method in UsersTabFilterImpl class
	public String toString() {
		return "\nOverriding toString in UsersTabFilterImpl Class";
	}

}
