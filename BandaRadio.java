public interface BandaRadio {

    void avanzarEstacion();
    void regresarEstacion();

    void guardarEstacion(int boton);
    void cargarEstacion(int boton);

    double getEstacionActual();

    
}
