package TA_22.TA_22;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import TA_22.TA_22.Vista;
import TA_22.TA_22.Modelo;
import TA_22.TA_22.conneccionBD;

public class Controlador {

	public static void opciones(Connection conn) {

		int opcion = TA_22.TA_22.Vista.menuPrincipal();

		boolean todoCorrect;

		switch (opcion) {
		case 1:
			// Borramos la tabla sumintra y la creamos otra vez para que este vacio
			todoCorrect = TA_22.TA_22.Modelo.inicializarTabla(conn);

			TA_22.TA_22.Vista.respuestaInstanciarTabla(todoCorrect);

			break;

			//		case 2:
			//
			//			Object[][] select = TA_22.TA_22.Modelo.verTabla(conn);
			//
			//			TA_22.TA_22.Vista.verTabla(select);
			//			
			//			break;

		case 2:

			todoCorrect = TA_22.TA_22.Modelo.crearContenido(conn);

			TA_22.TA_22.Vista.comprobarContenido(todoCorrect);

			break;

		case 3:
			boolean confirmacion = TA_22.TA_22.Vista.confirmacion();

			if (confirmacion) {
				todoCorrect = TA_22.TA_22.Modelo.borrarTabla(conn);
				TA_22.TA_22.Vista.respuestaBorrarTabla(todoCorrect);
			}

			break;

		case 4:

			opcion = TA_22.TA_22.Vista.menuCRUD();

			switch (opcion) {
			case 1:

				String[] informacion = TA_22.TA_22.Vista.pedirInformacion();
				
				todoCorrect = TA_22.TA_22.Modelo.anyadirContenido(informacion, conn);
				
				TA_22.TA_22.Vista.respuestaRegAdd(todoCorrect);
				
				break;

			case 2:
				
				int idPieza = TA_22.TA_22.Vista.pedirIDPieza();
				
				Object[][] selectID = TA_22.TA_22.Modelo.buscarPorID(idPieza, conn);
				
				TA_22.TA_22.Vista.verTabla(selectID);

				break;

			case 3:
				
				Object[][] selectAll = TA_22.TA_22.Modelo.verTabla(conn);
				
				TA_22.TA_22.Vista.verTabla(selectAll);
				
				break;

			case 4:
				
				String[] informacionUpd = TA_22.TA_22.Vista.pedirInfoParaUpdate();
				
				todoCorrect = TA_22.TA_22.Modelo.UpdateContenido(informacionUpd, conn);
				
				TA_22.TA_22.Vista.comprorUpdate(todoCorrect);
				
				break;

			case 5:

				int idPiezaDL = TA_22.TA_22.Vista.pedirIDPieza();
				
				todoCorrect = TA_22.TA_22.Modelo.deletePieza(idPiezaDL, conn);
				
				TA_22.TA_22.Vista.comprorDelete(todoCorrect);
				
				break;

			case 6:

				break;

			
			}

			break;
		}

	}

	public static Connection abrirBD() {
		Connection conn;
		conn = TA_22.TA_22.conneccionBD.conectar();
		if (conn!=null) {
			System.out.println("Connexión abierta correcta");
		}
		else {
			System.out.println("Connexión incorrecta");
		}

		return conn;
	}

	//	public static void cerrarBD() {
	//        Connection conn;
	//        conn = TA_22.TA_22.conneccionBD.cerrar();
	//        if (conn==null) {
	//            System.out.println("Connexión cerrada correcta");
	//        }
	//        else {
	//            System.out.println("Connexión incorrecta");
	//        }
	//    }

}

