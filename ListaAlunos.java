import java.util.Scanner;
import java.util.ArrayList;

class Aluno{
	private String nome;
	
	public Aluno(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void exibirDados() {
		System.out.println(nome);
	}
}

public class ListaAlunos {
	
	
    public static void main(String[] args) {
    	ArrayList<Aluno> alunos = new ArrayList<>();
    	Scanner	sc = new Scanner(System.in);
    	
    	int opcao;
    	
    	do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Adicionar aluno");
            System.out.println("2 - Remover aluno");
            System.out.println("3 - Consultar lista de alunos");
            System.out.println("4 - Criar lista numérica e consultar média");
            System.out.println("0 - Sair");
            
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch(opcao) {
            	case 1:
            		System.out.print("Nome: ");
                    String nome1 = sc.nextLine();
                    alunos.add(new Aluno(nome1));
                    break;
            	case 2:
            		System.out.print("Nome: ");
            		String nome2 = sc.nextLine();
            		for (Aluno aluno : alunos) {

            		    if (aluno.getNome().equals(nome2)) {

            		        alunos.remove(aluno);

            		        break;
            		    }
            		}
            	case 3:
                    System.out.println("Lista de alunos:");
                    for (Aluno aluno : alunos) {
                    	aluno.exibirDados();
                    }
                    break;
            	case 4:
            		int op;
            		ArrayList<Integer> numeros = new ArrayList<>();
            		do {
            			System.out.println("Digite o número: ");
            			int num = sc.nextInt();
            			numeros.add(num);
            			System.out.println("Deseja continuar? 1=Sim 0=Não");
            			op = sc.nextInt();
             		}while (op == 1);
            			int soma = 0;
            			for (int num : numeros) {
            				soma += num;
            			}
            			double media = (double) soma / numeros.size();
            			System.out.println("Média: " + media);
            			break;
            	case 0:
            		System.out.println("Encerrando...");
            		break;
            	default:
            		System.out.println("Opção inválida!");
            }
    	}while (opcao != 0);
    }
}
