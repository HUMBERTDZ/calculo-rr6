package com.ws_rr6_plenit.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateDocument {
	
	public String CrearExcel(String[] header, String[][] document, String Nombre, String nameHoja)
			throws IOException, ParseException {
		System.out.println("Creación de excel");
		@SuppressWarnings("unused")
		String respuesta = "";
		String rutaArchivo = "D:\\TempSesa\\" + Nombre;
//		String hoja = "Hoja1";
		@SuppressWarnings("resource")
		XSSFWorkbook libro = new XSSFWorkbook();
		XSSFSheet hoja1 = libro.createSheet(nameHoja);
		CellStyle style = libro.createCellStyle();
		Font font = libro.createFont();
		font.setBold(true);
		style.setFont(font);

		for (int i = 0; i <= document.length; i++) {
			XSSFRow row = hoja1.createRow(i);
			for (int j = 0; j < header.length - 1; j++) {
				if (i == 0) {
					XSSFCell cell = row.createCell(j);
					cell.setCellStyle(style);
					cell.setCellValue(header[j]);
				} else {
					XSSFCell cell = row.createCell(j);
					cell.setCellValue(document[i - 1][j]);
				}
			}
		}
		File file;
		file = new File(rutaArchivo);
		try (FileOutputStream fileOuS = new FileOutputStream(file)) {
			if (file.exists()) {
				file.delete();
				System.out.println("Archivo eliminado");
			}
			libro.write(fileOuS);
			fileOuS.flush();
			fileOuS.close();
			return "Archivo Excel creado";
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return e.getMessage();
		} catch (IOException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
}
