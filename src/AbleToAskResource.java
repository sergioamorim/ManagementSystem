
public class AbleToAskResource extends User {
	private boolean allocationInProgress;
	public void confirmAllocation(Resource resource) {
		resource.setStatus("Em andamento");
		this.allocationInProgress = true;
	}
	public boolean isAllocationInProgress() {
		return allocationInProgress;
	}
	public void setAllocationInProgress(boolean allocationInProgress) {
		this.allocationInProgress = allocationInProgress;
	}
}
