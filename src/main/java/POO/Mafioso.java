package POO;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mafioso extends Persona implements Investigable{
	

	private ArrayList<Arma> misArmas = new ArrayList<Arma>();
	private Lugar oficina;
	
	public Mafioso(Dni documento , Lugar locacion) {
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
	public void herir(Persona p) {
		// TODO Auto-generated method stub
	}
	
	

}
