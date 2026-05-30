import java.util.Scanner;
import java.util.InputMismatchException;

class IdadeInvalidaException extends Exception {
	private static final long serialVersionUID = 1L;

	public IdadeInvalidaException(String mensagem) {
        super(mensagem);
    }
}

public class Div {
	
	public static void validarIdade(int idade) throws IdadeInvalidaException {
	    if (idade <= 0) {
	        throw new IdadeInvalidaException("idade não pode ser negativa");
	    }
	}
	
	public static void main (String[] args) {
		Scanner entrada = new Scanner(System.in);
        int opcao;
        boolean dadosInvalidos = false;
        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1 - Realizar divisão");
            System.out.println("0 - Sair");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch(opcao) {

                case 1:
                	try {
                		System.out.println("Digite seu nome: ");
                		String nome = entrada.nextLine();
                		
                	    if (nome.trim().isEmpty() || !nome.matches("[a-zA-ZÀ-ÿ ]+")) {
                	        throw new IllegalArgumentException();
                	    }
                		
                    	System.out.println("Digite sua idade");
                    	int idade = entrada.nextInt();
                    	validarIdade(idade);
                    	
                    	System.out.println("Digite um número para dividir por 100");
                    	int numero = entrada.nextInt();
                    	
                    	int resultado = 100 / numero;
                    	
                        System.out.println("\n=== DADOS ===");
                        System.out.println("Nome: " + nome);
                        System.out.println("Idade: " + idade);
                        System.out.println("Resultado: " + resultado);
                    	
                    	dadosInvalidos = true;
                    	
                	} catch (InputMismatchException e) {
                		System.out.println("Erro: entrada inválida!");
                	} catch (IllegalArgumentException e) {
                		System.out.println("Erro: Nome inválido!");
            		} catch (ArithmeticException e) {
                		System.out.println("Erro: divisão por zero!");
                	} catch (IdadeInvalidaException e) {
                		System.out.println("Erro: idade inválida!");
                	} finally {
                		System.out.println("Operação finalizada!!!");
                		entrada.nextLine();
                	}
                	
                    break;
                    
                case 0:
                	
                    System.out.println("Encerrando...");
                    break;

                default:
                	
                    System.out.println("Opção inválida!");
                    break;
            }

        } while(opcao !=0 || dadosInvalidos == false);

        entrada.close();
	}
}
