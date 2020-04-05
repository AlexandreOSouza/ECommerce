package br.com.ecommerce.backend.services;

import br.com.ecommerce.backend.domain.Pedido;
import br.com.ecommerce.backend.repositoreis.PedidoRepository;
import br.com.ecommerce.backend.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    public Pedido find(Integer id) {
        Optional<Pedido> pedido = repo.findById(id);
        return pedido.orElseThrow(() -> new ObjectNotFoundException(
                "Pedido com o id " + id + " nao encontrado, Tipo "
                + Pedido.class.getName()
        ));
    }

}
