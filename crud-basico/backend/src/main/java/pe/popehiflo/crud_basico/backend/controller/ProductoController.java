/**
 * 
 */
package pe.popehiflo.crud_basico.backend.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.popehiflo.crud_basico.backend.dto.Mensaje;
import pe.popehiflo.crud_basico.backend.dto.ProductoDto;
import pe.popehiflo.crud_basico.backend.entity.Producto;
import pe.popehiflo.crud_basico.backend.service.ProductoService;

/**
 * @author popehiflo
 *
 */

@RestController
@RequestMapping("producto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {

	@Autowired
	ProductoService productoService;
	
	@GetMapping("/lista")
	public ResponseEntity<List<Producto>> list() {
		List<Producto> list = productoService.list();
		return new ResponseEntity<List<Producto>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<Producto> getById(@PathVariable("id") int id) {
		if(!productoService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		
		Producto producto = productoService.getOne(id).get();
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}
	
	@GetMapping("/detailproducto/{producto}")
	public ResponseEntity<Producto> getByProducto(@PathVariable("producto") String producto) {
		if(!productoService.existsByProducto(producto))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		
		Producto product = productoService.getByProducto(producto).get();
		return new ResponseEntity<Producto>(product, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody ProductoDto productoDto) {
		if(StringUtils.isBlank(productoDto.getProducto()))
			return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		if(productoDto.getPrecio() < 0)
			return new ResponseEntity(new Mensaje("el precio debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
		if(productoService.existsByProducto(productoDto.getProducto()))
			return new ResponseEntity(new Mensaje("el nombre ya existe"), HttpStatus.BAD_REQUEST);
		if(productoService.existsByCodigo(productoDto.getCodigo()))
			return new ResponseEntity(new Mensaje("el codigo/sku ya existe"), HttpStatus.BAD_REQUEST);
		Producto producto = new Producto(productoDto.getProducto(), productoDto.getCodigo(), productoDto.getPrecio());
		productoService.save(producto);
		
		return new ResponseEntity(new Mensaje("producto creado"), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ProductoDto productoDto) {
		if(!productoService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		
		if(productoService.existsByProducto(productoDto.getProducto()) && productoService.getByProducto(productoDto.getProducto()).get().getId() != id)
			return new ResponseEntity(new Mensaje("ese producto ya existe"), HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(productoDto.getProducto()))
			return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		
		if(productoService.existsByCodigo(productoDto.getCodigo()) && productoService.getByCodigo(productoDto.getProducto()).get().getId() != id)
			return new ResponseEntity(new Mensaje("el codigo/sku ya existe"), HttpStatus.BAD_REQUEST);
		
		if(productoDto.getPrecio() < 0)
			return new ResponseEntity(new Mensaje("el precio debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
		
		
		Producto producto = productoService.getOne(id).get();
		producto.setProducto(productoDto.getProducto());
		producto.setCodigo(productoDto.getCodigo());
		producto.setPrecio(productoDto.getPrecio());
		productoService.save(producto);
		
		return new ResponseEntity(new Mensaje("producto actualizado"), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		if(!productoService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		
		productoService.delete(id);
		
		return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
	}
	
}
