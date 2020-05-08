package br.pucsp.escola.model;
public class PrecoProdutoPapelaria {

	private double valor;

	private Papelaria papelaria;

	private Produto produto;

	private int opcao;
	
	public PrecoProdutoPapelaria() {
	}
	
	public PrecoProdutoPapelaria(Papelaria papelaria, Produto produto, int opcao) {
		super();
		this.papelaria = papelaria;
		this.produto = produto;
		this.opcao = opcao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Papelaria getPapelaria() {
		return papelaria;
	}

	public void setPapelaria(Papelaria papelaria) {
		this.papelaria = papelaria;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getOpcao() {
		return opcao;
	}

	public void setOpcao(int opcao) {
		this.opcao = opcao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + opcao;
		result = prime * result + ((papelaria == null) ? 0 : papelaria.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrecoProdutoPapelaria other = (PrecoProdutoPapelaria) obj;
		if (opcao != other.opcao)
			return false;
		if (papelaria == null) {
			if (other.papelaria != null)
				return false;
		} else if (!papelaria.equals(other.papelaria))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}
	
}
