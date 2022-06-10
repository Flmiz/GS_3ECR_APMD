package br.com.fiap.model;

import java.math.BigDecimal;
import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Posto {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	private BigDecimal precoWatt;
	private Long avaliacao;
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getRua() {
		return rua;
	}
	public String getBairro() {
		return bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public String getEstado() {
		return estado;
	}
	public BigDecimal getPrecoWatt() {
		return precoWatt;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setPrecoWatt(BigDecimal precoWatt) {
		this.precoWatt = precoWatt;
	}
	public void setAvaliacao(Long avaliacao) {
		this.avaliacao = avaliacao > 5 ? 5 : avaliacao;
	}
	
	@Override
	public String toString() {
		return "Posto [nome=" + nome + ", rua=" + rua + ", bairro=" + bairro + ", cidade=" + cidade + ", estado="
				+ estado + ", precoWatt=" + precoWatt + "]";
	}
	public Vector<String> getData() {
		Vector<String> data = new Vector<String>();
		data.add(nome);
		data.add(rua);
		data.add(cidade);
		data.add(bairro);
		data.add(estado);
		data.add("plugue");
		data.add(precoWatt.toString());
		data.add(avaliacao.toString());
		
		return data;
	}

	
}
