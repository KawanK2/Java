package aula2;
import java.util.Scanner;

public class ControleFluxodesafioextra {
		private static Scanner entrada;
		private static String nome;
		private static int idade;
		private static float nota;
		private static int numaprov;
		
		public static void main(String[] args) {
			numaprov = 0;
			for (int i = 0; i < 5; i++) {
				entrada = new Scanner(System.in);
				System.out.println("Digite seu nome:");
			    nome = entrada.nextLine();
			    System.out.println("Digite sua idade:");
			    idade = entrada.nextInt();
			    if (idade < 0) {
			    	System.out.println("idade inválida");
			    	return;
				}
			    System.out.println("Digite seu nota:");
			    nota = entrada.nextFloat();
			    if (nota < 0) {
			    	System.out.println("Nota inválida");
			    	return;
			    }else if (nota >= 7) {
			    	System.out.println("Aprovado");
			    	numaprov ++;
			    }else if (nota >= 5) {
			    	System.out.println("Recuperação");
			    }else {
			    	System.out.println("Recuperação");
			    }
			}
			System.out.println("Nome: " + nome + "\nIdade: " + idade + "\nNota: " + nota);
			System.out.println("Número de aprovados:" + numaprov);
		}
		
}
