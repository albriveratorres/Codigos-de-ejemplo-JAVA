package MetaDatos;

import java.sql.*;

public class Info_MetaDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mostrarinfo_BBDD();
		mostrarinfo_Tablas();
	}
	
	static void mostrarinfo_BBDD(){
				Connection miConexion = null;
		
		try {
			
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
			
			//--------------obtencion de metadatos-------
			
			DatabaseMetaData datosBBDD = miConexion.getMetaData();
			
			//------------obtener informacion de base de datos-------
			
			System.out.println("Gestor de base de datos: " + datosBBDD.getDatabaseProductName());
			
			System.out.println("Version de base de datos: " + datosBBDD.getDatabaseProductVersion());
			
			System.out.println("Nombre del driver " + datosBBDD.getDriverName());
			
			System.out.println("Version del driver " + datosBBDD.getDriverVersion());
		}catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			
			try {
				miConexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	static void mostrarinfo_Tablas() {
		Connection miConexion = null;
		
		ResultSet miResultset = null;
		
		try {
			
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
			
			//--------------obtencion de metadatos-------
			
			DatabaseMetaData datosBBDD = miConexion.getMetaData();
			
			//--------------lista de tablas--------------
			System.out.println("Lista de tablas:");
			
			miResultset = datosBBDD.getTables(null, null, "P%", null);// los puedes dejar como null y devuelva todas las tablas de la bd
			//getcolumns devuelve los datos de una columna estpecifica
			while(miResultset.next()) {
				
				System.out.println(miResultset.getString("TABLE_NAME"));
				
			}
			
			
			
		}catch(Exception e) {
			
		}finally {
			try {
				miConexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
