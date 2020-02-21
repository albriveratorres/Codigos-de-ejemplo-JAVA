package controlador;

import java.awt.event.*;

import modelo.*;
import vista.*;

public class ControladorCargaMenu extends WindowAdapter {
	
	public ControladorCargaMenu(Marco_Aplicacion2 elmarco) {
		
		this.elmarco = elmarco;
		
		
	}
	
	public void windowOpened(WindowEvent e) {
		
		obj.ejecutaConsultas();
		
		try {
			
			while(obj.rs.next()) { 
				
				elmarco.secciones.addItem(obj.rs.getString(1));
				
			}
			
			while(obj.rs2.next()) {
				
				elmarco.paises.addItem(obj.rs2.getString(1));
			}
			
		}catch(Exception e2) {
		
			System.out.println("NO CONECTA");
			
			e2.printStackTrace();
		}
	}
	
	CargaMenu obj = new CargaMenu();
	
	
	private Marco_Aplicacion2 elmarco;
	

}
