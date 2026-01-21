import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FMRadioTest {

    @Test
    public void testEstacionInicial() {
        FMRadio fm = new FMRadio();
        assertEquals(87.9, fm.getEstacionActual());
    }

    @Test
    public void testAvanzarEstacion() {
        FMRadio fm = new FMRadio();
        fm.avanzarEstacion();
        assertEquals(88.1, fm.getEstacionActual());
    }

    @Test
    public void testRegresarEstacion() {
        FMRadio fm = new FMRadio();
        fm.regresarEstacion();
        assertEquals(107.9, fm.getEstacionActual());
    }

    @Test
    public void testAvanzarMasAllaDelMaximo() {
        FMRadio fm = new FMRadio();
        // Calcular cuántos pasos para llegar a 107.9
        // De 87.9 a 107.9, diferencia 20, pasos de 0.2: 100 pasos
        for (int i = 0; i < 100; i++) {
            fm.avanzarEstacion();
        }
        assertEquals(107.9, fm.getEstacionActual());
        fm.avanzarEstacion();
        assertEquals(87.9, fm.getEstacionActual());
    }

    @Test
    public void testRegresarMenosDelMinimo() {
        FMRadio fm = new FMRadio();
        fm.regresarEstacion();
        assertEquals(107.9, fm.getEstacionActual());
    }

    @Test
    public void testGuardarEstacion() {
        FMRadio fm = new FMRadio();
        fm.avanzarEstacion(); // 88.1
        fm.guardarEstacion(1);
        assertEquals(88.1, fm.getEstacionActual());
    }

    @Test
    public void testCargarEstacion() {
        FMRadio fm = new FMRadio();
        fm.avanzarEstacion(); // 88.1
        fm.guardarEstacion(1);
        fm.avanzarEstacion(); // 88.3
        fm.cargarEstacion(1);
        assertEquals(88.1, fm.getEstacionActual());
    }
}