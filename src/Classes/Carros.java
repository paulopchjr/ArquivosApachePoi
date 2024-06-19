package Classes;

import java.math.BigDecimal;

public class Carros {

	private String nome;
	private String modelo;
	private String marca;
	private String cor;
	private int ano;
	private String descricao;
	private BigDecimal valor;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
	
	public String ConverteBigDecimalParaString() {
		return valor.toString();
	}
	
	public void ConveterValorDoubleParaBigDecimal(String valorConvertido) {
		 double v  = Double.valueOf(valorConvertido);
			this.valor = BigDecimal.valueOf(v); 
	}

	@Override
	public String toString() {
		return "Carros [nome=" + nome + ", modelo=" + modelo + ", marca=" + marca + ", cor=" + cor + ", ano=" + ano
				+ ", descricao=" + descricao + ", valor=" + valor + "]";
	}
	
	
	

}
