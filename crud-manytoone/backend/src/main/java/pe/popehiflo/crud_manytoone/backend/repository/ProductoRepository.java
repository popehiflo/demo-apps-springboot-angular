package pe.popehiflo.crud_manytoone.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.popehiflo.crud_manytoone.backend.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
