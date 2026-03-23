package GestionEmpleados;

public class Empleado {
	private String dni;
	private String nombre;
	private double salarioBase;
	private double porcentajeBonus;
	private static double precioHoraExtra = 0;
	private double horasExtraRealizadas = 0;
	
	public Empleado(String dni, String nombre, double salarioBase, double porcentajeBonus) {
		this.dni = dni;
		this.nombre = nombre;
		this.salarioBase = salarioBase;
		this.porcentajeBonus = porcentajeBonus;

	}
	
	public void setHorasExtra(double horas) {
		this.horasExtraRealizadas = horas;
	}
	
	public void setPorcentajeBonus(double nuevoPorcentaje) {
		this.porcentajeBonus= nuevoPorcentaje;
	}
	
	public String getDni() {
		return dni;
	}
	
	/*
	 * 
	 * 
	 * */
	public double getImporteBonus(){		
		return this.salarioBase * this.porcentajeBonus / 100;
	}
	
	public double getImporteTotalHorasExtra() {
		return this.horasExtraRealizadas * precioHoraExtra;
	}
	
	public double getSalarioTotalBruto() {
		return this.salarioBase + this.getImporteBonus() + this.getImporteTotalHorasExtra(); 
	}
	
	@Override
	public String toString() {
		return this.dni + " - " + this.nombre + "\n" 
				+ "Salario Base: " + this.salarioBase + " | Bonificacion: " + this.getImporteBonus() + "(" + this.porcentajeBonus + ") \n"
				+ "Horas Extra: " + this.horasExtraRealizadas + " | Total Bruto: " + this.getSalarioTotalBruto();
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean sonIguales = false;
		
		if (this == obj) {
			sonIguales = true;
		} else{
			Empleado empleado = (Empleado) obj;
			if (this.dni.equals(empleado.dni)) {
				sonIguales = true;
			}
		} 
			
		
		
		return sonIguales;
	}
	/*
	@Override 
	public int hashCode() {
		return ;
	}
	*/
	public boolean empleadoAltamenteBonificado() {
		return this.porcentajeBonus > 15;
		
	}
}
