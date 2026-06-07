import java.util.Scanner;
import java.util.ArrayList;


abstract class funcionario {
	private String nome;
	private float salario;
	protected static int totalFuncionarios = 0;
	public static final float SALARIO_MINIMO = (float) 1518.00;
	   
	public funcionario(String nome, float salario) {
		this.nome = nome;
	    setSalario(salario);
	    totalFuncionarios++;
	}
	
	public funcionario(String nome) { 
		this.nome = nome;
		totalFuncionarios++;
	}
	
	public String getNome() {
		return nome;
	}
	
	public float getSalario() {
		return salario;
	}
	
	public abstract float calcularBonus();
	
    public static int getTotalFuncionarios() {
        return totalFuncionarios;
    }
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setSalario(float salario) { 
		if (salario >= SALARIO_MINIMO) {
            this.salario = salario;
        } else {
            System.out.println("Salário inválido!");
        }
	}
	public void exibirDados() {
		System.out.println("--------------- Funcionário ---------------");
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
	private String setor; 
	
	public gerente(String nome, float salario, String setor) {
		super(nome, salario);
		this.setor = setor;
	}
	
	public gerente(String nome) { 
		super(nome);
		this.setor = "Sem setor";
	}
	
	public float calcularBonus() { 
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

class estagiario extends funcionario{ 
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
		System.out.println("--------------- Funcionário ---------------");
		System.out.println("Nome: " +  getNome());
		if (getSalario() == 0f) {
			System.out.println("Salário: Estágio não remunerado");
		}else {
			System.out.println("Saláro: " + getSalario());
		}
		System.out.println("Curso: " + curso);
		System.out.println("Semestre: " + semestre + "°");
	}
	
	public float calcularBonus() {
		return 0;
	}
}

class desenvolvedor extends funcionario{
	private String cargo;
	
	public desenvolvedor(String nome, float salario, String cargo) {
		super(nome, salario);
		this.cargo = cargo;
	}
	
	public void exibirDados() {
		super.exibirDados();
		System.out.println("Cargo: " + cargo);
	}
	
	public float calcularBonus() {
		return (float) (getSalario() * 0.05);
	}
}

class vendedor extends funcionario{
	private int num_vendas;
	
	public vendedor(String nome, float salario, int num_vendas) {
		super(nome, salario);
		this.num_vendas = num_vendas;
	}
	
	public float calcularBonus() {
		return (float) (num_vendas * 22.68);
	}
	
	public void exibirDados() {
		super.exibirDados();
		System.out.println("Número de vendas: " + num_vendas);
	}
}

public class Func3 {
	static ArrayList<funcionario> lista = new ArrayList<>();
	
	public static void aplicarAumento(ArrayList<funcionario> lista, String nome, float percentual) {
		for (funcionario f : lista) {
			if (f.getNome().equalsIgnoreCase(nome)) {
				float novoSalario = f.getSalario() * (1 + percentual / 100);
				f.setSalario(novoSalario);
				break;
			}
		}
	}
	
	public static void main (String[] args) {
		gerente g1 = new gerente("Tião", 8000f, "Vendas");
		gerente g2 = new gerente("Douglas");
		estagiario e1 = new estagiario("Felipe", 1000f, "Ciências da Computação", 3);
		estagiario e2 = new estagiario("Márcia", "Contabilidade", 4);
		funcionario f3 = new gerente("Rosa", 10000f, "Diretoria");
		desenvolvedor d1 = new desenvolvedor("Kawan", 2200f, "Júnior");
		vendedor v1 = new vendedor("Paulo", 3000, 20);
		g1.exibirDados();
		lista.add(g1);
		g2.exibirDados();
		lista.add(g2);
		e1.exibirDados();
		lista.add(e1);
		e2.exibirDados();
		lista.add(e2);
		f3.exibirDados();
		lista.add(f3);
		d1.exibirDados();
		lista.add(d1);
		v1.exibirDados();
		lista.add(v1);
		
		Scanner sc = new Scanner(System.in);

        int opcao;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1 - Criar Vendedor");
            System.out.println("2 - Criar Gerente");
            System.out.println("3 - Criar Estagiário");
            System.out.println("4 - Criar Desenvolvedor");
            System.out.println("5 - Visualizar todos os funcionários");
            System.out.println("6 - Aplicar aumento");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            switch(opcao) {

                case 1:
                	
                	System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Salário: ");
                    float salario = sc.nextFloat();
                    
                    System.out.print("Número de vendas: ");
                    int num_vendas = sc.nextInt();
                    sc.nextLine();

                    vendedor v = new vendedor(nome, salario, num_vendas);

                    v.exibirDados();
                    lista.add(v);

                    break;

                case 2:

                    System.out.print("Nome: ");
                    nome = sc.nextLine();

                    System.out.print("Salário: ");
                    salario = sc.nextFloat();

                    System.out.print("Setor: ");
                    String setor = sc.nextLine();
                    sc.nextLine();

                    funcionario g = new gerente(nome, salario, setor);

                    g.exibirDados();
                    lista.add(g);

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
                    sc.nextLine();

                    funcionario e = new estagiario(nome, salario, curso, semestre);

                    e.exibirDados();
                    lista.add(e);

                    break;
                    
                case 4:
                	
                    System.out.print("Nome: ");
                    nome = sc.nextLine();

                    System.out.print("Salário: ");
                    salario = sc.nextFloat();
                    
                    System.out.print("Cargo: ");
                    String cargo = sc.nextLine();
                    sc.nextLine();
                    
                    desenvolvedor d = new desenvolvedor(nome, salario, cargo);
                    
                    d.exibirDados();
                    lista.add(d);
                    
                    break;

                case 5:
                	
                	System.out.print("Lista de Funcionários: ");
                	for (funcionario func : lista) {
                		func.exibirDados();
                	}
                	System.out.println("\nTotal de Funcionários: " + funcionario.getTotalFuncionarios());
                	break;
                	
                case 6:
                	
                    System.out.print("Nome: ");
                    nome = sc.nextLine();
                    
                    System.out.print("Percentual de aumento: ");
                    float percentual = sc.nextFloat();
                    
                    aplicarAumento(lista, nome, percentual);
                    
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
