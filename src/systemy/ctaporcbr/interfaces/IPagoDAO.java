package systemy.ctaporcbr.interfaces;

import java.util.List;

import systemy.ctaporcbr.dto.PagoDTO;

public interface IPagoDAO {

	public List obtenerPagos();

	public boolean insertar(PagoDTO pago);

	public boolean eliminar(PagoDTO pago);

	public boolean modificar(PagoDTO pago);

}// Fin interface IPagoDAO
