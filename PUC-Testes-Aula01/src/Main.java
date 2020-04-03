public class Main {
	
	public static void main(String[] args) {
		// Exemplo cadastrando candidatos depois listando
		System.out.println("Exemplo cadastrando candidatos depois listando");
		try {
			Campanha campanha = new Campanha();
			campanha.incluirCandidato(Candidato.comSenhaNumerica(75913));
			//campanha.incluirCandidato(Candidato.comSenhaNumerica(75913));
			campanha.getCandidatos().forEach(candidato->System.out.println(candidato));
		} catch (Exception e) {
			System.out.println("Erro ao inserir candidato: " + e.getMessage());
		}
		System.out.println("------------------------------------------------");
		
		// Exemplo obtendo ordem candidato por senha
		System.out.println("Exemplo obtendo ordem candidato por senha");
		try {
			System.out.println(Candidato.comSenhaNumerica(75913));
		} catch (CampanhaException e) {
			System.out.println("Erro ao inserir candidato: " + e.getMessage());
		}
		System.out.println("------------------------------------------------");
		
		// Exemplo gerando senha para o candidato a partir da ordem definida
		System.out.println("Exemplo gerando senha para o candidato a partir da ordem definida");
		try {
			System.out.println(Candidato.comOrdemChamada(10));
		} catch (CampanhaException e) {
			System.out.println("Erro ao inserir candidato: " + e.getMessage());
		}
		System.out.println("------------------------------------------------");
		
		// Exemplo cadastrando todos os candidatos na campanha, depois listando
		System.out.println("Exemplo cadastrando todos os candidatos na campanha, depois listando");
		try {
			Campanha campanha = new Campanha();
			for (int i = 1; i <= 120; i++) {
				campanha.incluirCandidato(Candidato.comOrdemChamada(i));
			}
			campanha.getCandidatos().forEach(candidato->System.out.println(candidato));
		} catch (CampanhaException e) {
			System.out.println("Erro ao inserir candidato: " + e.getMessage());
		}
		System.out.println("------------------------------------------------");
	}

}
