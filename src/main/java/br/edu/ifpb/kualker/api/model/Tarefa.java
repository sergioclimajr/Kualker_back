package br.edu.ifpb.kualker.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_tarefa")
public class Tarefa {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String titulo;
   private String descricao;
   @ManyToOne()
   @JoinColumn(name="projeto_id", nullable=false)
   @JsonBackReference
   private Projeto projeto;
   
   public Tarefa() {
	}
   
   
   	public Tarefa(String titulo, String descricao) {
	this.titulo = titulo;
	this.descricao = descricao;
}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Projeto getProjeto() {
		return projeto;
	}
	
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
   
}
