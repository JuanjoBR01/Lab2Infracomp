package pasarela;

public class Pasarela{

	private static int caminandoDir0 = 0;

	private static int caminandoDir1 = 0;

	public synchronized void entrar (int dir) {

		if (dir == 0) {
			while (caminandoDir1>0) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			caminandoDir0++;
			System.out.println("Entr� uno en la direcci�n 0");
		}

		else {
			while (caminandoDir0>0) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			caminandoDir1++;
			System.out.println("Entr� uno en la direcci�n 1");
		}

	}
	
	
	public void caminar () {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	public synchronized void salir() {
		if (caminandoDir0 == 0) {
			caminandoDir1--;
			System.out.println("Sali� uno en la direcci�n 1");
			
			if (caminandoDir1 == 0) {
				notifyAll();
			}
			else {
				notify();
			}
		} 
		else {
			caminandoDir0--;
			System.out.println("Sali� uno en la direcci�n 0");
			if (caminandoDir0 == 0) {
				notifyAll();
			}
			else {
				notify();
			}
		}
		
	}
	
	
	



}
