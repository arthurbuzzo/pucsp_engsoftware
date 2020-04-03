
public class Candidato {

	private final int ordemChamada;
	private final static int ORDEM_CHAMADA_INICIAL = 1;
	private final static int ORDEM_CHAMADA_FINAL = 120;

	private Candidato (int ordemChamada) {
		this.ordemChamada = ordemChamada; 
	}
	
	public static Candidato comSenhaNumerica(int senhaNumerica) throws CampanhaException {
		int ordemChamada = Senhas.obterOrdemChamadaAPartirSenhaNumerica(senhaNumerica);
		if (!(ORDEM_CHAMADA_INICIAL <= ordemChamada && ordemChamada <= ORDEM_CHAMADA_FINAL)) {
			throw new CampanhaException("Senha invalida!");
		}
		return new Candidato(ordemChamada);
	}
	
	public static Candidato comOrdemChamada(int ordemChamada) throws CampanhaException {
		if (!(ORDEM_CHAMADA_INICIAL <= ordemChamada && ordemChamada <= ORDEM_CHAMADA_FINAL)) {
			throw new CampanhaException("Ordem de chamada invalido!");
		}
		return new Candidato(ordemChamada);
	}

	public int getOrdemChamada() {
		return ordemChamada;
	}

	public Senha getSenha() {
		return Senhas.obterSenhaAPartirOrdemChamada(ordemChamada);
	}
	
	@Override
	public String toString() {
		return "Candidato [getOrdemChamada()=" + getOrdemChamada() + ", getSenha()=" + getSenha() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ordemChamada;
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
		Candidato other = (Candidato) obj;
		if (ordemChamada != other.ordemChamada)
			return false;
		return true;
	}
	
	
	
}
