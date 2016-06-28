import java.util.ArrayList;

public class AbleToAskResource extends User {
	private static ArrayList<AbleToAskResource> ableToAskResourceList = new ArrayList<AbleToAskResource>();	
	private boolean allocationInProgress;
	private ArrayList<Allocation> allocationsHistory = new ArrayList<Allocation>();
	private ArrayList<Activity> activititesHistory = new ArrayList<Activity>();
	
	public AbleToAskResource() {
		AbleToAskResource.ableToAskResourceList.add(this);
	}
	
	public static AbleToAskResource findById(int id) {
		for (AbleToAskResource ableToAskResource : AbleToAskResource.ableToAskResourceList) {
			if (ableToAskResource.getId() == id) {
				return ableToAskResource;
			}
		}
		System.out.println("Recurso não encontrado.");
		return null;
	}
		
	public void confirmAllocation(Allocation allocation) {
		
		Allocation.allocatedCounter.decrease();
		Allocation.inProgressCounter.increase();
		this.setAllocationInProgress(true);
		allocation.getResource().setStatus("Em andamento");
	}
	public boolean isAllocationInProgress() {
		return allocationInProgress;
	}
	public void setAllocationInProgress(boolean allocationInProgress) {
		this.allocationInProgress = allocationInProgress;
	}
	public ArrayList<Allocation> getAllocationsHistory() {
		return allocationsHistory;
	}
	public void setAllocationsHistory(ArrayList<Allocation> resourcesHistory) {
		this.allocationsHistory = resourcesHistory;
	}
	public ArrayList<Activity> getActivititesHistory() {
		return activititesHistory;
	}
	public void setActivititesHistory(ArrayList<Activity> activititesHistory) {
		this.activititesHistory = activititesHistory;
	}
	public void saveResourceInHistory(Allocation allocation) {
		ArrayList<Allocation> newAllocationsHistory;
		newAllocationsHistory = this.getAllocationsHistory();
		newAllocationsHistory.add(allocation);
		this.setAllocationsHistory(newAllocationsHistory);
	}
	public void saveActivityResourceInHistory(Activity activity) {
		ArrayList<Activity> newActivitiesHistory;
		newActivitiesHistory = this.getActivititesHistory();
		newActivitiesHistory.add(activity);
		this.setActivititesHistory(newActivitiesHistory);
	}
}
