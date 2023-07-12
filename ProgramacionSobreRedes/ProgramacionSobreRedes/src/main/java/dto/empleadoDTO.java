package dto;

import java.util.Objects;

public class empleadoDTO {

	private int id;
	private String nombre;
	private String apellido;
	private int rol;
	
	public empleadoDTO(int id, String nombre, String apellido, int rol) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.rol = rol;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}
	
	
    /**
     * Estos metodos son utiles para los DTO ya que son donde guardamos los
     * datos de la DB como un objeto en memoria, nos servira para comparar mas
     * rapido o para ver la existencia de los mismos en colecciones.
     */
    /**
     * Tanto el metodo hashCode como equal son utilizados para la comparacion de
     * objetos (de forma interna) en las colecciones,especialemente en los de
     * tipo Diccionario ( MAP ) y su rescritura proporciona una mayor velocidad
     * en la busqueda por comparaciones o existencia.
     *
     * @return Su valor unico en un Hash de 32 bytes
     */  

	@Override
	public int hashCode() {
		return Objects.hash(apellido, id, nombre, rol);
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		empleadoDTO other = (empleadoDTO) obj;
		return Objects.equals(apellido, other.apellido) && id == other.id && Objects.equals(nombre, other.nombre)
				&& rol == other.rol;
	}

	
	 /**
     * El metodo toString nos permite mostrar los datos del objeto de manera
     * sencilla para verifijar su informacion interna, recuerden que mostrar un
     * objetos solo nos devuelve su direccion de memoria no sus datos.
     *
     * @return Por consola los datos del Objeto
     */  
	@Override
	public String toString() {
		return "empleadoDTO [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", rol=" + rol + "]";
	}

	
}
