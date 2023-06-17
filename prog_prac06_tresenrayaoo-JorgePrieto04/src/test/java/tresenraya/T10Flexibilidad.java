package tresenraya;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class T10Flexibilidad {

	/**
	   |   |   |   
	---+---+---+---
	   |   |   |   
	---+---+---+---
	   |   |   |   
	---+---+---+---
	   |   |   |   	
	 */
	private static final String PINTAR_1 = "   |   |   |   \n---+---+---+---\n   |   |   |   \n---+---+---+---\n   |   |   |   \n---+---+---+---\n   |   |   |   \n";

	/**
	   |   |   |   
	---+---+---+---
	   |   |   |   
	---+---+---+---
	 O |   |   |   
	---+---+---+---
	   |   |   |    	
	 */
	private static final String PINTAR_2 = "   |   |   |   \n---+---+---+---\n   |   |   |   \n---+---+---+---\n O |   |   |   \n---+---+---+---\n   |   |   |   \n";

	/**
	   |   |   |   
	---+---+---+---
	   |   |   |   
	---+---+---+---
	 X |   |   |   
	---+---+---+---
	   |   |   |    	
	 */
	private static final String PINTAR_2B = "   |   |   |   \n---+---+---+---\n   |   |   |   \n---+---+---+---\n X |   |   |   \n---+---+---+---\n   |   |   |   \n";

	/**
	   |   |   |   
	---+---+---+---
	   |   |   |   
	---+---+---+---
	 O |   |   |   
	---+---+---+---
	   |   |   | X 	
	 */
	private static final String PINTAR_3 = "   |   |   |   \n---+---+---+---\n   |   |   |   \n---+---+---+---\n O |   |   |   \n---+---+---+---\n   |   |   | X \n";

	/**
	   |   |   |   
	---+---+---+---
	 O |   |   |   
	---+---+---+---
	 X |   |   |   
	---+---+---+---
	   |   |   | X 	
	 */
	private static final String PINTAR_3B = "   |   |   |   \n---+---+---+---\n O |   |   |   \n---+---+---+---\n X |   |   |   \n---+---+---+---\n   |   |   | X \n";

	/**
	   |   |   |   
	---+---+---+---
	   |   |   |   
	---+---+---+---
	 O |   |   |   
	---+---+---+---
	 X | X | X | X 	
	 */
	private static final String PINTAR_4 = "   |   |   |   \n---+---+---+---\n   |   |   |   \n---+---+---+---\n O |   |   |   \n---+---+---+---\n X | X | X | X \n";

	/**
	 O |   | O |   
	---+---+---+---
	 O | O |   |   
	---+---+---+---
	 X |   |   |   
	---+---+---+---
	 X | X | X | X 	
	 */
	private static final String PINTAR_4B = " O |   | O |   \n---+---+---+---\n O | O |   |   \n---+---+---+---\n X |   |   |   \n---+---+---+---\n X | X | X | X \n";

	/**
	   |   
	---+---
	   |   
	 */
	private static final String PINTAR2_1 = "   |   \n---+---\n   |   \n";

	/**
	 X |   
	---+---
	   |   
	 */
	private static final String PINTAR2_2 = " X |   \n---+---\n   |   \n";

	/**
	 X | O 
	---+---
	   |   
	 */
	private static final String PINTAR2_3 = " X | O \n---+---\n   |   \n";

	/**
	 X | O 
	---+---
	   | X 
	 */
	private static final String PINTAR2_4 = " X | O \n---+---\n   | X \n";

	@Test
	void tablero4x4Test() {
		Tablero tablero = new Tablero(4);
		assertEquals(PINTAR_1, tablero.toString());
		boolean ganaX = tablero.gana(Ficha.X);
		assertFalse(ganaX);

		tablero.jugar(Ficha.O, 2, 0);
		assertEquals(PINTAR_2, tablero.toString());
		boolean ganaO = tablero.gana(Ficha.O);
		assertFalse(ganaO);
		
		tablero.jugar(Ficha.X, 3, 3);
		assertEquals(PINTAR_3, tablero.toString());
		
		tablero.jugar(Ficha.X, 3, 2);
		tablero.jugar(Ficha.X, 3, 1);
		tablero.jugar(Ficha.X, 3, 0);
		assertEquals(PINTAR_4, tablero.toString());
		boolean ganaO2 = tablero.gana(Ficha.O);
		assertFalse(ganaO2);
		boolean ganaX2 = tablero.gana(Ficha.X);
		assertTrue(ganaX2);

		boolean lleno = tablero.estaLleno();
		assertFalse(lleno);
	}
	
	@Test
	void tablero2x2Test() {
		Tablero tablero = new Tablero(2);
		assertEquals(PINTAR2_1, tablero.toString());
		boolean ganaX = tablero.gana(Ficha.O);
		assertFalse(ganaX);

		tablero.jugar(Ficha.X, 0, 0);
		assertEquals(PINTAR2_2, tablero.toString());
		boolean ganaO = tablero.gana(Ficha.X);
		assertFalse(ganaO);
		
		tablero.jugar(Ficha.O, 0, 1);
		assertEquals(PINTAR2_3, tablero.toString());
		
		tablero.jugar(Ficha.X, 1, 1);
		assertEquals(PINTAR2_4, tablero.toString());
		boolean ganaO2 = tablero.gana(Ficha.X);
		assertTrue(ganaO2);

		boolean lleno =  tablero.estaLleno();
		assertFalse(lleno);
		tablero.jugar(Ficha.O, 1, 0);
		assertTrue(tablero.estaLleno());
	}

	@Test
	void partida4x4Test() {
		Partida partida = new Partida(4);
		assertEquals(PINTAR_1 + "\n Turno: X", partida.toString());
		assertNull(partida.ganador());

		partida.jugar(2, 0);
		assertEquals(PINTAR_2B + "\n Turno: O", partida.toString());
		assertNull(partida.ganador());
		
		partida.jugar(1, 0); // O
		partida.jugar(3, 3);
		assertEquals(PINTAR_3B + "\n Turno: O", partida.toString());
		
		partida.jugar(0, 0); // O
		partida.jugar(3, 2); // X
		partida.jugar(0, 2); // O
		partida.jugar(3, 1); // X
		partida.jugar(1, 1); // O
		partida.jugar(3, 0); // X
		assertEquals(PINTAR_4B + "\n Turno: O", partida.toString());
		assertEquals(Ficha.X, partida.ganador());

		assertTrue(partida.terminada());
	}
	
	@Test
	void partida2x2Test() {
		Partida partida = new Partida(2);
		assertEquals(PINTAR2_1 + "\n Turno: X", partida.toString());
		assertNull(partida.ganador());

		partida.jugar(0, 0);
		assertEquals(PINTAR2_2 + "\n Turno: O", partida.toString());
		assertNull(partida.ganador());
		
		partida.jugar(0, 1);
		assertEquals(PINTAR2_3 + "\n Turno: X", partida.toString());
		
		partida.jugar(1, 1);
		assertEquals(PINTAR2_4 + "\n Turno: O", partida.toString());
		assertEquals(Ficha.X, partida.ganador());

		assertTrue(partida.terminada());
		partida.jugar(1, 0);
		assertTrue(partida.terminada());
	}

}
