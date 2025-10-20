package com.ws_rr6_plenit.util;

import com.ws_rr6_plenit.models.Cred;
import com.ws_rr6_plenit.models.Deud;
import com.ws_rr6_plenit.models.Fopa;
import com.ws_rr6_plenit.models.Inmu;
import com.ws_rr6_plenit.models.Inve;
import com.ws_rr6_plenit.models.Irre;
import com.ws_rr6_plenit.models.Oinv;

public class Helper {
	
	public Inve buildInve(Inve entry) {
		Inve result = new Inve();
		
		result.setAfectacion(entry.getAfectacion());
		result.setCalce(entry.getCalce());
		result.setCalif(entry.getCalif());
		result.setCalifoncpt(entry.getCalifoncpt());
		result.setCalifongaran(entry.getCalifongaran());
		result.setClasificacion(entry.getClasificacion());
		result.setConsecutiv(entry.getConsecutiv());
		result.setContrato(entry.getContrato());
		result.setCtoAdq(entry.getCtoAdq());
		result.setCveEmisor(entry.getCveEmisor());
		result.setCveInve(entry.getCveInve());////////////
		result.setCveOrg(entry.getCveOrg());
		result.setCvePonderadorContraparte(entry.getCvePonderadorContraparte());
		result.setCveTasRef(entry.getCveTasRef());
		result.setdXInt(entry.getdXInt());
		result.setDescrip(entry.getDescrip());
		result.setDeterioro(entry.getDeterioro());
		result.setDivXCob(entry.getDivXCob());
		result.setFchAdq(entry.getFchAdq());
		result.setFchEmi(entry.getFchEmi());
		result.setFchVto(entry.getFchVto());
		result.setInXDev(entry.getInXDev());
		result.setIncDelVal(entry.getIncDelVal());
		result.setIncXValuaCbi(entry.getIncXValuaCbi());
		result.setIncXValuaOp(entry.getIncXValuaOp());
		result.setIncXValuaRcs(entry.getIncXValuaRcs());
		result.setIntLpCubreCp(entry.getIntLpCubreCp());
		result.setIsin(entry.getIsin());
		result.setLiquidez(entry.getLiquidez());
		result.setMdaBase(entry.getMdaBase());
		result.setMoneda(entry.getMoneda());
		result.setNegociable(entry.getNegociable());
		result.setNivelFondos(entry.getNivelFondos());
		result.setNivel1(entry.getNivel1());
		result.setNivel2(entry.getNivel2());
		result.setNivel3(entry.getNivel3());
		result.setNivel4(entry.getNivel4());
		result.setNotaEstructurada(entry.getNotaEstructurada());
		result.setParamtriz(entry.getParamtriz());
		result.setPeriodAmort(entry.getPeriodAmort());
		result.setPlazo(entry.getPlazo());
		result.setPlazoCupon(entry.getPlazoCupon());
		result.setPortaSegFlex(entry.getPortaSegFlex());
		result.setPrecioUni(entry.getPrecioUni());
		result.setPremio(entry.getPremio());
		result.setReglaCupon(entry.getReglaCupon());
		result.setSerie(entry.getSerie());
		result.setTasaAmort(entry.getTasaAmort());
		result.setTasaCupo(entry.getTasaCupo());
		result.setTasaGaranti(entry.getTasaGaranti());
		result.setTasaPactDer(entry.getTasaPactDer());
		result.setTasaVal(entry.getTasaVal());
		result.setTiiAmpDer(entry.getTiiAmpDer());
		result.setTipoEmisora(entry.getTipoEmisora());
		result.setTipoGarantiaCobertura(entry.getTipoGarantiaCobertura());
		result.setTipoNotaEstructurada(entry.getTipoNotaEstructurada());
		result.setTipoOrg(entry.getTipoOrg());
		result.setTipoValor(entry.getTipoValor());
		result.setTitulos(entry.getTitulos());
		result.setTotalAct(entry.getTotalAct());
		result.setValMercado(entry.getValMercado());
		result.setValorConversionARiesgocpt(entry.getValorConversionARiesgocpt());
		result.setValorGaranCober(entry.getValorGaranCober());
		result.setValorNom(entry.getValorNom());
		result.setVePonderadorGarantia(entry.getVePonderadorGarantia());		
		return result;
	}

