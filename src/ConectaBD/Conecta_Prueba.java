package ConectaBD;

import java.sql.*;

public class Conecta_Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			//1. establecer conexion
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
			
			//2. crear objeto statement
			Statement miStatement = miConexion.createStatement();
			
			//3. EJECUTAR SQL
			ResultSet miResulset = miStatement.executeQuery("SELECT * FROM PRODUCTOS");
			
			//4. recorrer el resulste
			while(miResulset.next()) {
				
				System.out.println(miResulset.getString("NOMBREARTICULO") + " " + miResulset.getString("SECCION") + " " + miResulset.getString("PRECIO"));
				
			}
			
		}catch(Exception e) {
			
			System.out.println("NO CONECTA");
			
			e.printStackTrace();
						
		}
	}

}
