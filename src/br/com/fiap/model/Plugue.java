package br.com.fiap.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Plugue {
	
	@Id
	private Long id;
	private String plugue;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPlugue() {
		return plugue;
	}
	public void setPlugue(String plugue) {
		this.plugue = plugue;
	}
	
	@Override
	public String toString() {
		return "Plugue [id=" + id + ", plugue=" + plugue + "]";
	}
	
}
