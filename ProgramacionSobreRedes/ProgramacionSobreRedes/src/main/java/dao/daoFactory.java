package dao;

public class daoFactory {

	private static daoFactory fabrica = null;

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

			break;
		case RRHH:

			break;
		}

		return 
	}

}
