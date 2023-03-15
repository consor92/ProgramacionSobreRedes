package POO;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
public class Dni {

	Foto foto;

	int documento;
	String nombre;

	// dependencia
	public Dni(String nom) {
		this.setFoto(new Foto());
		this.setNombre(nom);
	}
}
