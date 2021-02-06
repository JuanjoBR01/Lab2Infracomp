package maxFila;

public class Maximo {
	
	private int contador, maximo, nThreads, identificador;
	
	/**
	 * M�todo constructor de la clases
	 * @param numT
	 */
	public Maximo (int numT) {
		nThreads = numT;
		maximo=0;
		contador=0;
		identificador=0;
	}
	
	public int darMaximo() {
		return maximo;
	}
	
	public int darIdentificador() {
		return identificador;
	}
	
	
	
	public synchronized boolean anotar (int n, int pId) {
		
		/**
		 * Se revisa si se supera al m�ximo que se ten�a y se hacen las respectivas asignaciones
		 */
		
		if (n > maximo) {
			maximo = n ;
			identificador = pId+1;
		}
		
		/**
		 * Se revisa que el �ltimo Thread se haya ejecutado para poder imprimir en la consola
		 */
		
		if(++contador == nThreads) return true;
		else return false;
	}
}
