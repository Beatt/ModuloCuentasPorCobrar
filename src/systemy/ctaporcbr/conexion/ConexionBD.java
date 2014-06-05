package systemy.ctaporcbr.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.swing.JOptionPane;

public class ConexionBD {

	public static Connection conexion = null;
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String BD = "jdbc:mysql://localhost/ctacbr";
	private final String USUARIO = "beat";
	private final String PASSWORD = "bdjava";
	
	
	private ConexionBD() {
		
		try {
			
			Runtime.getRuntime().addShutdownHook(new CerrarBD());
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(BD, USUARIO, PASSWORD);
			
		} catch(ClassNotFoundException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage(), "No se encontre el driver", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
			
		} catch(SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage(), "No se pudo conectar ", JOptionPane.ERROR_MESSAGE);
			
		}
		
	}
	
	public static Connection getConexion() {
		
		if(conexion == null) {
			new ConexionBD();
		}
		
		return conexion;
		
	}//Fin getConexion
	
	public void cerrarConexion() {
		
		try {
			
			conexion.close();
			
		} catch(SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage(), "No se pudo cerrar la BD",
					JOptionPane.ERROR_MESSAGE);
			System.exit(1);
			
		}
				
	}//Fin cerrarConexion
	
	public static class CerrarBD extends Thread {
		
		public void run() {
			
			try {
				
			} catch(Exception error) {
				
				JOptionPane.showMessageDialog(null, error.getMessage(), "No se pudo conectar a la "
						+ " Base de Datos", JOptionPane.ERROR_MESSAGE);
				
			}	
			
		}//Fin run
		
	}//Fin class CerrarBD
	
	public static void main(String[] args) {
		
		Connection con = ConexionBD.getConexion();
		PreparedStatement preparedStatement;
		
		try {
			
			preparedStatement = con.prepareStatement("INSERT INTO ctacbr.Credito_Cta_Cobrar(id_factura, "
					+ "estado, fecha_inicio, monto_credito,  fecha_vencimiento, concepto)" +
					"VALUES(?, ?, ?, ?, ?, ?)");
			
			preparedStatement.setInt(1, 1);
			preparedStatement.setBoolean(2, true);
			preparedStatement.setTimestamp(3, new Timestamp(2001));
			preparedStatement.setDouble(4, 3222);
			preparedStatement.setTimestamp(5, new Timestamp(2004));
			preparedStatement.setString(6, "CONTADO");
			preparedStatement.execute();
			
			
		} catch(SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage(), "No se pudo conectar a la "
					+ " Base de Datos", JOptionPane.ERROR_MESSAGE);
			
		}
				
	}
	
}//Fin class ConexionBD
