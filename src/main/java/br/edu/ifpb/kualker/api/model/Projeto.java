package br.edu.ifpb.kualker.api.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_projeto")
public class Projeto {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String nome;
   private String descricao;
   @OneToMany(mappedBy="projeto")
   @JsonManagedReference
   private List<Tarefa> tarefas;
   
   
   
   
	public Projeto() {
		this.tarefas = new ArrayList<>();
	}
	
	public Projeto(Long id, String nome, String descricao, List<Tarefa> tarefas) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.tarefas = new ArrayList<>();
	}

	public Projeto(String nome, String descricao, List<Tarefa> tarefas) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.tarefas = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Tarefa> getTarefas() {
		return tarefas;
	}
	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

   
}
