package com.org.generation.blogPessoal.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.org.generation.blogPessoal.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
public class UserRepositoryTest {

	private @Autowired UsuarioRepository repository;
	
	@Autowired
    private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
	
    @BeforeAll
	void start() {
		repository.save(new Usuario("Renomario","rinocc","2012454"));
		repository.save(new Usuario("márioPedro","rinoccc","2012454"));
		repository.save(new Usuario("Pedro","rinots","2012454"));
		repository.save(new Usuario("Silvamario","rinotask","2012454"));	
	}
	
    @Test
    @DisplayName("Retorna 1 Usuario")
    void deveRetornaUmUsuario() {
        Usuario user = repository.findByUsuario("rinocc").get();
        assertTrue(user.getUsuario().equals("rinocc"));
    }

	
	
}
