package br.gov.sp.fatec.transparencia.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "increment")
	private Long id;
	
	private String rgf;
	private String nome;
	private String cargo;
	private Double salario;

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", rgf=" + rgf + ", nome=" + nome + ", cargo=" + cargo + "]";
	}

}
