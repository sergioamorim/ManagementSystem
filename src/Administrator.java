
public class Administrator extends AbleToAskResource {
	public Administrator(int id, String name, String email) {
		super(id, name, email);
	}

	public void finishAllocation(Allocation allocation) {
		if (allocation.getActivity().getDescription() != null) {
			allocation.getResponsible().saveResourceInHistory(allocation);
			allocation.getResponsible().saveActivityResourceInHistory(allocation.getActivity());
			allocation.getResponsible().setAllocationInProgress(false);
			Allocation.inProgressCounter.decrease();
			Allocation.finishedCounter.increase();
			allocation.getResource().setStatus("Concluído");
		}
		else
			System.out.println("Impossível alterar status, não há descrição da atividade.");
	}
}