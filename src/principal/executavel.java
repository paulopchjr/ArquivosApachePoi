package principal;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import Classes.Carros;

public class executavel {

	public static void main(String[] args) throws Exception {

		File arquivoExcel = new File(
				"C:\\Users\\Junior\\Documents\\Curso Java\\Modulo 16 - Arquivos apache poi\\ApachePoi\\ListaCarros.xls");

		if (arquivoExcel.exists()) {

			JOptionPane.showMessageDialog(null, "Arquivo já existe");

		} else {

			arquivoExcel.createNewFile();
			String qtd = JOptionPane.showInputDialog("Quantos carros acrescentar na lista?");
			List<Carros> carros = new ArrayList<Carros>();

			for (int p = 0; p < Integer.parseInt(qtd); p++) {
				Carros carro = new Carros();
				
				//0 
				String nome = JOptionPane.showInputDialog("Qual é o nome do carro " + (p + 1) + "?");
				// 1
				carro.setNome(nome);
				String modelo = JOptionPane.showInputDialog("Qual éo seu modelo ?");
				// 2
				carro.setModelo(modelo);
				String marca = JOptionPane.showInputDialog("Qual é marca ?");
				carro.setMarca(marca);
				//3
				String ano = JOptionPane.showInputDialog("Qual é ano ?");
				carro.setAno(Integer.valueOf(ano));
				//4
				String cor = JOptionPane.showInputDialog("Qual é a cor ?");
				carro.setCor(cor);
				//5
				String descricao = JOptionPane.showInputDialog("mais alguma descriçao ?");
				carro.setDescricao(descricao);
				//6
				String valor = JOptionPane.showInputDialog("Qual é o valor do carro ?");
				carro.setValor(BigDecimal.valueOf(Double.valueOf(valor)));

				carros.add(carro);

			}

			// OBJETO APACHE POI
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(); // CRIANDO A PLANILHA

			HSSFSheet linhaCarro = hssfWorkbook.createSheet("Lista de Carros");

			int numeroLinhas = 0;

			for (Carros c : carros) {

				Row linha = linhaCarro.createRow(numeroLinhas++); // criando a quantidade de linhas na Planilha

				// CELULAS
				int celula = 0;

				Cell cellCarroNome = linha.createCell(celula++);
				cellCarroNome.setCellValue(c.getNome());

				Cell cellCarroModelo = linha.createCell(celula++);
				cellCarroModelo.setCellValue(c.getModelo());
				
				

				Cell cellCarroMarca = linha.createCell(celula++);
				cellCarroMarca.setCellValue(c.getMarca());
				
				Cell cellCarroAno = linha.createCell(celula ++);
				cellCarroAno.setCellValue(c.getAno());
				
				Cell cellCarroCor = linha.createCell(celula++);
				cellCarroCor.setCellValue(c.getCor());

				Cell cellCarroValor = linha.createCell(celula++);
				cellCarroValor.setCellValue(c.ConverteBigDecimalParaString());

				Cell cellCarroDescricao = linha.createCell(celula++);
				cellCarroDescricao.setCellValue(c.getDescricao());
				
				

			}

			FileOutputStream saida = new FileOutputStream(arquivoExcel);
			hssfWorkbook.write(saida); // escrevendo na planilha
			saida.flush();
			saida.close();

			System.out.println("Planinha feita com sucesso");

		}
	}

}
