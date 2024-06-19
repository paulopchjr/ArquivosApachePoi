package principal;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Classes.Usuarios;

public class EscreverJson {

	public static void main(String[] args) throws Exception {

		List<Usuarios> lista = new ArrayList<Usuarios>();

		for (int x = 0; x < 2; x++) {

			Usuarios usuarios = new Usuarios();
			String nome = JOptionPane.showInputDialog("Informe o nome do " + (x + 1) + " usuário");
			usuarios.setNome(nome);

			String email = JOptionPane.showInputDialog("Informe o email do " + (x + 1) + " usuário");
			usuarios.setEmail(email);

			String senha = JOptionPane.showInputDialog("Informe a senha do " + (x + 1) + " usuário");
			usuarios.setSenha(senha);

			lista.add(usuarios);
		}

		// Json Estruturado Gson organiza o codigo em Json
		Gson gsonUser = new GsonBuilder().setPrettyPrinting().create();
		
		// Json sem Estrututura -> 
		String jsoUser = gsonUser.toJson(lista);

		System.out.println(jsoUser);

		/// ESCREVENDO O JSON
		FileWriter fileWriter = new FileWriter(
				"C:\\Users\\Junior\\Documents\\Curso Java\\Modulo 16 - Arquivos apache poi\\ApachePoi\\PoiJson.json");
		fileWriter.write(jsoUser);
		fileWriter.flush();
		fileWriter.close();

	}

}
