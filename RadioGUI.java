import javax.swing.*;
import java.awt.*;

public class RadioGUI extends JFrame {

    private Radio radio;
    private JLabel lblEstado;
    private JLabel lblEstacion;

    public RadioGUI(Radio radio) {
        this.radio = radio;

        setTitle("Radio AM / FM");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Info
        JPanel panelInfo = new JPanel(new GridLayout(2, 1));
        lblEstado = new JLabel("Radio apagado", SwingConstants.CENTER);
        lblEstacion = new JLabel("Estación: ---", SwingConstants.CENTER);
        panelInfo.add(lblEstado);
        panelInfo.add(lblEstacion);
        add(panelInfo, BorderLayout.NORTH);

        // Botones
        JPanel panelBotones = new JPanel(new GridLayout(4, 2));

        JButton btnPrender = new JButton("Prender");
        JButton btnApagar = new JButton("Apagar");
        JButton btnAM = new JButton("AM");
        JButton btnFM = new JButton("FM");
        JButton btnAvanzar = new JButton("Avanzar");
        JButton btnGuardar = new JButton("Guardar");
        JButton btnCargar = new JButton("Cargar");

        panelBotones.add(btnPrender);
        panelBotones.add(btnApagar);
        panelBotones.add(btnAM);
        panelBotones.add(btnFM);
        panelBotones.add(btnAvanzar);
        panelBotones.add(btnGuardar);
        panelBotones.add(btnCargar);

        add(panelBotones, BorderLayout.CENTER);

        // Acciones
        btnPrender.addActionListener(e -> {
            radio.prenderRadio();
            lblEstado.setText("Radio encendido");
            actualizarEstacion();
        });

        btnApagar.addActionListener(e -> {
            radio.apagarRadio();
            lblEstado.setText("Radio apagado");
            lblEstacion.setText("Estación: ---");
        });

        btnAM.addActionListener(e -> {
            radio.cambiarAM();
            actualizarEstacion();
        });

        btnFM.addActionListener(e -> {
            radio.cambiarFM();
            actualizarEstacion();
        });

        btnAvanzar.addActionListener(e -> {
            radio.avanzarEstacion();
            actualizarEstacion();
        });

        btnGuardar.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Botón (1-12):");
            if (input != null) {
                radio.guardarEstacion(Integer.parseInt(input));
            }
        });

        btnCargar.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Botón (1-12):");
            if (input != null) {
                radio.cargarEstacion(Integer.parseInt(input));
                actualizarEstacion();
            }
        });

        setVisible(true);
    }

    private void actualizarEstacion() {
        if (radio instanceof RadioImpl) {
            RadioImpl r = (RadioImpl) radio;
            lblEstacion.setText("Estación: " + r.getEstacionActual());
        }
    }
}
