package controlador;

import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.*;
import vista.*;
import java.sql.*;


public class ControladorBotonEjecuta implements ActionListener {
	
	public ControladorBotonEjecuta(Marco_Aplicacion2 elmarco) {
		
		this.elmarco = elmarco;
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String seleccionSeccion = (String)elmarco.secciones.getSelectedItem();
		
		String seleccionPaises = (String)elmarco.paises.getSelectedItem();
		
		resultadoConsulta = obj.filtraBBDD(seleccionSeccion, seleccionPaises);
		
		
		String seccion = null;
		String pais = null;
		
		resultadoConsulta = obj.filtraBBDD(seccion, pais);
		
	}
	 
	private Marco_Aplicacion2 elmarco;
	
	EjecutaConsulta obj = new EjecutaConsulta();
	
	private ResultSet resultadoConsulta;

}
