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
		setAllocationsTotal(getAllocationsTotal() + 1);
		setInAllocationProccess(getInAllocationProccess() + 1);
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
		
		setInAllocationProccess(getInAllocationProccess() - 1);
		setAllocatedCount(getAllocatedCount() + 1);
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

	public static void setInProgressCount(int inProgressCount) {
		Resource.inProgressCount = inProgressCount;
	}

	public static int getInAllocationProccess() {
		return inAllocationProccess;
	}

	public static void setInAllocationProccess(int inAllocationProccess) {
		Resource.inAllocationProccess = inAllocationProccess;
	}

	public static int getAllocatedCount() {
		return allocatedCount;
	}

	public static void setAllocatedCount(int allocatedCount) {
		Resource.allocatedCount = allocatedCount;
	}

	public static int getFinishedCount() {
		return finishedCount;
	}

	public static void setFinishedCount(int finishedCount) {
		Resource.finishedCount = finishedCount;
	}

	public static int getAllocationsTotal() {
		return allocationsTotal;
	}

	public static void setAllocationsTotal(int allocationsTotal) {
		Resource.allocationsTotal = allocationsTotal;
	}
	
}