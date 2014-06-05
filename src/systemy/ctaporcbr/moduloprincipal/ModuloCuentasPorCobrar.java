package systemy.ctaporcbr.moduloprincipal;

import systemy.ctaporcbr.daoimpl.CreditoDAOImpl;
import systemy.ctaporcbr.daoimpl.PagoDAOImpl;
import systemy.ctaporcbr.dto.CreditoDTO;
import systemy.ctaporcbr.interfaces.ICreditoDAO;
import systemy.ctaporcbr.interfaces.IModuloCuentasPorCobrar;
import systemy.ctaporcbr.interfaces.IPagoDAO;


/**
 * 
 * @author SysteMy
 * 
 */
public class ModuloCuentasPorCobrar implements IModuloCuentasPorCobrar{
	
	private static ModuloCuentasPorCobrar moduloCuentasPorCobrar = null;	
	
	private ICreditoDAO iCreditoDAO;
	private IPagoDAO iPagoDAO;
	
	private ModuloCuentasPorCobrar() {
		
		iCreditoDAO = new CreditoDAOImpl();
		iPagoDAO = new PagoDAOImpl();
		
		System.out.println("CREO UNA INSTANCIA DE MODULOPORCOBRAR");
	}//Fin ModuloCuentasPorCobrar
	
	/**
	 * 
	 * @return moduloCuentasPorCobrar Instancia del modulo cuentas por cobrar.
	 */
	public static ModuloCuentasPorCobrar obtenerModulo() {
		
		if(moduloCuentasPorCobrar == null) {
			moduloCuentasPorCobrar = new ModuloCuentasPorCobrar();
		}
		
		return moduloCuentasPorCobrar;
		
	}//Fin obtenerModulo
	
	
	/**
	 * Objetivo: Permite obtener un crédito.
	 * 
	 * 
	 */
	@Override
	public void obtenerCredito(int idFactura, double montoCredito, String concepto) {
		
		iCreditoDAO.insertar(new CreditoDTO(idFactura, montoCredito, concepto));
		
	}//fin obtenerCredito
	
}//Fin class ModuloCuentasPorCobrar
