package dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.tabla;


public class DTOfactory {

	private static DTOfactory factory = null;
	private generalDTO dto = null;

	private DTOfactory() {
		super();
	}
	
	//patron SINGLENTON
	//nos asegura una unica instancia de un objeto
	public static DTOfactory getInstance() {
		if (factory == null)
			factory = new DTOfactory();

		return factory;
	}

	// interface nombre = new classConcreta();
	// Patron FACTORY
	public generalDTO getDTO(tabla type, ResultSet rs) {
		try {
			switch (type) {
			case EMPLEADO:
				dto = new empleadoDTO(rs.getInt("id"), rs.getString("nombre"), rs.getString("dni"), rs.getInt("rol"));
				break;
			case RRHH:
				dto = new rrhhDTO();
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dto;
	}

	// interface nombre = new classConcreta();
	// Patron FACTORY
	public generalDTO getDTO(tabla type) {
		switch (type) {
		case EMPLEADO:
			dto = new empleadoDTO();
			break;
		case RRHH:
			dto = new rrhhDTO();
			break;
		}

		return dto;
	}

}
