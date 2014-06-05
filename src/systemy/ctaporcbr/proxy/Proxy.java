package systemy.ctaporcbr.proxy;

import java.util.Scanner;

import systemy.ctaporcbr.gui.LoginGUI;
import systemy.ctaporcbr.interfaces.IModuloCuentasPorCobrar;
import systemy.ctaporcbr.moduloprincipal.ModuloCuentasPorCobrar;


/**
 * 
 * @author SysteMy
 *
 */
public class Proxy implements IModuloCuentasPorCobrar {
	
	private LoginGUI loginGUI;
	
	/** @see ModuloCuentasPorCobrar */
	private ModuloCuentasPorCobrar moduloCuentasPorCobrar;
	
	private boolean logueado;
	
	/**
	 * Objetivo: Permitir autentificar al usuario.
	 * 	
	 */
	private boolean autentificacion() {
		
		loginGUI = new LoginGUI("CUENTAS POR COBRAR");
		
		/*
		// Mensaje en la interfaz grafica
		System.out.println("Cuentas por cobrar...");
		
		// Entrada de la interfaz...
		System.out.println("Ingrese su usuario: ");
		String rspUsuario = scanner.nextLine();
		
		System.out.println("Ingrese su password: ");
		String rspPass = scanner.nextLine();
		
		if((rspUsuario != null && rspPass != null) &&
				(rspUsuario.equals(usuario) && rspPass.equals(password))) {
			
			// Se ha logueado usuario
			logueado = true;
			
			if(moduloCuentasPorCobrar == null) {
				
				System.out.println("Bienvenido " + usuario);
				
				// Obtenemos acceso al modulo de cuentas por cobrar.				
				moduloCuentasPorCobrar = ModuloCuentasPorCobrar.obtenerModulo();
				return true;
			}
			
		}
		
		System.out.println("Usuario " + rspUsuario + " y Password " + password +
				" incorrectos...");*/
		
		
		
		return false;
	}//Fin autentificación
	
	/**
	 * Objetivo: Permite que un cliente obtenga un crédito.
	 */
	@Override
	public void obtenerCredito(int idFactura, double monto, String concepto) {
		
		verificarAutentificacion();
		
		if(logueado) {
			moduloCuentasPorCobrar.obtenerCredito(idFactura, monto, concepto);
		}
		
	}//Fin obtenerCredito
	
	/**
	 * Objetivo: Verificar que el usuario se encuentre autentificado
	 */
	private void verificarAutentificacion() {
		
		if(!logueado) {
			if(moduloCuentasPorCobrar == null) {
				autentificacion();
			}
		}
		
	}//Fin verificarAutentificacion
	
}//Fin class Proxy
