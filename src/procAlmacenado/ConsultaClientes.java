package procAlmacenado;

import java.sql.*;

public class ConsultaClientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
			
			CallableStatement misentencia = miConexion.prepareCall("{call MUESTRA_CLIENTE}");
			
			ResultSet rs = misentencia.executeQuery();
			
			while(rs.next()) {
				
				System.out.println(rs.getString(1) + rs.getString(2) + rs.getString(3));
				
			}
			
			rs.close();
			
		}catch(Exception e){
			
			
			
		}
		
	}

}
