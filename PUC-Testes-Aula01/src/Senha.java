import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Senha {
	
	private final int valor;
	
	private final static List<Integer> DIGITOS_VALIDOS = Arrays.asList(1, 3, 5, 7, 9);
	
	private Senha(int valor) {
		this.valor = valor;
	}
	
	public static Senha criarSenha(int valorNumerico) throws SenhaException {
		if (!possuiApenasDigitosValidosEUnicos(valorNumerico)) {
			throw new SenhaException("Senha Invalida");
		}
		return new Senha(valorNumerico);
	}
	
	private static boolean possuiApenasDigitosValidosEUnicos(int valor) {
		String valorStr = String.valueOf(valor);
		
		List<Integer> digitosAnteriores = new ArrayList<Integer>();
		for (int i = 0; i < valorStr.length(); i++) {
			int digito = Integer.valueOf(valorStr.substring(i, i+1));
			if (!DIGITOS_VALIDOS.contains(digito)) {
				return false;
			}
			if (digitosAnteriores.contains(digito)) {
				return false;
			}
			digitosAnteriores.add(digito);
		}
		return true;
	}

	public int getValor() {
		return valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + valor;
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
		Senha other = (Senha) obj;
		if (valor != other.valor)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Senha [valor=" + valor + "]";
	}
	
}
