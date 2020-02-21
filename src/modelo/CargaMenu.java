package modelo;

import java.sql.*;




public class CargaMenu {
	
	public CargaMenu() {
		
		miConexion = new Conexion();
		
	}
	
	public String ejecutaConsultas() {
		
		Productos miProducto = null;
		
		Connection accesoBBDD = miConexion.dameConexion();
		
		try {
			
			Statement secciones  = accesoBBDD.createStatement();
			
			Statement paises  = accesoBBDD.createStatement();
			
			rs = secciones.executeQuery("SELECT DISTINCTROW SECCION FROM PRODUCTOS");
			
			rs2 = paises.executeQuery("SELECT DISTINCTROW PAISDEORIGEN FROM PRODUCTOS");
			
			//while(rs.next()) {
				
				miProducto = new Productos();
				
				miProducto.setSeccion(rs.getString(1));
				
				miProducto.setpOrigen(rs.getString(1));
				
				//return miProducto.getSeccion();
			//}
			
			rs.close();
			
			rs2.close();
			
			accesoBBDD.close();
			
		}catch(Exception e){
			
			
		}
		return miProducto.getSeccion();
		
	}
	
	public Conexion miConexion;
	
	public ResultSet rs;
	
	public ResultSet rs2;
}
