package com.org.generation.blogPessoal.repository;

import com.org.generation.blogPessoal.model.Tema;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemaRepository extends JpaRepository<Tema,Long>{
	
	public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);

	
	
}
