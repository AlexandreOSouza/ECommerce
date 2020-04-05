package br.com.ecommerce.backend.domain.DTO;

import br.com.ecommerce.backend.domain.Categoria;
import lombok.Data;

import java.io.Serializable;

@Data
public class CategoriaDTO implements Serializable {

    private Integer id;
    private String nome;

    public CategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();

    }

}
