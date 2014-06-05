package systemy.ctaporcbr.interfaces;

/**
 * 
 * @author SysteMy
 *
 */
public interface IModuloCuentasPorCobrar {
	
	void obtenerCredito(int id_factura, double monto, String concepto);
	
}//Fin interface IModuloCuentasPorCobrar
