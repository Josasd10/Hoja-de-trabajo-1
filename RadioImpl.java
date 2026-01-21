public class RadioImpl implements Radio {

    private boolean encendido;

    private BandaRadio am;
    private BandaRadio fm;
    private BandaRadio bandaActual;

    public RadioImpl() {
        encendido = false;
        am = new AMRadio();
        fm = new FMRadio();
        bandaActual = am;
    }

    @Override
    public void prenderRadio() {
        encendido = true;
    }

    @Override
    public void apagarRadio() {
        encendido = false;
    }

    @Override
    public void avanzarEstacion() {
        if (encendido) {
            bandaActual.avanzarEstacion();
        }
    }

    @Override
    public void regresarEstacion() {
        if (encendido) {
            bandaActual.regresarEstacion();
        }
    }

    @Override
    public void guardarEstacion(int numeroBoton) {
        if (encendido) {
            bandaActual.guardarEstacion(numeroBoton);
        }
    }

    @Override
    public void cargarEstacion(int numeroBoton) {
        if (encendido) {
            bandaActual.cargarEstacion(numeroBoton);
        }
    }

    @Override
    public void cambiarFM() {
        bandaActual = fm;
    }

    @Override
    public void cambiarAM() {
        bandaActual = am;
    }

    // Método auxiliar para la GUI
    public double getEstacionActual() {
        return bandaActual.getEstacionActual();
    }
}
