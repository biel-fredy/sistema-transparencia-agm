package br.gov.sp.fatec.transparencia.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import br.gov.sp.fatec.transparencia.model.Funcionario;
import br.gov.sp.fatec.transparencia.model.ItemRendimentos;
import br.gov.sp.fatec.transparencia.model.LogSalarios;
import br.gov.sp.fatec.transparencia.model.enums.Mes;
import br.gov.sp.fatec.transparencia.repository.Funcionarios;
import br.gov.sp.fatec.transparencia.repository.ItemRendimentosRepositorio;
import br.gov.sp.fatec.transparencia.repository.LogSalariosRepositorio;
import br.gov.sp.fatec.transparencia.webcrawler.Servidores;
import br.gov.sp.fatec.transparencia.webcrawler.Detalhamento;
import br.gov.sp.fatec.transparencia.webcrawler.ItemRendimentosPMMC;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class WebCrawlerController {

	private final RestTemplate restTemplate;
	private final Funcionarios funcionarios;
	private final ItemRendimentosRepositorio itemRendimentosRepositorio;
	private final LogSalariosRepositorio logSalariosRepositorio;

	@GetMapping("/atualizar")
	public @ResponseBody String salariosServidores() {

		System.out.println("Cehgaq sd");

		List<LogSalarios> logs = new ArrayList<LogSalarios>();

		String urlDetalhamento = "http://www.licitacao.pmmc.com.br/Transparencia/detalhamento?rgf=";

		Servidores servidores = restTemplate.getForObject("http://www.licitacao.pmmc.com.br/Transparencia/vencimentos2",
				Servidores.class);

		String[] referencia = servidores.getReferencia().split("/");

		System.out.println("Teste1");

		logs = logSalariosRepositorio.findAll();

		System.out.println("Teste2");

		for (LogSalarios log : logs) {
			if (log.getMes() == Mes.toEnum(referencia[0].toLowerCase()).getTrigama() && log.getAno() == referencia[1]) {
				return "Referência já adicionada";
			}
		}
		List<Funcionario> listaFuncionarios = servidores.converteFuncionario();
		List<ItemRendimentos> listaItemRendimentos = new ArrayList<ItemRendimentos>();

		for (Funcionario func : listaFuncionarios) {
			String url = urlDetalhamento + func.getRgf();
			Detalhamento detalhamento = restTemplate.getForObject(url, Detalhamento.class);

			for (ItemRendimentosPMMC itemPMMC : detalhamento.getRendimentos()) {
				String valor = itemPMMC.getValor().replace(".", "").replace(",", ".");
				ItemRendimentos itemRendimento = new ItemRendimentos(null, itemPMMC.getNome(),
						Double.parseDouble(valor), Mes.toEnum(referencia[0].toLowerCase()).getNumeral().toString(),
						referencia[1], "0", func);
				listaItemRendimentos.add(itemRendimento);

			}
			for (ItemRendimentosPMMC itemPMMC : detalhamento.getDescontos()) {
				String valor = itemPMMC.getValor().replace(".", "").replace(",", ".");
				ItemRendimentos itemDesconto = new ItemRendimentos(null, itemPMMC.getNome(), Double.parseDouble(valor),
						Mes.toEnum(referencia[0].toLowerCase()).getNumeral().toString(), referencia[1], "1", func);
				listaItemRendimentos.add(itemDesconto);
			}
			for (ItemRendimentosPMMC itemPMMC : detalhamento.getOutros()) {
				String valor = itemPMMC.getValor().replace(".", "").replace(",", ".");
				ItemRendimentos itemOutro = new ItemRendimentos(null, itemPMMC.getNome(), Double.parseDouble(valor),
						Mes.toEnum(referencia[0].toLowerCase()).getNumeral().toString(), referencia[1], "2", func);
				listaItemRendimentos.add(itemOutro);
			}
		}

		for (Funcionario f : listaFuncionarios) {
			funcionarios.save(f);
		}

		//for (ItemRendimentos i : listaItemRendimentos) {
		//	itemRendimentosRepositorio.save(i);
		//}

		LogSalarios logSal = new LogSalarios(Mes.toEnum(referencia[0].toLowerCase()), referencia[1]);

		logSalariosRepositorio.save(logSal);

		return "Resultado" + listaFuncionarios.size();
	}

	@GetMapping("/rendimentos")
	public @ResponseBody String rendimentos() {

		Detalhamento detalhamento = restTemplate.getForObject(
				"http://www.licitacao.pmmc.com.br/Transparencia/detalhamento?rgf=19675", Detalhamento.class);

		return "Resultado" + detalhamento;
	}

}
