package br.com.padaria.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.padaria.model.Categoria;
import br.com.padaria.service.CategoriaService;

@ViewScoped
@ManagedBean(name = "categoriaMB")
public class CategoriaManageBean {

	private Categoria categoria = new Categoria();
	private CategoriaService service = new CategoriaService();
	private List<Categoria> categorias = new ArrayList<Categoria>();
	
	@PostConstruct
	public void inicio() {
		this.buscarCategorias();
	}

	public String salvar() {
		this.service.salvar(categoria);
		this.categoria = new Categoria();
		return "/paginas/categoria/lista.xhtml";
	}

	public String alterar() {
		this.service.alterar(categoria);
		this.categoria = new Categoria();
		return "/paginas/categoria/lista.xhtml";
	}

	public void buscarCategorias() {
		this.categorias = this.service.buscarTodos();
	}

	public void buscarPorId() {
		this.categoria = this.service.buscarPorId(this.categoria.getId());
	}

	public String deletar(Categoria c) {
		this.service.deletar(c);
		this.buscarCategorias();
		return null;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

}
