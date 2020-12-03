package br.gov.sp.fatec.transparencia.webcrawler;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Detalhamento {

	private String referencia;
	private String cargo;
	private String nome;
	private String regime;
	private List<ItemRendimentosPMMC> rendimentos = new ArrayList<ItemRendimentosPMMC>();
	private List<ItemRendimentosPMMC> descontos = new ArrayList<ItemRendimentosPMMC>();
	private List<ItemRendimentosPMMC> totais = new ArrayList<ItemRendimentosPMMC>();
	private List<ItemRendimentosPMMC> outros = new ArrayList<ItemRendimentosPMMC>();

	@Override
	public String toString() {
		return "Detalhamento [referencia=" + referencia + ", cargo=" + cargo + ", nome=" + nome + ", regime=" + regime
				+ ", rendimentos=" + rendimentos + ", descontos=" + descontos + ", totais=" + totais + ", outros="
				+ outros + "]";
	}

}
