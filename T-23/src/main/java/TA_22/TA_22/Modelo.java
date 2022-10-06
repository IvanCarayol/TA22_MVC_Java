package TA_22.TA_22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Modelo {

	public static boolean inicializarTabla(Connection conn) {

		Statement st;
		try {
			st = conn.createStatement(); // Permite comandos SQL
			
			st.executeUpdate("DROP TABLE IF EXISTS suministra");
			st.executeUpdate("CREATE TABLE IF NOT EXISTS suministra (\r\n"
					+ "    CodigoPieza INT,\r\n"
					+ "    idProveedor CHAR(4),\r\n"
					+ "    Precio INT,\r\n"
					+ "    PRIMARY KEY(CodigoPieza,idProveedor),\r\n"
					+ "    FOREIGN KEY (CodigoPieza) REFERENCES Piezas(Codigo),\r\n"
					+ "    FOREIGN KEY (idProveedor) REFERENCES Proveedores(id)\r\n"
					+ ");");
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public static Object[][] verTabla(Connection conn) {

		int registros = 0;

		//obtenemos la cantidad de registros existentes en la tabla y se almacena en la variable "registros"
		//para formar la matriz de datos
		try{
			PreparedStatement pstm=conn.prepareStatement("SELECT count(*) as total FROM suministra");
			ResultSet res = pstm.executeQuery();
			res.next();
			registros = res.getInt("total");
			res.close();
		}
		catch (SQLException e) {
			System.err.println( e.getMessage() );
		}
		//se crea una matriz con tantas filas y columnas que necesite
		Object[][] data = new String[registros][3];
		try {
			//realizamos la consulta sql y llenamos los datos en la matriz "Object[][] data"
			PreparedStatement pstm=conn.prepareStatement("SELECT * FROM suministra");
			ResultSet res = pstm.executeQuery();
			int i=0;
			while (res.next()) {
				data[i][0] = res.getString("CodigoPieza");
				data[i][1] = res.getString("idProveedor");
				data[i][2] = res.getString("Precio");
				i++;
			}
			res.close();
		} catch(SQLException e) {
			System.err.println( e.getMessage() );
		}
		return data;
	}

	public static boolean borrarTabla(Connection conn) {

		Statement st;
		try {
			st = conn.createStatement(); // Permite comandos SQL
			st.executeUpdate("DROP TABLE suministra");

			st.close();

			return true;

		} catch (SQLException e) {
			return false;
		}
	}

	public static boolean crearContenido(Connection conn) {


		try {
			Statement st = conn.createStatement();// Permite comandos SQL
			st.executeUpdate("INSERT INTO suministra (CodigoPieza, idProveedor, Precio) VALUES ROW (4, 0011, 1), ROW (1, 0012, 15), ROW (3, 0013, 43), ROW (7, 0014, 51);");
			
			st.close();

			return true;

		} catch (SQLException e) {
			return false;
		}
	}
	
	public static boolean anyadirContenido(String[] informacion, Connection conn) {


		try {
			Statement st = conn.createStatement();// Permite comandos SQL
			st.executeUpdate("INSERT INTO suministra (CodigoPieza, idProveedor, Precio) VALUES (" + informacion[0] +"," + informacion[1] + ", " + informacion[2] +  " );");
			
			st.close();

			return true;

		} catch (SQLException e) {
			return false;
		}
	}
	
	public static Object[][] buscarPorID(int ID, Connection conn) {

		int registros = 0;

		//obtenemos la cantidad de registros existentes en la tabla y se almacena en la variable "registros"
		//para formar la matriz de datos
		try{
			PreparedStatement pstm=conn.prepareStatement("SELECT count(*) as total FROM suministra WHERE CodigoPieza =" + ID);
			ResultSet res = pstm.executeQuery();
			res.next();
			registros = res.getInt("total");
			res.close();
		}
		catch (SQLException e) {
			System.err.println( e.getMessage() );
		}
		//se crea una matriz con tantas filas y columnas que necesite
		Object[][] data = new String[registros][3];
		try {
			//realizamos la consulta sql y llenamos los datos en la matriz "Object[][] data"
			PreparedStatement pstm=conn.prepareStatement("SELECT * FROM suministra WHERE CodigoPieza = " + ID);
			ResultSet res = pstm.executeQuery();
			int i=0;
			while (res.next()) {
				data[i][0] = res.getString("CodigoPieza");
				data[i][1] = res.getString("idProveedor");
				data[i][2] = res.getString("Precio");
				i++;
			}
			res.close();
		} catch(SQLException e) {
			System.err.println( e.getMessage() );
		}
		return data;
	}
	
	
	public static boolean UpdateContenido(String[] informacion, Connection conn) {


		try {
			Statement st = conn.createStatement();// Permite comandos SQL
			st.executeUpdate("UPDATE suministra SET idProveedor = " + informacion[1] +", idProveedor = " + informacion[2] + " WHERE CodigoPieza = " + informacion[0] +  ";");
			
			st.close();

			return true;

		} catch (SQLException e) {
			return false;
		}
	}
	
	public static boolean deletePieza(int ID, Connection conn) {

        //se ejecuta la consulta
        try {
            PreparedStatement pstm=conn.prepareStatement("DELETE FROM suministra WHERE  CodigoPieza = " + ID);
            pstm.execute();
            pstm.close();
            return true;
        } catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        return false;
    }
	

}
