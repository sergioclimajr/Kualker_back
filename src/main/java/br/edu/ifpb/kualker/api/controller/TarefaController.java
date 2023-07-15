package br.edu.ifpb.kualker.api.controller;

import br.edu.ifpb.kualker.api.model.Projeto;
import br.edu.ifpb.kualker.api.model.Tarefa;
import br.edu.ifpb.kualker.api.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class TarefaController {

   @Autowired
   private TarefaService tarefaService;

   @GetMapping("/tarefas/{id}")
   public Tarefa getTarefaPorId(@PathVariable("id") Long idTarefa) {
       return this.tarefaService.getTarefaPorId(idTarefa);
   }

   @PutMapping("/tarefas/{id}")
   public Tarefa atualizarTarefa(@RequestBody Tarefa tarefa){
       return this.tarefaService.atualizar(tarefa);
   }

   @DeleteMapping("/tarefas/{id}")
   public void apagarTarefa(@PathVariable("id") Long id) {
       this.tarefaService.apagar(id);
   }
   
   
   @PostMapping("/projetos/{projetoId}/tarefas")
   public Tarefa inserirTarefa(@PathVariable("projetoId") Long id, @RequestBody Tarefa tarefa){
       return this.tarefaService.inserirOuAtualizar(id, tarefa);
   }
   
   
}