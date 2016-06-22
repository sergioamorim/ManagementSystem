import java.util.ArrayList;

public class AbleToAskResource extends User {
	private boolean allocationInProgress;
	private ArrayList<Resource> resourcesHistory;
	private ArrayList<Activity> activititesHistory;
		
	public void confirmAllocation(Resource resource) {
		Resource.decreaseAllocatedCount();
		Resource.increaseInProgressCount();
		this.setAllocationInProgress(true);
		resource.setStatus("Em andamento");
	}
	public boolean isAllocationInProgress() {
		return allocationInProgress;
	}
	public void setAllocationInProgress(boolean allocationInProgress) {
		this.allocationInProgress = allocationInProgress;
	}
	public ArrayList<Resource> getResourcesHistory() {
		return resourcesHistory;
	}
	public void setResourcesHistory(ArrayList<Resource> resourcesHistory) {
		this.resourcesHistory = resourcesHistory;
	}
	public ArrayList<Activity> getActivititesHistory() {
		return activititesHistory;
	}
	public void setActivititesHistory(ArrayList<Activity> activititesHistory) {
		this.activititesHistory = activititesHistory;
	}
	public void saveResourceInHistory(Resource resource) {
		ArrayList<Resource> newResourcesHistory;
		newResourcesHistory = this.getResourcesHistory();
		newResourcesHistory.add(resource);
		this.setResourcesHistory(newResourcesHistory);
	}
	public void saveActivityResourceInHistory(Activity activity) {
		ArrayList<Activity> newActivitiesHistory;
		newActivitiesHistory = this.getActivititesHistory();
		newActivitiesHistory.add(activity);
		this.setActivititesHistory(newActivitiesHistory);
	}
}
