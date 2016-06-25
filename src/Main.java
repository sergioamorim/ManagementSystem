import java.util.Scanner;
import Activity;
import Resource;
import User;


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
			}
			else if (choice == 3) { /* menu for administrators*/
				Main.printAdministratorMenu();
				choice = kb.nextInt();
				while (choice != 0 && choice != 9) {
					if (choice == 1) { /* create a resource allocation */
						
					}
					else if (choice == 2) { /* edit a resource allocation */
						
					}
					else if (choice == 3) { /* delete a resource allocation */
						
					}
					else if (choice == 4) { /* print activities report */
						Main.printActivitiesReport();
					}
					Main.printAdministratorMenu();
					choice = kb.nextInt();
				}
			}
			else if (choice == 1){ /* menu for students */
				Main.printStudentMenu();
			}
			else { /* invalid input */
				System.out.println("Entrada inválida");
			}
			choice = kb.nextInt();
		}
		kb.close();
	}
	private static void printActivitiesReport(){
		System.out.print(Activity.laboratoriesCounter.getCount());
		System.out.print(Activity.presentationsCounter.getCount());
		System.out.print(Activity.traditionalClassesCounter.getCount());
		System.out.print(Resource.allocatedCounter.getCount());
		System.out.print(Resource.allocationsTotalCounter.getCount());
		System.out.print(Resource.finishedCounter.getCount());
		System.out.print(Resource.inAllocationProccessCounter.getCount());
		System.out.print(Resource.inProgressCounter.getCount());
		System.out.print(User.counter.getCount());
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
