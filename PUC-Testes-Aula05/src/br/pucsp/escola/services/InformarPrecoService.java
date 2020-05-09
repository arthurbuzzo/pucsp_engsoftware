package br.pucsp.escola.services;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import br.pucsp.escola.model.Papelaria;
import br.pucsp.escola.model.PrecoProdutoPapelaria;
import br.pucsp.escola.model.Produto;

public class InformarPrecoService {
	
	private static final InformarPrecoService INSTANCE = new InformarPrecoService();
	
	private Map<PrecoProdutoPapelaria, PrecoProdutoPapelaria> map = new HashMap<PrecoProdutoPapelaria, PrecoProdutoPapelaria>();

	private InformarPrecoService() {
		// classe singleton, apenas pode ser obtida instancia pelo método statico
	}
	
	public static InformarPrecoService of() {
		return INSTANCE;
	}
	
	public boolean inserirPreco(PrecoProdutoPapelaria opcaoPreco) {
		Preconditions.checkArgument(consultarOpcoesEPrecos(opcaoPreco.getPapelaria(), opcaoPreco.getProduto()).size() < 5, 
				"Deve possuir no maximo 5 opções de preco cadastradas por produto");
		return map.put(opcaoPreco, opcaoPreco) != null;
	}
	
	public PrecoProdutoPapelaria consultarPreco(Papelaria papelaria, Produto produto, int opcao) {
		return map.get(new PrecoProdutoPapelaria(papelaria, produto, opcao));
	}
	
	public List<PrecoProdutoPapelaria> consultarOpcoesEPrecos(Papelaria papelaria, Produto produto) {
		List<PrecoProdutoPapelaria> list = Lists.newArrayList();
		
		for (PrecoProdutoPapelaria precoProdutoPapelaria : map.keySet()) {
			if (precoProdutoPapelaria.getProduto().equals(produto) && precoProdutoPapelaria.getPapelaria().equals(papelaria)) {
				list.add(precoProdutoPapelaria);
			}
		}
		
		return list;
	}

}
