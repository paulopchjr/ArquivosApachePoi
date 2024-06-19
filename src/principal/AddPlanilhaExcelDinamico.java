package principal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class AddPlanilhaExcelDinamico {

	public static void main(String[] args) throws Exception {

		File arquivo = new File(
				"C:\\Users\\Junior\\Documents\\Curso Java\\Modulo 16 - Arquivos apache poi\\ApachePoi\\ListaCarros.xls");

		FileInputStream entrada = new FileInputStream(arquivo);  

		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);///Prepara a entrada  do arquivo xls excel
		HSSFSheet planinha =  hssfWorkbook.getSheetAt(0); // pegando a planinha no excel
		
		Iterator<Row>linhaIterator = planinha.iterator(); // enquanto tiver linha 
		
		
		while(linhaIterator.hasNext()) {
			Row linha = linhaIterator.next();
			
			int numeroCelulas = linha.getPhysicalNumberOfCells(); // quantidade de celula na planinha
			
			Cell cell = linha.createCell(numeroCelulas); // cria uma nova celula na linha
			cell.setCellValue("19/06/2024"); // valor da celular
			
			
		}
		
		entrada.close();
		
		
		FileOutputStream saida = new FileOutputStream(arquivo);
		hssfWorkbook.write(saida);
		saida.flush();
		saida.close();
		
		
		
		System.out.println("Planinha Atualizada com Sucesso");
		
		
	}

}
