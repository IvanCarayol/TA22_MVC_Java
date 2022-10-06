package TA_22.TA_22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class conneccionBD {

	/**
	 * Funcion para abrir la conexion a la base de datos
	 * @return
	 */
	public static Connection conectar() {

		String bd = "t14_ej8_piezas_proveedores"; 
		String login = "root"; 
		String password = "1234"; 
		String url = "jdbc:mysql://localhost:3306/";

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url+bd, login, password);

		}catch(SQLException ex) {
			System.err.println(ex);
		}
		return conn;
	}


	// Funcion para cerrar la conexion de base de datos
	public static Connection cerrar(Connection conn) {
		if (conn!=null) {
			try {
				conn.close();

			}catch(SQLException ex) {
				System.out.println(ex);
			}
		}
		return conn;
	}

}