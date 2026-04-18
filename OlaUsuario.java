package aula1;
import java.util.Scanner;

public class OlaUsuario {
	private static Scanner entrada;
	private static Scanner entradac;
	
	public static void main(String[] args) {
		entrada = new Scanner(System.in);
		entradac = new Scanner(System.in);
	    System.out.println("Digite seu nome:");
	    String nome = entrada.nextLine();
	    System.out.println("Digite sua idade:");
	    int idade = entrada.nextInt();
	    System.out.println("Digite seu curso:");
	    String curso = entradac.nextLine();
	    System.out.println("Olá " + nome + ", você tem " + idade + " anos, seja bem-vindo ao curso de " + curso);
	}
}