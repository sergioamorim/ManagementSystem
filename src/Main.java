import java.util.Scanner;
import java.time.LocalDateTime;

public class Main {

	public static void main(String args[]){
		int choice = 9;
		Scanner kb = new Scanner(System.in);
		
		new Auditorium(1);
		new Classroom(3);
		new Projector(4);
		new Laboratory(7);
		new Professor(1, "Baldoino", "baldoino@ic.ufal.br");
		new Professor(2, "Rodrigo", "rodrigo@ic.ufal.br");
		new Researcher(3, "Márcio", "marcio@ic.ufal.br");
		new MasterDegree(4, "Henrique", "hfa@ic.ufal.br");
		new MasterDegree(5, "Marcus", "macpj@ic.ufal.br");
		new GraduationDegree(6, "Sergio", "sata@ic.ufal.br");
		
		while (choice != 0) {
			if (choice == 9){ /* main menu */
				Main.printMainMenu();
			}
			else if (choice == 2) { /* menu for professors and researchers */
				Main.printProfessorsResearchersMenu();
				choice = getNaturalNumberFromKeyboard();
				while (choice != 0 && choice != 9) {
					if (choice == 1) { /* confirm an allocation */
						confirmAllocation();
					}
					else if (choice == 2) { /* input activity information */
						inputActivityInformation();
					}
					else { /* invalid input */
						System.out.println("Entrada inválida");
					}
					Main.printProfessorsResearchersMenu();
					choice = getNaturalNumberFromKeyboard();
				}
			}
			else if (choice == 3) { /* menu for administrators*/
				Main.printAdministratorMenu();
				choice = getNaturalNumberFromKeyboard();
				while (choice != 0 && choice != 9) {
					if (choice == 1) { /* create a resource allocation */
						createResourceAllocation();
					}
					else if (choice == 2) { /* modify a resource allocation */
						modifyAllocation();						
					}
					else if (choice == 3) { /* delete a resource allocation */
						deleteAllocation();
					}
					else if (choice == 4) { /* print activities report */
						Main.printActivitiesReport();
					}
					else if (choice == 4) { /* print allocation properties */
						Main.printAllocationProperties();
					}
					else { /* invalid input */
						System.out.println("Entrada inválida");
					}
					Main.printAdministratorMenu();
					choice = getNaturalNumberFromKeyboard();
				}
			}
			else if (choice == 1){ /* menu for students */
				Main.printStudentMenu();
				choice = getNaturalNumberFromKeyboard();
				while (choice != 0 && choice != 9) {
					/* there is no valid option for students yet */
					System.out.println("Entrada inválida"); /* invalid input */
					Main.printStudentMenu();
					choice = getNaturalNumberFromKeyboard();
				}
			}
			else { /* invalid input */
				System.out.println("Entrada inválida");
			}
			choice = getNaturalNumberFromKeyboard();
		}
		kb.close();
	}
	
