package br.edu.ifpb.kualker.api.service;

import br.edu.ifpb.kualker.api.repositories.ProjetoRepository;
import br.edu.ifpb.kualker.api.model.Projeto;
import br.edu.ifpb.kualker.api.model.Tarefa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjetoService {

   @Autowired
   private ProjetoRepository projetoRepository;

   public List<Projeto> getProjetos() {
       return this.projetoRepository.findAll();
   }
   
   public List<Tarefa> getTarefas(Long id) {
       return this.projetoRepository.getTarefasByProjetoId(id);
   }
   
   
   public Projeto getProjetoPorId(Long idProjeto) {
       return this.projetoRepository.findById(idProjeto).orElse(null);
   }

   @Transactional
   public Projeto inserirOuAtualizar(Projeto projeto) {
       Projeto projetoInserido = this.projetoRepository.save(projeto);
       return projetoInserido;
   }

   public void apagar(Long id) {
       this.projetoRepository.deleteById(id);
   }
   
}

