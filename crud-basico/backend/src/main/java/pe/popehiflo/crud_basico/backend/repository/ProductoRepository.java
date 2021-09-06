/**
 * 
 */
package pe.popehiflo.crud_basico.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.popehiflo.crud_basico.backend.entity.Producto;

/**
 * @author popehiflo
 *
 */

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

	Optional<Producto> findByProducto(String producto);
	Optional<Producto> findByCodigo(String codigo);
	boolean existsByProducto(String producto);
	boolean existsByCodigo(String codigo);
	
}
