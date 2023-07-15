package br.edu.ifpb.kualker.api.service;

import br.edu.ifpb.kualker.api.repositories.TarefaRepository;
import br.edu.ifpb.kualker.api.repositories.ProjetoRepository;
import br.edu.ifpb.kualker.api.model.Projeto;
import br.edu.ifpb.kualker.api.model.Tarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

   @Autowired
   private TarefaRepository tarefaRepository;
   
   
   @Autowired
   private ProjetoRepository projetoRepository;
    
   
   public List<Tarefa> getTarefa() {
       return this.tarefaRepository.findAll();
   }

   public Tarefa getTarefaPorId(Long idTarefa) {
       return this.tarefaRepository.findById(idTarefa).orElse(null);
   }

   @Transactional
   public Tarefa inserirOuAtualizar(Long id, Tarefa tarefa) {
	   Optional<Projeto> optionalProjeto = projetoRepository.findById(id);
       if (optionalProjeto.isPresent()) {
           Projeto projeto = optionalProjeto.get();
           tarefa.setProjeto(projeto);
           tarefaRepository.save(tarefa);
           return tarefa;
       } else {
           throw new IllegalArgumentException("Projeto não encontrado com o ID: " + id);
       }

   }
   
   @Transactional
   public Tarefa atualizar(Tarefa tarefa) {
	   Tarefa tarefaAtual = tarefaRepository.findById(tarefa.getId())
	            .orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada"));
	        // Atualize apenas os atributos desejados
	        tarefaAtual.setTitulo(tarefa.getTitulo());
	        tarefaAtual.setDescricao(tarefa.getDescricao());
	        // Atualize outros atributos conforme necessário
	        Tarefa tarefaAtualizada = tarefaRepository.save(tarefaAtual);
	        return tarefaAtualizada;
   }
   

   public void apagar(Long id) {
       this.tarefaRepository.deleteById(id);
   }
   
}
