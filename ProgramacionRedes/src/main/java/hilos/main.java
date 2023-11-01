package hilos;

import java.io.PrintStream;

public class main {

	static PrintStream ps;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CicloVida hilo = new CicloVida();
		ps = new PrintStream(System.out);

		ps.println(Thread.currentThread().getName());
		
		@SuppressWarnings("unused")
		Thread hilo_2 = new Thread(
				new Runnable() {
					@SuppressWarnings("static-access")
					public void run() {
						for(int i = 0 ; i<10;i++ )
						{
							ps.println( Thread.currentThread().getName() + ":" + i);
							try {
								Thread.currentThread().sleep(200);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}, "Del1Al10"
		);
		
		hilo_2.start();

		// hilo.run(); <-llama al metodo no al hilo
		ps.println(Thread.currentThread().getName());

		ps.println(hilo.getState());
		hilo.start();

		try {
			// Thread.currentThread().sleep(200);
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (hilo.getState() == Thread.State.TIMED_WAITING) {
			ps.println("esta el hilo a la espera");
		}

		while (hilo.getState() != Thread.State.TERMINATED) {
			ps.println(hilo.getState());
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
