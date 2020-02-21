package procAlmacenado;

import java.sql.*;

import javax.swing.JOptionPane;

public class ActualizaProductos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int nPrecio = Integer.parseInt(JOptionPane.showInputDialog("Introduce Precio"));
		
		String nArticulo = JOptionPane.showInputDialog("Introduce Nompre Articulo");
		
		try {
			
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
			
			CallableStatement misentencia = miConexion.prepareCall("{call ACTUALIZA_PRODUCTO(?,?)}");//envia parametros
			
			misentencia.setInt(1, nPrecio);
			
			misentencia.setString(2, nArticulo);
			
			misentencia.execute();
			
			System.out.println("listo");
		}catch(Exception e){
			
			
			
		}
		
	}

}
