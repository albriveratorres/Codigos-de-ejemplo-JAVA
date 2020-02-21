package ConectaBD;

import java.sql.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;


public class ConsultaPreparada {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//Crear conexion
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
			
			//prepara consulta
			PreparedStatement miSentencia = miConexion.prepareStatement("SELECT NOMBREARTICULO, SECCION, PAISDEORIGEN FROM PRODUCTOS WHERE SECCION = ? AND PAISDEORIGEN = ?");
			
			//ESTABLECER LOS PARAMETROSde consulkta
			miSentencia.setString(1, "deporte");
			
			miSentencia.setString(2, "USA");
			
			//ejecutar y recorrer consulta
			ResultSet rs = miSentencia.executeQuery();
			
			while(rs.next()) {
				
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
				
			}
			
			rs.close();
			
			//reutilizacion de consulta
			System.out.println("segunda consulta");
			
			System.out.println(" ");
			
			miSentencia.setString(1, "ceramica");
			
			miSentencia.setString(2, "china");
			
			rs = miSentencia.executeQuery();
			
			while(rs.next()) {
				
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
				
			}
			
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
