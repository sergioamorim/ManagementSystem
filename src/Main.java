import java.util.Scanner;
import java.time.LocalDateTime;

public class Main {

	public static void main(String args[]){
		int choice = 9;
		Scanner kb = new Scanner(System.in);
		
		Resource ex = new Resource();
		ex.setId(1);
		
		while (choice != 0) {
			if (choice == 9){ /* main menu */
				Main.printMainMenu();
			}
			else if (choice == 2) { /* menu for professors and researchers */
				Main.printProfessorsResearchersMenu();
				try {
					choice = kb.nextInt();
				} 
				catch (java.util.InputMismatchException e){
					System.out.println("ERRO! Insira um número inteiro.");
					choice = 10;
				}	
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
					try {
						choice = kb.nextInt();
					} 
					catch (java.util.InputMismatchException e){
						System.out.println("ERRO! Insira um número inteiro.");
						choice = 10;
					}	
				}
			}
			else if (choice == 3) { /* menu for administrators*/
				Main.printAdministratorMenu();
				try {
					choice = kb.nextInt();
				} 
				catch (java.util.InputMismatchException e){
					System.out.println("ERRO! Insira um número inteiro.");
					choice = 10;
				}	
				while (choice != 0 && choice != 9) {
					if (choice == 1) { /* create a resource allocation */
						createResourceAllocation();
					}
					else if (choice == 2) { /* modify a resource allocation */
						System.out.println("Insira o ID do recurso a ser alocado: ");
						int resourceId = 0;
						int responsibleId = 0;
						String dataEHora = null;
						Resource resource = null;
						AbleToAskResource responsible = null;
						LocalDateTime startAllocation = null;
						LocalDateTime finishAllocation = null;
						
					}
					else if (choice == 3) { /* delete a resource allocation */
						
					}
					else if (choice == 4) { /* print activities report */
						Main.printActivitiesReport();
					}
					else { /* invalid input */
						System.out.println("Entrada inválida");
					}
					Main.printAdministratorMenu();
					try {
						choice = kb.nextInt();
					} 
					catch (java.util.InputMismatchException e){
						System.out.println("ERRO! Insira um número inteiro.");
						choice = 10;
					}	
				}
			}
			else if (choice == 1){ /* menu for students */
				Main.printStudentMenu();
				try {
					choice = kb.nextInt();
				} 
				catch (java.util.InputMismatchException e){
					System.out.println("ERRO! Insira um número inteiro.");
					choice = 10;
				}	
				while (choice != 0 && choice != 9) {
					/* there is no valid option for students yet */
					System.out.println("Entrada inválida"); /* invalid input */
					Main.printStudentMenu();
					try {
						choice = kb.nextInt();
					}
					catch (java.util.InputMismatchException e){
						System.out.println("ERRO! Insira um número inteiro.");
						choice = 10;
					}	
				}
			}
			else { /* invalid input */
				System.out.println("Entrada inválida");
			}
			try {
				choice = kb.nextInt();
			} 
			catch (java.util.InputMismatchException e){
				System.out.println("ERRO! Insira um número inteiro.");
				choice = 10;
			}	
		}
		kb.close();
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
		System.out.println("Insira o ID do recurso a ser alocado: ");
		int resourceId = 0;
		int responsibleId = 0;
		String dataEHora = null;
		Resource resource = null;
		AbleToAskResource responsible = null;
		LocalDateTime startAllocation = null;
		LocalDateTime finishAllocation = null;
		Allocation allocation = null;
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
				dataEHora = kb.next();
				try {
					startAllocation = LocalDateTime.parse(dataEHora);
				}
				catch (java.time.format.DateTimeParseException e) {
					startAllocation = null;
				}
				if (startAllocation == null) {
					System.out.println("Formato incorreto de data e hora! Refaça o procedimento com o formato correto.");
				}
				else {
					System.out.println("Insira a data e a hora do fim da alocação no formato yyyy-MM-ddThh:mm");
					dataEHora = kb.next();
					try {
						finishAllocation = LocalDateTime.parse(dataEHora);
					}
					catch (java.time.format.DateTimeParseException e) {
						finishAllocation = null;
					}
					if (finishAllocation == null) {
						System.out.println("Formato incorreto de data e hora! Refaça o procedimento com o formato correto.");
					}
					else {
						allocation = new Allocation(resource, responsible, startAllocation, finishAllocation);
						System.out.println("Alocação criada com sucesso!");
					}
				}
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
		System.out.println("Insira 9 para voltar ao menu anterior");
	}
	private static void printStudentMenu(){
		System.out.println("Insira 0 para sair");
		System.out.println("Insira 9 para voltar ao menu anterior");
	}
}
