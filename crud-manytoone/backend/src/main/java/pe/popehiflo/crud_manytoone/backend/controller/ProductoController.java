package pe.popehiflo.crud_manytoone.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.popehiflo.crud_manytoone.backend.entity.Producto;
import pe.popehiflo.crud_manytoone.backend.service.ProductoService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping(value = "")
    public ResponseEntity<List<Producto>> listarProductos() {
        return new ResponseEntity<>(productoService.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        return new ResponseEntity<>(productoService.save(producto), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Producto> modificarProducto(@PathVariable Long id, @RequestBody Producto newProducto) {
        Producto oldProducto = productoService.findById(id);
        if (oldProducto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            oldProducto.setNombre(newProducto.getNombre());
            oldProducto.setPrecio(newProducto.getPrecio());
            oldProducto.setImagen(newProducto.getImagen());
            oldProducto.setCategoria(newProducto.getCategoria());
            return new ResponseEntity<>(productoService.save(oldProducto), HttpStatus.CREATED);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Long id) {
        productoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
