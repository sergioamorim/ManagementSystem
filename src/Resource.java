import java.util.Date;

public class Resource {
	private static int inAllocationProccess = 0;
	private static int inProgressCount = 0;
	private static int allocatedCount = 0;
	private static int finishedCount = 0;
	private static int allocationsTotal = 0;
	
	private int id;
	private String status;
	private Activity activity;
	private AbleToAskResource responsible;
	private Date startAllocation;
	private Date finishAllocation;
	
	public void allocate(AbleToAskResource responsible, Date startAllocation, Date finishAllocation) {
		increaseAllocationsTotal();
		increaseInAllocationProccess();
		this.setStatus("Em processo de alocação");
		
		AbleToAskResource newResponsible;
		newResponsible = new AbleToAskResource();
		this.setResponsible(newResponsible);
		
		Activity newActivity;
		newActivity = new Activity();
		this.setActivity(newActivity);
		
		Date newStartAllocation;
		newStartAllocation = new Date();
		this.setStartAllocation(newStartAllocation);
		
		Date newFinishAllocation;
		newFinishAllocation = new Date();
		this.setFinishAllocation(newFinishAllocation);		
		
		decreaseInAllocationProccess();
		increaseAllocatedCount();
		this.setStatus("Alocado");
	}
	
	public AbleToAskResource getResponsible() {
		return responsible;
	}
	public void setResponsible(AbleToAskResource responsible) {
		this.responsible = responsible;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Date getStartAllocation() {
		return startAllocation;
	}
	public void setStartAllocation(Date startAllocation) {
		this.startAllocation = startAllocation;
	}

	public Date getFinishAllocation() {
		return finishAllocation;
	}
	public void setFinishAllocation(Date finishAllocation) {
		this.finishAllocation = finishAllocation;
	}

	public static int getInProgressCount() {
		return inProgressCount;
	}
	public static void increaseInProgressCount() {
		inProgressCount += 1;
	}
	public static void decreaseInProgressCount() {
		inProgressCount -= 1;
	}

	public static int getInAllocationProccess() {
		return inAllocationProccess;
	}
	public static void increaseInAllocationProccess() {
		inAllocationProccess += 1;
	}
	public static void decreaseInAllocationProccess() {
		inAllocationProccess -= 1;
	}

	public static int getAllocatedCount() {
		return allocatedCount;
	}
	public static void increaseAllocatedCount() {
		allocatedCount += 1;
	}	
	public static void decreaseAllocatedCount() {
		allocatedCount -= 1;
	}

	public static int getFinishedCount() {
		return finishedCount;
	}
	public static void increaseFinishedCount() {
		finishedCount += 1;
	}
		public static void decreaseFinishedCount() {
		finishedCount -= 1;
	}

	public static int getAllocationsTotal() {
		return allocationsTotal;
	}
	public static void increaseAllocationsTotal() {
		allocationsTotal += 1;
	}
		public static void decreaseAllocationsTotal() {
		allocationsTotal -= 1;
	}
}