package tresenraya;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class T03CrearPartidaTest {

	private static final int TAM = 3;

	/**
   |   |   
---+---+---
   |   |   
---+---+---
   |   |     	
	 */
	private static final String PINTAR_VACIO = "   |   |   \n---+---+---\n   |   |   \n---+---+---\n   |   |   \n";

	@Test
	void crearPartida() {
		PrintStream originalErr = System.err;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		System.setErr(new PrintStream(bos));
		
		Partida partida = new Partida(TAM);
		assertFalse(partida.terminada());
		for (int i = 0; i < TAM; i++) {
			for (int j = 0; j < TAM; j++) {
				partida.jugar(i, j);
			}
		}
		assertEquals("", bos.toString());
	
		System.setErr(originalErr);
	}
	
	@Test
	void pintarPartidaVaciaTest() {
		Partida partida = new Partida(TAM);
		String salida = partida.toString();
		assertEquals(PINTAR_VACIO + "\n Turno: X", salida);
	}

}
