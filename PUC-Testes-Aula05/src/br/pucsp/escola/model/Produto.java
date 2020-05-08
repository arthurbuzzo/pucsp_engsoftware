package br.pucsp.escola.model;
public class Produto {

	private String descricao;

	private ListaMaterial listaMaterial;
	
	public Produto(String descricao, ListaMaterial listaMaterial) {
		super();
		this.descricao = descricao;
		this.listaMaterial = listaMaterial;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ListaMaterial getListaMaterial() {
		return listaMaterial;
	}

	public void setListaMaterial(ListaMaterial listaMaterial) {
		this.listaMaterial = listaMaterial;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((listaMaterial == null) ? 0 : listaMaterial.hashCode());
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
		Produto other = (Produto) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (listaMaterial == null) {
			if (other.listaMaterial != null)
				return false;
		} else if (!listaMaterial.equals(other.listaMaterial))
			return false;
		return true;
	}

}
