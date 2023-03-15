package POO;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public abstract class Arma {

	protected final double dañoBase = 0.7;
	@NonNull
	protected int numIdentifiacion;
	
	
	public abstract void atacar( Persona p );
	
}
