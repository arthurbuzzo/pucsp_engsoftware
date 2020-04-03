import java.util.ArrayList;
import java.util.List;

public class Campanha {
	
	private static final int NUMERO_MAXIMO_CANDIDATOS_CAMPANHA = 120;
	private List<Candidato> candidatos = new ArrayList<Candidato>();
	
	public List<Candidato> getCandidatos() {
		return new ArrayList<Candidato>(candidatos);
	}
	
	public void incluirCandidato(Candidato candidato) throws CampanhaException {
		if (candidatos.contains(candidato)) {
			throw new CampanhaException("Canditado já existente na campanha");
		}
		if (candidatos.size() >= NUMERO_MAXIMO_CANDIDATOS_CAMPANHA) {
			throw new CampanhaException("Numero máximo de candidatos excedidos");
		}
		candidatos.add(candidato);
	}
	
}
