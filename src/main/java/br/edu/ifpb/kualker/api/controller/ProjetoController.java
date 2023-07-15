package br.edu.ifpb.kualker.api.controller;

import br.edu.ifpb.kualker.api.model.Projeto;
import br.edu.ifpb.kualker.api.model.Tarefa;
import br.edu.ifpb.kualker.api.service.ProjetoService;
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
public class ProjetoController {

   @Autowired
   private ProjetoService projetoService;

   @GetMapping("/projetos")
   public List<Projeto> getProjetos() {
       return this.projetoService.getProjetos();
   }

   @GetMapping("/projetos/{id}")
   public Projeto getProjetoPorId(@PathVariable("id") Long idProjeto) {
       return this.projetoService.getProjetoPorId(idProjeto);
   }
   
   @GetMapping("/projetos/{id}/tarefas")
   public List<Tarefa> getTarefas(@PathVariable("id") Long id) {
       return this.projetoService.getTarefas(id);
   }

   @PostMapping("/projetos")
   public Projeto inserirProjeto(@RequestBody Projeto projeto){
       return this.projetoService.inserirOuAtualizar(projeto);
   }

   @PutMapping("/projetos/{id}")
   public Projeto atualizarProjeto(@RequestBody Projeto projeto){
       return this.projetoService.inserirOuAtualizar(projeto);
   }

   @DeleteMapping("/projetos/{id}")
   public void apagarProjeto(@PathVariable("id") Long id) {
       this.projetoService.apagar(id);
   }
   
   
   
}


