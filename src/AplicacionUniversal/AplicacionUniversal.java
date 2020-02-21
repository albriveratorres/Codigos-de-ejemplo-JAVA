package AplicacionUniversal;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import modelo.Conexion;

import java.sql.*;
import java.util.ArrayList;




public class AplicacionUniversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoBBDD mimarco=new MarcoBBDD();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}

}

class MarcoBBDD extends JFrame{

	public MarcoBBDD(){
		
		setBounds(300,200,700,700);
		
		LaminaBBDD milamina=new LaminaBBDD();
		
		add(milamina);
		
	}	
	
}

class LaminaBBDD extends JPanel{
	
	public LaminaBBDD(){
		
		setLayout(new BorderLayout());
		
		
		
		comboTablas=new JComboBox();
		
		areaInformacion=new JTextArea();
		
		add(areaInformacion,BorderLayout.CENTER);	
		
		conectarBBDD();
		
		obtenerTablas();		
		
		comboTablas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String nombreTabla = (String)comboTablas.getSelectedItem();
				
				mostrarInfoTabla(nombreTabla);
			}
			
		});
		
		add(comboTablas, BorderLayout.NORTH);
		

		
		
		
		}
	
	public void conectarBBDD() {
		
		miConexion = null;
		
		String datos[] = new String[3];
		
		
		
		try {
			
			entrada = new FileReader("C:/Users/Dell/Desktop/datos_config.txt");
			
		}catch(IOException e) {
			
			JOptionPane.showMessageDialog(this, "No se encuentra el archivo de la conexion");
			
			JFileChooser chooser = new JFileChooser();
			
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "Archivos de texto", "txt");
		    
		    chooser.setFileFilter(filter);
		    
		    int returnVal = chooser.showOpenDialog(this);
		    
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		    	
		    	try {
					entrada = new FileReader(chooser.getSelectedFile().getAbsolutePath());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    
		    	/*System.out.println("You chose to open this file: " +  
		    			chooser.getSelectedFile().getAbsolutePath());*/
		    }
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		try {
			
		
			
			
			BufferedReader miBuffer = new BufferedReader(entrada);
			
			for( int i = 0; i < 2; i++) {
				
				try {
					datos[i] = miBuffer.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			miConexion = DriverManager.getConnection(datos[0],datos[1],datos[2]);
			
			entrada.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		
}

	public void obtenerTablas() {
		
		ResultSet miResultset = null;
		
		try {
			
			DatabaseMetaData datosBBDD = miConexion.getMetaData();
			
			miResultset = datosBBDD.getTables(null, null, null, null);
			
			while(miResultset.next()) {
				
				comboTablas.addItem(miResultset.getString("TABLE_NAME"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void mostrarInfoTabla(String tabla) {
		
		ArrayList<String> campos = new ArrayList<String>();
		
		String consulta = "SELECT * FROM " + tabla;
		
		try {
			
			areaInformacion.setText("");
			
			Statement miStatement = miConexion.createStatement();
			
			ResultSet miResultset = miStatement.executeQuery(consulta);
			
			ResultSetMetaData rsBBDD =  miResultset.getMetaData();
			
			for(int i = 1; i<= rsBBDD.getColumnCount(); i++) {
				
				campos.add(rsBBDD.getColumnLabel(i));
				
			}
			
			while(miResultset.next()) {
				
				for (String nombrecampo : campos) {
					areaInformacion.append(miResultset.getString(nombrecampo) + " ");
				}
				
				areaInformacion.append("\n");
				
			}
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	

	
	private JComboBox comboTablas;

	private JTextArea areaInformacion;
	
	private Connection miConexion;
	
	private FileReader entrada;
	
	
}


		
