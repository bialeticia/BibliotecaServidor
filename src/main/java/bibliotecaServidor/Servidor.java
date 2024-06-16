package bibliotecaServidor;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Servidor {
	private static final int PORT = 1234;
	private static List<Livro> livros;
	
	public static void main(String[] args) {
		 try {
	            livros = carregarLivros();
	            ServerSocket serverSocket = new ServerSocket(PORT);
	            System.out.println("Servidor iniciado na porta " + PORT);

	            while (true) {
	                Socket clientSocket = serverSocket.accept();
	                new Thread(new ClienteHandler(clientSocket)).start();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
	 private static List<Livro> carregarLivros() throws IOException {
		 ObjectMapper mapper = new ObjectMapper();
		 Biblioteca biblioteca = mapper.readValue(new File("src/main/resources/livros.json"), Biblioteca.class);
		 return biblioteca.getLivros();
	 }
	 
	 public static synchronized String listarLivros() {
		 return livros.stream()
				 .map(livro -> livro.getTitulo() + " por " + livro.getAutor() + " (" + livro.getExemplares() + " exemplares)")
				 .collect(Collectors.joining("||")); // "||" como delimitador
	 }
	 
	 public static synchronized void salvarLivros() throws IOException {
		 ObjectMapper mapper = new ObjectMapper();
		 Biblioteca biblioteca = new Biblioteca(livros);
		 mapper.writeValue(new File("src/main/resources/livros.json"), biblioteca);
	 }
	 
	 public static synchronized String cadastrarLivro(String titulo, String autor, String genero, int exemplares) {
		 Livro novoLivro = new Livro(titulo, autor, genero, exemplares);
		 livros.add(novoLivro);
		 try {
			 salvarLivros();
		 } catch (IOException e) {
			 return "Erro ao salvar o livro.";
		 }
		 return "Livro cadastrado com sucesso!";
	 }

}
