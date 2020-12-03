package br.gov.sp.fatec.transparencia.webcrawler;

import br.gov.sp.fatec.transparencia.repository.Funcionarios;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Servidor {

	private String rgf;
	private String nome;
	private String cargo;
	private String rendimentos;
	
	@Override
	public String toString() {
		return "Servidor [rgf=" + rgf + ", nome=" + nome + ", cargo=" + cargo + ", rendimentos=" + rendimentos + "]";
	}
}
