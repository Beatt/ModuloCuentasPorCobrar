package systemy.ctaporcbr.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import systemy.ctaporcbr.controladores.ControladorRegistroCuenta;

import java.io.Serializable;

public class RegistroCuentaGUI extends JFrame {

	private JTextField cuadtxIDCliente, cuadtxMonto, cuadtxConcepto,
			cuadtxNombre;

	private JButton botGuardar, botSalir;

	private final Color COLOR_PANEL = new Color(18, 94, 153);
	private final Color COLOR_CONT = new Color(60, 135, 203);
	private final Color COLOR_LETRA = new Color(255, 255, 255);

	public RegistroCuentaGUI(String CuentasPorCobrar) {
		super(CuentasPorCobrar);

		Dimension dim = this.getToolkit().getScreenSize();
		Rectangle rec = this.getBounds();
		this.setLocation((dim.width - rec.width) / 2,
				((dim.height - rec.height) / 2) - 20);
		setLocationRelativeTo(null);
		setLocation(400, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);
		setSize(700, 450);
		setVisible(true);

		JPanel paneCont = new JPanel();
		paneCont.setLayout(null);
		paneCont.setBackground(COLOR_PANEL);
		paneCont.setBounds(24, 80, 650, 310);

		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon("img/sigecologo.png"));

		JPanel paneLogo = new JPanel();
		paneLogo.setLocation(24, 6);
		paneLogo.setSize(132, 98);
		paneLogo.setBackground(COLOR_CONT);

		paneLogo.add(logo);

		JLabel lblSigeco = new JLabel("SIGECO");
		lblSigeco.setVerticalAlignment(SwingConstants.TOP);
		lblSigeco.setFont(new Font("Consolas", Font.PLAIN, 50));
		lblSigeco.setBounds(156, 29, 276, 55);

		JLabel Titulo = new JLabel("Registro de Cuenta");
		Titulo.setVerticalAlignment(SwingConstants.TOP);
		Titulo.setFont(new Font("Arial", Font.PLAIN, 20));
		Titulo.setBackground(COLOR_LETRA);
		Titulo.setBounds(250, 25, 276, 55);

		JLabel etqIDCliente = new JLabel("ID Cliente");
		etqIDCliente.setVerticalAlignment(SwingConstants.TOP);
		etqIDCliente.setFont(new Font("Arial", Font.PLAIN, 16));
		etqIDCliente.setBounds(58, 85, 180, 50);

		cuadtxIDCliente = new JTextField();
		cuadtxIDCliente.setSize(1, 5);
		cuadtxIDCliente.setBounds(139, 85, 180, 25);
		cuadtxIDCliente.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					getToolkit().beep();
					e.consume();
				}
			}
		});

		JLabel etqNombre = new JLabel("Nombre");
		etqNombre.setVerticalAlignment(SwingConstants.TOP);
		etqNombre.setFont(new Font("Arial", Font.PLAIN, 16));
		etqNombre.setBounds(50, 115, 180, 25);

		cuadtxNombre = new JTextField();
		cuadtxNombre.setSize(1, 5);
		cuadtxNombre.setBounds(139, 115, 180, 25);

		cuadtxNombre.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isDigit(c)) {
					getToolkit().beep();
					e.consume();
				}
			}
		});

		JLabel etqMonto = new JLabel("Monto");
		etqMonto.setVerticalAlignment(SwingConstants.TOP);
		etqMonto.setFont(new Font("Arial", Font.PLAIN, 16));
		etqMonto.setBounds(50, 145, 180, 25);

		cuadtxMonto = new JTextField();
		cuadtxMonto.setSize(1, 5);
		cuadtxMonto.setBounds(139, 145, 180, 25);

		cuadtxMonto.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isLetter(c)) {
					getToolkit().beep();
					e.consume();
				}
			}
		});

		JLabel etqConcepto = new JLabel("Concepto");
		etqConcepto.setVerticalAlignment(SwingConstants.TOP);
		etqConcepto.setFont(new Font("Arial", Font.PLAIN, 16));
		etqConcepto.setBounds(50, 175, 180, 25);

		cuadtxConcepto = new JTextField();
		cuadtxConcepto.setSize(1, 5);
		cuadtxConcepto.setBounds(139, 175, 180, 25);

		botGuardar = new JButton("Aceptar");
		botGuardar.setBounds(100, 245, 180, 50);

		botSalir = new JButton("Salir");
		botSalir.setBounds(300, 245, 180, 50);

		Container cont = getContentPane();
		cont.setBackground(COLOR_CONT);

		cont.add(paneCont);
		cont.add(paneLogo);
		cont.add(lblSigeco);
		paneCont.add(Titulo);
		paneCont.add(etqIDCliente);
		paneCont.add(cuadtxIDCliente);
		paneCont.add(etqMonto);
		paneCont.add(cuadtxMonto);
		paneCont.add(etqConcepto);
		paneCont.add(cuadtxConcepto);
		paneCont.add(etqNombre);
		paneCont.add(cuadtxNombre);
		paneCont.add(botGuardar);
		paneCont.add(botSalir);

		ControladorRegistroCuenta controladorCuenta = new ControladorRegistroCuenta(this);
		botGuardar.addActionListener(controladorCuenta);
		botSalir.addActionListener(controladorCuenta);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public JTextField getCuadtxIDCliente() {
		return cuadtxIDCliente;
	}

	public void setCuadtxIDCliente(JTextField cuadtxIDCliente) {
		this.cuadtxIDCliente = cuadtxIDCliente;
	}

	public JTextField getCuadtxMonto() {
		return cuadtxMonto;
	}

	public void setCuadtxMonto(JTextField cuadtxMonto) {
		this.cuadtxMonto = cuadtxMonto;
	}

	public JTextField getCuadtxConcepto() {
		return cuadtxConcepto;
	}

	public void setCuadtxConcepto(JTextField cuadtxConcepto) {
		this.cuadtxConcepto = cuadtxConcepto;
	}

	public JTextField getCuadtxNombre() {
		return cuadtxNombre;
	}

	public void setCuadtxNombre(JTextField cuadtxNombre) {
		this.cuadtxNombre = cuadtxNombre;
	}

}// Fin class RegistroCuenta