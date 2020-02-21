package modelo;

import java.sql.*;

public class Conexion {
	Connection miConexion = null;
	
	public Conexion() {
		
		
	}
	
	public Connection dameConexion() {
		try{
			//1. establecer conexion
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
			
		}catch(Exception e) {
			
			System.out.println("NO CONECTA1");
			
			e.printStackTrace();
			
		}
		return miConexion;
	}
	
	
	
}
