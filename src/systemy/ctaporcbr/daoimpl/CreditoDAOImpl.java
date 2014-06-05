package systemy.ctaporcbr.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import javax.swing.JOptionPane;

import systemy.ctaporcbr.conexion.ConexionBD;
import systemy.ctaporcbr.dto.CreditoDTO;
import systemy.ctaporcbr.interfaces.ICreditoDAO;

public class CreditoDAOImpl implements ICreditoDAO{
	
	public CreditoDAOImpl() {
	}

	@Override
	public List obtenerCreditos() {
		return null;
	}//Fin obtenerCreditos
	
	/**
	 * <h2>Objetivo</h2> 
	 * <p>Agregar un registro a la tabla ctacbr.Credito_Cta_Cobrar</p>
	 * @author Jiménez M. G. G.
	 * @param credito Contiene información del credito.
	 * @return success Respuesta de la inserción a la tabla.
	 */
	@Override
	public boolean insertar(CreditoDTO credito) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;		
		boolean success = true,
				result;
		
		try {
			
			connection = ConexionBD.getConexion();
			connection.setAutoCommit(false);
			
			preparedStatement = connection.prepareStatement
					(
						"INSERT INTO " + 
							"ctacbr.Credito_Cta_Cobrar(id_factura, " + 
								"monto_credito, concepto, fecha_vencimiento)" +
							"VALUES(?, ?, ?, ?)"
					);
			
			preparedStatement.setInt(1, credito.getidFactura());
			preparedStatement.setDouble(2, credito.getmontoCredito());
			preparedStatement.setString(3, credito.getConcepto());
			preparedStatement.setTimestamp(4, Timestamp.valueOf("2030-12-16 10:10:10.0"));
			
			result = preparedStatement.execute();
			
			if(!result) {
				
				connection.commit();
				
			} else {
				
				connection.rollback();
				success = false;
				
			}
			
			
		} catch(SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error método agregarCredito",
					JOptionPane.ERROR_MESSAGE);
			
		} finally {
			
			try {
				
				if (preparedStatement != null) {					
					preparedStatement.close();
				}
				
			} catch (SQLException sqlEx2) {
				success = false;
			}
		}
		
		return success;
		
	}//Fin agregarCredito

	@Override
	public boolean eliminar(CreditoDTO credito) {
		return false;
		
	}//Fin eliminarCredito

	/**
	 * @autor Jiménez M. G. G.
	 * @param credito Contiene información del credito.
	 * @return success Respuesta de la modificación a la tabla.
	 */
	@Override
	public boolean modificar(CreditoDTO credito) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean success = true;
		int	result;
		
		
		try {
			
			connection = ConexionBD.getConexion();
			connection.setAutoCommit(false);
			
			preparedStatement = connection.prepareStatement
					(
						"UPDATE ctacbr.Credito_Cta_Cobrar " +
							"SET id_factura = ? ," +
							"monto_credito = ? ," +	
							"concepto = ? ," +
							"fecha_vencimiento = ? ," +
							"estado = ? " +
							"WHERE id_credito = ?"
					);
			
			preparedStatement.setInt(1, credito.getidFactura());
			preparedStatement.setDouble(2, credito.getmontoCredito());
			preparedStatement.setString(3, credito.getConcepto());
			preparedStatement.setTimestamp(4, credito.getfechaVencimiento());
			preparedStatement.setBoolean(5, credito.isEstado());
			preparedStatement.setInt(6, credito.getidCredito());
			
			result = preparedStatement.executeUpdate();
			
			if(result == 1) {
				
				connection.commit();				
				
			} else {
				
				connection.rollback();
				success = false;
				
			}
			
		} catch(SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error método modificar pago",
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
		
	}//Fin actualizarCredito
	
	
	public static void main(String[] args) {
		
		
		CreditoDAOImpl credito = new CreditoDAOImpl();
		
		
		// MODIFICAR
		CreditoDTO creditoDTO = new CreditoDTO(1, 5, 2323, "UPDATE", false, Timestamp.valueOf("2035-10-10 14:48:36"));
		credito.modificar(creditoDTO);
		
		
	}
	
}//Fin class CreditoDAOImpl
