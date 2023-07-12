package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import dto.empleadoDTO;

public class EmpleadoDAO {
	// Muy parecido a hacer CRUD pero para un solo DTO (osea tabla)
	
	//agregar
	public void addEmpleado(empleadoDTO empleado)
	{
		
	}
	
	//agregar muchos
	public void addEmpleado( LinkedList<empleadoDTO> lista )
	{
		this.addEmpleado( lista.get(0) );
	}
	
	//borrar
	
	//actualizar
	
	public LinkedList<empleadoDTO> getAll()
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		LinkedList<empleadoDTO> aux = new LinkedList<>();
		
		String sql = "SELECT * FROM empleado";
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios" , "root" , "" );
			ps = conn.prepareStatement( sql );
			
			rs = ps.executeQuery();
			
			while( rs.next() )
			{
				aux.add( new empleadoDTO(
							rs.getInt("id"),
							rs.getString("nombre"),
							rs.getString("apellido"),
							rs.getInt("rol")
							)
				 );
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cerrarConexiones(rs , ps, conn);
		}
		
		return aux;		
	}
	
	public empleadoDTO getEmpleado(int id)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM empleado WHERE id=?";
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios" , "root" , "" );
			ps = conn.prepareStatement( sql );
			
			ps.setInt( 1 , id );
			
			rs = ps.executeQuery();
			
			while( rs.next() )
			{
				return new empleadoDTO(
								rs.getInt("id"),
								rs.getString("nombre"),
								rs.getString("apellido"),
								rs.getInt("rol")
							);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cerrarConexiones(rs , ps, conn);
		}
		
		return new empleadoDTO(0, null, null, 0);
	}
	
	private void cerrarConexiones(ResultSet rs, PreparedStatement ps, Connection conn)
	{
		try
		{
			if( rs!= null )    rs.close();	
			if( ps != null )   ps.close();			
			if( conn != null ) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
}
