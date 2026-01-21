public class FMRadio implements BandaRadio {

    private double estacionActual;
    private double[] botones;

    public FMRadio() {
        estacionActual = 87.9;
        botones = new double[12];
    }

    @Override
    public void avanzarEstacion() {
        estacionActual += 0.2;
        if (estacionActual > 107.9) {
            estacionActual = 87.9;
        }
        // Redondear a un decimal para evitar demasiados números
        estacionActual = Math.round(estacionActual * 10.0) / 10.0;
    }

    @Override
    public void guardarEstacion(int boton) {
        botones[boton - 1] = estacionActual;
    }

    @Override
    public void cargarEstacion(int boton) {
        estacionActual = botones[boton - 1];
    }

    @Override
    public double getEstacionActual() {
        return estacionActual;
    }
}
