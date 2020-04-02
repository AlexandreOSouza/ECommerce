package br.com.ecommerce.backend.services;

import br.com.ecommerce.backend.domain.Categoria;
import br.com.ecommerce.backend.repositoreis.CategoriaRepository;
import br.com.ecommerce.backend.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria buscar(Integer id) {
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto nao encontrado! Id:" + id + ", Tipo: " + Categoria.class.getName())
        );
    }


}
