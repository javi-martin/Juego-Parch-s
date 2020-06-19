package es.studium.Parchis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Modelo 
{
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/parchis?autoReconnect=true&useSSL=false";
	String login = "root";
	String password = "Studium2019;";
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;	
	
	Connection conexion = null;
	
	public Connection conectar()
	{
		try
		{
			//Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			//Establecer la conexión con la BD Empresa
			connection = DriverManager.getConnection(url, login, password);
		}
		catch (ClassNotFoundException cnfe)
		{
			System.out.println("Error 1-"+cnfe.getMessage());
		}
		catch (SQLException sqle)
		{
			System.out.println("Error 2-"+sqle.getMessage());
		}
		return connection;
	}
	
	public int insertar(Connection con, String nombre, String color) 
	{	
		int resultado = 0;
		
		try 
		{
			// Creamos un STATEMENT para una consulta SQL INSERT.
			Statement statement = con.createStatement();
			String sentencia = "INSERT INTO jugadores (nombreJugador,colorJugador) "
					+ "VALUES ('" + nombre + "','"+color+"')";
			System.out.println(sentencia);
			if((statement.executeUpdate(sentencia))==1)
			{
				String sentenciaConsulta = "SELECT idJugador FROM jugadores ORDER BY 1 DESC LIMIT 1";
				ResultSet rs = statement.executeQuery(sentenciaConsulta);
				if(rs.next())
				{
					resultado = rs.getInt("idJugador");
				}
			}
			else
			{
				resultado = 0;
			}
		}
		catch (SQLException sqle)
		{
			System.out.println("Error 2-"+sqle.getMessage());
		}
		return (resultado);
	}
	public String rellenarChoice(Connection c)
	{
		String resultado = "Nombre-Color Ficha-Puntuación\n--------------------------------------------\n";
		
		try
		{
			int i=1;
			String sentencia = "SELECT * FROM jugadores WHERE ganador=0 ORDER BY 4;";
			//Crear una sentencia
			statement = c.createStatement();
			//Crear un objeto ResultSet para guardar lo obtenido
			//y ejecutar la sentencia SQL
			rs = statement.executeQuery(sentencia);
			while (rs.next())
			{
				resultado = resultado +(i++)+" - "+rs.getString("nombreJugador") +
						" - "+rs.getString("colorJugador")+
						" - "+rs.getInt("puntuacionJugador")+"\n";
			}
		}
		catch (SQLException sqle)
		{
			System.out.println("Error 2-"+sqle.getMessage());
		}
		return (resultado);
	}
	
	public void desconectar(Connection con)
	{
		try
		{
			con.close();				
		}
		catch(Exception e) {}
	}	
}
