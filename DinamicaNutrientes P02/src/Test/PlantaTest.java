package Test;

import Reglas.Planta;
import Reglas.ParametroNP;
import Reglas.ContenidoNP;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlantaTest {

    @Test
    public void testConstructor() {
        Planta planta = new Planta();
        assertEquals("", planta.nombre);
        assertNull(planta.parametro);
        assertNull(planta.contenido);
    }

    @Test
    public void testSetNombre() {
        Planta planta = new Planta();
        planta.nombre = "Planta de Tomate";
        assertEquals("Planta de Tomate", planta.nombre);
    }

    @Test
    public void testSetParametro() {
        Planta planta = new Planta();
        ParametroNP parametro = new ParametroNP(null, null); // Puedes proporcionar instancias válidas
        planta.parametro = parametro;
        assertSame(parametro, planta.parametro);
    }

    @Test
    public void testSetContenido() {
        Planta planta = new Planta();
        ContenidoNP contenido = new ContenidoNP(null, null); // Puedes proporcionar instancias válidas
        planta.contenido = contenido;
        assertSame(contenido, planta.contenido);
    }
}