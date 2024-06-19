package principal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

public class EditandoCelulaExistentenoXLS {

	public static void main(String[] args) throws Exception {
	
		File arquivo = new File(
				"C:\\Users\\Junior\\Documents\\Curso Java\\Modulo 16 - Arquivos apache poi\\ApachePoi\\ListaCarros.xls");
		
		
		FileInputStream entrada = new FileInputStream(arquivo);
		
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada); //// prepara a entrada do arquivo xls do excel
		HSSFSheet plainha = hssfWorkbook.getSheetAt(0); //pegando a planilha
		
		Iterator<Row> linhaIterator = plainha.iterator();
		
		while (linhaIterator.hasNext()) {
			Row linhRow = linhaIterator.next();
			int numeroCelula = linhRow.getPhysicalNumberOfCells();
			 
			String valorCelula = linhRow.getCell(0).getStringCellValue();
			linhRow.getCell(0).setCellValue(valorCelula + "Celulas editada");
			
		}
		
		entrada.close();
		
		
		FileOutputStream saida = new FileOutputStream(arquivo);
		hssfWorkbook.write(saida);
		saida.flush();
		saida.close();
		
		
		System.out.println("PLanilha Atualizada com sucesso");
		
	}
}
