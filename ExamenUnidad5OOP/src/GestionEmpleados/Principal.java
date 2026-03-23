package GestionEmpleados;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int opcionJugador;
		do {
			System.out.println("=================================================");
			System.out.println("= BIENVENIDO AL SISTEMA DE GESTION DE EMPLEADOS =");
			System.out.println("=================================================");
			System.out.println("= 1. Añadir empleado 							= ");
			System.out.println("= 2. Listar empleados 							= ");
			System.out.println("= 3. Buscar empleado por DNI					= ");
			System.out.println("= 4. Modificar horas extra						= ");
			System.out.println("= 5. Modificar precio hora extra				= ");
			System.out.println("= 6. Eliminar empleado 							= ");
			System.out.println("= 7. Ver estadisticas 							= ");
			System.out.println("= 8. Salir										= ");
			System.out.println("=================================================");
			System.out.print("Elija la opcion deseada: ");
			opcionJugador = entrada.nextInt();
			entrada.nextLine();
			
			Empleado empleado;
			String dni;
			String nombre;
			double salarioBase;
			double porcentajeBonus;
			double horasExtra;
			
			switch (opcionJugador) {
				case 1: 
					System.out.println("Introduzca los siguientes datos: ");
					System.out.println("DNI:");
					dni = entrada.nextLine();
					System.out.println("Nombre:");
					nombre = entrada.nextLine();
					System.out.println("Salario Base:");
					salarioBase= entrada.nextDouble();
					System.out.println("Porcentaje de Bonificacion:");
					porcentajeBonus = entrada.nextDouble();
					empleado = new Empleado(dni, nombre, salarioBase, porcentajeBonus)
					if (ListadoEmpleado.añadirEmpleado(empleado)) {
						System.out.println("Empleado añadido correctamente");
					} else {
						System.out.println("ERROR: Empleado ya existente");
						
					}
					break;
					
				case 2: 
					ListadoEmpleado.listarTodos();
					break;	
					
				case 3: 
					System.out.println("Introduzca el DNI del empleado a buscar: ");
					dni = entrada.nextLine();
					empleado = ListadoEmpleado.buscarPorDni(dni);
					if (empleado != null) {
						System.out.println(empleado);
					}else {
						System.out.println("ERROR: Empleado no encontrado");
					}
					break;
					
				case 4: 
					System.out.println("Introduzca el DNI del empleado a buscar: ");
					dni = entrada.nextLine();
					System.out.println("Introduzca el nuevo valor de horas extras: ");
					horasExtra = entrada.nextDouble();
					empleado = ListadoEmpleado.buscarPorDni(dni);
					if (empleado != null) {
						ListadoEmpleado.modificarHorasExtra(dni, horasExtra);
						System.out.println("Modificado correctamente");

					}else {
						System.out.println("ERROR: Empleado no encontrado");
					}
					break;
					
				case 5: 
					System.out.println("Introduzca el DNI del empleado a buscar: ");
					dni = entrada.nextLine();
					System.out.println("Introduzca el nuevo porcentaje de bonificacion: ");
					porcentajeBonus = entrada.nextDouble();
					empleado = ListadoEmpleado.buscarPorDni(dni);
					if (empleado != null) {
						System.out.println("Modificado correctamente");

					}else {
						System.out.println("ERROR: Empleado no encontrado");
					}
					break;
					
					break;
				default:
					System.out.println("La opcion debe de ser una de las señaladas");;
			}
		} while (opcionJugador != 8);
		
		entrada.close();
	}
}
