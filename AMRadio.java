public class AMRadio implements BandaRadio {

    private double estacionActual;
    private double[] botones;

    public AMRadio() {
        estacionActual = 530;
        botones = new double[12];
    }

    @Override
    public void avanzarEstacion() {
        estacionActual += 10;
        if (estacionActual > 1610) {
            estacionActual = 530;
        }
    }
  
    

    @Override
    public void regresarEstacion() {
        estacionActual -= 10;
        if (estacionActual < 530) {
            estacionActual = 1610;
        }
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
