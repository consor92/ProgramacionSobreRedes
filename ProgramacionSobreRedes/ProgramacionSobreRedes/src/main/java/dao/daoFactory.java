package dao;

public class daoFactory {

	private static daoFactory fabrica = null;

	private static EmpleadoDAO empleado = null;
	private static RrhhDAO rrhh = null;

	private daoFactory() {

	}

	public static daoFactory getInstance() {
		if (fabrica == null)
			fabrica = new daoFactory();

		return fabrica;
	}

	public GeneralDAO getDAO(tabla type) {
		switch (type) {
		case EMPLEADO:
			if (empleado == null)
				empleado = new EmpleadoDAO();

			return empleado;
		case RRHH:
			if (rrhh == null)
				rrhh = new RrhhDAO();

			return empleado;
		}

		return null;
	}

}
