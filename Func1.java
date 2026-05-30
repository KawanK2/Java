package funcionario2;
import java.util.Scanner;


class funcionario {
	private String nome;
	private float salario; // nível 1

	public funcionario(String nome, float salario) {
		this.nome = nome;
	    this.salario = salario;
	}

	public funcionario(String nome) { // nível 2
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public float getSalario() {
		return salario;
	}

	public float calcularBonus() { // nível 5
		return getSalario() * 0.10f;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSalario(float salario) { 
		if (salario > 0) {
            this.salario = salario;
        } else {
            System.out.println("Salário inválido!");
        }
	}
	public void exibirDados() {
		System.out.println("--------------- Novo Funcionário ---------------");
		System.out.println("Nome: " + nome);
	    System.out.println("Salário: " + salario);
	    System.out.println("Bonus: " + calcularBonus());
	    System.out.println("Salário final: " + (getSalario() + calcularBonus()));
	}
	public void exibirDados(String nome) {
		System.out.println("--------------- Funcionário Desativado ---------------");
		System.out.println("Nome: " + nome);
	}
}
class gerente extends funcionario {
	private String setor; // nível 1

	public gerente(String nome, float salario, String setor) {
		super(nome, salario);
		this.setor = setor;
	}

	public gerente(String nome) { // nível 2
		super(nome);
		this.setor = "Sem setor";
	}

	public float calcularBonus() { // nível 5
		return getSalario() * 0.20f;
	}

	public void exibirDados() {
		super.exibirDados();
		System.out.println("Setor: " + setor);

	}
	public void exibirDados(String nome) {
		super.exibirDados(nome);
	}
}

class estagiario extends funcionario{ // nível 3
	private String curso;
	private int semestre;

	public estagiario(String nome, float salario, String curso, int semestre) {
		super(nome, salario);
		this.curso = curso;
		this.semestre = semestre;
	}


	public estagiario(String nome, String curso, int semestre) {
		super(nome, 0f);
		this.curso = curso;
		this.semestre = semestre;
	}

	public void exibirDados() {
		System.out.println("--------------- Novo Funcionário ---------------");
		System.out.println("Nome: " +  getNome());
		if (getSalario() == 0f) {
			System.out.println("Salário: Estágio não remunerado");
		}else {
			System.out.println("Saláro: " + getSalario());
		}
		System.out.println("Curso: " + curso);
		System.out.println("Semestre: " + semestre + "°");
	}
}

public class Func1 {
	public static void main (String[] args) {
		funcionario f1 = new funcionario("David", 2000f);
		gerente g1 = new gerente("Tião", 8000f, "Vendas");
		funcionario f2 = new funcionario("Marcos");
		gerente g2 = new gerente("Douglas");
		estagiario e1 = new estagiario("Felipe", 1000f, "Ciências da Computação", 3);
		estagiario e2 = new estagiario("Márcia", "Contabilidade", 4);
		funcionario f3 = new gerente("Rosa", 10000f, "Diretoria"); // nível 4
		f1.exibirDados();
		g1.exibirDados();
		f2.exibirDados();
		g2.exibirDados();
		e1.exibirDados();
		e2.exibirDados();
		f3.exibirDados();

		Scanner sc = new Scanner(System.in);

        int opcao;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1 - Criar Funcionário");
            System.out.println("2 - Criar Gerente");
            System.out.println("3 - Criar Estagiário");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            switch(opcao) {

                case 1:

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Salário: ");
                    float salario = sc.nextFloat();

                    funcionario f = new funcionario(nome, salario);

                    f.exibirDados();

                    break;

                case 2:

                    System.out.print("Nome: ");
                    nome = sc.nextLine();

                    System.out.print("Salário: ");
                    salario = sc.nextFloat();
                    sc.nextLine();

                    System.out.print("Setor: ");
                    String setor = sc.nextLine();

                    funcionario g = new gerente(nome, salario, setor);

                    g.exibirDados();

                    break;

                case 3:

                    System.out.print("Nome: ");
                    nome = sc.nextLine();

                    System.out.print("Salário: ");
                    salario = sc.nextFloat();
                    sc.nextLine();

                    System.out.print("Curso: ");
                    String curso = sc.nextLine();

                    System.out.print("Semestre: ");
                    int semestre = sc.nextInt();

                    funcionario e = new estagiario(nome, salario, curso, semestre);

                    e.exibirDados();	

                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while(opcao != 0);

        sc.close();
	}
}
