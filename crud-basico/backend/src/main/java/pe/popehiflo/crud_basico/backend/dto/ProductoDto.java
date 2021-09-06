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
	
	
	/**
	 * @return the producto
	 */
	public String getProducto() {
		return producto;
	}
	/**
	 * @param producto the producto to set
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}
	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the precio
	 */
	public float getPrecio() {
		return precio;
	}
	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
}
