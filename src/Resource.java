import java.util.Date;
import java.util.ArrayList;

public class Resource {
	public static Counter inAllocationProccessCounter = new Counter("recursos em processo de alocação");
	public static Counter inProgressCounter = new Counter("recursos com alocação em andamento");
	public static Counter allocatedCounter = new Counter("recursos alocados");
	public static Counter finishedCounter = new Counter("alocações concluídas");
	public static Counter allocationsTotalCounter = new Counter("alocações no total");
	private static ArrayList<Resource> Resources;
	
	private int id;
	private String status;
	private Activity activity;
	private AbleToAskResource responsible;
	private Date startAllocation;
	private Date finishAllocation;
	
	public Resource() {
		Resource.Resources.add(this);
	}
	
	public static Resource findById(int id) {
		for (Resource resource : Resource.Resources) {
			if (resource.getId() == id) {
				return resource;
			}
		}
		System.out.println("Recurso não encontrado.");
		return null;
	}
	
	public void allocate(AbleToAskResource responsible, Date startAllocation, Date finishAllocation) {
		Resource.allocationsTotalCounter.increase();
		Resource.inAllocationProccessCounter.increase();
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
		
		Resource.inAllocationProccessCounter.decrease();
		Resource.allocatedCounter.increase();
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