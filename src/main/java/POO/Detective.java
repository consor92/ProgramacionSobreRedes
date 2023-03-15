package POO;

import java.util.ArrayList;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Detective extends Persona implements Investigable {

	
	private ArrayList<Arma> misArmas = new ArrayList<Arma>();
	private Lugar oficina;
	
	
	public Detective(Dni documento , Lugar locacion) {
		super(documento);
		
		this.setOficina( locacion );
	}


	public boolean serInvestigado() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean esCulpable() {
		// TODO Auto-generated method stub
		return false;
	}

	public void herir(Persona sujeto) {
		// TODO Auto-generated method stub
		misArmas.get(0).atacar( sujeto );
	}



}
