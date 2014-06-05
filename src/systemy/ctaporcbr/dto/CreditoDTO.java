package systemy.ctaporcbr.dto;

import java.sql.Timestamp;

/**
 * 
 * @author SysteMy
 *
 */
public class CreditoDTO {
	
	private int idCredito;
	private int idFactura;
	private boolean estado;
	private Timestamp fechaInicio;
	private double montoCredito;
	private Timestamp fechaVencimiento;
	private String concepto;
	
	public CreditoDTO() {
		
		setidCredito(0);
		setidFactura(0);
		setEstado(false);
		setfechaInicio(null);
		setmontoCredito(0.0);
		setfechaVencimiento(null);
		setConcepto(null);
		
	}//Fin CreditoDTO
	
	public CreditoDTO(int idFactura, double montoCredito, String concepto) {
		
		this.idFactura = idFactura;
		this.montoCredito = montoCredito;
		this.concepto = concepto;			
		
		
	}//Fin CreditoDTO
	
	public CreditoDTO(int idCredito, int idFactura, double montoCredito, 
			String concepto, boolean estado, Timestamp fechaVencimiento) {
		
		this.idCredito = idCredito;
		this.idFactura = idFactura;
		this.montoCredito = montoCredito;
		this.concepto = concepto;			
		this.estado = estado;
		this.fechaVencimiento = fechaVencimiento;
		
	}//Fin CreditoDTO
	
	
	public CreditoDTO(int idCredito, int idFactura, double montoCredito, String concepto,
			boolean estado, Timestamp fechaInicio, Timestamp fechaVencimiento) {
		
		this.montoCredito = montoCredito;
		this.idCredito = idCredito;
		this.concepto = concepto;
		this.idFactura = idFactura;
		this.estado = estado;
		this.fechaInicio = fechaInicio;
		this.fechaVencimiento = fechaVencimiento;
		
	}//Fin CreditoDTO
	
	
	/*------------------------------------------------
	 * 				GETTERS AND SETTERS  
	 -----------------------------------------------*/
	
	public int getidCredito() {
		return idCredito;
	}

	public void setidCredito(int idCredito) {
		this.idCredito = idCredito;
	}

	public int getidFactura() {
		return idFactura;
	}

	public void setidFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Timestamp getfechaInicio() {
		return fechaInicio;
	}

	public void setfechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public double getmontoCredito() {
		return montoCredito;
	}

	public void setmontoCredito(double montoCredito) {
		this.montoCredito = montoCredito;
	}

	public Timestamp getfechaVencimiento() {
		return fechaVencimiento;
	}

	public void setfechaVencimiento(Timestamp fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	
	/*------------------------------------------------
	 * 					OVERRIDE 
	 -----------------------------------------------*/
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Id Crédito: " + idCredito);
		sb.append("\nId Factura: " + idFactura);
		sb.append("\nEstado: " + estado);
		sb.append("\nFecha inicio: " + fechaInicio);
		sb.append("\nMonto del crédito: " + montoCredito);
		sb.append("\nFecha vencimiento: " + fechaVencimiento);
		sb.append("\nConcepto: " + concepto);
		
		return sb.toString();
		
	}//Fin toString
	
	public boolean equals(Object obj) {
		
		if(obj instanceof CreditoDTO) {
			
			CreditoDTO creditoDTO = (CreditoDTO) obj;
			
			return creditoDTO.idFactura == this.idFactura &&
					creditoDTO.idCredito == this.idCredito &&
					creditoDTO.estado == this.estado &&
					creditoDTO.fechaInicio.equals(this.fechaInicio) &&
					creditoDTO.fechaVencimiento.equals(this.fechaVencimiento) &&
					creditoDTO.montoCredito == this.montoCredito &&
					creditoDTO.concepto.equals(this.concepto) 
					? true : false;
			
		} 
		
		return false;
		
	}//Fin equals
	
	public int hashCode() {
		
		return new Integer(idCredito).hashCode() + new Integer(idFactura).hashCode() +
				new Boolean(estado).hashCode() + fechaInicio.hashCode() +
				fechaVencimiento.hashCode() + new Double(montoCredito).hashCode() +
				concepto.hashCode();
		
	}//Fin hashCode
	
	/*
	 * Prueba...
	 *
	public static void main(String[] args) {
		CreditoDTO credito = new CreditoDTO(1, 2, 32321, "RH");
		System.out.println(credito);
		System.out.println("ES IGUAL " + credito.equals(new CreditoDTO(1, 2, 32321, "RH")));
		
	}*/
	
}//Fin class CreditoDOA
