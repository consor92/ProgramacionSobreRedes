package Principal;

import dao.EmpleadoDAO;
import dto.DTOfactory;
import dto.empleadoDTO;
import dao.tabla;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//ConnectionProbando DB = new ConnectionProbando();
		
		EmpleadoDAO datos = new EmpleadoDAO();
		
		datos.addEmpleado( (empleadoDTO)DTOfactory.getInstance().getDTO(tabla.EMPLEADO) );
		
	}

}
