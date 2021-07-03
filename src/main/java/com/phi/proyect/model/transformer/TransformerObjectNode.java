package com.phi.proyect.model.transformer;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.phi.proyect.models.DeDivisas;
import com.phi.proyect.models.DeFuturos;

public final class TransformerObjectNode {

	public static final DeDivisas toDeDivisas(ObjectNode obj) {
		DeDivisas divisa = new DeDivisas();

		divisa.setCdTransaccion(obj.get("0").asText());
		divisa.setCdInstrumento(obj.get("1").asInt());
		divisa.setTcOriginal(obj.get("2").asDouble());
		divisa.setCdCurva(obj.get("3").asInt());
		divisa.setNuMonto(obj.get("4").asDouble());
		divisa.setCdMoneda(obj.get("5").asInt());
		divisa.setTpPosicion(obj.get("6").asInt());
		divisa.setNbTrader(obj.get("7").asText());
		divisa.setNbContraparte(obj.get("8").asText());

		return divisa;
	}

	public static final DeFuturos toDeFuturos(ObjectNode obj) {
		DeFuturos deFuturos = new DeFuturos();
		
		deFuturos.setCodigoDeTransaccion(obj.get("0").asInt());
		deFuturos.setCdInstrumento(obj.get("1").asInt());
		deFuturos.setFechaInicio(obj.get("2").asText());
		deFuturos.setFechaFin(obj.get("3").asText());
		deFuturos.setUnCurvaLocal(obj.get("4").asInt());
		deFuturos.setUnCurvaForanea(obj.get("5").asInt());
		deFuturos.setUnCurvaIndice(obj.get("6").asInt());
		deFuturos.setNuPactado(obj.get("7").asDouble());
		deFuturos.setUnContratos(obj.get("8").asInt());
		deFuturos.setUnPosicion(obj.get("9").asInt());
		deFuturos.setUnPlazo(obj.get("10").asInt());
		deFuturos.setConvencion(obj.get("11").asInt());

		return deFuturos;
	}
}
