package br.gov.sp.fatec.transparencia.controller;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.gov.sp.fatec.transparencia.repository.Funcionarios;
import br.gov.sp.fatec.transparencia.view.model.SalarioRange;

@Controller
public class FuncionariosController {

	@Autowired
	private Funcionarios funcionarios;

	@GetMapping("/transparenciaMogi")
	public ModelAndView telaPrincipal() {
		ModelAndView modelAndView = new ModelAndView("TransparenciaMogi");
		return modelAndView;
	}

	@GetMapping("/funcionarios")
	public ModelAndView listaFuncionarios() {
		ModelAndView modelAndView = new ModelAndView("ListaFuncionarios");

		modelAndView.addObject("funcionarios", funcionarios.findAll());
		return modelAndView;
	}
	
	@PostMapping("**/pesquisarfuncionario")
	public ModelAndView listaFuncionariosComFiltro(
			@RequestParam("nomepesquisa") String nomePesquisa,
			@RequestParam("cargopesquisa") String cargoPesquisa,
			@RequestParam("amount") String salarioRange) {
		ModelAndView modelAndView = new ModelAndView("ListaFuncionarios");
		HashMap<String, String> parametrosPesquisa = new HashMap<String, String>();
		SalarioRange salRange = new SalarioRange();
		String[] arraySalarioRange = salarioRange.split("-");
		
		salRange.setMin(Double.parseDouble(arraySalarioRange[0].substring(2).trim()));
		salRange.setMax(Double.parseDouble(arraySalarioRange[1].substring(3).trim()));
		
		System.out.println("Max = " + salRange.getMax() + "\n" +
							"Min = " + salRange.getMin());

		if (!nomePesquisa.trim().isEmpty() && nomePesquisa != null) {
			nomePesquisa = "%" + nomePesquisa.toUpperCase() + "%";
			parametrosPesquisa.put("nome", nomePesquisa);
		}
		if (!cargoPesquisa.trim().isEmpty() && cargoPesquisa != null) {
			cargoPesquisa = "%" + cargoPesquisa.toUpperCase() + "%";
			parametrosPesquisa.put("cargo", cargoPesquisa);
		}

		if (parametrosPesquisa.containsKey("nome") && parametrosPesquisa.containsKey("cargo")) {
			modelAndView.addObject("funcionarios", funcionarios.findFuncionarioPorNome(salRange.getMin(), salRange.getMax(),
					parametrosPesquisa.get("nome"), parametrosPesquisa.get("cargo")));
		} else {
			if (parametrosPesquisa.containsKey("nome")) {
				modelAndView.addObject("funcionarios",
						funcionarios.findFuncionarioPorNome(salRange.getMin(), salRange.getMax(), parametrosPesquisa.get("nome")));
			} else if (parametrosPesquisa.containsKey("cargo")) {
				modelAndView.addObject("funcionarios",
						funcionarios.findFuncionarioPorCargoAndSalario(salRange.getMin(), salRange.getMax(), parametrosPesquisa.get("cargo")));
			} else {
				modelAndView.addObject("funcionarios", funcionarios.findFuncionarioPorSalario(salRange.getMin(), salRange.getMax()));
			}
		}
		return modelAndView;
	}

	@PostMapping("**/salarioprefeito")
	public ModelAndView listarSalarioPrefeito() {
		ModelAndView modelAndView = new ModelAndView("ListaFuncionarios");
		String cargo = "%PREFEI%";

		modelAndView.addObject("funcionarios", funcionarios.findFuncionarioPorCargo(cargo));

		return modelAndView;
	}

	@GetMapping("**/salarioprefeito")
	public ModelAndView listarSalarioPrefeitoGet() {
		ModelAndView modelAndView = new ModelAndView("ListaFuncionarios");
		String cargo = "%PREFEI%";

		modelAndView.addObject("funcionarios", funcionarios.findFuncionarioPorCargo(cargo));

		return modelAndView;
	}

	//@PostMapping("**/compararfuncionario")
	//public ModelAndView compararFuncionario() ) {

	//}
}
