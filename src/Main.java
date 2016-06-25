import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		int choice = 9;
		Scanner kb = new Scanner(System.in);
		
		while (choice != 0) {
			if (choice == 9){
				System.out.println("Insira 0 para sair");
				System.out.println("Insira 1 se você é estudante");
				System.out.println("Insira 2 se você é professor ou pesquisador");
				System.out.println("Insira 3 se você é administrador");
			}
			else if (choice == 2) {
				System.out.println("Insira 0 para sair");
				System.out.println("Insira 1 para confirmar uma alocação");
				System.out.println("Insira 9 para ir ao menu principal");
			}
			else if (choice == 3) {
				System.out.println("Insira 0 para sair");
				System.out.println("Insira 1 para criar uma alocação de recurso");
				System.out.println("Insira 2 para editar uma alocação de recurso");
				System.out.println("Insira 3 para remover uma alocação de recurso");
				System.out.println("Insira 9 para ir ao menu principal");
			}
			else if (choice == 1){
				System.out.println("Insira 0 para sair");
				System.out.println("Insira 9 para ir ao menu principal");
			}
			else {
				System.out.println("Entrada inválida");
			}
			choice = kb.nextInt();
		}
		kb.close();
	}
}
