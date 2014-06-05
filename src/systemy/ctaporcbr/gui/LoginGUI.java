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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import systemy.ctaporcbr.controladores.ControladorLogin;
import systemy.ctaporcbr.moduloprincipal.ModuloCuentasPorCobrar;

import java.io.Serializable;

public class LoginGUI extends JFrame {
	
	private JPasswordField cuadtxPassword;
	private JTextField cuadtxUsuario;

	private JButton botGuardar, botSalir;
	
	private final String USUARIO = "Cuentas";
	private final String PASSWORD = "Cuentas";
	
	private final Color COLORPANEL = new Color (18,94,153);
	private final Color COLORCONT = new Color (60,135,203);
	private final Color COLORLETRA = new Color(255,255,255);
	
	/** @see ModuloCuentasPorCobrar */
	private ModuloCuentasPorCobrar moduloCuentasPorCobrar;
	
	public LoginGUI(String CuentasPorCobrar)
	{
		super("Acceso");

		this.setLocationRelativeTo(null);
                setLocation(400, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);
		setSize(700,450);
		setVisible(true);
				
		JPanel paneCont = new JPanel();
		paneCont.setLayout(null);
		paneCont.setBackground(COLORPANEL);
		paneCont.setBounds(24, 80,650, 310);
		
		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon("img/sigecologo.png"));
		
		JPanel paneLogo = new JPanel();
		paneLogo.setLocation(24, 6);
		paneLogo.setSize(132, 98);
		paneLogo.setBackground(COLORCONT);
		
		paneLogo.add(logo);
		
		JLabel lblSigeco = new JLabel("SIGECO");
		lblSigeco.setVerticalAlignment(SwingConstants.TOP);
		lblSigeco.setFont(new Font("Consolas", Font.PLAIN, 35));
		lblSigeco.setBounds(156, 29, 276, 55);
		
		JLabel Titulo = new JLabel("Inreso al Modulo");
		Titulo.setVerticalAlignment(SwingConstants.TOP);
		Titulo.setFont(new Font("Arial", Font.PLAIN, 20));
		Titulo.setBackground(COLORLETRA);
		Titulo.setBounds(250, 25, 276, 55);
				
		JLabel etqUsuario = new JLabel ("Usuario");
		etqUsuario.setVerticalAlignment(SwingConstants.TOP);
		etqUsuario.setFont(new Font("Arial", Font.PLAIN, 16));
		etqUsuario.setBounds(58, 95, 180,50);
		
		cuadtxUsuario = new JTextField();
		cuadtxUsuario.setSize(1, 5);
		cuadtxUsuario.setBounds(139, 85, 180,50);
		
		JLabel etqPassword = new JLabel ("Password");
		etqPassword.setVerticalAlignment(SwingConstants.TOP);
		etqPassword.setFont(new Font("Arial", Font.PLAIN, 16));
		etqPassword.setBounds(50, 155, 180,50);
		
		cuadtxPassword = new JPasswordField();
		cuadtxPassword.setSize(1, 5);
		cuadtxPassword.setBounds(139, 145, 180,50);
				
		setBotGuardar(new JButton("Aceptar"));
		getBotGuardar().setBounds(100, 245,180,50);
		
		setBotSalir(new JButton("Salir"));
		getBotSalir().setBounds(300, 245,180,50);
		
		Container cont = getContentPane();
		cont.setBackground(COLORCONT);
		
		cont.add(paneCont);
		cont.add(paneLogo);
		cont.add(lblSigeco);
		paneCont.add(Titulo);
		paneCont.add(etqUsuario);
		paneCont.add(cuadtxUsuario);
		paneCont.add(etqPassword);
		paneCont.add(cuadtxPassword);
		paneCont.add(getBotGuardar());
		paneCont.add(getBotSalir());
		
		ControladorLogin controlador = new ControladorLogin(this);
		botGuardar.addActionListener(controlador);
		botSalir.addActionListener(controlador);
			
		this.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
	}
	
	/*------------------------------------------------
	 * 				GETTERS AND SETTERS  
	 -----------------------------------------------*/
	
	public JPasswordField getCuadtxPassword() {
		return cuadtxPassword;
	}

	public void setCuadtxPassword(JPasswordField cuadtxPassword) {
		this.cuadtxPassword = cuadtxPassword;
	}

	public JTextField getCuadtxUsuario() {
		return cuadtxUsuario;
	}

	public void setCuadtxUsuario(JTextField cuadtxUsuario) {
		this.cuadtxUsuario = cuadtxUsuario;
	}

	public JButton getBotGuardar() {
		return botGuardar;
	}

	public void setBotGuardar(JButton botGuardar) {
		this.botGuardar = botGuardar;
	}

	public JButton getBotSalir() {
		return botSalir;
	}

	public void setBotSalir(JButton botSalir) {
		this.botSalir = botSalir;
	}

	public String getUSUARIO() {
		return USUARIO;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public ModuloCuentasPorCobrar getModuloCuentasPorCobrar() {
		return moduloCuentasPorCobrar;
	}

	public void setModuloCuentasPorCobrar(ModuloCuentasPorCobrar moduloCuentasPorCobrar) {
		this.moduloCuentasPorCobrar = moduloCuentasPorCobrar;
	}
	
}//Fin class LoginGUI
