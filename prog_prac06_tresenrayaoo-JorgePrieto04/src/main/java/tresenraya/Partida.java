package tresenraya;

public class Partida {
	private Tablero tablero;
	private Ficha turno;
	
	public Partida(int tam) {
		tablero = new Tablero(tam);
		int pos = 0; 
		turno = Ficha.values()[pos]; 
		System.out.println("Empieza jugando " + turno);
	}

	public void jugar(int fila, int columna) {
		if (tablero.jugar(turno, fila, columna)) {
			turno = turno.siguiente();
		} else {
			System.err.println("Casilla [" + fila + ", " + columna + "] ocupada, vuelve a jugar " + turno);
		}
	}
	
	public boolean terminada() {
		return tablero.estaLleno() || ganador() != null;
	}

	public Ficha ganador() {
		for (Ficha f : Ficha.values()) {
			if (tablero.gana(f)) {
				return f;
			}
		}
		return null;
	}

	public String toString() {
		return tablero + "\n Turno: " + turno;
	}
}