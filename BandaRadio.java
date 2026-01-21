public interface BandaRadio {

    void avanzarEstacion();

    void guardarEstacion(int boton);
    void cargarEstacion(int boton);

    double getEstacionActual();
}