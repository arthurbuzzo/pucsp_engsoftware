import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Senhas {
	
	private static Map<Integer, Senha> MAP = new HashMap<Integer, Senha>();
	
	private final static int SENHA_INICIAL = 13579;
	private final static int SENHA_FINAL = 97531;
	
	// POS 1 13579
	// POS 2 13597
	// POS 3 13957
	// POS 4 19357...
	static {
		// Pré-carrega senhas para otimização do calculo
		int posicao = 1;
		for (int i = SENHA_INICIAL; i <= SENHA_FINAL; i++) {
			try {
				Senha senha = Senha.criarSenha(i);
				MAP.put(posicao++, senha);
			} catch (SenhaException e) {
				continue;
			}
		}
	}
	
	public static int obterOrdemChamadaAPartirSenhaNumerica(int senhaNumerica) {
		Set<Integer> ordens = MAP.keySet();
		
		for (Integer ordem : ordens) {
			Senha s = MAP.get(ordem); 
			if (senhaNumerica == s.getValor()) {
				return ordem;
			}
		}
		return 0;
	}
	
	public static Senha obterSenhaAPartirOrdemChamada(int ordemChamada)  {
		return MAP.get(ordemChamada);
	}
	
}
