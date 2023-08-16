package dto;

import java.sql.ResultSet;
import java.sql.SQLException;


public class DTOfactory {

	private static DTOfactory factory = null;
	private generalDTO dto = null;

	private DTOfactory() {
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
	public generalDTO getDTO(String type, ResultSet rs) {
		try {
			switch (type) {
			case "empleado":
				dto = new empleadoDTO(rs.getInt("id"), rs.getString("nombre"), rs.getString("dni"), rs.getInt("rol"));
				break;
			case "rrhh":
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
	public generalDTO getDTO(String type) {
		switch (type) {
		case "empleado":
			dto = new empleadoDTO();
			break;
		case "rrhh":
			dto = new rrhhDTO();
			break;
		}

		return dto;
	}

}
