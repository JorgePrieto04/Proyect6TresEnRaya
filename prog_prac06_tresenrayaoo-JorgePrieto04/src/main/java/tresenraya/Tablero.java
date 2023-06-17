package tresenraya;

public class Tablero {
	private static final String VERT = "|";
	private static final String SEP = " ";
	private static final String HORT = "---";
	private static final String CRUZ = "+";

	private Ficha[][] tablero;

	public Tablero(int tam) {
		tablero = new Ficha[tam][tam];
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				tablero[i][j] = null;
			}
		}
	}

	public boolean jugar(Ficha ficha, int fila, int columna) {
		if (tablero[fila][columna] == null) {
			tablero[fila][columna] = ficha;
			return true;
		}
		return false;
	}

	public boolean estaLleno() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (tablero[i][j] == null) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean gana(Ficha jugador) {
		return ganaHorizontal(jugador) || ganaVertical(jugador) || ganaDiagonalDirecta(jugador)
				|| ganaDiagonalInversa(jugador);
	}

	protected boolean ganaHorizontal(Ficha jugador) {
		boolean gana = false;
		for (int i = 0; i < tablero.length && !gana; i++) {
			gana = true;
			for (int j = 0; j < tablero[i].length && gana; j++) {
				gana &= tablero[i][j] == jugador;
			}
		}
		return gana;
	}

	protected boolean ganaVertical(Ficha jugador) {
		boolean gana = false;
		for (int i = 0; i < tablero.length && !gana; i++) {
			gana = true;
			for (int j = 0; j < tablero[i].length && gana; j++) {
				gana &= tablero[j][i] == jugador;
			}
		}
		return gana;
	}

	protected boolean ganaDiagonalDirecta(Ficha jugador) {
		boolean gana = true;
		for (int i = 0; i < tablero.length; i++) {
			gana &= tablero[i][i] == jugador;
		}
		return gana;
	}

	protected boolean ganaDiagonalInversa(Ficha jugador) {
		boolean gana = true;
		for (int i = 0; i < tablero.length; i++) {
			gana &= tablero[tablero.length - 1 - i][i] == jugador;
		}
		return gana;
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				s += SEP + pintaFicha(tablero[i][j]) + SEP;
				if (j < tablero[i].length - 1) {
					s += VERT;
				}
			}
			s += "\n";
			if (i < tablero.length - 1) {
				for (int j = 0; j < tablero[i].length; j++) {
					s += HORT;
					if (j < tablero[i].length - 1) {
						s += CRUZ;
					}
				}
				s += "\n";
			}
		}
		return s;
	}

	private Object pintaFicha(Ficha f) {
		return f == null ? " " : f;
	}
}