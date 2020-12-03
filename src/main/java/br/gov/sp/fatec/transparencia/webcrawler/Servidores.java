package br.gov.sp.fatec.transparencia.webcrawler;

import java.util.ArrayList;
import java.util.List;

import br.gov.sp.fatec.transparencia.model.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Servidores {

	private List<Servidor> servidores;
	private String referencia;

	@Override
	public String toString() {
		return "Servidores [servidores=" + servidores + ", referencia=" + referencia + "]";
	}

	public List<Funcionario> converteFuncionario() {
		List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
		for (Servidor servidor : this.getServidores()) {
			Funcionario func = new Funcionario(null, servidor.getRgf(), servidor.getNome(), servidor.getCargo());
			listaFuncionario.add(func);
		}
		return listaFuncionario;
	}
}
