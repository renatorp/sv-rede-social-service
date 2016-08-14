package br.pucminas.prod.entity;

public class Amizade {
	
	private Integer id;
	private Cliente amigoSolicitante;
	private Cliente amigoSolicitado;
	private Boolean solicitacaoAceita;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getAmigoSolicitante() {
		return amigoSolicitante;
	}

	public void setAmigoSolicitante(Cliente amigoSolicitante) {
		this.amigoSolicitante = amigoSolicitante;
	}

	public Cliente getAmigoSolicitado() {
		return amigoSolicitado;
	}

	public void setAmigoSolicitado(Cliente amigoSolicitado) {
		this.amigoSolicitado = amigoSolicitado;
	}

	public Boolean getSolicitacaoAceita() {
		return solicitacaoAceita;
	}

	public void setSolicitacaoAceita(Boolean solicitacaoAceita) {
		this.solicitacaoAceita = solicitacaoAceita;
	}

}
