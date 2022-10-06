package TA_22.TA_22;

import java.util.Scanner;

public class Vista {

	static Scanner teclado = new Scanner(System.in);

	public static int menuPrincipal() {

		System.out.println("Menu:\r\n" + 
				" 1. Instanciar tabla\r\n" +
				" 2. Insertar paquete datos\r\n" + 
				" 3. Borrar tabla\r\n" + 
				" 4. CRUD\r\n" + 
				" 5. Salir");

		int opcion = teclado.nextInt();
		return opcion;
	}

	public static int menuCRUD() {
		System.out.println("Menu CRUD:\r\n" + 
				" 1. Añadir registro\r\n" + 
				" 2. Consultar por ID\r\n" + 
				" 3. Listar registros\r\n" + 
				" 4. Modificar registro\r\n" + 
				" 5. Borrar registro\r\n" + 
				" 6. Salir");

		int opcion = teclado.nextInt();
		return opcion;
	}
	
	public static boolean confirmacion() {
		System.out.println("La tabla suministra existe?(S/N)");
		char letra = teclado.next().charAt(0);
		
		if (letra == 'S') {
			return true;
		} else {
			return false;
		}
		
	}

	public static void respuestaInstanciarTabla(boolean todoCorrecto) {

		if (todoCorrecto) {
			System.out.println("Tabla instanciada correctamente.");
		} else {
			System.out.println("Ha ocurrido un error. Mire que la base de datos ya este creada.");
		}

	}


	public static void verTabla(Object[][] informacion) {

		for (int i = 0; i < informacion.length; i++) {
			for (int j = 0; j < informacion[i].length; j++) {
				System.out.print("\t"+informacion[i][j]+" ");
			}
			System.out.println();
		}

	}

	
	public static void comprobarContenido(boolean todoCorrecto) {

		if (todoCorrecto) {
			System.out.println("Contenido creado correctamente.");
		} else {
			System.out.println("Ha ocurrido un error. Puede que no tengas los productos creados.");
		}

	}
	

	public static void respuestaBorrarTabla(boolean todoCorrecto) {

		if (todoCorrecto) {
			System.out.println("Tabla borrada correctamente.");
		} else {
			System.out.println("Ha ocurrido un error.");
		}

	}
	
	public static String[] pedirInformacion() {

		String[] informacion = new String[3];
		
		System.out.println("Inserte CodigoPieza. Ej: 4");
		informacion[0] = teclado.next();
		
		System.out.println("Inserte idProveedor. Ej: 0011");
		informacion[1] = teclado.next();
		
		System.out.println("Inserte Precio. Ej: 1");
		informacion[2] = teclado.next();
		
		return informacion;
		
	}
	
	public static void respuestaRegAdd(boolean todoCorrecto) {

		if (todoCorrecto) {
			System.out.println("Registro insertado correctamente.");
		} else {
			System.out.println("Ha ocurrido un error.");
		}

	}
	
	public static int pedirIDPieza() {

		System.out.println("Inserte CodigoPieza.");
		int informacion = teclado.nextInt();
		return informacion;
	}
	
	public static String[] pedirInfoParaUpdate() {

		String[] informacion = new String[3];
		
		System.out.println("Inserte CodigoPieza que quieras editar.");
		informacion[0] = teclado.next();
		
		System.out.println("Inserte nuevo idProveedor. Ej: 0011");
		informacion[1] = teclado.next();
		
		System.out.println("Inserte nuevo Precio. Ej: 1");
		informacion[2] = teclado.next();
		
		return informacion;
	}
	
	public static void comprorUpdate(boolean todoCorrecto) {

		if (todoCorrecto) {
			System.out.println("Cambiado correctamente.");
		} else {
			System.out.println("Ha ocurrido un error.");
		}

	}
	
	public static void comprorDelete(boolean todoCorrecto) {

		if (todoCorrecto) {
			System.out.println("Borrado correctamente.");
		} else {
			System.out.println("Ha ocurrido un error.");
		}

	}


}
