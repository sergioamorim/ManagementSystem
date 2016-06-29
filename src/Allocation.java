import java.time.LocalDateTime;
import java.util.ArrayList;

public class Allocation {
	public static Counter inAllocationProccessCounter = new Counter("recursos em processo de alocação");
	public static Counter inProgressCounter = new Counter("recursos com alocação em andamento");
	public static Counter allocatedCounter = new Counter("recursos alocados");
	public static Counter finishedCounter = new Counter("alocações concluídas");
	public static Counter allocationsTotalCounter = new Counter("alocações no total");
	private static ArrayList<Allocation> allocations = new ArrayList<Allocation>();
	
	private int id;
	private Resource resource;
	private AbleToAskResource responsible;
	private Activity activity;
	private LocalDateTime startAllocation;
	private LocalDateTime finishAllocation;
	
	public String toString() {
		return super.toString()+" ID: "+this.id+
				" Recurso: "+this.resource.toString()+
				" Responsável: "+this.responsible.toString()+
				" Atividade: "+this.activity.toString()+
				" Início: "+this.startAllocation.toString()+
				" Fim: "+this.finishAllocation.toString();
	}
	
	public static Allocation findById(int id) {
		for (Allocation allocation : Allocation.allocations) {
			if (allocation.getId() == id) {
				return allocation;
			}
		}
		System.out.println("Alocação não encontrada.");
		return null;
	}
	
	public static void deleteAllocation(Allocation allocation) {
		Allocation.allocationsTotalCounter.decrease();
		String resourceStatus = allocation.getResource().getStatus();
		if (resourceStatus == "Em processo de alocação")
			Allocation.inAllocationProccessCounter.decrease();
		else if (resourceStatus == "Em andamento")
			Allocation.inProgressCounter.decrease();
		else if (resourceStatus == "Alocado")
			Allocation.allocatedCounter.decrease();
		else if (resourceStatus == "Concluído")
			Allocation.finishedCounter.decrease();
		allocations.remove(allocation);
	}
	
	public Allocation(int id, Resource resource, AbleToAskResource responsible, LocalDateTime startAllocation, LocalDateTime finishAllocation) {
		Allocation.allocations.add(this);
		
		this.setId(id);
		
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
