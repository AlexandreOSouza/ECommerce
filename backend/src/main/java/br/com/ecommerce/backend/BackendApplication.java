package br.com.ecommerce.backend;

import br.com.ecommerce.backend.domain.Categoria;
import br.com.ecommerce.backend.repositoreis.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Informatica");
        Categoria cat2 = new Categoria(null, "Escritorio");

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));

    }
}
