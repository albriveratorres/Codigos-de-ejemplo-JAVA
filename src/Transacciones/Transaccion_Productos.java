package Transacciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Transaccion_Productos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection miConexion = null;
		
		try{					
				
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
			
			miConexion.setAutoCommit(false);
			
			Statement miStatement =miConexion.createStatement();
			
		    String instruccionSql_1="DELETE FROM PRODUCTOS WHERE PAISDEORIGEN = 'ITALIA'";
		        
		    String instruccionSql_2="DELETE FROM PRODUCTOS WHERE PRECIO>300";//hay que modificarel campo PRECIO en la base de datos por un valor numerico
					    
		    String instruccionSql_3="UPDATE PRODUCTOS SET PRECIO = PRECIO * 1.15";
		    
		    boolean ejecutar = ejecutar_transaccion();
		    
		    if (ejecutar) {
		    	
		    	miStatement.executeUpdate(instruccionSql_1);
		    
		    	miStatement.executeUpdate(instruccionSql_2);
		    
		    	miStatement.executeUpdate(instruccionSql_3);
		    	
		    }else {
		    	System.out.println("No se realizo cambio en BD");
		    }
		    
		   miConexion.commit();
		    				    
		   System.out.println("Datos INSERTADOS correctamente");
				
		}catch(Exception e){
				
			System.out.println("ERROR EN LA INSERCIÓN DE DATOS!!");
			
			try {
				miConexion.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("Algo salio mal");
			}
			
			e.printStackTrace();	
			System.out.println("Parametros o conexion incorecta");
				
			}
	}

	private static boolean ejecutar_transaccion() {
		// TODO Auto-generated method stub
		String ejecucion = JOptionPane.showInputDialog("Ejecutamos transaccion??");
		
		if((ejecucion.equals("si"))) return true;
		
		else return false;
	}

}
