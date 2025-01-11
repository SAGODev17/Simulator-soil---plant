package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Reglas.Nutriente;

public class NutrienteTest {

	
	
	@Test
	public void testNutriente() {
		Nutriente nutriente = new Nutriente();
		assertEquals(0, nutriente.enBiomasa, 0);
		assertEquals(0, nutriente.enSolucion, 0);
		assertEquals(0, nutriente.precipitado, 0);
		assertEquals(0, nutriente.velocidadAbsorcion, 0);
		assertEquals(0, nutriente.velocidadPrecipitacion, 0);
	}

	/**
	 * Prueba del método cantidadAbsorcion.
	 * 
	 * Verifica que el cálculo de la cantidad de absorción se realice correctamente.
	 */
	@Test
	public void testCantidadAbsorcion() {
		Nutriente nutriente = new Nutriente();
		nutriente.enSolucion = 10;
		nutriente.velocidadAbsorcion = 5;
		float cantidadAbsorcion = nutriente.cantidadAbsorcion();
		assertEquals(5, cantidadAbsorcion, 0);
	}

	/**
	 * Prueba del método cantidadPrecipitacion.
	 * 
	 * Verifica que el cálculo de la cantidad de precipitación se realice correctamente.
	 */
	@Test
	public void testCantidadPrecipitacion() {
		Nutriente nutriente = new Nutriente();
		nutriente.enSolucion = 8;
		nutriente.velocidadPrecipitacion = 3;
		float cantidadPrecipitacion = nutriente.cantidadPrecipitacion();
		assertEquals(3, cantidadPrecipitacion, 0);
	}

	/**
	 * Prueba del método absorcion.
	 * 
	 * Verifica que el proceso de absorción actualice los valores correctamente.
	 */
	@Test
	public void testAbsorcion() {
		Nutriente nutriente = new Nutriente();
		nutriente.enSolucion = 10;
		nutriente.velocidadAbsorcion = 5;
		nutriente.absorcion();
		assertEquals(5, nutriente.enSolucion, 0);
		assertEquals(5, nutriente.enBiomasa, 0);
	}

	/**
	 * Prueba del método precipitacion.
	 * 
	 * Verifica que el proceso de precipitación actualice los valores correctamente.
	 */
	@Test
	public void testPrecipitacion() {
		Nutriente nutriente = new Nutriente();
		nutriente.enSolucion = 8;
		nutriente.velocidadPrecipitacion = 3;
		nutriente.precipitacion();
		assertEquals(5, nutriente.enSolucion, 0);
		assertEquals(3, nutriente.precipitado, 0);
	}

	/**
	 * Prueba del método paso.
	 * 
	 * Verifica que el proceso de paso (que involucra absorción y precipitación) actualice los valores correctamente.
	 */
	@Test
	public void testPaso() {
		Nutriente nutriente = new Nutriente();
		nutriente.enSolucion = 10;
		nutriente.velocidadAbsorcion = 5;
		nutriente.velocidadPrecipitacion = 3;
		nutriente.paso();
		assertEquals(2, nutriente.enSolucion, 0);
		assertEquals(5, nutriente.enBiomasa, 0);
		assertEquals(3, nutriente.precipitado, 0);
	}

	/**
	 * Prueba del método enSolucion.
	 * 
	 * Verifica que el método enSolucion devuelva el resultado esperado.
	 */
	
	@Test
	public void testEnSolucion() {
		Nutriente nutriente = new Nutriente();
		nutriente.enSolucion = 0;
		assertFalse(nutriente.enSolucion());
		nutriente.enSolucion = 5;
		assertTrue(nutriente.enSolucion());
	}
}

