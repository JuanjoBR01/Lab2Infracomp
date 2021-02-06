package pasarela;

public class Persona extends Thread{

	private int idPersona;
	private int dir;
	
	public static Pasarela pista;
	
	public Persona (int idPersona, int dir) {
		this.dir=dir;
		this.idPersona=idPersona;
	}
	

	public void run(){
		pista.entrar(this.dir);
		pista.caminar();
		pista.salir();
	}
	
	public static void main(String[] args) {
		
		pista = new Pasarela();
		
		for (int i = 0; i < 20; i++) 
			new Persona(i,(int)(Math.random()*2)).start();
		
	}

	
}
