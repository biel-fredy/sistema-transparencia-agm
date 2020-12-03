package br.gov.sp.fatec.transparencia.model.enums;

public enum TipoRendimento {
	
	RENDIMENTO(0, "Rendimento"),
	DESCONTO(1, "Desconto"),
	OUTRO(2, "Outro");
	
	private Integer valor;
	private String descricao;
	
	private TipoRendimento(int valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public Integer getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoRendimento toEnum(Integer valor) {
		if (valor == null) {
			return null;
		}
		for (TipoRendimento status : TipoRendimento.values()) {
			if (valor == status.getValor()) {
				return status;
			}
		}		
		throw new IllegalArgumentException("Valor inválido: " + valor);
	}

}
