import java.util.Date;

public class Resource {
	private int id;
	private String status;
	private Activity activity;
	private AbleToAskResource responsible;
	private Date startAllocation;
	private Date finishAllocation;
	
	public void allocate(AbleToAskResource responsible, Date startAllocation, Date finishAllocation) {
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
	
}