package systemy.ctaporcbr.gui;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import systemy.ctaporcbr.controladores.ControladorVentanaPrincipal;
import systemy.ctaporcbr.moduloprincipal.ModuloCuentasPorCobrar;

import java.io.Serializable;

public class VentanaPrincipalGUI extends JFrame {
		
	private JButton botRegPago, botRegCuenta, botConCuenta, botModCuenta, botModPago;
	
	private final Color colorPanel = new Color (18,94,153);
	private final Color colorCont = new Color (60,135,203);
	private final Color colorLetra = new Color(255,255,255);
	
	public VentanaPrincipalGUI(String CuentasPorCobrar)
	{
		super(CuentasPorCobrar);
		
		Dimension dim = this.getToolkit().getScreenSize();
        Rectangle rec = this.getBounds();
        this.setLocation((dim.width - rec.width) / 2, ((dim.height - rec.height) / 2) - 20);
		//setMinimumSize(dimVentana);
		setLocationRelativeTo(null);
                setLocation(400, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);
		setSize(700,450);
		setVisible(true);
		
		Container cont = getContentPane();
		cont.setSize(dim.width-100,dim.height-100);
		cont.setBackground(colorCont);
		
		JPanel paneCont = new JPanel();
		paneCont.setLayout(null);
		paneCont.setBackground(colorPanel);
		paneCont.setBounds(24, 80,650, 330);
		
		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon("img/sigecologo.png"));
		logo.setBounds(900, 49, 186, 55);
		
		JPanel paneLogo = new JPanel();
		paneLogo.setLocation(24, 6);
		paneLogo.setSize(132, 98);
		paneLogo.setBackground(colorCont);
		
		paneLogo.add(logo);
		
		JLabel lblSigeco = new JLabel("SIGECO");
		lblSigeco.setVerticalAlignment(SwingConstants.TOP);
		lblSigeco.setFont(new Font("Consolas", Font.PLAIN, 50));
		lblSigeco.setBounds(156, 29, 276, 55);
		
		JLabel Titulo = new JLabel("Seleccione Actividad");
		Titulo.setVerticalAlignment(SwingConstants.TOP);
		Titulo.setFont(new Font("Arial", Font.PLAIN, 20));
		Titulo.setBackground(colorLetra);
		Titulo.setBounds(250, 25, 276, 55);
				
		botRegCuenta = new JButton("Registrar Cuenta");
		botRegCuenta.setBounds(250, 70,180,50);
		
		botRegPago = new JButton("Registrar Pago");
		botRegPago.setBounds(250, 120,180,50);
		
		botConCuenta = new JButton("Consultar Cuenta");
		botConCuenta.setBounds(250, 170,180,50);
		
		botModCuenta = new JButton("Modificar Cuenta");
		botModCuenta.setBounds(250, 220,180,50);
		
		botModPago = new JButton("Modificar Pago");
		botModPago.setBounds(250, 270,180,50);
				
		cont.add(paneCont);
		cont.add(paneLogo);
		cont.add(lblSigeco);
		paneCont.add(Titulo);
		paneCont.add(botRegCuenta);
		paneCont.add(botRegPago);
		paneCont.add(botConCuenta);
		paneCont.add(botModCuenta);
		paneCont.add(botModPago);
		
		
		ControladorVentanaPrincipal controladorPrincipal = new ControladorVentanaPrincipal(this);
		botRegCuenta.addActionListener(controladorPrincipal);
		botRegPago.addActionListener(controladorPrincipal);
		botConCuenta.addActionListener(controladorPrincipal);
		botModCuenta.addActionListener(controladorPrincipal);
		botModPago.addActionListener(controladorPrincipal);
		
	}
	
}//Fin class VentanaPrincipalGUI
