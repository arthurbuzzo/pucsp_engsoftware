package br.pucsp.escola.services;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import br.pucsp.escola.model.Produto;

public class BuscarProdutosService {

	private static final BuscarProdutosService INSTANCE = new BuscarProdutosService();
	
	private Map<Produto, Produto> map = new HashMap<Produto, Produto>();
	
	private BuscarProdutosService() { 
		// classe singleton, apenas pode ser obtida instancia pelo método statico
	}
	
	public static BuscarProdutosService of() {
		return INSTANCE;
	}

	public List<Produto> porEndereco(int raio, String endereco, GeolocalizacaoService geoService) {
		
		Preconditions.checkArgument(raio > 0, "O raio deve ser maior que zero");
		Preconditions.checkArgument(endereco != null, "O endereço de referencia deve ser informado");

		List<Produto> list = Lists.newArrayList();
		
		for (Produto produto : map.keySet()) {
			if (geoService.obterRaioEmKMEntreDoisEnderecos(produto.getListaMaterial().getCurso().getEscola().getEndereco(), endereco) <= raio) {
				list.add(produto);
			}
		}
		
		return list;
		
	}

	public List<Produto> porNomeEscola(String nomeEscola) {
		
		Preconditions.checkArgument(nomeEscola != null, "O nome da escola deve ser informado");
		
		List<Produto> list = Lists.newArrayList();
		
		for (Produto produto : map.keySet()) {
			if (produto.getListaMaterial().getCurso().getEscola().getNome().equals(nomeEscola)) {
				list.add(produto);
			}
		}
		
		return list;
	}
	
	public boolean inserirProduto(Produto produto) {
		return map.put(produto, produto) != null;
	}

}
