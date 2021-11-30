package pe.popehiflo.crud_manytoone.backend.service;

import pe.popehiflo.crud_manytoone.backend.entity.Producto;

import java.util.List;

public interface ProductoService {

    public Producto save(Producto producto);
    public Producto findById(Long id);
    public List<Producto> findAll();
    public void delete(Long id);

}
