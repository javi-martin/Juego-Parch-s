package es.studium.Parchis;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.TextField;

public class Vista extends Frame
{
	private static final long serialVersionUID = 1L;

	// Declarar la Barra de Menú

	MenuBar barraMenu = new MenuBar();

	// Declarar las opciones de la Barra de Menú

	Menu parchis = new Menu("PARCHIS");
	
	// Declarar las opciones del submenú de PARCHIS

	MenuItem nuevaPartida = new MenuItem("Nueva Partida");
	MenuItem mejoresPartidas = new MenuItem("Mejores Partidas");
	MenuItem ayuda = new MenuItem("Ayuda");
	MenuItem salir = new MenuItem("Salir");
	
	// Creamos la ventana de diálogo Número de Jugadores
	Dialog numeroJugadores = new Dialog(this, "", true);
	Label lblnumeroJugadores = new Label("Número de Jugadores:");
	Choice choNumeroJugadores = new Choice();
	//TextField txtnumeroJugadores = new TextField(5);
	Button bntnumeroJugadoresAceptar = new Button("Aceptar");
	Button bntnumeroJugadoresCancelar = new Button("Cancelar");
	
	// Creamos la ventana de diálogo Nombre de Jugadores
	Dialog nombreJugadores = new Dialog(this, "Nombres Jugadores", true);
	Label lblnombreJugador1 = new Label("Nombre Jugador 1:");
	TextField txtnombreJugador1 = new TextField(20);
	Label lblAzul = new Label("Color Azul    ");
	Label lblnombreJugador2 = new Label("Nombre Jugador 2:");
	TextField txtnombreJugador2 = new TextField(20);
	Label lblVerde = new Label("Color Verde   ");
	Label lblnombreJugador3 = new Label("Nombre Jugador 3:");
	TextField txtnombreJugador3 = new TextField(20);
	Label lblrojo = new Label("Color Rojo    ");
	Label lblnombreJugador4 = new Label("Nombre Jugador 4:");
	TextField txtnombreJugador4 = new TextField(20);
	Label lblAmarillo = new Label("Color Amarillo");
	Button bntNombreJugadorAceptar = new Button("Aceptar");
	Button bntNombreJugadorCancelar = new Button("Cancelar");
	
	// Creamos el cuadro de diálogo Mejores partidas
	Dialog partidas = new Dialog(this,"Mejores Partidas", true);	
	TextArea listado = new TextArea(13,40);
	Button btnSalir = new Button("Volver");		
	
	public Vista() 
	{
		setLayout(new FlowLayout());	
		setTitle("Menú Pincipal");
	
		//Establecemos la barra de menú como tal
	
		setMenuBar(barraMenu);
	
		//Añadimos al menú Artículo las opciones de submenú, con separador entre ellas
		
		parchis.add(nuevaPartida);
		parchis.addSeparator();
		parchis.add(mejoresPartidas);
		parchis.addSeparator();
		parchis.add(ayuda);
		parchis.addSeparator();
		parchis.add(salir);
		
		barraMenu.add(parchis);
		
		setSize(350,200);
		setLocationRelativeTo(null);
		setVisible(true);
		
		nombreJugadores.setLayout(new FlowLayout());	
		nombreJugadores.setSize(420,200);
		nombreJugadores.setLocationRelativeTo(null);
		
		partidas.setLayout(new FlowLayout());	
		partidas.setSize(350,300);
		partidas.setLocationRelativeTo(null);
	}
	
	public void numeroJugadores()
	{
		numeroJugadores.setLayout(new FlowLayout());
		numeroJugadores.setTitle("Número Jugadores");		            
		numeroJugadores.add(lblnumeroJugadores);
		//numeroJugadores.add(txtnumeroJugadores);
		//txtnumeroJugadores.setText("2");
		numeroJugadores.add(choNumeroJugadores);
		choNumeroJugadores.add("2");
		choNumeroJugadores.add("3");
		choNumeroJugadores.add("4");
		numeroJugadores.add(bntnumeroJugadoresAceptar);
		numeroJugadores.add(bntnumeroJugadoresCancelar);
		numeroJugadores.setSize(250,120);
		numeroJugadores.setLocationRelativeTo(null);
		numeroJugadores.setVisible(true);
	}
	
	
	
}
