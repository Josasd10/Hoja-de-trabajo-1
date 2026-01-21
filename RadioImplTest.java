import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RadioImplTest {

    @Test
    public void testPrenderRadio() {
        RadioImpl radio = new RadioImpl();
        radio.prenderRadio();
        // No hay getter para encendido, así que probar indirectamente
        // Al avanzar, debería cambiar si encendido
        double estacionInicial = radio.getEstacionActual();
        radio.avanzarEstacion();
        assertNotEquals(estacionInicial, radio.getEstacionActual());
    }

    @Test
    public void testApagarRadio() {
        RadioImpl radio = new RadioImpl();
        radio.prenderRadio();
        radio.apagarRadio();
        // Al avanzar, no debería cambiar si apagado
        double estacionInicial = radio.getEstacionActual();
        radio.avanzarEstacion();
        assertEquals(estacionInicial, radio.getEstacionActual());
    }

    @Test
    public void testCambiarAM() {
        RadioImpl radio = new RadioImpl();
        radio.prenderRadio();
        radio.cambiarAM();
        // Estación AM inicial 530
        assertEquals(530.0, radio.getEstacionActual());
    }

    @Test
    public void testCambiarFM() {
        RadioImpl radio = new RadioImpl();
        radio.prenderRadio();
        radio.cambiarFM();
        // Estación FM inicial 87.9
        assertEquals(87.9, radio.getEstacionActual());
    }

    @Test
    public void testAvanzarEstacionAM() {
        RadioImpl radio = new RadioImpl();
        radio.prenderRadio();
        radio.cambiarAM();
        double estacionInicial = radio.getEstacionActual();
        radio.avanzarEstacion();
        assertEquals(estacionInicial + 10, radio.getEstacionActual());
    }

    @Test
    public void testRegresarEstacionAM() {
        RadioImpl radio = new RadioImpl();
        radio.prenderRadio();
        radio.cambiarAM();
        radio.avanzarEstacion(); // 540
        radio.regresarEstacion();
        assertEquals(530.0, radio.getEstacionActual());
    }

    @Test
    public void testAvanzarEstacionFM() {
        RadioImpl radio = new RadioImpl();
        radio.prenderRadio();
        radio.cambiarFM();
        double estacionInicial = radio.getEstacionActual();
        radio.avanzarEstacion();
        assertEquals(estacionInicial + 0.2, radio.getEstacionActual());
    }

    @Test
    public void testRegresarEstacionFM() {
        RadioImpl radio = new RadioImpl();
        radio.prenderRadio();
        radio.cambiarFM();
        radio.avanzarEstacion(); // 88.1
        radio.regresarEstacion();
        assertEquals(87.9, radio.getEstacionActual());
    }

    @Test
    public void testGuardarYCargarEstacion() {
        RadioImpl radio = new RadioImpl();
        radio.prenderRadio();
        radio.cambiarAM();
        radio.avanzarEstacion(); // 540
        radio.guardarEstacion(1);
        radio.avanzarEstacion(); // 550
        radio.cargarEstacion(1);
        assertEquals(540.0, radio.getEstacionActual());
    }

    @Test
    public void testNoOperarApagado() {
        RadioImpl radio = new RadioImpl();
        // Apagado por defecto
        double estacionInicial = radio.getEstacionActual();
        radio.avanzarEstacion();
        assertEquals(estacionInicial, radio.getEstacionActual());
    }
}