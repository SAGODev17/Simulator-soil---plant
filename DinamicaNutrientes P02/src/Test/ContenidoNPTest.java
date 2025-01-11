package Test;
import Reglas.ContenidoNP;
import Reglas.Nutriente;
import Reglas.Planta;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContenidoNPTest {

    @Test
    public void testConstructor() {
        Nutriente nutriente = new Nutriente();
        Planta planta = new Planta();
        ContenidoNP contenido = new ContenidoNP(nutriente, planta);
        assertEquals(nutriente, contenido.nutriente);
        assertEquals(planta, contenido.planta);
        assertEquals(0, contenido.enBiomasa, 0.01); // Usamos 0.01 de margen para valores flotantes
    }

    @Test
    public void testSetEnBiomasa() {
        Nutriente nutriente = new Nutriente();
        Planta planta = new Planta();
        ContenidoNP contenido = new ContenidoNP(nutriente, planta);
        contenido.enBiomasa = 10; // Asignamos un valor
        assertEquals(10, contenido.enBiomasa, 0.01);
    }
}