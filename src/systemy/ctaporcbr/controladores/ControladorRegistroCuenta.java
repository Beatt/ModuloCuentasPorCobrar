package systemy.ctaporcbr.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import systemy.ctaporcbr.gui.RegistroCuentaGUI;
import systemy.ctaporcbr.moduloprincipal.ModuloCuentasPorCobrar;

public class ControladorRegistroCuenta implements ActionListener{
	
	/** @autor Jessica Niña rata :D ñ_________ñ */
	RegistroCuentaGUI vista;
	
	public ControladorRegistroCuenta(RegistroCuentaGUI vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand() == "Aceptar") {
			
			ModuloCuentasPorCobrar modulo = ModuloCuentasPorCobrar.obtenerModulo();
			modulo.obtenerCredito(Integer.parseInt(vista.getCuadtxIDCliente().getText().toString()), 
					Double.parseDouble(vista.getCuadtxMonto().getText().toString()), 
					vista.getCuadtxConcepto().getText().toString());
			
		}
		else if(e.getActionCommand() == "Salir") {
			vista.dispose();
		}
	}

}//fin de clase ControladorRegistroCuenta
