package br.gov.sp.fatec.transparencia.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class ItemRendimentos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id        
	@GeneratedValue(generator = "increment")
	private Long id;
	private String nome;
	private Double valor;
	private String mes;
	private String ano;
	private String tipo;
	
	@ManyToOne
    @JoinColumn(name="funcionario", referencedColumnName="ID")
	private Funcionario funcionario;
	
	@Override
	public String toString() {
		return "ItemRendimentos [nome=" + nome + ", valor=" + valor + "]";
	}
	
}
