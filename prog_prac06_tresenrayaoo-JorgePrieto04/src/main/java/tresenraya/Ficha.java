package tresenraya;

public enum Ficha {
	X, O;

	public Ficha siguiente() {
		switch (this) {
		case X: 
			return Ficha.O;
		case O:
			return Ficha.X;
		default: 
			return null; 
		}
	}
}