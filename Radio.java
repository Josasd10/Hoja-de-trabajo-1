public interface Radio {

    void prenderRadio();
    void apagarRadio();

    void avanzarEstacion();
    void regresarEstacion();

    void guardarEstacion(int numeroBoton);
    void cargarEstacion(int numeroBoton);

    void cambiarFM();
    void cambiarAM();
}



