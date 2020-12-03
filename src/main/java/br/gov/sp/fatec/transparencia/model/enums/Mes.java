package br.gov.sp.fatec.transparencia.model.enums;

public enum Mes {
	
	JANEIRO(1, "Janeiro", "jan"),
	FEVEREIRO(2, "Fevereiro", "fev"),
	MARCO(3, "Março", "mar"),
	ABRIL(4, "Abril", "abr"),
	MAIO(5, "Maio", "mai"),
	JUNHO(6, "Junho", "jun"),
	JULHO(7, "Julho", "jul"),
	AGOSTO(8, "Agosto", "ago"),
	SETEMBRO(9, "Setembro", "set"),
	OUTUBRO(10, "Outubro", "out"),
	NOVEMBRO(11, "Novembro", "nov"),
	DEZEMBRO(12, "Dezembro", "dez");
	
	private Integer numeral;
	private String nomeMes;
	private String trigama;
	
	private Mes(int numeral, String nomeMes, String trigama) {
		this.numeral = numeral;
		this.nomeMes = nomeMes;
		this.trigama = trigama;
	}

	public Integer getNumeral() {
		return numeral;
	}

	public String getNomeMes() {
		return nomeMes;
	}
	
	public String getTrigama() {
		return trigama;
	}
	
	public static Mes toEnum(Integer numeral) {
		if (numeral == null) {
			return null;
		}
		for (Mes mes : Mes.values()) {
			if (numeral == mes.getNumeral()) {
				return mes;
			}
		}		
		throw new IllegalArgumentException("Valor inválido: " + numeral);
	}
	
	public static Mes toEnum(String trigama) {
		if (trigama == null) {
			return null;
		}
		for (Mes mes : Mes.values()) {
			if (trigama.equals(mes.getTrigama())) {
				return mes;
			}
		}		
		throw new IllegalArgumentException("Valor inválido: " + trigama);
	}
}
