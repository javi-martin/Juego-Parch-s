package es.studium.Parchis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;


public class Controlador implements WindowListener, ActionListener
{
	Modelo modelo = null;	
	Vista vista = null;
	
	public Controlador(Modelo modelo, Vista vista) 
	{
		this.modelo = modelo;		
		this.vista = vista;
		
		// Añadimos el listener a cada opción de submenú del menú Artículos
		vista.nuevaPartida.addActionListener(this);
		vista.mejoresPartidas.addActionListener(this);
		vista.ayuda.addActionListener(this);
		vista.salir.addActionListener(this);
		
		// Añadimos el listener a cada botón
		vista.bntnumeroJugadoresAceptar.addActionListener(this);
		vista.bntnumeroJugadoresCancelar.addActionListener(this);
		vista.bntNombreJugadorAceptar.addActionListener(this);
		vista.bntNombreJugadorCancelar.addActionListener(this);
		vista.btnSalir.addActionListener(this);
		
		// Añadimos el listener a las ventanas		
		vista.addWindowListener(this);
		vista.numeroJugadores.addWindowListener(this);
		vista.nombreJugadores.addWindowListener(this);
		vista.partidas.addWindowListener(this);		
	}
	
	public void windowActivated(WindowEvent arg0) {}	
	public void windowClosed(WindowEvent arg0) {}		
	public void windowClosing(WindowEvent we) 
	{
		if(vista.numeroJugadores.isActive()) 
		{
			vista.numeroJugadores.setVisible(false);
			vista.setVisible(true);
		}
		else if(vista.nombreJugadores.isActive()) 
		{
			vista.nombreJugadores.setVisible(false);
			vista.numeroJugadores.setVisible(true);
		}
		else if(vista.partidas.isActive()) 
		{
			vista.partidas.setVisible(false);		
		}
		else 
		{
			System.exit(0);
		}			
	}	
	public void windowDeactivated(WindowEvent arg0) {}	
	public void windowDeiconified(WindowEvent arg0) {}		
	public void windowIconified(WindowEvent arg0) {	}
	public void windowOpened(WindowEvent arg0) {}
	
