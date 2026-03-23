package GestionEmpleados;

import java.util.HashMap;
import java.util.Iterator;

import GestionEmpleados.Empleado;
public class ListadoEmpleado {
	private static HashMap<String, Empleado> listaEmpleados = new HashMap<>();
	
	
	public static boolean añadirEmpleado(Empleado empleado){
		boolean esValido = true;
		if (listaEmpleados.putIfAbsent(empleado.getDni(), empleado) != null) {
			esValido = false;
		}
		
		return esValido;
	}
	
	public static void listarTodos() {
		for(Empleado empleado : listaEmpleados.values()) {
			System.out.println(empleado);
		}
	}

	public static Empleado buscarPorDni(String dni) {
		return listaEmpleados.get(dni);
	}
	
	public static boolean modificarHorasExtra(String dni, double horas) {
		boolean esCambiado = false;
		Empleado empleado = buscarPorDni(dni);
		if (empleado != null && horas >= 0) {
			empleado.setHorasExtra(horas);
			esCambiado = true;
		}
		return esCambiado;
	}
	
	public static boolean modificarBonificacion(String dni, double porcentaje) {
		boolean esCambiado = false;
		Empleado empleado = buscarPorDni(dni);
		if (empleado != null && porcentaje >= 0 && porcentaje <= 30) {
			empleado.setPorcentajeBonus(porcentaje);
			esCambiado = true;
		}
		return esCambiado;
	}
	public static boolean eliminarPorDni(String dni) {
		boolean esPosible = false;
		Empleado empleado = buscarPorDni(dni);
		if (empleado != null) {
			listaEmpleados.remove(dni);
			esPosible = true;
		}
		return esPosible;
	}
	
	public static double calcularGastoBonificaciones() {
		double sumaTotal = 0;

		return sumaTotal;
	}
	
	public static void listarEmpleadosAltoDesempenio() {
        for (Empleado empleado : listaEmpleados.values()) {
            if (empleado.empleadoAltamenteBonificado()) {
                System.out.println(empleado);
            }
        }
    }
}
