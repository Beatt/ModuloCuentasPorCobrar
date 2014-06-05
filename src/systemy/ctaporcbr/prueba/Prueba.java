package systemy.ctaporcbr.prueba;

import systemy.ctaporcbr.interfaces.IModuloCuentasPorCobrar;
import systemy.ctaporcbr.proxy.Proxy;

public class Prueba {
	public static void main(String[] args) {
		IModuloCuentasPorCobrar modulo = new Proxy();
		modulo.obtenerCredito(3, 4002.3, "OTRO");
	}
}
