package br.gov.sp.fatec.transparencia.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.gov.sp.fatec.transparencia.model.enums.Mes;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

@Entity
public class LogSalarios implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "increment")
	private Long id;
	
	private String mes;
	private String ano;
	private Date dataAtualizacao;
	
	public LogSalarios(Mes mes, String ano) {
		this.mes = mes.getNumeral().toString();
		this.ano = ano;
		this.dataAtualizacao = new Date();
	}
	
}
