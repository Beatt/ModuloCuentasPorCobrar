package systemy.ctaporcbr.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import systemy.ctaporcbr.gui.LoginGUI;
import systemy.ctaporcbr.gui.VentanaPrincipalGUI;
import systemy.ctaporcbr.moduloprincipal.ModuloCuentasPorCobrar;

public class ControladorLogin implements ActionListener {

	private LoginGUI vista;
	
	public ControladorLogin(LoginGUI vista) {
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand() == "Aceptar") {
			
			 if(vista.getCuadtxUsuario().getText().trim().length()==0) {
			       JOptionPane.showMessageDialog(null, "El campo Usuario esta vacio", "Error", JOptionPane.ERROR_MESSAGE);
			 }
			 else if(vista.getCuadtxPassword().getText().trim().length()==0) {
			       JOptionPane.showMessageDialog(null, "El campo Password esta vacio", "Error", JOptionPane.ERROR_MESSAGE);
			 }
			 else if(vista.getCuadtxUsuario().getText().equals(vista.getUSUARIO()) && vista.getCuadtxPassword().getText().equals(vista.getPASSWORD())) {
			       JOptionPane.showMessageDialog(null, "Acceso Correcto", "Confirmacion", JOptionPane.PLAIN_MESSAGE);
			       vista.dispose();
			       			     
			       new VentanaPrincipalGUI("Cuentas Por Cobrar");
			 }
			 else
			 {
				  JOptionPane.showMessageDialog(null, "Password o Usuario Invalido", "Error", JOptionPane.ERROR_MESSAGE);
				  vista.getCuadtxPassword().setText("");
				  vista.getCuadtxUsuario().setText("");
			 }  
			
		}
			
	}

}//Fin class ControladorLogin
