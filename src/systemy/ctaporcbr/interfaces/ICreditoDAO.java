package systemy.ctaporcbr.interfaces;

import java.util.List;

import systemy.ctaporcbr.dto.CreditoDTO;

public interface ICreditoDAO {

	public List obtenerCreditos();

	public boolean insertar(CreditoDTO credito);

	public boolean eliminar(CreditoDTO credito);

	public boolean modificar(CreditoDTO credito);

}// Fin interface CreditoDAO
