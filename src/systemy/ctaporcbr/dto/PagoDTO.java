package systemy.ctaporcbr.dto;

import java.sql.Timestamp;

/**
 * 
 * @author SysteMy
 *
 */
public class PagoDTO {

	private int idPago;
	private int idFormaDePago;
	private Timestamp fechaDePago;
	private double montoPago;
	
	
	public PagoDTO() {
		
		setIdPago(0);
		setidFormaDePago(0);
		setFechaDePago(null);
		setMontoPago(0.0);
		
	}
	
	public PagoDTO(int idPago, int idFormaDePago, Timestamp fechaDePago, double montoPago) {
		
		setIdPago(idPago);
		setidFormaDePago(idFormaDePago);
		setFechaDePago(fechaDePago);
		setMontoPago(montoPago);		
	}
	
	/*------------------------------------------------
	 * 				GETTERS AND SETTERS  
	 -----------------------------------------------*/
	
	public int getIdPago() {
		return idPago;
	}
	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}
	public int getidFormaDePago() {
		return idFormaDePago;
	}
	public void setidFormaDePago(int idFormaDePago) {
		this.idFormaDePago = idFormaDePago;
	}
	public Timestamp getFechaDePago() {
		return fechaDePago;
	}
	public void setFechaDePago(Timestamp fechaDePago) {
		this.fechaDePago = fechaDePago;
	}
	public double getMontoPago() {
		return montoPago;
	}
	public void setMontoPago(double montoPago) {
		this.montoPago = montoPago;
	}
	
	/*------------------------------------------------
	 * 					OVERRIDE 
	 -----------------------------------------------*/
		
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Id pago: " + idPago);
		sb.append("\nId idFormaDePago: " + idFormaDePago);
		sb.append("\nFecha de pago: " + fechaDePago);
		sb.append("\nMonto de pago: " + montoPago);
		
		return sb.toString();
		
	}//Fin toString
	
	public boolean equals(Object obj) {
		
		if(obj instanceof PagoDTO) {
			
			PagoDTO pagoDTO = (PagoDTO) obj;
			
			return pagoDTO.idPago == this.idPago &&
					pagoDTO.idFormaDePago == this.idFormaDePago &&
					pagoDTO.fechaDePago.equals(this.fechaDePago) &&
					pagoDTO.montoPago == this.montoPago
					? true : false;
			
		} 
		
		return false;
		
	}//Fin equals
	
	public int hashCode() {
		
		return new Integer(idPago).hashCode() + 
				new Integer(idFormaDePago).hashCode() +
				fechaDePago.hashCode() + 
				new Double(montoPago).hashCode();
		
	}//Fin hashCode
	
	/*
	 * Prueba
	 * 
	public static void main(String[] args) {
		
		PagoDTO pagoDTO = new PagoDTO(3, 4, new Date(2002, 3, 4), 300);
		System.out.println("Id de pago: " + pagoDTO.getIdPago());
		pagoDTO.setIdPago(10);
		System.out.println("Id de pago: " + pagoDTO.getIdPago());
		System.out.println("Igual: " + pagoDTO.equals(new PagoDTO(10, 4, new Date(2002, 3, 4), 300)));		
		
	}*/
	
}//Fin class PagoDTO