	private static void modifyAllocation() {
		int allocationId;
		Allocation allocation;
		int resourceId = 0;
		int responsibleId = 0;
		LocalDateTime startAllocation = null;
		LocalDateTime finishAllocation = null;
		System.out.println("Insira o ID da alocação a ser modificada: ");
		allocationId = getNaturalNumberFromKeyboard();
		allocation = Allocation.findById(allocationId);
		if (allocation == null) {
			System.out.println("Certifique-se de que o ID informado está correto e refaça o procedimento.");
		}
		else {
			System.out.println("Informe o novo ID ("+allocation.getId()+"é o atual): ");
			allocationId = getNaturalNumberFromKeyboard();
			allocation.setId(allocationId);
			System.out.println("Informe o ID do novo recurso ("+allocation.getResource().getId()+"é o atual): ");
			resourceId = getNaturalNumberFromKeyboard();
			if (Resource.findById(resourceId) == null) {
				System.out.println("Certifique-se de que ID informado está correto e tente novamente.");
			}
			else {
				allocation.setResource(Resource.findById(resourceId));
			}
			System.out.println("Informe o ID do novo responsável ("+allocation.getResponsible().getId()+"é o atual): ");
			responsibleId = getNaturalNumberFromKeyboard();
			if (AbleToAskResource.findById(responsibleId) == null) {
				System.out.println("Certifique-se de que o ID informado está correto e refaça o procendimento.");
			}
			else{
				allocation.setResponsible(AbleToAskResource.findById(responsibleId));
			}
			System.out.println("Informe o novo horário de início ("+allocation.getStartAllocation().toString()+"é o atual): ");
			startAllocation = getAValidDateTime();
			allocation.setStartAllocation(startAllocation);
			System.out.println("Informe o novo horário de finalização ("+allocation.getFinishAllocation().toString()+"é o atual): ");
			finishAllocation = getAValidDateTime();
			allocation.setFinishAllocation(finishAllocation);
			System.out.println("Modificações realizadas com sucesso.");
		}
	}

	private static void printAllocationProperties() {
		int allocationId;
		System.out.println("Informe o ID da alocação que deseja obter informações: ");
		allocationId = getNaturalNumberFromKeyboard();
		if (Allocation.findById(allocationId) == null) {
			System.out.println("Certifique-se de que o ID informado está correto e refaça o procedimento.");
		}
		else {
			System.out.println(Allocation.findById(allocationId).toString());
		}
	}

	private static void deleteAllocation() {
		int allocationId;
		System.out.println("Informe o ID da alocação para excluir: ");
		allocationId = getNaturalNumberFromKeyboard();
		if (Allocation.findById(allocationId) == null) {
			System.out.println("Certifique-se de que o ID informado está correto e refaça o procedimento.");
		}
		else {
			Allocation.deleteAllocation(Allocation.findById(allocationId));
			System.out.println("Alocação removida com sucesso.");
		}
	}
	
	private static LocalDateTime getAValidDateTime() {
		Scanner kb = new Scanner(System.in);
		String validDateTimeString = kb.next();
		LocalDateTime validDateTime = null;
		while (validDateTime == null) {
			try {
				validDateTime = LocalDateTime.parse(validDateTimeString);
			}
			catch (java.time.format.DateTimeParseException e) {
				validDateTime = null;
			}
			if (validDateTime == null) {
				System.out.println("Formato incorreto de data e hora! Tente novamente com o formato yyyy-MM-ddThh:mm");
			}
		}
		kb.close();
		return validDateTime;
	}
	
	private static void confirmAllocation(){
		int idAllocation;
		Allocation allocation;
		System.out.println("Informe o ID da alocação para confirmar: ");
		idAllocation = getNaturalNumberFromKeyboard();
		allocation = Allocation.findById(idAllocation);
		if (allocation == null) {
			System.out.println("Certifique-se de que o ID informado está correto e refaça o procedimento.");
		}
		else {
			allocation.getResponsible().confirmAllocation(allocation);
			System.out.println("Alocação confirmada.");
		}
	}
	
	private static void inputActivityInformation(){
		Scanner kb = new Scanner(System.in);
		int idAllocation;
		Allocation allocation;
		String activityTitle;
		String activityDescription;
		System.out.println("Insira o ID da alocação: ");
		idAllocation = getNaturalNumberFromKeyboard();
		allocation = Allocation.findById(idAllocation);
		if (allocation == null){
			System.out.println("Certifique-se de que o ID informado está correto e refaça o procedimento.");
		}
		else {
			System.out.println("Insira o título da atividade: ");
			activityTitle = kb.next();
			allocation.getActivity().setTitle(activityTitle);
			System.out.println("Insira a descrição da atividade: ");
			activityDescription = kb.next();
			allocation.getActivity().setDescription(activityDescription);
			System.out.println("Informações adicionadas com sucesso.");
			kb.close();
		}
	}
	
