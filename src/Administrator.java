
public class Administrator extends AbleToAskResource {
	public void finishAllocation(Resource resource) {
		if (resource.getActivity().description != null) {
			resource.setStatus("Concluído");
			resource.getResponsible().setAllocationInProgress(false);
		}
		else
			System.out.println("Impossível alterar status, não há descrição da atividade.");
	}
}