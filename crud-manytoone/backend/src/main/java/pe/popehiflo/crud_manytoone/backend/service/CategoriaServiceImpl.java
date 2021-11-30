package pe.popehiflo.crud_manytoone.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.popehiflo.crud_manytoone.backend.entity.Categoria;
import pe.popehiflo.crud_manytoone.backend.repository.CategoriaRepository;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }
}