	private static void createResourceAllocation(){
		Scanner kb = new Scanner(System.in);
		int allocationId;
		int resourceId = 0;
		int responsibleId = 0;
		Resource resource = null;
		AbleToAskResource responsible = null;
		LocalDateTime startAllocation = null;
		LocalDateTime finishAllocation = null;
		System.out.println("Insira um ID para a alocação: ");
		allocationId = getNaturalNumberFromKeyboard();
		System.out.println("Insira o ID do recurso a ser alocado: ");
		resourceId = getNaturalNumberFromKeyboard();
		resource = Resource.findById(resourceId);
		if (resource == null) {
			System.out.println("Certifique-se de que o ID informado está correto e refaça o procendimento.");
		}
		else {
			Allocation.allocationsTotalCounter.increase();
			Allocation.inAllocationProccessCounter.increase();
			resource.setStatus("Em processo de alocação");
			System.out.println("Insira o ID do responsável: ");
			responsibleId = getNaturalNumberFromKeyboard();
			responsible = AbleToAskResource.findById(responsibleId);
			if (responsible == null) {
				System.out.println("Certifique-se de que o ID informado está correto e refaça o procendimento.");
			}
			else {
				System.out.println("Insira a data e a hora de início da alocação no formato yyyy-MM-ddThh:mm");
				startAllocation = getAValidDateTime();
				System.out.println("Insira a data e a hora do fim da alocação no formato yyyy-MM-ddThh:mm");
				finishAllocation = getAValidDateTime();
				new Allocation(allocationId, resource, responsible, startAllocation, finishAllocation);
				System.out.println("Alocação criada com sucesso!");
			}
		}
		kb.close();
	}
	
	private static int getNaturalNumberFromKeyboard(){
		Scanner kb = new Scanner(System.in);
		int naturalNumber = -1;
		while (naturalNumber < 0) {
			try {
				naturalNumber = kb.nextInt();
			}
			catch (java.util.InputMismatchException e) {
				System.out.println("ERRO! Insira um número natural.");
				naturalNumber = -1;
			}
		}		
		kb.close();
		return naturalNumber;
	}
	
	private static void printActivitiesReport(){
		Activity.laboratoriesCounter.printCount();
		Activity.presentationsCounter.printCount();
		Activity.traditionalClassesCounter.printCount();
		Allocation.allocatedCounter.printCount();
		Allocation.allocationsTotalCounter.printCount();
		Allocation.finishedCounter.printCount();
		Allocation.inAllocationProccessCounter.printCount();
		Allocation.inProgressCounter.printCount();
		User.counter.printCount();
	}
	private static void printMainMenu(){
		System.out.println("Insira 0 para sair");
		System.out.println("Insira 1 se você é estudante");
		System.out.println("Insira 2 se você é professor ou pesquisador");
		System.out.println("Insira 3 se você é administrador");
	}
	private static void printProfessorsResearchersMenu(){
		System.out.println("Insira 0 para sair");
		System.out.println("Insira 1 para confirmar uma alocação");
		System.out.println("Insira 2 para adicionar informações de atividade em uma alocação");
		System.out.println("Insira 9 para voltar ao menu anterior");
	}
	private static void printAdministratorMenu(){
		System.out.println("Insira 0 para sair");
		System.out.println("Insira 1 para criar uma alocação de recurso");
		System.out.println("Insira 2 para editar uma alocação de recurso");
		System.out.println("Insira 3 para remover uma alocação de recurso");
		System.out.println("Insira 4 para exibir o relatório de atividades");
		System.out.println("Insira 5 para exibir informações de uma alocação");
		System.out.println("Insira 9 para voltar ao menu anterior");
	}
	private static void printStudentMenu(){
		System.out.println("Insira 0 para sair");
		System.out.println("Insira 9 para voltar ao menu anterior");
	}
}
