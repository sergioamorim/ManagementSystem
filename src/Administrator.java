
public class Administrator extends AbleToAskResource {
	public void finishAllocation(Allocation allocation) {
		if (allocation.getActivity().description != null) {
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