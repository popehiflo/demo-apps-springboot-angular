/**
 * 
 */
package pe.popehiflo.crud_basico.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.popehiflo.crud_basico.backend.entity.Producto;
import pe.popehiflo.crud_basico.backend.repository.ProductoRepository;

/**
 * @author popehiflo
 *
 */

@Service
@Transactional
public class ProductoService {

	@Autowired
	ProductoRepository productoRepository;
	
	/**
	 * Lista de todos los productos
	 * @return List
	 */
	public List<Producto> list() {
		List<Producto> res = productoRepository.findAll();
		return res;
	}
	
	public Optional<Producto> getOne(int id) {
		Optional<Producto> res = productoRepository.findById(id);
		return res;
	}
	
	/**
	 * 
	 * @param producto
	 * @return
	 */
	public Optional<Producto> getByProducto(String producto) {
		Optional<Producto> res = productoRepository.findByProducto(producto);
		return res;
	}
	
	public void save(Producto producto) {
		productoRepository.save(producto);
	}
	
	public void delete(int id) {
		productoRepository.deleteById(id);
	}
	
	public boolean existsById(int id) {
		return productoRepository.existsById(id);
	}
	
	public boolean existsByProducto(String producto) {
		return productoRepository.existsByProducto(producto);
	}
	
	
}
