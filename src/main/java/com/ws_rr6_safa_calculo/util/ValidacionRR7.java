package com.ws_rr6_safa_calculo.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidacionRR7 {

	Logger logger = LoggerFactory.getLogger(ValidacionRR7.class);
	
	public static ArrayList<String> validacionCCMP(ArrayList<String> ctasCCMP, double valores, List<Map<String, Object>> datosCMBG) {
//		String error1, nivel1, nivel2, nivel3, nivel4, moneda;
		ArrayList<String> ctasCMBG;
		
		ctasCMBG = informacionCMBG(datosCMBG);
		
		ArrayList<String> al4 = new ArrayList<String>();
//		ArrayList<String> al5 = new ArrayList<String>();
		
		System.out.println(ctasCCMP);
		
		for (String cta : ctasCCMP) { //ctasCCMP
			al4.add(!(ctasCMBG.contains(cta)) ? "" : cta);
		}
		
		System.out.println(al4);
		
//		for (int i = 0; i < al4.size(); i++) {
//			if(!al4.get(i).equals("")) {
//				al5.add(al4.get(i));
//			}
//		}
			
		return al4;
	}	
	
	private static ArrayList<String> informacionCMBG(List<Map<String, Object>> datosCMBG) {
		String nivel1, nivel2, nivel3, nivel4, monCMBG, ctaCMBG;
		double valCMBG = 0;
		
		ArrayList<String> ctasCMBG = new ArrayList<>();
		
		for (Map<String, Object> map : datosCMBG) {
			nivel1 = map.get("NIVEL1").toString();
			nivel2 = map.get("NIVEL2").toString();
			nivel3 = map.get("NIVEL3").toString();
			nivel4 = map.get("NIVEL4").toString();
			monCMBG = map.get("CVEMONEDA").toString();
			valCMBG = Double.parseDouble(map.get("VALORES").toString());
			
			ctaCMBG = nivel1+"-"+nivel2+"-"+nivel3+"-"+nivel4+"-"+monCMBG+"-"+valCMBG+"|";
			
			ctasCMBG.add(ctaCMBG);
		}
		
		return ctasCMBG;
	}
	
}
