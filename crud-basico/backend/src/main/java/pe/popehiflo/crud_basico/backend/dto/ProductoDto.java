/**
 * 
 */
package pe.popehiflo.crud_basico.backend.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author popehiflo
 *
 */
//@SuppressWarnings("deprecation")
public class ProductoDto {

	@NotBlank
	private String producto;
	
	private String codigo;
	@Min(0)
	private float precio;
	
	public ProductoDto() {
		
	}
	/**
	 * @param producto
	 * @param codigo
	 * @param precio
	 */
	public ProductoDto(String producto, String codigo, float precio) {
		super();
		this.producto = producto;
		this.codigo = codigo;
		this.precio = precio;
	}
	
}
