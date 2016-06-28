import java.time.LocalDateTime;

public class Allocation {
	public static Counter inAllocationProccessCounter = new Counter("recursos em processo de alocação");
	public static Counter inProgressCounter = new Counter("recursos com alocação em andamento");
	public static Counter allocatedCounter = new Counter("recursos alocados");
	public static Counter finishedCounter = new Counter("alocações concluídas");
	public static Counter allocationsTotalCounter = new Counter("alocações no total");
	
	private Resource resource;
	private AbleToAskResource responsible;
	private Activity activity;
	private LocalDateTime startAllocation;
	private LocalDateTime finishAllocation;
	
	public Allocation(Resource resource, AbleToAskResource responsible, LocalDateTime startAllocation, LocalDateTime finishAllocation) {
		
		this.setResource(resource);
		
		this.setResponsible(responsible);
		
		this.setStartAllocation(startAllocation);

		this.setFinishAllocation(finishAllocation);
		
		Allocation.inAllocationProccessCounter.decrease();
		Allocation.allocatedCounter.increase();
		resource.setStatus("Alocado");
	}
	
	public AbleToAskResource getResponsible() {
		return responsible;
	}
	public void setResponsible(AbleToAskResource responsible) {
		this.responsible = responsible;
	}

	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	
	public LocalDateTime getStartAllocation() {
		return startAllocation;
	}
	public void setStartAllocation(LocalDateTime startAllocation2) {
		this.startAllocation = startAllocation2;
	}

	public LocalDateTime getFinishAllocation() {
		return finishAllocation;
	}
	public void setFinishAllocation(LocalDateTime finishAllocation2) {
		this.finishAllocation = finishAllocation2;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}
	
}
