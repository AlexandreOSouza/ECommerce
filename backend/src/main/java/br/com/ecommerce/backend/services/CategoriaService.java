package br.com.ecommerce.backend.services;

import br.com.ecommerce.backend.services.exceptions.DataIntegrityException;
import br.com.ecommerce.backend.domain.Categoria;
import br.com.ecommerce.backend.repositoreis.CategoriaRepository;
import br.com.ecommerce.backend.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria find(Integer id) {
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto nao encontrado! Id:" + id + ", Tipo: " + Categoria.class.getName())
        );
    }

    public Categoria insert(Categoria categoria) {
        categoria.setId(null);
        return repo.save(categoria);
    }

    public Categoria update(Categoria categoria) {
        find(categoria.getId());
        return repo.save(categoria);
    }

    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Nao e possivel excluir uma categoria que possui produtos");
        }
    }

}
