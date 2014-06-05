package systemy.ctaporcbr.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import systemy.ctaporcbr.conexion.ConexionBD;
import systemy.ctaporcbr.dto.PagoDTO;
import systemy.ctaporcbr.interfaces.IPagoDAO;

/**
 * @author SysteMe
 *
 */
public class PagoDAOImpl implements IPagoDAO {
	
	
	public PagoDAOImpl() {
		
	}
	
	@Override
	public List obtenerPagos() {
		return null;
	}//Fin obtenerPagos
	
	/**
	 * @autor Jiménez M. G. G.
	 * @param PagoDTO Contiene información del pago correspondiente
	 * 	a un crédito.
	 * @return success Respuesta de la inserción a la tabla.
	 */
	@Override
	public boolean insertar(PagoDTO pago) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean result;
		boolean success = true;
		
		try {
			
			connection = ConexionBD.getConexion();
			connection.setAutoCommit(false);
			
			preparedStatement = connection.prepareStatement
					(
						"INSERT INTO " + 
							"ctacbr.Pago_Cta_Cobrar(id_forma_de_pago, forma_de_pago, monto_pago)" + 
							"VALUES(?, ?, ?)"
					
					);
			
			preparedStatement.setInt(1, pago.getIdPago());
			preparedStatement.setInt(2, pago.getidFormaDePago());
			preparedStatement.setDouble(3, pago.getMontoPago());
			result = preparedStatement.execute();
			
			if(!result) {
				
				connection.commit();
				
				
			} else {
				
				connection.rollback();
				success = false;
			}
			
		} catch(SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error método insertar PagoDAOImpl",
					JOptionPane.ERROR_MESSAGE);
			
		} finally {
			
			try {
				
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				
			} catch(SQLException e2) {
				success = false;
			}
		}
		
		return success;
		
	}//Fin agregarPago

	@Override
	public boolean eliminar(PagoDTO pago) {
		return false;
	}//Fin eliminarPago

	@Override
	public boolean modificar(PagoDTO pago) {
		return false;
	}//Fin actualizarPago
	
	/*public static void main(String[] args) {
		PagoDAOImpl pagoDAO = new PagoDAOImpl();
		pagoDAO.insertar(new PagoDTO());
	}*/

}//Fin class PagoDAOImpl
