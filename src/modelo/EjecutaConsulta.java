package modelo;

import java.sql.*;

public class EjecutaConsulta {
	
	public EjecutaConsulta() {
		
		miconexion = new Conexion();
		
	}
	
	public ResultSet filtraBBDD(String seccion, String pais) {
		
		Connection conecta = miconexion.dameConexion();
		
		rs = null;
		try {
			if(!seccion.equals("Todos") && pais.equals("Todos")) {
			
				enviaConsultaSeccion = conecta.prepareStatement(consultaSeccion);
				
				enviaConsultaSeccion.setString(1, seccion);
				
				rs = enviaConsultaSeccion.executeQuery();
				
				
			
			
			}else if(seccion.equals("Todos") && !pais.equals("Todos")) {
			
		
					
			}else{
			
			}
			
		
		}catch(Exception e){
		
		
		}
		
		return rs;
	}
	
	//private String pruebas;
	private Conexion miconexion;
	
	private ResultSet rs;
	
	private PreparedStatement enviaConsultaSeccion;
	
	private final String consultaSeccion = "SELECT NOMBREARTICULO, SECCION, PAISDEORIGEN FROM PRODUCTOS WHERE SECCION = ?";
	
}
