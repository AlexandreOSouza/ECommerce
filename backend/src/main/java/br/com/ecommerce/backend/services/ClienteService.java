package br.com.ecommerce.backend.services;

import br.com.ecommerce.backend.domain.Cliente;
import br.com.ecommerce.backend.repositoreis.ClienteRepository;
import br.com.ecommerce.backend.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente find(Integer id) {
        Optional<Cliente> cli = repo.findById(id);
        return cli.orElseThrow(() -> new ObjectNotFoundException(
                "Cliente com o id " + id + " nao encontrado, Tipo " + Cliente.class.getName()
        ));
    }
}
