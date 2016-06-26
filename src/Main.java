import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		int choice = 9;
		Scanner kb = new Scanner(System.in);
		
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
						System.out.println("Insira o ID do recurso a ser alocado: ");
						int resourceId = 0;
						Resource resource = null;
						try {
							resourceId = kb.nextInt();
						}
						catch (java.util.InputMismatchException e) {
							resourceId = -1;
						}
						if (resourceId < 0) {
							System.out.println("ERRO! ID inválido. Insira um número natural.");
							choice = 1;
						}
						else {
							resource = Resource.findById(resourceId);
							if (resource == null) {
								choice = 1;
							}
							else {
								
							}
						}
						
					}
					else if (choice == 2) { /* modify a resource allocation */
						
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
	private static void printActivitiesReport(){
		Activity.laboratoriesCounter.printCount();
		Activity.presentationsCounter.printCount();
		Activity.traditionalClassesCounter.printCount();
		Resource.allocatedCounter.printCount();
		Resource.allocationsTotalCounter.printCount();
		Resource.finishedCounter.printCount();
		Resource.inAllocationProccessCounter.printCount();
		Resource.inProgressCounter.printCount();
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
