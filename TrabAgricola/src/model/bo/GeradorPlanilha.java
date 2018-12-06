package model.bo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import model.dao.tables.PropriedadeTable;
import model.vo.conector.Produto;
import model.vo.conector.Propriedade;

public class GeradorPlanilha {
	/**
	 * Gera uma planilha .xls de produtos (exemplo básico)
	 * 
	 * @param produtos
	 *            a lista de produtos que vai preencher a planilha
	 * 
	 * @return byte[] a planilha (do tipo HSSFWorkbook) convertida para um array
	 *         de bytes
	 */
	public void gerarPlanilhaPropriedades(List<Propriedade> propriedades, String caminho) {
		String[] columns = {"IdPropriedade","Documento","Data_cadastro","Endereco","Hectares_total","Idcliente"};

		HSSFWorkbook planilha = new HSSFWorkbook();

		// 1) Cria uma aba na planilha (nome é um parâmetro opcional)
		HSSFSheet abaPlanilha = planilha.createSheet("Propriedades");

		Row headerRow = abaPlanilha.createRow(0);

		// 2) Cria o cabeçalho a partir de um array columns
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
		}

		// 3) Cria as linhas com os produtos da lista
		int rowNum = 1;
		for (Propriedade pro : propriedades) {
			Row novaLinha = abaPlanilha.createRow(rowNum++);

			novaLinha.createCell(0).setCellValue(pro.getIdPropriedade());
			novaLinha.createCell(1).setCellValue(pro.getDocumento());
			novaLinha.createCell(2).setCellValue(pro.getData_cadastro().toString());
			novaLinha.createCell(3).setCellValue(pro.getEndereco());
			novaLinha.createCell(4).setCellValue(pro.getHectares_total());
			novaLinha.createCell(5).setCellValue(pro.getIdcliente());

		}

		// 4) Ajusta o tamanho de todas as colunas conforme a largura do
		// conteúdo
		for (int i = 0; i < columns.length; i++) {
			abaPlanilha.autoSizeColumn(i);
		}

		//5) Escreve o arquivo em disco, no caminho informado
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(caminho + ".xls");
			planilha.write(fileOut);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fileOut != null){
				try {
					fileOut.close();
					planilha.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
