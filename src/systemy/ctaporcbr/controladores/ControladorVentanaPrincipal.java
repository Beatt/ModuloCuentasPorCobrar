package systemy.ctaporcbr.controladores;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import systemy.ctaporcbr.gui.*;

/**
 * 
 * @author SystemMe.
 *
 */
public class ControladorVentanaPrincipal implements ActionListener {
	
	private VentanaPrincipalGUI vistap;
	
	public ControladorVentanaPrincipal(VentanaPrincipalGUI vistap){
		this.vistap = vistap;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand() == "Registrar Cuenta") {
			
			new RegistroCuentaGUI("Registrar cuenta");
			
		}
		if(e.getActionCommand() == "Registrar Pago") {
			
			//RegistroPago regCuenta = new RegistroPago();
			
		}
		if(e.getActionCommand() == "Consultar Cuenta") {
			
			//Con regCuenta = new RegistroCuenta();
			
		}
	}

}//Fin class ControladorVentanaPrincipal
