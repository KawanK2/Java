package aula2;
import java.util.Scanner;

public class ControleFluxo {
	private static Scanner entrada;
	private static int idade;
	private static String nome;
	private static float nota;
	public static void main(String[] args) {
		int wop = 1;
		while(wop == 1) {
			entrada = new Scanner(System.in);
			System.out.println("Digite seu nome:");
		    nome = entrada.nextLine();
		    System.out.println("Digite sua idade:");
		    idade = entrada.nextInt();
		    System.out.println("Digite seu nota:");
		    nota = entrada.nextFloat();
		    if (nota < 0) {
		    	System.out.println("\nNota inválida!!!");
		    	return;
		    }else if (nota >= 7) {
		    	System.out.println("\nAprovado!!!");
		    }else if (nota >= 5) {
		    	System.out.println("\nRecuperação!!!");
		    }else {
		    	System.out.println("\nRecuperação!!!");
		    }
		    System.out.println("\nNome: " + nome + "\nIdade: " + idade + "\nNota: " + nota);
			System.out.println("Menu interativo:\n1. Verificar idade\n2. Calcular média\n3. Sair");
			int op = entrada.nextInt();
			entrada = new Scanner(System.in);
			switch(op) {
			case 1:
				if (idade > 0) {
					for (int i = 0;i <= idade; i++) {
						System.out.println(" " + i + " ");
					}
				}else {
			    	System.out.println("idade inválida");
			    	return;
				}
				System.out.println("Deseja utilizar o programa novamente? \n0 = não\n1 = sim");
				wop = entrada.nextInt();
				break;
			case 2:
				System.out.println("Quantas notas deseja fazer a média?");
				int ct = entrada.nextInt();
				float nots = 0;
				for (int i = 1;i <= ct;i++) {
					System.out.println("Digite a nota:");
					float not = entrada.nextInt();
					nots += not;
				}
				float media = nots / ct;
				System.out.println("Média: " + media);
				System.out.println("Deseja utilizar o programa novamente? \n0 = não\n1 = sim");
				wop = entrada.nextInt();
				break;
			case 3:
				System.out.println("Até a próxima.");
				break;
			}
		}
	}
}
