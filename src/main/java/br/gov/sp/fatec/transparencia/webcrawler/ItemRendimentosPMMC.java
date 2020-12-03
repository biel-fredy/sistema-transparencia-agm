package br.gov.sp.fatec.transparencia.webcrawler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class ItemRendimentosPMMC {

	private String nome;
	private String valor;

	@Override
	public String toString() {
		return "ItemRendimentosPMMC [nome=" + nome + ", valor=" + valor + "]";
	}

}