	public Inmu buildInmu(Inmu entry) {
		Inmu result = new Inmu();

		result.setAfectacion(entry.getAfectacion());
		result.setCalle(entry.getCalle());
		result.setCapSuperavit(entry.getCapSuperavit());
		result.setClasifInm(entry.getClasifInm());
		result.setColonia(entry.getColonia());
		result.setConsecutiv(entry.getConsecutiv());
		result.setCp(entry.getCp());
		result.setCtoHist(entry.getCtoHist());
		result.setCveInmu(entry.getCveInmu()); /////////
		result.setDepreInc(entry.getDepreInc());
		result.setDepreciHi(entry.getDepreciHi());
		result.setEntidad(entry.getEntidad());
		result.setEstatusPR(entry.getEstatusPR());
		result.setFchAdq(entry.getFchAdq());
		result.setFchCapSv(entry.getFchCapSv());
		result.setFchIniArren(entry.getFchIniArren());
		result.setFchIniCons(entry.getFchIniCons());
		result.setFchUltVal(entry.getFchUltVal());
		result.setFchVenArren(entry.getFchVenArren());
		result.setGastosAn(entry.getGastosAn());
		result.setImporteAfectoTotal(entry.getImporteAfectoTotal());
		result.setIncrVal(entry.getIncrVal());
		result.setMoneda(entry.getMoneda());
		result.setNivelFondos(entry.getNivelFondos());
		result.setNivel1(entry.getNivel1());
		result.setNivel2(entry.getNivel2());
		result.setNivel3(entry.getNivel3());
		result.setNivel4(entry.getNivel4());
		result.setNumero(entry.getNumero());
		result.setPorcentajeAfect(entry.getPorcentajeAfect());
		result.setPortaSegFlex(entry.getPortaSegFlex());
		result.setRentasAn(entry.getRentasAn());
		result.setSuperavitAfecto(entry.getSuperavitAfecto());
		result.setSuperavitAfectoOp(entry.getSuperavitAfectoOp());
		result.setSuperavitAfectoRcs(entry.getSuperavitAfectoRcs());
		result.setTasaGaranti(entry.getTasaGaranti());
		result.setTasaRdto(entry.getTasaRdto());
		result.setTipoInm(entry.getTipoInm());
		result.setTotalInmueble(entry.getTotalInmueble());
		result.setValorComer(entry.getValorComer());
		result.setValorFis(entry.getValorFis());
		result.setValorRent(entry.getValorRent());
		
		return result;
	}

