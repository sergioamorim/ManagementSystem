
public class Administrator extends AbleToAskResource {
	public void finishAllocation(Resource resource) {
		if (resource.getActivity().description != null) {
			resource.getResponsible().saveResourceInHistory(resource);
			resource.getResponsible().saveActivityResourceInHistory(resource.getActivity());
			resource.getResponsible().setAllocationInProgress(false);
			Resource.setInProgressCount(Resource.getInProgressCount() - 1);
			Resource.setFinishedCount(Resource.getFinishedCount() + 1);
			resource.setStatus("Concluído");
		}
		else
			System.out.println("Impossível alterar status, não há descrição da atividade.");
	}
}