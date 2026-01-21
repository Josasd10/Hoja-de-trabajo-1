import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AMRadioTest {

    @Test
    public void testEstacionInicial() {
        AMRadio am = new AMRadio();
        assertEquals(530.0, am.getEstacionActual());
    }

    @Test
    public void testAvanzarEstacion() {
        AMRadio am = new AMRadio();
        am.avanzarEstacion();
        assertEquals(540.0, am.getEstacionActual());
    }

    @Test
    public void testRegresarEstacion() {
        AMRadio am = new AMRadio();
        am.regresarEstacion();
        assertEquals(1610.0, am.getEstacionActual());
    }

    @Test
    public void testAvanzarMasAllaDelMaximo() {
        AMRadio am = new AMRadio();
        // Establecer en 1610
        for (int i = 0; i < 108; i++) { // 530 + 10*108 = 1610
            am.avanzarEstacion();
        }
        assertEquals(1610.0, am.getEstacionActual());
        am.avanzarEstacion();
        assertEquals(530.0, am.getEstacionActual());
    }

    @Test
    public void testRegresarMenosDelMinimo() {
        AMRadio am = new AMRadio();
        am.regresarEstacion();
        assertEquals(1610.0, am.getEstacionActual());
    }

    @Test
    public void testGuardarEstacion() {
        AMRadio am = new AMRadio();
        am.avanzarEstacion(); // 540
        am.guardarEstacion(1);
        assertEquals(540.0, am.getEstacionActual());
    }

    @Test
    public void testCargarEstacion() {
        AMRadio am = new AMRadio();
        am.avanzarEstacion(); // 540
        am.guardarEstacion(1);
        am.avanzarEstacion(); // 550
        am.cargarEstacion(1);
        assertEquals(540.0, am.getEstacionActual());
    }
}