	public Cred buildCred(Cred entry) {
		Cred result = new Cred();
		
		result.setAfectacion(entry.getAfectacion());
		result.setApellidoMaterno(entry.getApellidoMaterno());
		result.setApellidoPaterno(entry.getApellidoPaterno());
		result.setAvaluoFis(entry.getAvaluoFis());
		result.setCalifoncpt(entry.getCalifoncpt());
		result.setCalifongaran(entry.getCalifongaran());
		result.setCarteraVencida(entry.getCarteraVencida());
		result.setConsecutiv(entry.getConsecutiv());///////////////esta como IDENTITY en la tabla
		result.setCveCred(entry.getCveCred());//////////////
		result.setCvePonderadorContraparte(entry.getCvePonderadorContraparte());
		result.setCvePonderadorGarantia(entry.getCvePonderadorGarantia());
		result.setDXI(entry.getDXI());
		result.setEstimCastigos(entry.getEstimCastigos());
		result.setFechaAdqui(entry.getFechaAdqui());
		result.setFechaVencimiento(entry.getFechaVencimiento());
		result.setGarantia(entry.getGarantia());
		result.setMoneda(entry.getMoneda());
		result.setNivelFondos(entry.getNivelFondos());
		result.setNivel1(entry.getNivel1());
		result.setNivel2(entry.getNivel2());
		result.setNivel3(entry.getNivel3());
		result.setNivel4(entry.getNivel4());
		result.setNumeroPolizaDanios(entry.getNumeroPolizaDanios());
		result.setNumeroPolizaVida(entry.getNumeroPolizaVida());
		result.setPagoCapital(entry.getPagoCapital());
		result.setPersonalidadJuridica(entry.getPersonalidadJuridica());
		result.setPlazoInt(entry.getPlazoInt());
		result.setPortaSegFlex(entry.getPortaSegFlex());
		result.setPrimerNombre(entry.getPrimerNombre());
		result.setRazonSocial(entry.getRazonSocial());
		result.setReservaPreventiva(entry.getReservaPreventiva());
		result.setSaldoCierre(entry.getSaldoCierre());
		result.setSegundoNombre(entry.getSegundoNombre());
		result.setTasaGaranti(entry.getTasaGaranti());
		result.setTasaInt(entry.getTasaInt());
		result.setTipoCredito(entry.getTipoCredito());
		result.setTipoGarantiaCobertura(entry.getTipoGarantiaCobertura());
		result.setValHistInicial(entry.getValHistInicial());
		result.setValorConversionARiesgocpt(entry.getValorConversionARiesgocpt());
		result.setValorGaran(entry.getValorGaran());
		result.setValorGaranCober(entry.getValorGaranCober());		
		return result;		
	}
	public Deud buildDeud(Deud entry) {
		Deud result = new Deud();
		result.setAfectacion(entry.getAfectacion());
		result.setComiXDev(entry.getComiXDev());
		result.setConsecutivo(entry.getConsecutivo());
		result.setCveDeud(entry.getCveDeud());////////////////////////////////
		result.setCveRamo(entry.getCveRamo());
		result.setDerechosPoliza(entry.getDerechosPoliza());
		result.setDerechosPolizaDev(entry.getDerechosPolizaDev());
		result.setImpuestos(entry.getImpuestos());
		result.setMoneda(entry.getMoneda());
		result.setNivel1(entry.getNivel1());
		result.setNivel2(entry.getNivel2());
		result.setNivel3(entry.getNivel3());
		result.setNivel4(entry.getNivel4());
		result.setOperacion(entry.getOperacion());
		result.setPlazo(entry.getPlazo());
		result.setPrimasPorCobrarAfecto(entry.getPrimasPorCobrarAfecto());
		result.setPrimasPorCobrarTotal(entry.getPrimasPorCobrarTotal());
		result.setRecargos(entry.getRecargos());
		result.setRecargosDev(entry.getRecargosDev());		
		return result;
	}
	public Oinv buildOinv(Oinv entry) {
		Oinv result = new Oinv();
		result.setAfectacion(entry.getAfectacion());
		result.setApellidoMaterno(entry.getApellidoMaterno());
		result.setApellidoPaterno(entry.getApellidoPaterno());
		result.setCalifoncpt(entry.getCalifoncpt());
		result.setCalifongaran(entry.getCalifongaran());
		result.setConsecutivo(entry.getConsecutivo());
		result.setCveOinv(entry.getCveOinv());////////////////
		result.setCvePonderadorContraparte(entry.getCvePonderadorContraparte());
		result.setCvePonderadorGarantia(entry.getCvePonderadorGarantia());
		result.setDXInt(entry.getDXInt());
		result.setFchVnto(entry.getFchVnto());
		result.setFechaAdqui(entry.getFechaAdqui());
		result.setImpDeuFianzas(entry.getImpDeuFianzas());
		result.setMoneda(entry.getMoneda());
		result.setNivel1(entry.getNivel1());
		result.setNivel2(entry.getNivel2());
		result.setNivel3(entry.getNivel3());
		result.setNivel4(entry.getNivel4());
		result.setNivelFondos(entry.getNivelFondos());
		result.setNumeroLicita(entry.getNumeroLicita());
		result.setPersonalidadJuridica(entry.getPersonalidadJuridica());
		result.setPlazoInt(entry.getPlazoInt());
		result.setPortaSegFlex(entry.getPortaSegFlex());
		result.setPrimerNombre(entry.getPrimerNombre());
		result.setRazonSocial(entry.getRazonSocial());
		result.setSaldoCierre(entry.getSaldoCierre());
		result.setSegundoNombre(entry.getSegundoNombre());
		result.setTasaGaranti(entry.getTasaGaranti());
		result.setTasaInt(entry.getTasaInt());
		result.setTipoActivo(entry.getTipoActivo());
		result.setTipoDeuXResp(entry.getTipoDeuXResp());
		result.setTipoDeudor(entry.getTipoDeudor());
		result.setTipoDiv(entry.getTipoDiv());
		result.setTipoDxc(entry.getTipoDxc());
		result.setTipoGarantiaCobertura(entry.getTipoGarantiaCobertura());
		result.setValHistInicial(entry.getValHistInicial());
		result.setValorConversionARiesgocpt(entry.getValorConversionARiesgocpt());
		result.setValorGaranCober(entry.getValorGaranCober());

		return result;
	}
	
	public Irre buildIrre(Irre entry) {
		Irre result = new Irre();
		
		result.setAfectacion(entry.getAfectacion());
		result.setCveIrre(entry.getCveIrre());////////////////////////
		result.setCveRamo(entry.getCveRamo());
		result.setMoneda(entry.getMoneda());
		result.setNivel1(entry.getNivel1());
		result.setNivel2(entry.getNivel2());
		result.setNivel3(entry.getNivel3());
		result.setNivel4(entry.getNivel4());
		result.setNivelFondos(entry.getNivelFondos());
		result.setOperacion(entry.getOperacion());
		result.setSaldo(entry.getSaldo());		
		
		return result ;
	}
	
	public Fopa buildFopa(Fopa entry) {
		Fopa result = new Fopa();

		result.setAfectacion(entry.getAfectacion());
		result.setCveFopa(entry.getCveFopa());//////////////////////////////
		result.setMoneda(entry.getMoneda());
		result.setNivel1(entry.getNivel1());
		result.setNivel2(entry.getNivel2());
		result.setNivel3(entry.getNivel3());
		result.setNivel4(entry.getNivel4());
		result.setNivelfondos(entry.getNivelfondos());
		result.setSaldo(entry.getSaldo());
		
		return result;
	}
}
