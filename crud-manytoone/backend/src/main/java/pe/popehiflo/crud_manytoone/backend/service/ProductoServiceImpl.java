package pe.popehiflo.crud_manytoone.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.popehiflo.crud_manytoone.backend.entity.Producto;
import pe.popehiflo.crud_manytoone.backend.repository.ProductoRepository;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto findById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        productoRepository.deleteById(id);
    }
}
