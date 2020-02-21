package ConectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ModificaBD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			//1. establecer conexion
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
			
			//2. crear objeto statement
			Statement miStatement = miConexion.createStatement();
			
			//inserta producto
			//String instruccionSQL = " INSERT INTO PRODUCTOS (NOMBREARTICULO, SECCION, PRECIO) VALUES ( 'PANTALONPRUEBA','CONFECCION' ,'499.00')";
			
			//actualiza producto
			//String instruccionSQL = "UPDATE PRODUCTOS SET PRECIO=PRECIO*2 WHERE NOMBREARTICULO = 'PANTALONPRUEBA'";
			
			//BORRAR REGISTRO
			String instruccionSQL = " DELETE FROM PRODUCTOS WHERE NOMBREARTICULO = 'PANTALONPRUEBA'";
			
			miStatement.execute(instruccionSQL);
			
			System.out.println("Datos instertados correctamente");
			
		}catch(Exception e) {
			
			System.out.println("NO CONECTA");
			
			e.printStackTrace();
						
		}
	}

}
