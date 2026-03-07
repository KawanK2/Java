public static void main(String[] args) {
    public class Conta {
        String numero;
        String titular;
        String agencia;
        Double saldo;
        Double limite;

        void depositar(Double valor) {
            saldo = saldo + valor;
        }

        void sacar(Double valor) {
            if (saldo < 0) {
                System.out.println("Transação Impossível ");
            }else {
                saldo = saldo - valor;
            }
        }

        void verExtrato() {
            System.out.println("Número: " + numero);
            System.out.println("Titular: " + titular);
            System.out.println("Agência: " + agencia);
            System.out.println("Saldo: " + saldo);
            System.out.println("Limite: " + limite);
        }
    }

    public class Teste {
        Conta minhaConta = new Conta();
        minhaConta.numero = "659";
        minhaConta.titular = "Kawan";
        minhaConta.agencia = "226";
        minhaConta.saldo = 0.0;
        minhaConta.limite = 0.0;
        
        depositar(500);
        sacar(10);
        sacar(1000);
        depositar(-40);
        verExtrato(); 
    }
}
