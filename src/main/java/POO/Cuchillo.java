package POO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;


@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Cuchillo extends Arma {
	
	@NonNull
	private String tipo;
	private final int modDaño = 3;
	
	public Cuchillo( int marcado , String tipo)
	{
		super( marcado );
		this.setTipo(tipo);
	}
	
	
	@Override
	public void atacar( Persona p ) {
		// TODO Auto-generated method stub
		System.out.format("Apuñale a %s", p.getDocumento().getNombre() );	
		p. bajarVida( this.getDañoBase() * this.getModDaño() );
		System.out.format("Quedo en: %s" , p.getVida() );
	}

	
	
}
