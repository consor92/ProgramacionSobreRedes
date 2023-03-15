package POO;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public abstract class Persona implements Investigable{

	private boolean culpable = false;
	private boolean estaInvestigado = false;	
	private double vida = 100;
	
	// Agregaciones
	Perfiles perfil;
	Antecedente antecedentes;
	
	String idioma;
	boolean diestro;
	
	//Composicion (asociacion extricta)
	@NonNull
	Dni documento;
	
	
	protected void bajarVida(double daño)
	{
		this.setVida(this.getVida() - daño);
	}
	
	
}
