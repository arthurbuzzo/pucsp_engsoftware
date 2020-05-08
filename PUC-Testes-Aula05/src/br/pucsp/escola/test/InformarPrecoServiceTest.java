package br.pucsp.escola.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.pucsp.escola.model.Papelaria;
import br.pucsp.escola.model.PrecoProdutoPapelaria;
import br.pucsp.escola.model.Produto;
import br.pucsp.escola.services.InformarPrecoService;

public class InformarPrecoServiceTest {

	@Test
    public void inserirPreco() {
		InformarPrecoService service = InformarPrecoService.of();

		PrecoProdutoPapelaria precoProdutoPapelaria = new PrecoProdutoPapelaria();
		
        // assert statements
        assertTrue("Pre�o deve ser inserido", service.inserirPreco(precoProdutoPapelaria));
    }
	
	
	@Test
    public void consultarPreco() {
		InformarPrecoService service = InformarPrecoService.of();

		Papelaria papelaria = new Papelaria();
		Produto produto = new Produto();
		
        // assert statements
        assertNotNull("Pre�o n�o deve ser nulo", service.consultarPreco(papelaria, produto, 1));
    }
	
}
