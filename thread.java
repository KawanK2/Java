class ContadorCompartilhado {
    public static int contador = 0;
}

class ContagemCrescente implements Runnable {

    public void run() {
        for (int i = 1; i <= 10; i++) {

            System.out.println(Thread.currentThread().getName() + ": " + i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrompida.");
            }
        }
    }
}

class ContagemDecrescente implements Runnable {

    @Override
    public void run() {
        for (int i = 10; i >= 1; i--) {

            System.out.println(Thread.currentThread().getName() + ": " + i);

            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                System.out.println("Thread interrompida.");
            }
        }
    }
}

class ContadorRunnable implements Runnable {

    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {
            ContadorCompartilhado.contador++;
        }

        System.out.println(Thread.currentThread().getName()
                + " terminou.");
    }
}

public class thread {

    public static void main(String[] args) {
    	
        Thread t1 = new Thread(new ContagemCrescente());

        Thread t2 = new Thread(new ContagemDecrescente());

        t1.setName("Thread A");
        t2.setName("Thread B");

        t1.start();
        t2.start();

        Thread t3 = new Thread(() -> {

            for (int i = 1; i <= 5; i++) {

                System.out.println(
                        Thread.currentThread().getName()
                                + ": mensagem " + i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        t3.setName("Thread C");
        t3.start();

        try {

            t1.join();
            t2.join();
            t3.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n=== Teste de condição de corrida ===");

        Thread c1 = new Thread(new ContadorRunnable());
        Thread c2 = new Thread(new ContadorRunnable());

        c1.setName("Contador 1");
        c2.setName("Contador 2");

        c1.start();
        c2.start();

        try {

            c1.join();
            c2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(
                "Valor final do contador: "
                        + ContadorCompartilhado.contador);
    }
}
