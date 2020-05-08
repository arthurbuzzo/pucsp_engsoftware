package br.pucsp.escola.model;

import java.util.ArrayList;
import java.util.List;

public class Curso {

	private String descricao;

	private Escola escola;
	
	private List<ListaMaterial> listasMateriais = new ArrayList<ListaMaterial>();
	
	public Curso(String descricao, Escola escola) {
		super();
		this.descricao = descricao;
		this.escola = escola;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<ListaMaterial> getListasMateriais() {
		return listasMateriais;
	}

	public void setListasMateriais(List<ListaMaterial> listasMateriais) {
		this.listasMateriais = listasMateriais;
	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((escola == null) ? 0 : escola.hashCode());
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
		Curso other = (Curso) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (escola == null) {
			if (other.escola != null)
				return false;
		} else if (!escola.equals(other.escola))
			return false;
		return true;
	}
	
}
