/**
 * 
 */
package pe.popehiflo.crud_basico.backend.dto;

/**
 * @author popehiflo
 *
 */
public class Mensaje {

	private String mensaje;

	/**
	 * @param mensaje
	 */
	public Mensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
