
public class Administrator extends AbleToAskResource {
	public void finishAllocation(Resource resource) {
		if (resource.getActivity().description != null) {
			resource.getResponsible().saveResourceInHistory(resource);
			resource.getResponsible().saveActivityResourceInHistory(resource.getActivity());
			resource.getResponsible().setAllocationInProgress(false);
			resource.setStatus("Concluído");
		}
		else
			System.out.println("Impossível alterar status, não há descrição da atividade.");
	}
}