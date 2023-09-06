package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import dto.DTOfactory;
import dto.empleadoDTO;
import dto.tabla;

/**
 * 
 * @author Gonza
 *
 *         Esta Class tiene por funcionalidad contener los Metodos de accedo a
 *         datos (CRUD/ABM/AMBL) a una tabla especifica EMPLEADOS representada
 *         por los objetos de la clase {@link dto.empleadoDTO} siguiendo el
 *         patron de diseño DAO.
 * 
 *         Al final de estos metodos clasicos se generan los especificos para
 *         consultas con parametros punales.
 */
public class EmpleadoDAO implements GeneralDAO<empleadoDTO>{

	/**
	 * El LOG lo usaremos para mostrar los errores por pantalla en vez del
	 * {@link System#err}.
	 * 
	 */
	final Logger LOG = Logger.getLogger(empleadoDTO.class.getName());

	/**
	 * Metodo para el alta de un empleado
	 * 
	 * @param empleado recibe un Objeto de tipo {@link dto.empleadoDTO} el cual lo
	 *                 impacta a la DB.
	 * @return 0 = si no pudo cargar los datos 1 = si pudo cargar el dato.
	 */
	@Override
	public int add(empleadoDTO item) {
		PreparedStatement ps = null;
		Connection conn = null;

		try {

			/**
			 * Los objetos de la clase {@link java.lang.StringBuilder} trabaja bajo un
			 * patron de dideño BUILDER el cual nos permiten ir contruyendo un objeto de a
			 * poco confome tegamos la informacion para completarlos, en este caso para
			 * construir una cadana de texto {@link String}.
			 * 
			 * Su principal conpetidor de versiones anteriores de Java es el StringBuffer
			 * que cumple con la misma funcionalidad, con la diferencia que este no se puede
			 * SINCRONIZAR para el acceso multiple cuando trabajemos con THREAD.
			 */
			StringBuilder sql = new StringBuilder();

			sql.append("INSERT INTO empleado").append("(nombre, apellido, rol)").append(" VALUES ");
			sql.append("(");
			sql.append(item.getNombre()).append(", ");
			sql.append(item.getApellido()).append(", ");
			sql.append(item.getRol()).append(");  ");

			/**
			 * Este sector devera ser remplazado por el uso de un FACTORY que nos
			 * proporcione {@link db.ConnectionFactory}.
			 */
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios", "root", "");
			ps = conn.prepareStatement(sql.toString());

			return ps.executeUpdate();
		} catch (SQLException ex) {
			LOG.log(Level.SEVERE,
					"INDICE CON ERROR:".concat(String.valueOf(item.getId())).concat(" - TABLA: EMPLEDO"), ex);
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException ex) {
				LOG.log(Level.SEVERE, null, ex);
			}
		}
		return 0;
	}

	
	
	/*
	 * metodo para agregar muchos pero reutilizando el metodo de agregar 1 public
	 * void addEmpleado(LinkedList<empleadoDTO> lista) {
	 * 
	 * for (empleadoDTO r : lista) { this.addEmpleado(r); } }
	 */

	
	
	/**
	 * Metodo para dar de alta a muchos empleados recibidos por una lista
	 * 
	 * @param lista una coleccion {@link java.util.LinkedList } de objetos empleados
	 *              del tipo {@link dto.empleadoDTO}
	 * @return 0 = si no pudo cargar los datos >1 = si pudo cargar los dato y
	 *         cuantos
	 */
	@Override
	public int add(LinkedList<empleadoDTO> lista) {
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

			return ps.executeUpdate();
		} catch (SQLException ex) {
			LOG.log(Level.SEVERE, null, ex);
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException ex) {
				LOG.log(Level.SEVERE, null, ex);
			}
		}
		return 0;
	}

	/**
	 * Metodo para dar de baja a un empleado
	 * 
	 * @param aBorrar objeto de tipo {@link dto.empleadoDTO} a impactar en el DB
	 * @return -1 = si no pudo borrar ningun dato 1 = si pudo borrar los dato
	 */
	@Override
	public int delete(empleadoDTO aBorrar) {
		PreparedStatement ps = null;
		Connection conn = null;

		try {
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM empleado ").append(" WHERE ").append(" id=? ");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios", "root", "");
			ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, aBorrar.getId());

			return ps.executeUpdate();
		} catch (SQLException ex) {
			LOG.log(Level.SEVERE,
					"INDICE CON ERROR:".concat(String.valueOf(aBorrar.getId())).concat(" - TABLA: EMPLEDO"), ex);
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException ex) {
				LOG.log(Level.SEVERE, null, ex);
			}
		}
		return -1;
	}

	/**
	 * Metodo para dar de baja a muchos empleados recibidos por una lista
	 * 
	 * @param aBorrar una coleccion {@link java.util.LinkedList } de objetos
	 *                empleados del tipo {@link dto.empleadoDTO}
	 * @return 0 = si no pudo cargar los datos >1 = si pudo borrar los dato y
	 *         cuantos
	 */
	@Override
	public int delete(LinkedList<empleadoDTO> aBorrar) {
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

			return ps.executeUpdate();
		} catch (SQLException ex) {
			LOG.log(Level.SEVERE, null, ex);
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException ex) {
				LOG.log(Level.SEVERE, null, ex);
			}
		}
		return -1;
	}

	/**
	 * Metodo para modificar un empleados recibido
	 * 
	 * @param registro una coleccion {@link java.util.LinkedList } de objetos
	 *                 empleados del tipo {@link dto.empleadoDTO}
	 * @return 0 = si no pudo modificar los datos 1 = si pudo modificar los dato
	 */
	@Override
	public int update(empleadoDTO registro) {
		PreparedStatement ps = null;
		Connection conn = null;

		try {
			String consulta = "UPDATE empleado SET nombre=? , apellido=? , rol=? WHERE id=?";

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios", "root", "");
			ps = conn.prepareStatement(consulta);

			ps.setString(1, registro.getNombre());
			ps.setString(2, registro.getApellido());
			ps.setInt(3, registro.getRol());
			ps.setInt(4, registro.getId());

			return ps.executeUpdate();
		} catch (SQLException ex) {
			LOG.log(Level.SEVERE,
					"INDICE CON ERROR:".concat(String.valueOf(registro.getId())).concat(" - TABLA: EMPLEDO"), ex);
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException ex) {
				LOG.log(Level.SEVERE, null, ex);
			}
		}
		return -1;
	}

	// actualizar muchos
	/*
	 * public void update(LinkedList<empleadoDTO> registro) { for (empleadoDTO r :
	 * registro) { this.update(r); } }
	 */

	/**
	 * Metodo para modificar a muchos empleados recibidos por una lista
	 * 
	 * @param registro una coleccion {@link java.util.LinkedList } de objetos
	 *                 empleados del tipo {@link dto.empleadoDTO}
	 * @return -1 = si no pudo modificar los datos >1 = si pudo modificar los dato y
	 *         cuantos
	 */
	@Override
	public int update(LinkedList<empleadoDTO> registro) {
		PreparedStatement ps = null;
		Connection conn = null;

		try {
			StringBuilder sql = new StringBuilder();
			for (empleadoDTO r : registro) {
				sql.append("UPDATE empleado").append(" SET ");
				sql.append(" nombre = '").append(r.getNombre()).append("', ");
				sql.append(" apellido = '").append(r.getApellido()).append("', ");
				sql.append(" rol = ").append(r.getRol());

				sql.append(" where id=?").append(";  ");
			}

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios", "root", "");
			ps = conn.prepareStatement(sql.toString());

			int index = 1;
			for (empleadoDTO r : registro) {
				ps.setInt(index++, r.getId());
			}

			return ps.executeUpdate();
		} catch (SQLException ex) {
			LOG.log(Level.SEVERE, null, ex);
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException ex) {
				LOG.log(Level.SEVERE, null, ex);
			}
		}
		return -1;
	}

	/**
	 * Metodo para obtener todos los empleados en las DB
	 * 
	 * @return una {@link java.util.LinkedList} de objetos con tipo
	 *         {@link dto.empleadoDTO} que representasn todos los registro en la DB
	 *         de empleados
	 */
	@Override
	public LinkedList<empleadoDTO> getAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		LinkedList<empleadoDTO> aux = new LinkedList<empleadoDTO>();

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
			LOG.log(Level.SEVERE, null, e);
		} finally {
			cerrarConexiones(rs, ps, conn);
		}

		return aux;
	}

	/**
	 * Metodo para obtener empleados existentes
	 * 
	 * @param id valor identificatorio como PK en la DB de empleados
	 * @return objeto de la clase {@link dto.empleadoDTO} representando un registro
	 *         de la DB
	 */
	@Override
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
				return (empleadoDTO) DTOfactory.getInstance().getDTO(tabla.EMPLEADO, rs);
			}
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, null, e);
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
			LOG.log(Level.SEVERE, null, e);
		}
	}

}
