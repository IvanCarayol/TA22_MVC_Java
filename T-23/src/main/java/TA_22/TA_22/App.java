package TA_22.TA_22;

import java.sql.Connection;

import TA_22.TA_22.Controlador;

/**
 * Hello world!
 *
 */
public class App {

	public static void main( String[] args ) {
		
		Connection conn = TA_22.TA_22.Controlador.abrirBD();
		
		TA_22.TA_22.Controlador.opciones(conn);

	}


}
