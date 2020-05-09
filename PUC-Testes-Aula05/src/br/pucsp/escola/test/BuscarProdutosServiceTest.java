package br.pucsp.escola.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.pucsp.escola.model.Curso;
import br.pucsp.escola.model.Escola;
import br.pucsp.escola.model.ListaMaterial;
import br.pucsp.escola.model.Produto;
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
		
		Escola escola = new Escola("EMEI Jose Candido", "Rua Prof Jose Candido");
		Curso curso = new Curso("1º Serie", escola);
		ListaMaterial listaMaterial = new ListaMaterial("Materiais 1º Semestre - 1º Serie", curso);
		
		// Insere produtos para escola próxima
		service.inserirProduto(new Produto("Lapis de Cor", listaMaterial));
		service.inserirProduto(new Produto("Caneta Esferográfica Azul", listaMaterial));
		service.inserirProduto(new Produto("Caneta Esferográfica Vermelha", listaMaterial));
		service.inserirProduto(new Produto("Borracha", listaMaterial));
		
		escola = new Escola("EMEI Escola Muito Distante", "Rua Da Escola Escola Muito Distante, Escola Muito Distante, Escola Muito Distante, Escola Muito Distante Mesmo!");
		curso = new Curso("1º Serie", escola);
		listaMaterial = new ListaMaterial("Materiais 1º Semestre - 1º Serie", curso);
		
		// Insere produtos para escola distante
		service.inserirProduto(new Produto("Lapis de Cor", listaMaterial));
		service.inserirProduto(new Produto("Caneta Esferográfica Azul", listaMaterial));
		service.inserirProduto(new Produto("Caneta Esferográfica Vermelha", listaMaterial));
		service.inserirProduto(new Produto("Borracha", listaMaterial));
		service.inserirProduto(new Produto("Caderno de 100 folhas", listaMaterial));
		
	}
	
	@Test
    public void porEndereco1km() {
		BuscarProdutosService service = BuscarProdutosService.of();

        List<Produto> produtos1Km = service.porEndereco(1, "Rua da Papelaria", geolocalizacaoServiceMock);
        assertNotEquals(null, produtos1Km, "Lista de produtos não pode ser nula");
        assertEquals(0, produtos1Km.size()); // Não Deve retornar nenhum produto (Baseado no Mock)
    }

	@Test
    public void porEndereco50km() {
		BuscarProdutosService service = BuscarProdutosService.of();

        List<Produto> produtos50Km = service.porEndereco(50, "Rua da Papelaria", geolocalizacaoServiceMock);
        assertNotEquals(null, produtos50Km, "Lista de produtos não pode ser nula");
        assertEquals(4, produtos50Km.size()); // Deve retornar apenas os produtos da EMEI Jose Candido (Gerada no Mock)
    }
	
	@Test
    public void porEndereco500km() {
		BuscarProdutosService service = BuscarProdutosService.of();

        List<Produto> produtos500Km = service.porEndereco(500, "Rua da Papelaria", geolocalizacaoServiceMock);
        assertNotEquals(null, produtos500Km, "Lista de produtos não pode ser nula");
        assertEquals(9, produtos500Km.size()); // Deve retornar todos os produtos da EMEI Jose Candido e da EMEI Escola Muito Distante (Gerada no Mock)
    }
	
	@Test
    public void porNomeEscolaInexistente() {
		BuscarProdutosService service = BuscarProdutosService.of();

        // assert statements
		List<Produto> produtos = service.porNomeEscola("Escola XPTO");
        assertNotNull("Lista de produtos não pode ser nula", produtos);
        assertEquals(0, produtos.size()); // Não Deve retornar nenhum produto, pois não existe escola com esse nome (Baseado no Mock)
    }
	
	@Test
    public void porNomeEscolaMuitoDistante() {
		BuscarProdutosService service = BuscarProdutosService.of();

        // assert statements
		List<Produto> produtos = service.porNomeEscola("EMEI Escola Muito Distante");
        assertNotNull("Lista de produtos não pode ser nula", produtos);
        assertEquals(5, produtos.size()); // Não Deve 5 produtos da escola muito distante 0(Baseado no Mock)
    }
	
	@Test(expected = IllegalArgumentException.class)
    public void porNomeEscolaNulo() {
		BuscarProdutosService service = BuscarProdutosService.of();

        // Deve dar erro de execução por não possuir nome da escola
		service.porNomeEscola(null);
    }
	
	@Test(expected = IllegalArgumentException.class)
    public void porEnderecoNulo() {
		BuscarProdutosService service = BuscarProdutosService.of();

        // Deve dar erro de execução por não possuir nome da escola
		service.porEndereco(10, null, geolocalizacaoServiceMock);
    }
	
	@Test(expected = IllegalArgumentException.class)
    public void porRaioMenorQueZero() {
		BuscarProdutosService service = BuscarProdutosService.of();

        // Deve dar erro de execução por não possuir nome da escola
		service.porEndereco(-10, "Rua Teste", geolocalizacaoServiceMock);
    }

}
