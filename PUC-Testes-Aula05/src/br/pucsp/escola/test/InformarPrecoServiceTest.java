package br.pucsp.escola.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.pucsp.escola.model.Curso;
import br.pucsp.escola.model.Escola;
import br.pucsp.escola.model.ListaMaterial;
import br.pucsp.escola.model.Papelaria;
import br.pucsp.escola.model.PrecoProdutoPapelaria;
import br.pucsp.escola.model.Produto;
import br.pucsp.escola.services.InformarPrecoService;

public class InformarPrecoServiceTest {

	@Test
    public void inserirPreco() {
		InformarPrecoService service = InformarPrecoService.of();

		Papelaria papelaria = new Papelaria();
		Escola escola = new Escola("EMEI Jose Candido", "Rua Prof Jose Candido");
		Curso curso = new Curso("1º Serie", escola);
		ListaMaterial listaMaterial = new ListaMaterial("Materiais 1º Semestre - 1º Serie", curso);
		Produto produto = new Produto("Lapis de Cor", listaMaterial);
		
        // assert statements
        assertTrue("Preço deve ser inserido", service.inserirPreco(new PrecoProdutoPapelaria(papelaria, produto, 1)));
    }
	
	@Test(expected = IllegalArgumentException.class)
    public void inserirMais5OpcoesPreco() {
		InformarPrecoService service = InformarPrecoService.of();

		Papelaria papelaria = new Papelaria();
		Escola escola = new Escola("EMEI Jose Candido", "Rua Prof Jose Candido");
		Curso curso = new Curso("1º Serie", escola);
		ListaMaterial listaMaterial = new ListaMaterial("Materiais 1º Semestre - 1º Serie", curso);
		Produto produto = new Produto("Lapis de Cor 36 cores", listaMaterial);
		
		service.inserirPreco(new PrecoProdutoPapelaria(papelaria, produto, 1));
		service.inserirPreco(new PrecoProdutoPapelaria(papelaria, produto, 2));
		service.inserirPreco(new PrecoProdutoPapelaria(papelaria, produto, 3));
		service.inserirPreco(new PrecoProdutoPapelaria(papelaria, produto, 4));
		service.inserirPreco(new PrecoProdutoPapelaria(papelaria, produto, 5));
		service.inserirPreco(new PrecoProdutoPapelaria(papelaria, produto, 6));
    }
	
	@Test
    public void inserir5OpcoesPreco() {
		InformarPrecoService service = InformarPrecoService.of();

		Papelaria papelaria = new Papelaria();
		Escola escola = new Escola("EMEI Jose Candido", "Rua Prof Jose Candido");
		Curso curso = new Curso("1º Serie", escola);
		ListaMaterial listaMaterial = new ListaMaterial("Materiais 1º Semestre - 1º Serie", curso);
		Produto produto = new Produto("Lapis de Cor 24 cores", listaMaterial);
		
		service.inserirPreco(new PrecoProdutoPapelaria(papelaria, produto, 1));
		service.inserirPreco(new PrecoProdutoPapelaria(papelaria, produto, 2));
		service.inserirPreco(new PrecoProdutoPapelaria(papelaria, produto, 3));
		service.inserirPreco(new PrecoProdutoPapelaria(papelaria, produto, 4));
		service.inserirPreco(new PrecoProdutoPapelaria(papelaria, produto, 5));
    }
	
	@Test
    public void consultarPreco() {
		InformarPrecoService service = InformarPrecoService.of();

		Papelaria papelaria = new Papelaria();
		Escola escola = new Escola("EMEI Jose Candido", "Rua Prof Jose Candido");
		Curso curso = new Curso("1º Serie", escola);
		ListaMaterial listaMaterial = new ListaMaterial("Materiais 1º Semestre - 1º Serie", curso);
		Produto produto = new Produto("Lapis de Cor", listaMaterial);
		
		PrecoProdutoPapelaria precoProdutoPapelaria = new PrecoProdutoPapelaria(papelaria, produto, 1);
		precoProdutoPapelaria.setValor(10);
		service.inserirPreco(precoProdutoPapelaria);
		
		precoProdutoPapelaria = service.consultarPreco(papelaria, produto, 1);
		
		assertNotNull("Preço não deve ser nulo", precoProdutoPapelaria);
        assertEquals(10, precoProdutoPapelaria.getValor(), 0);
        
		precoProdutoPapelaria = new PrecoProdutoPapelaria(papelaria, produto, 2);
		precoProdutoPapelaria.setValor(20);
		service.inserirPreco(precoProdutoPapelaria);
		
        precoProdutoPapelaria = service.consultarPreco(papelaria, produto, 2);
        assertNotNull("Preço não deve ser nulo", precoProdutoPapelaria);
        assertEquals(20, precoProdutoPapelaria.getValor(), 0);
    }
	
}
