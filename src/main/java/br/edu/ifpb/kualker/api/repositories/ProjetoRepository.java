package br.edu.ifpb.kualker.api.repositories;

import br.edu.ifpb.kualker.api.model.Projeto;
import br.edu.ifpb.kualker.api.model.Tarefa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

	@Query("SELECT tarefas FROM Projeto p WHERE p.id = :projetoId")
    List<Tarefa> getTarefasByProjetoId(@Param("projetoId") Long projetoId);
	
}


