package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import dto.DTOfactory;
import dto.empleadoDTO;
import dto.generalDTO;

public class EmpleadoDAO {
	// Muy parecido a hacer CRUD pero para un solo DTO (osea tabla)

	// agregar
	public void addEmpleado(empleadoDTO empleado) {
		PreparedStatement ps = null;
		Connection conn = null;

		try {

			StringBuilder sql = new StringBuilder();

			sql.append("INSERT INTO empleado").append("(nombre, apellido, rol)").append(" VALUES ");
			sql.append("(");
			sql.append(empleado.getNombre()).append(", ");
			sql.append(empleado.getApellido()).append(", ");
			sql.append(empleado.getRol()).append(");  ");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios", "root", "");
			ps = conn.prepareStatement(sql.toString());

			ps.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
			}

		}

	}

	/*
	 * metodo para agregar muchos pero reutilizando el metodo de agregar 1 public
	 * void addEmpleado(LinkedList<empleadoDTO> lista) { StringBuilder sql = new
	 * StringBuilder();
	 * 
	 * for (empleadoDTO r : lista) { this.addEmpleado(r); } }
	 */

	// agregar muchos
	public void addEmpleado(LinkedList<empleadoDTO> lista) {
		PreparedStatement ps = null;
		Connection conn = null;

		try {

			StringBuilder sql = new StringBuilder();
			for (empleadoDTO r : lista) {
				sql.append("INSERT INTO empleado").append("(nombre, apellido, rol)").append(" VALUES ");
				sql.append("(");
				sql.append(r.getNombre()).append(", ");
				sql.append(r.getApellido()).append(", ");
				sql.append(r.getRol()).append(");  ");
			}

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios", "root", "");
			ps = conn.prepareStatement(sql.toString());

			ps.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
			}

		}

	}

	// borrar uno
	public void borrar(empleadoDTO aBorrar) {
		PreparedStatement ps = null;
		Connection conn = null;

		try {
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM empleado ").append(" WHERE ").append(" id=? ");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios", "root", "");
			ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, aBorrar.getId() );
			
			ps.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
			}

		}
	}

	// borrar varios
	public void borrar(LinkedList<empleadoDTO> aBorrar) {
		PreparedStatement ps = null;
		Connection conn = null;

		try {

			String consulta = "DELETE FROM empleado WHERE ";
			for (int i = 0; i < aBorrar.size(); i++) {
				consulta.concat(" id = ? ");
				if (i < aBorrar.size() - 1)
					consulta.concat(", ");
			}

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios", "root", "");
			ps = conn.prepareStatement(consulta);

			int i = 1;
			for (empleadoDTO r : aBorrar) {
				ps.setInt(i++, r.getId());
			}

			ps.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
			}

		}
	}

	// actualizar
	public void update( empleadoDTO registro) {
        PreparedStatement ps = null;
        Connection con = null;
        
        try {
            String consulta = "UPDATE {?empleado} SET nombre=? , dni=? , fecha=? WHERE id=?";
            
            con = ConexionesFactory.getInstance().getConection();
            ps = con.prepareStatement(consulta); 
            
            ps.setString(1, registro.getNombre() );
            ps.setString(2, registro.getDni());
            ps.setDate(3, registro.getFecha());
            ps.setInt(4, registro.getId());
            
            ps.executeUpdate();  
        } catch (SQLException ex) {
            Logger.getLogger(clienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(clienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }     
	}
	
	// obtener todo
	public LinkedList<empleadoDTO> getAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		LinkedList<empleadoDTO> aux = new LinkedList<>();

		String sql = "SELECT * FROM empleado";

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios", "root", "");
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				aux.add(new empleadoDTO(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"),
						rs.getInt("rol")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cerrarConexiones(rs, ps, conn);
		}

		return aux;
	}

	// obtener uno
	public empleadoDTO getEmpleado(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM empleado WHERE id=?";

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios", "root", "");
			ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			rs = ps.executeQuery();

			while (rs.next()) {
				return (empleadoDTO) DTOfactory.getInstance().getDTO("empleado", rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cerrarConexiones(rs, ps, conn);
		}
		return null;
	}

	private void cerrarConexiones(ResultSet rs, PreparedStatement ps, Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
