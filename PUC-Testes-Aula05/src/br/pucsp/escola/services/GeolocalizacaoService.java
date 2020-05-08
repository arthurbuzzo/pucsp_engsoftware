package br.pucsp.escola.services;

/**
 * Interface para abstração de informações de Geolocalização, não será implementada por esse projeto
 */
public interface GeolocalizacaoService {

	int obterRaioEmKMEntreDoisEnderecos(String enderecoA, String enderecoB);
	
}
