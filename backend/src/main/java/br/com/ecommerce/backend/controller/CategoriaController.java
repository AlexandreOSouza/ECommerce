package br.com.ecommerce.backend.controller;

import br.com.ecommerce.backend.domain.Categoria;
import br.com.ecommerce.backend.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Categoria> find(@PathVariable Integer id) {
        Categoria obj = categoriaService.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Categoria categoria) {
        categoria = categoriaService.insert(categoria);
        // Pega a URI do recurso -> ex: http://localhost:8080/categorias
        // e insere o id da nova categoria, utilizando as boas praticas
        // de um servico REST
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(categoria.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Categoria categoria, @PathVariable Integer id) {
        categoria.setId(id);
        System.out.println(categoria.getNome());
        categoria = categoriaService.update(categoria);
        return ResponseEntity.noContent().build();
    }



}
