package br.pucsp.escola.test;

import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import br.pucsp.escola.services.BuscarProdutosService;
import br.pucsp.escola.services.GeolocalizacaoService;

public class BuscarProdutosServiceTest {
	
	private GeolocalizacaoService geolocalizacaoServiceMock = new GeolocalizacaoService() {
		
		@Override
		public int obterRaioEmKMEntreDoisEnderecos(String enderecoA, String enderecoB) {
			//Mock apenas para teste do serviço de busca de produtos
			return enderecoA.length() + enderecoB.length();
		}
	};
	
	@Before
	public void before() {
		BuscarProdutosService service = BuscarProdutosService.of();
		
		service.inserirProduto(produto);
	}

	@Test
    public void porEndereco50km() {
		BuscarProdutosService service = BuscarProdutosService.of();

        // assert statements
        assertNotEquals(null, service.porEndereco(50, "Rua Teste", geolocalizacaoServiceMock), "Lista de produtos não pode ser nula");
    }
	
	@Test
    public void porNomeEscola() {
		BuscarProdutosService service = BuscarProdutosService.of();

        // assert statements
        assertNotEquals(null, service.porNomeEscola("Escola XPTO"), "Lista de escolas não pode ser nula");
    }

}
