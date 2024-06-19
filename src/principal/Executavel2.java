package principal;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import Classes.Carros;

public class Executavel2 {

	public static void main(String[] args) throws Exception {

		FileInputStream entrada = new FileInputStream(
				"C:\\Users\\Junior\\Documents\\Curso Java\\Modulo 16 - Arquivos apache poi\\ApachePoi\\ListaCarros.xls");

		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada); // prepara a entrada do arquivo excel para ler
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0); /* Pega a Primeira Planilha do nosso arquivo excel */

		Iterator<Row> linhaITerator = planilha.iterator();

		// percorrendo o arquivo e colocando em uma lista de carros

		List<Carros> listaCarros = new ArrayList<Carros>();
		while (linhaITerator.hasNext()) { // percorre enquanto tiver linha
			Row linha = linhaITerator.next(); // pegando os dados na linha

			Iterator<Cell> celula = linha.iterator();
			
			Carros c = new Carros();

			while (celula.hasNext()) { // percorrewndo as celulas
				Cell cell = celula.next();

				switch (cell.getColumnIndex()) {
				case 0: c.setNome(cell.getStringCellValue()); break;
				case 1: c.setModelo(cell.getStringCellValue()); break;
				case 2: c.setMarca(cell.getStringCellValue()); break;
				case 3: c.setAno(cell.getRowIndex()); break;
				case 4: c.setCor(cell.getStringCellValue());break;
				case 5: c.ConveterValorDoubleParaBigDecimal(cell.getStringCellValue());break;
				case 6: c.setDescricao(cell.getStringCellValue());
				}

			}
			listaCarros.add(c);

		}
		entrada.close();
		
		for (Carros carro : listaCarros) {
			System.out.println(carro);
		}
	}

}
