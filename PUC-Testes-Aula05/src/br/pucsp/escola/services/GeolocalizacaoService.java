package br.pucsp.escola.services;

/**
 * Interface para abstra��o de informa��es de Geolocaliza��o, n�o ser� implementada por esse projeto
 */
public interface GeolocalizacaoService {

	int obterRaioEmKMEntreDoisEnderecos(String enderecoA, String enderecoB);
	
}
