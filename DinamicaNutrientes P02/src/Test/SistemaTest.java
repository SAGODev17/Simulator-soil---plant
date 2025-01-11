package Test;

import Reglas.Sistema;
import Reglas.Planta;
import Reglas.Suelo;
import Reglas.ParametroNP;
import Reglas.ParametroNS;
import Reglas.ContenidoNP;
import Reglas.ContenidoNS;
import Reglas.Nutriente;
import org.junit.Test;
import static org.junit.Assert.*;

public class SistemaTest {

    @Test
    public void testConstructor() {
        Planta planta = new Planta();
        Suelo suelo = new Suelo();
        Sistema sistema = new Sistema(planta, suelo);
        assertSame(planta, sistema.planta);
        assertSame(suelo, sistema.suelo);
    }

    @Test
    public void testCantidadAbsorcion() {
        Planta planta = new Planta();
        Suelo suelo = new Suelo();
        ParametroNP parametroNP = new ParametroNP(new Nutriente(), planta);
        ParametroNS parametroNS = new ParametroNS(new Nutriente(), suelo);
        ContenidoNP contenidoNP = new ContenidoNP(new Nutriente(), planta);
        ContenidoNS contenidoNS = new ContenidoNS(new Nutriente(), suelo);
        planta.parametro = parametroNP;
        suelo.parametro = parametroNS;
        planta.contenido = contenidoNP;
        suelo.contenido = contenidoNS;
        Sistema sistema = new Sistema(planta, suelo);
        float cantidadAbsorcion = sistema.cantidadAbsorcion();
        assertEquals(0, cantidadAbsorcion, 0.01); 
    }

    @Test
    public void testCantidadPrecipitacion() {
        Planta planta = new Planta();
        Suelo suelo = new Suelo();
        ParametroNP parametroNP = new ParametroNP(new Nutriente(), planta);
        ParametroNS parametroNS = new ParametroNS(new Nutriente(), suelo);
        ContenidoNP contenidoNP = new ContenidoNP(new Nutriente(), planta);
        ContenidoNS contenidoNS = new ContenidoNS(new Nutriente(), suelo);
        planta.parametro = parametroNP;
        suelo.parametro = parametroNS;
        planta.contenido = contenidoNP;
        suelo.contenido = contenidoNS;

        Sistema sistema = new Sistema(planta, suelo);
        float cantidadPrecipitacion = sistema.cantidadPrecipitacion();
        assertEquals(0, cantidadPrecipitacion, 0.01); // Debe ser 0 inicialmente
    }

    @Test
    public void testAbsorcion() {
        Planta planta = new Planta();
        Suelo suelo = new Suelo();
        ParametroNP parametroNP = new ParametroNP(new Nutriente(), planta);
        ParametroNS parametroNS = new ParametroNS(new Nutriente(), suelo);
        ContenidoNP contenidoNP = new ContenidoNP(new Nutriente(), planta);
        ContenidoNS contenidoNS = new ContenidoNS(new Nutriente(), suelo);
        planta.parametro = parametroNP;
        suelo.parametro = parametroNS;
        planta.contenido = contenidoNP;
        suelo.contenido = contenidoNS;

        Sistema sistema = new Sistema(planta, suelo);
        sistema.absorcion();
        assertEquals(0, suelo.contenido.enSolucion, 0.01);
        assertEquals(0, planta.contenido.enBiomasa, 0.01);
    }

    @Test
    public void testPrecipitacion() {
        Planta planta = new Planta();
        Suelo suelo = new Suelo();
        ParametroNP parametroNP = new ParametroNP(new Nutriente(), planta);
        ParametroNS parametroNS = new ParametroNS(new Nutriente(), suelo);
        ContenidoNP contenidoNP = new ContenidoNP(new Nutriente(), planta);
        ContenidoNS contenidoNS = new ContenidoNS(new Nutriente(), suelo);
        planta.parametro = parametroNP;
        suelo.parametro = parametroNS;
        planta.contenido = contenidoNP;
        suelo.contenido = contenidoNS;

        Sistema sistema = new Sistema(planta, suelo);
        sistema.precipitacion();
        assertEquals(0, suelo.contenido.enSolucion, 0.01);
        assertEquals(0, suelo.contenido.precipitado, 0.01);
    }

    @Test
    public void testPaso() {
        Planta planta = new Planta();
        Suelo suelo = new Suelo();
        ParametroNP parametroNP = new ParametroNP(new Nutriente(), planta);
        ParametroNS parametroNS = new ParametroNS(new Nutriente(), suelo);
        ContenidoNP contenidoNP = new ContenidoNP(new Nutriente(), planta);
        ContenidoNS contenidoNS = new ContenidoNS(new Nutriente(), suelo);
        planta.parametro = parametroNP;
        suelo.parametro = parametroNS;
        planta.contenido = contenidoNP;
        suelo.contenido = contenidoNS;
    }
}