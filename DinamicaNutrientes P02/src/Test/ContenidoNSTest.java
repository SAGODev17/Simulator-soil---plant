package Test;

import Reglas.ContenidoNS;
import Reglas.Nutriente;
import Reglas.Suelo;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContenidoNSTest {

    @Test
    public void testConstructor() {
        Nutriente nutriente = new Nutriente();
        Suelo suelo = new Suelo();
        ContenidoNS contenido = new ContenidoNS(nutriente, suelo);
        assertEquals(nutriente, contenido.nutriente);
        assertEquals(suelo, contenido.suelo);
        assertEquals(0, contenido.enSolucion, 0.01); // Usamos 0.01 de margen para valores flotantes
        assertEquals(0, contenido.precipitado, 0.01);
    }

    @Test
    public void testEnSolucion() {
        Nutriente nutriente = new Nutriente();
        Suelo suelo = new Suelo();
        ContenidoNS contenido = new ContenidoNS(nutriente, suelo);
        assertFalse(contenido.enSolucion()); // Debe ser falso inicialmente
        contenido.enSolucion = 5;
        assertTrue(contenido.enSolucion()); // Debe ser verdadero después de asignar un valor
    }
}