	public void actionPerformed(ActionEvent ae) 
	{
		Object a;		
		a = ae.getSource();	
		
		if(a.equals(vista.salir)) 
		{
			System.exit(0);
		}
		else if(a.equals(vista.ayuda)) 
		{
			try
			{
				Runtime.getRuntime().exec("hh.exe Ayuda.chm");
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else if(a.equals(vista.nuevaPartida)) 
		{
			vista.setVisible(false);
			vista.numeroJugadores();			
		}
		else if(a.equals(vista.bntnumeroJugadoresCancelar))
		{
			vista.numeroJugadores.setVisible(false);
			vista.setVisible(true);
		}
		else if(a.equals(vista.bntnumeroJugadoresAceptar)) 
		{
			if(vista.choNumeroJugadores.getSelectedItem().equals("2"))
			{
				//Mostrar Dialog nombreJugadores con 2 jugadores
				vista.nombreJugadores.add(vista.lblnombreJugador1);
				vista.nombreJugadores.add(vista.txtnombreJugador1);
				vista.nombreJugadores.add(vista.lblAzul);
				vista.nombreJugadores.add(vista.lblnombreJugador2);
				vista.nombreJugadores.add(vista.txtnombreJugador2);
				vista.nombreJugadores.add(vista.lblVerde);
				vista.nombreJugadores.add(vista.bntNombreJugadorAceptar);
				vista.nombreJugadores.add(vista.bntNombreJugadorCancelar);
				vista.nombreJugadores.setVisible(true);				
			}
			else if(vista.choNumeroJugadores.getSelectedItem().equals("3")) 
			{
				//Mostrar Dialog nombreJugadores con 3 jugadores
				vista.nombreJugadores.add(vista.lblnombreJugador1);
				vista.nombreJugadores.add(vista.txtnombreJugador1);
				vista.nombreJugadores.add(vista.lblAzul);
				vista.nombreJugadores.add(vista.lblnombreJugador2);
				vista.nombreJugadores.add(vista.txtnombreJugador2);
				vista.nombreJugadores.add(vista.lblVerde);
				vista.nombreJugadores.add(vista.lblnombreJugador3);
				vista.nombreJugadores.add(vista.txtnombreJugador3);
				vista.nombreJugadores.add(vista.lblrojo);
				vista.nombreJugadores.add(vista.bntNombreJugadorAceptar);
				vista.nombreJugadores.add(vista.bntNombreJugadorCancelar);
				vista.nombreJugadores.setVisible(true);				
			}
			else if(vista.choNumeroJugadores.getSelectedItem().equals("4")) 
			{
				//Mostrar Dialog nombreJugadores con 3 jugadores
				vista.nombreJugadores.add(vista.lblnombreJugador1);
				vista.nombreJugadores.add(vista.txtnombreJugador1);
				vista.nombreJugadores.add(vista.lblAzul);
				vista.nombreJugadores.add(vista.lblnombreJugador2);
				vista.nombreJugadores.add(vista.txtnombreJugador2);
				vista.nombreJugadores.add(vista.lblVerde);
				vista.nombreJugadores.add(vista.lblnombreJugador3);
				vista.nombreJugadores.add(vista.txtnombreJugador3);
				vista.nombreJugadores.add(vista.lblrojo);
				vista.nombreJugadores.add(vista.lblnombreJugador4);
				vista.nombreJugadores.add(vista.txtnombreJugador4);
				vista.nombreJugadores.add(vista.lblAmarillo);
				vista.nombreJugadores.add(vista.bntNombreJugadorAceptar);
				vista.nombreJugadores.add(vista.bntNombreJugadorCancelar);
				vista.nombreJugadores.setVisible(true);				
			}			
		}
		else if(a.equals(vista.bntNombreJugadorCancelar)) 
		{
			vista.nombreJugadores.setVisible(false);			
		}
		else if(a.equals(vista.bntNombreJugadorAceptar)) 
		{
			if(vista.choNumeroJugadores.getSelectedItem().equals("2")) 
			{
							
				new Tablero();				
				vista.nombreJugadores.setVisible(false);
				vista.numeroJugadores.setVisible(false);
				
			}
			else if(vista.choNumeroJugadores.getSelectedItem().equals("3"))
			{
				modelo.conexion = modelo.conectar();
				int idJugador1 = modelo.insertar(modelo.conexion, vista.txtnombreJugador1.getText(), "Azul");
				int idJugador2 = modelo.insertar(modelo.conexion, vista.txtnombreJugador2.getText(), "Verde");
				int idJugador3 = modelo.insertar(modelo.conexion, vista.txtnombreJugador3.getText(), "Rojo");
				modelo.desconectar(modelo.conexion);
			}
			else 
			{
				modelo.conexion = modelo.conectar();
				int idJugador1 = modelo.insertar(modelo.conexion, vista.txtnombreJugador1.getText(), "Azul");
				int idJugador2 = modelo.insertar(modelo.conexion, vista.txtnombreJugador2.getText(), "Verde");
				int idJugador3 = modelo.insertar(modelo.conexion, vista.txtnombreJugador3.getText(), "Rojo");
				int idJugador4 = modelo.insertar(modelo.conexion, vista.txtnombreJugador4.getText(), "Amarillo");
				modelo.desconectar(modelo.conexion);
			}
		}
		else if(a.equals(vista.mejoresPartidas)) 
		{
			
			// Conectar con la BD
			modelo.conexion = modelo.conectar();
			vista.listado.setText(modelo.rellenarChoice(modelo.conexion));
			vista.partidas.add(vista.listado);
			modelo.desconectar(modelo.conexion);
			vista.partidas.add(vista.btnSalir);
			vista.partidas.setVisible(true);
		}
		else 
		{
			vista.partidas.setVisible(false);
		}
	}
}
