package Test;

import Reglas.Suelo;
import org.junit.Test;
import static org.junit.Assert.*;

public class SueloTest {

    @Test
    public void testConstructor() {
        Suelo suelo = new Suelo();
        assertEquals("", suelo.nombre);
        assertNull(suelo.parametro);
        assertNull(suelo.contenido);
    }
}