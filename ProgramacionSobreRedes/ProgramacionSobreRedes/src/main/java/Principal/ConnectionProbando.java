package Principal;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ConnectionProbando {

	Connection conn = null;
	PreparedStatement ps = null;

	public ConnectionProbando()
	{

		//  CONEXION CON DB
		try {	
			Class.forName( "com.mysql.cj.jdbc.Driver" );
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		try {
			conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/usuarios" , "root" , "" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//  CONEXION DB
		
		PrintStream consola = new PrintStream( System.out);
		String consulta = "SELECT * from empleado ";
		
		try {
			ps = conn.prepareStatement( consulta );
			
			//ps.setString( 1 , "empleado");
			
			ResultSet rs = ps.executeQuery();
		
			/*
			 * id nombre apellido rol
			 * 5   jkjk     jkjk   1  
			 * 8   kkjkk    iooi   2  <-
			 */
			// id nombre apellido rol
			while( rs.next() )
			{					
				consola.println( rs.getInt("id") );
				consola.println( rs.getString("nombre") );
				consola.println( rs.getString("apellido") );
				consola.println( rs.getInt("rol") );
				
				if( rs.isLast() )
					consola.println( "\n Cantidad de resultados:" + rs.getRow() );
				
			}
			
			
			consulta = "INSERT INTO empleado (id,nombre,apellido,rol) VALUES (? , ? , ? , ?)";
			ps = conn.prepareStatement( consulta );
			ps.setInt(1, 6);
			ps.setString(2, "Pedro");
			ps.setString(3, "Martinez");
			ps.setInt(4, 4);
			
			consola.println( ps.executeUpdate() );
			
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
