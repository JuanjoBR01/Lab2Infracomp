package maxFila;
import java.util.concurrent.ThreadLocalRandom;

public class T extends Thread {  


	private final static int DIM = 4;
	private final static int LIM = 500;
	private static int[][] matriz = new int[DIM][DIM];

	private static Maximo maxGlobal;

	private int id = 0 ;
	private int maxFila = -1;


	public static void inicializarMAtriz() {

		for(int i = 0; i < DIM; i++) {
			for(int j = 0; j < DIM; j++) {
				matriz[i][j] = ThreadLocalRandom.current().nextInt(0, LIM);
			}
		}
	}


	public static void imprimirMatriz() {

		for(int i = 0; i < DIM; i++) {
			for(int j = 0; j < DIM; j++) {
				System.out.print(matriz[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("******************************");
	}

	/**
	 * Constructor para inicializar el Thread
	 * @param pId
	 */
	public T (int pId) {
		id = pId ;
	}


	public void run () {


		for(int j = 0; j < DIM; j++){
			if(this.maxFila < matriz[this.id][j]) this.maxFila = matriz[this.id][j];
		}


		if(maxGlobal.anotar(this.maxFila, this.id)) 
			System.out.println("Valor máximo: " + maxGlobal.darMaximo() + " - Localizado por el thread: " + maxGlobal.darIdentificador());
	}

	public static void main(String[] args) {


		System.out.println("*************************");
		System.out.println("********  Matriz ******** ");
		System.out.println("*************************");

		inicializarMAtriz();
		imprimirMatriz();

		int numThreads = DIM;
		maxGlobal = new Maximo(numThreads);

		for (int i = 0; i < numThreads; i++) 
			new T (i).start();

	}

}