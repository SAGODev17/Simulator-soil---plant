package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Reglas.Nutriente;

public class NutrienteTest {

    @Test
    public void testConstructor() {
        Nutriente nutriente = new Nutriente();
        assertEquals("", nutriente.nombre);
    }

    @Test
    public void testSetNombre() {
        Nutriente nutriente = new Nutriente();
        nutriente.nombre = "Nitrógeno";
        assertEquals("Nitrógeno", nutriente.nombre);
    }
}
